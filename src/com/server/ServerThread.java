package com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread {

	public Socket socket = null;
	
	public ServerThread(Socket socket){
		this.socket = socket;		
	}
	
	public void run(){
		try {
			
			//输入流用于响应客户端发送的信息
			InputStream inputStream = socket.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			
			String info = null;
			while((info = bufferedReader.readLine()) != null){
				System.out.println("客户端发送的消息是：" + info);				
			}	
			socket.shutdownInput();
			
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			printWriter.write("欢迎登陆！");
			printWriter.flush();
			socket.shutdownOutput();
			
			printWriter.close();
			outputStream.close();
			bufferedReader.close();
			inputStream.close();
			socket.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
