package com.server;


import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("****�����Ƿ���ˣ��ȴ���Ӧ****");
		int count = 0;
		Socket socket = null;
		while (true) {
			socket = serverSocket.accept();
			count = count + 1;
			System.out.println("��"+count+"���ͻ���");
			ServerThread serverThread = new ServerThread(socket);
			serverThread.run();
			
			//����Socket�������õ�InetAddressʵ�����ݴ��ܻ��IP��ַ��
			InetAddress address = socket.getInetAddress();
			//����InetAddressʵ�����IP��ַ��
			System.out.println("�ͻ���IP��ַ��"+address.getHostAddress());			
		}
	}
}
