package com.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Socket对象本身就包含连接的全部信息，可以进行连接。 服务器端要有ServerSocket和Socket两种对象。 客户端有Socket对象就够了。
 * 
 * @author WJLUCK
 *
 */

public class Client {
	/*
	 * Socket对象上绑定有对方的主机地址和端口号。 Socket相当于一个管子的端点，标识其通向的位置。管子可以自由通向其他位置。
	 * 服务器端需要另外一个可以侦听是否有新管子到达的对象。ServerSocket。
	 */

	public static void main(String[] args) throws IOException {
		// 1.创建Socket对象，客户端的这个Socket对象本身就可以进行连接。
		int port = 8888;
		Socket socket = new Socket("localhost", port);

		// 建立连接。Socket一旦创建就和对方进行了连接，所以直接使用输出流发送信息即可。

		// 2.获得输出字节流
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter printWriter = new PrintWriter(outputStream);

		// 3.写信息
		printWriter.write("用户名:admin;密码:1234");
		printWriter.flush();
		socket.shutdownOutput();

		//接收服务器端的响应信息
		//获得一个输入流
		InputStream inputStream = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));		
		String info = null;
		while((info = reader.readLine()) != null){
			System.out.println(info);
		}
		socket.shutdownInput();	
		
		// 4.关闭资源
		reader.close();
		inputStream.close();
		printWriter.close();
		outputStream.close();
		socket.close();
	}

}
