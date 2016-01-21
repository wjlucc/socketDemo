package com.origin.server;

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

		// 1.����ServerSocket���󣬰󶨼����˿�
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("****�����Ƿ���ˣ��ȴ���Ӧ****");

		// 2.ͨ��accept()���������ͻ�������
		Socket socket = serverSocket.accept();

		// 3.���ӽ�����ͨ����������ȡ�ͻ��˷��͵�������Ϣ
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String info = null;
		while ((info = br.readLine()) != null) {
			System.out.println("�յ�����Ϣ�ǣ�" + info);
		}
		// �ر�socket������������Ҫ��
		socket.shutdownInput();

		// 4.ͨ���������ͻ��˷�����Ӧ��Ϣ
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter printWriter = new PrintWriter(outputStream);
		printWriter.write("��ӭ��½��");
		// д����Ϣ����ˢ�£���������ȷд��
		printWriter.flush();
		socket.shutdownOutput();

		// 5���ر���Դ��������������� �Լ�Socket �� ServerSocket��
		printWriter.close();
		outputStream.close();
		br.close();
		isr.close();
		is.close();

		socket.close();
		serverSocket.close();
	}
}
