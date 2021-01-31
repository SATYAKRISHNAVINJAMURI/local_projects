/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package networksinjava;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author SATYA KRISHNA VINJAM
 */
public class ServerSocketTesting {
    public static void main(String[]args) throws IOException {
      System.out.println("Starting Server");
      try(ServerSocket server_server = new ServerSocket(9999)) {
          System.out.println("Waiting for the client to connect");
          Socket server_socket = server_server.accept();
          System.out.println("Created connection at port 9999");
          }
      catch(Exception e){
          System.out.println(e);
      }
              
    
    }
    
}
