package com.socket3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {

		// 1.�������˴���һ��ServerSocketͨ�ŵ㣬��Ϊͨ�ŷ����������Ұ󶨶˿ڡ�
		ServerSocket serverSocket = new ServerSocket(8888);

		// 2.��������ʼ������ֱ�������ӽ�����
		System.out.println("----�������Ѿ��������ȴ�����----");
		int count = 0;
		Socket socket = null;
		while (true) {
			socket = serverSocket.accept();
			count = count + 1;
			ServerThread serverThread = new ServerThread(socket);
			serverThread.start();
			String IP = socket.getInetAddress().getHostAddress();
			System.out.println("���ǵ�" + count + "���ͻ��ˣ�IP��ַ��" + IP);

		}

	}
}
