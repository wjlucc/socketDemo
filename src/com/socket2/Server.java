package com.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		
		//1.�������˴���һ��ServerSocketͨ�ŵ㣬��Ϊͨ�ŷ����������Ұ󶨶˿ڡ�
		ServerSocket serverSocket = new ServerSocket(8888);		
		
		//2.��������ʼ������ֱ�������ӽ�����
		System.out.println("----�������Ѿ��������ȴ�����----");
		Socket socket = serverSocket.accept();
		
		//3.�������ӻ��һ�������ֽ�����ͨ��������õ�socketʵ����
		InputStream inputStream = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		//4.ͨ����������������Ϣ
		String info = null;
		while((info = reader.readLine()) != null){
			System.out.println(info);
		}
		socket.shutdownInput();	//���ͽ��������ر�socket��������Դ��������Ҫ��
		
		//������Ӧ
		//�������������ⲿд��Ϣ��
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter printWriter = new PrintWriter(outputStream);
		printWriter.write("��ӭ��½��");
		printWriter.flush();
		socket.shutdownOutput();
		
		
		
		//5.�ر�������Դ
		printWriter.close();
		outputStream.close();
		reader.close();
		inputStream.close();
		socket.close();
		serverSocket.close();
		
	} 
}
