package com.inetaddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Example2 {
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");
		
//		System.out.println(url.getFile());
//		System.out.println(url.getProtocol());
//		System.out.println(url.getHost());
//		System.out.println(url.getContent());
//		System.out.println(url.getQuery());
//		
//		
		
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		BufferedReader bis = new BufferedReader(isr);
		
		String data = bis.readLine();
		while(data != null){
			System.out.println(data);
			data = bis.readLine();
		}
		bis.close();
		isr.close();
		is.close();
		
	}

	
}
