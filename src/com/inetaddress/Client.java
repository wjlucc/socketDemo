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
		// 1.����Socket����ָ����Ҫ���ӵķ������ĵ�ַ�Ͷ˿ںš�
		Socket socket = new Socket("localhost", 8888);

		// 2.���ӽ�����ͨ���������������˷���������Ϣ��
		OutputStream os = socket.getOutputStream();
		PrintWriter bw = new PrintWriter(os);
		bw.write("�û���:admiddddn;����:1234");
		bw.flush();
		// ÿ�δ�����Ϣ������Ҫ�ر����Socket����
		socket.shutdownOutput();

		// 3.ͨ����������ȡ��������Ӧ����Ϣ��
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String info = null;
		while ((info = br.readLine()) != null) {
			System.out.println("�ͻ����յ�����Ϣ�ǣ�" + info);
		}
		// ÿ�δ�����Ϣ������Ҫ�ر����Socket����
		socket.shutdownInput();

		// 4.�ر���ص���Դ�������������Socket��
		bw.close();
		os.close();
		br.close();
		isr.close();
		is.close();

		socket.close();

	}
}
