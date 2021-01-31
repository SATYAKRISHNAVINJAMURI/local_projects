package com.satya.Networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientChat {

	public static void main(String[] args) throws UnknownHostException ,Exception{
		String ip  = "localhost";
		String msg = "null";
		int port = 9999;
		Socket s = new Socket(ip,port);
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter pw = new PrintWriter(os);
		Scanner scan = new Scanner(System.in);
		System.out.println("Start Chatting and Enter quit to exit");
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
	}

}