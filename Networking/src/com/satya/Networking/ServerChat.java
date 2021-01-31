package com.satya.Networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat {

	public static void main(String[] args) throws Exception {
		String msg;
		ServerSocket ss = new ServerSocket(9999);
		System.out.println("Waiting for Client to Connect");
		Socket s = ss.accept();
		System.out.println("Client Connected");
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter pw = new PrintWriter(os);
		Scanner scan = new Scanner(System.in);
		msg = br.readLine();
		System.out.println("				message:" +msg);
		msg = scan.nextLine();
		while(!msg.equals("quit")) {
			pw.println(msg);	
			pw.flush();
			System.out.println("sent");
			msg = br.readLine();
			System.out.println("				message:" +msg);
			msg = scan.nextLine();		
			
		}
		System.out.println("Chatting ended");
		s.close();
		ss.close();
		
		
		

	}

}