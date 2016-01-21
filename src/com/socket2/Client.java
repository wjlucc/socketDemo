package com.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Socket������Ͱ������ӵ�ȫ����Ϣ�����Խ������ӡ� ��������Ҫ��ServerSocket��Socket���ֶ��� �ͻ�����Socket����͹��ˡ�
 * 
 * @author WJLUCK
 *
 */

public class Client {
	/*
	 * Socket�����ϰ��жԷ���������ַ�Ͷ˿ںš� Socket�൱��һ�����ӵĶ˵㣬��ʶ��ͨ���λ�á����ӿ�������ͨ������λ�á�
	 * ����������Ҫ����һ�����������Ƿ����¹��ӵ���Ķ���ServerSocket��
	 */

	public static void main(String[] args) throws IOException {
		// 1.����Socket���󣬿ͻ��˵����Socket������Ϳ��Խ������ӡ�
		int port = 8888;
		Socket socket = new Socket("localhost", port);

		// �������ӡ�Socketһ�������ͺͶԷ����������ӣ�����ֱ��ʹ�������������Ϣ���ɡ�

		// 2.�������ֽ���
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter printWriter = new PrintWriter(outputStream);

		// 3.д��Ϣ
		printWriter.write("�û���:admin;����:1234");
		printWriter.flush();
		socket.shutdownOutput();

		//���շ������˵���Ӧ��Ϣ
		//���һ��������
		InputStream inputStream = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));		
		String info = null;
		while((info = reader.readLine()) != null){
			System.out.println(info);
		}
		socket.shutdownInput();	
		
		// 4.�ر���Դ
		reader.close();
		inputStream.close();
		printWriter.close();
		outputStream.close();
		socket.close();
	}

}
