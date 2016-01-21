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
		
		//1.服务器端创建一个ServerSocket通信点，作为通信服务器。并且绑定端口。
		ServerSocket serverSocket = new ServerSocket(8888);		
		
		//2.服务器开始侦听，直到有连接建立。
		System.out.println("----服务器已经建立，等待连接----");
		Socket socket = serverSocket.accept();
		
		//3.建立连接获得一个输入字节流。通过侦听获得的socket实例。
		InputStream inputStream = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		//4.通过这个输入流获得信息
		String info = null;
		while((info = reader.readLine()) != null){
			System.out.println(info);
		}
		socket.shutdownInput();	//传送结束立即关闭socket输入流资源，这点很重要。
		
		//进行响应
		//获得输出流并向外部写信息。
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter printWriter = new PrintWriter(outputStream);
		printWriter.write("欢迎登陆！");
		printWriter.flush();
		socket.shutdownOutput();
		
		
		
		//5.关闭其他资源
		printWriter.close();
		outputStream.close();
		reader.close();
		inputStream.close();
		socket.close();
		serverSocket.close();
		
	} 
}
