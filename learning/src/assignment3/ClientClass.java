package assignment3;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Socket;

public class ClientClass{
	private Socket client_socket;
	public void makeConnnection(String IP , int port){
		try {
			client_socket = new Socket(IP,port);
			System.out.println("Successfully made a connection");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[]args){
		byte[] buffer = {0};
		ClientClass obj = new ClientClass();
		obj.makeConnnection("localhost", 9999);
		DatagramPacket dp = new DatagramPacket(buffer, 10);
		while(true){
			
		}
		
	}
}