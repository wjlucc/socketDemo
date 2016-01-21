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

		// 1.创建ServerSocket对象，绑定监听端口
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("****这里是服务端，等待相应****");

		// 2.通过accept()方法监听客户端请求
		Socket socket = serverSocket.accept();

		// 3.连接建立后通过输入流读取客户端发送的请求信息
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String info = null;
		while ((info = br.readLine()) != null) {
			System.out.println("收到的信息是：" + info);
		}
		// 关闭socket的输入流，重要！
		socket.shutdownInput();

		// 4.通过输出流向客户端发送响应信息
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter printWriter = new PrintWriter(outputStream);
		printWriter.write("欢迎登陆！");
		// 写完信息必须刷新，否则不能正确写入
		printWriter.flush();
		socket.shutdownOutput();

		// 5、关闭资源。各种输入输出流 以及Socket 和 ServerSocket。
		printWriter.close();
		outputStream.close();
		br.close();
		isr.close();
		is.close();

		socket.close();
		serverSocket.close();
	}
}
