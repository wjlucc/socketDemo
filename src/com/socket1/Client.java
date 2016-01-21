package com.socket1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Socket������Ͱ������ӵ�ȫ����Ϣ�����Խ������ӡ� ��������Ҫ��ServerSocket��Socket���ֶ��� �ͻ�����Socket����͹��ˡ�
 * 
 * @author WJLUCK
 *
 */

public class Client {
	/*
	 * Socket�����ϰ��жԷ���������ַ�Ͷ˿ںš� Socket�൱��һ�����ӵĶ˵㣬��ʶ��ͨ���λ�á����ӿ�������ͨ������λ�á�
	 * ����������Ҫ����һ�����������Ƿ����¹��ӵ���Ķ���ServerSocket��
	 */

	public static void main(String[] args) throws IOException {
		// 1.����Socket���󣬿ͻ��˵����Socket������Ϳ��Խ������ӡ�
		int port = 8888;
		Socket socket = new Socket("localhost", port);

		// �������ӡ�Socketһ�������ͺͶԷ����������ӣ�����ֱ��ʹ�������������Ϣ���ɡ�

		// 2.�������ֽ���
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter printWriter = new PrintWriter(outputStream);

		// 3.д��Ϣ
		printWriter.write("�û���:admin;����:1234");
		printWriter.flush();
		socket.shutdownOutput();

		// 4.�ر���Դ
		printWriter.close();
		outputStream.close();
		socket.close();
	}

}
