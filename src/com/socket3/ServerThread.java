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
			// �������������ͨ�������������ȡ��Ϣ
			InputStream inputStream = this.socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			String info = null;
			while ((info = reader.readLine()) != null) {
				System.out.println(info);
			}
			socket.shutdownInput(); // ���ͽ��������ر�socket��������Դ��������Ҫ��

			// ������Ӧ
			// �������������ⲿд��Ϣ��
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			printWriter.write("��ӭ��½��");
			printWriter.flush();
			socket.shutdownOutput();

			// 5.�ر�������Դ
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
