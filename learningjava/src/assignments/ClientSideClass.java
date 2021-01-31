package assignments;
import java.net.Socket;
import java.io.*;
public class ClientSideClass {
        
    private static Socket client_socket;

	public static void main(String[]args) throws IOException {
       try{ 
         String IP = "localhost";
         int port = 9999;
         client_socket = new Socket(IP,port);
         System.out.println("Connection Established");
         OutputStreamWriter osw = new OutputStreamWriter(client_socket.getOutputStream());
         PrintWriter pw = new PrintWriter(osw);
         pw.write("index");
         pw.flush();
         InputStreamReader ir = new InputStreamReader(client_socket.getInputStream());
         BufferedReader  br = new BufferedReader(ir);
         System.out.println("list of files\n" + br.readLine() );
         osw.write("get input");
       }
       
       catch(Exception e){
           System.out.println(e);
       }
    }
    
}
