package assignments;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;
public class ClientSideClass {
        
    private static Socket client_socket;
   
	public static void main(String[]args) throws IOException {
       try{ 
    	   Scanner input = new Scanner(System.in);
         String IP = "localhost";
         int port = 9999;
         client_socket = new Socket(IP,port);
         System.out.println("Connection Established");
         OutputStreamWriter osw = new OutputStreamWriter(client_socket.getOutputStream());
         PrintWriter pw = new PrintWriter(osw);
         pw.println("index");
         pw.flush();
         InputStreamReader isr = new InputStreamReader(client_socket.getInputStream());
        BufferedReader  br = new BufferedReader(isr);
        System.out.println("list of files");
        String str;
        while((str=br.readLine())!=null){
        	if(str.equals("EOF")){
        		break;
        	}
        	System.out.println(str);
        	
        }
        System.out.println("End of file\n");
        System.out.println("Enter file you want to download");
        String file1 = input.nextLine();
        input.close();
        pw.println("get " + file1);
        pw.flush();
        str = br.readLine();
        	if(str.equals("OK")){
        		File required_file = new  File("C:\\Users\\SATYA KRISHNA VINJAM\\Desktop\\"+file1);
        		PrintWriter pwf = new PrintWriter(required_file);
           		while((str=br.readLine())!=null){
           			pwf.println(str);
        		}
           	System.out.println("Transfer Completed");
           	pwf.close();
        	}
        	else{
        		System.out.println(str);
        	}
       }
       
       catch(Exception e){
           System.out.println(e);
       }
    }
    
}
