package com.inetaddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// 1.创建Socket对象，指明需要连接的服务器的地址和端口号。
		Socket socket = new Socket("localhost", 8888);

		// 2.连接建立后，通过输出流向服务器端发送请求信息。
		OutputStream os = socket.getOutputStream();
		PrintWriter bw = new PrintWriter(os);
		bw.write("用户名:admiddddn;密码:1234");
		bw.flush();
		// 每次传送信息结束就要关闭这个Socket流。
		socket.shutdownOutput();

		// 3.通过输入流获取服务器响应的信息。
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String info = null;
		while ((info = br.readLine()) != null) {
			System.out.println("客户端收到的信息是：" + info);
		}
		// 每次传送信息结束就要关闭这个Socket流。
		socket.shutdownInput();

		// 4.关闭相关的资源。输入输出流和Socket。
		bw.close();
		os.close();
		br.close();
		isr.close();
		is.close();

		socket.close();

	}
}
