package com.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Example {
	
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address1 = InetAddress.getLocalHost();
		System.out.println(address1.getHostName());
		System.out.println(address1.getHostAddress());		
		
		byte[] byadd = address1.getAddress();
		byadd[3] = 111;
		System.out.println(byadd[3]);
		System.out.println(Arrays.toString(byadd));
		
		for(int i = byadd[3]-90;i < byadd[3]+1;i++){
			byte temp = (byte)(0 + i);
			byadd[3] = temp;
			InetAddress address2 = InetAddress.getByAddress(byadd);
			System.out.println(address2.getHostName()+" ----- "+address2.getHostAddress());			
		}
		
		
		
		
		
	}

}
