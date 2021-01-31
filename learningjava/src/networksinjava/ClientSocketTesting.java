/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package networksinjava;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author SATYA KRISHNA VINJAM
 */
public class ClientSocketTesting {

    public static void main(String[]args) throws IOException {
        
        String IP = "localhost";
        int port = 9999;
        Socket client_socket  = new Socket(IP,port);
        client_socket.close();
        
    }
    
}
