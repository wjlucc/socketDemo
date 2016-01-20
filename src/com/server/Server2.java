package com.server;


import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("****这里是服务端，等待相应****");
		int count = 0;
		Socket socket = null;
		while (true) {
			socket = serverSocket.accept();
			count = count + 1;
			System.out.println("第"+count+"个客户端");
			ServerThread serverThread = new ServerThread(socket);
			serverThread.run();
			
			//根据Socket对象能拿到InetAddress实例，据此能获得IP地址。
			InetAddress address = socket.getInetAddress();
			//根据InetAddress实例获得IP地址。
			System.out.println("客户端IP地址："+address.getHostAddress());			
		}
	}
}
