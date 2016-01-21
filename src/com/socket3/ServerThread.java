package com.socket3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {

		try {
			// 获得输入流，并通过这个输入流获取信息
			InputStream inputStream = this.socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			String info = null;
			while ((info = reader.readLine()) != null) {
				System.out.println(info);
			}
			socket.shutdownInput(); // 传送结束立即关闭socket输入流资源，这点很重要。

			// 进行响应
			// 获得输出流并向外部写信息。
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			printWriter.write("欢迎登陆！");
			printWriter.flush();
			socket.shutdownOutput();

			// 5.关闭其他资源
			printWriter.close();
			outputStream.close();
			reader.close();
			inputStream.close();
			this.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
