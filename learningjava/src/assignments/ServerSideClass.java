
package assignments;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSideClass {
    public static void main(String[]args) throws IOException {
      System.out.println("Starting Server");
      try(ServerSocket server_server = new ServerSocket(9999)) {
          System.out.println("Waiting for the client to connect");
          Socket server_socket = server_server.accept();
          System.out.println("Created connection at port 9999");
          File file = new File(args[0]);
          InputStreamReader ir = new InputStreamReader(server_socket.getInputStream());
          BufferedReader br = new BufferedReader(ir);
          String command = br.readLine();
          if(strc)
          }
      catch(Exception e){
          System.out.println(e);
      }
              
    
    }
    
}
