package assignments;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSideClass {
    public static void main(String[]args) throws IOException {
    	int flag=0;
      System.out.println("Starting Server");
      try{
    	  
    	  //Creating a Server Socket that manages the socket connections.
    	  ServerSocket server_server = new ServerSocket(9999) ;
          System.out.println("Waiting for the client to connect");
          //Creating a Socket when we got a Request from the client
          Socket server_socket = server_server.accept();
          System.out.println("Connection established at port 9999");
          File dir = new File("C:\\Users\\SATYA KRISHNA VINJAM\\Desktop\\Myfiles");
          File[] files = dir.listFiles();//Contains the list of files in the directory
          
          //Creating an Reader at input Stream of the server_socket
          InputStreamReader isr = new InputStreamReader(server_socket.getInputStream());
          BufferedReader br = new BufferedReader(isr);
          
          //Creating an Writer at output Stream of the server_socket
          OutputStreamWriter osw = new OutputStreamWriter(server_socket.getOutputStream());
          PrintWriter pw = new PrintWriter(osw);
          
          String command = br.readLine();
          if(command.equalsIgnoreCase("index")){ 
        	  int i=1;
        	  for(File file:files){
        		  pw.write(i+")");
        		  pw.write(file.getName()+"\n");
        		  pw.flush();
        		  i++;
        		  
        	  } 
        	  pw.write("EOF"+"\n");
        	  pw.flush();
          }
          command = br.readLine();
          if(command.startsWith("get")){
        	String filename = command.substring(4);
        	for(File file:files){
      		  if(filename.equals(file.getName())){
      			  
      			  pw.write("OK\n");
      			  pw.flush();
      			BufferedReader brf = new BufferedReader(new FileReader(file));
      			 String line;
      			 while ((line = brf.readLine()) != null) {
      			       pw.write(line+"\n");
      			    }
      			  flag = 1;
      			brf.close();
      			break;  
      		  }
      	  } 
        	if(flag == 0){
        		pw.write("Couldn't find the file\n");
        	}
          }
          System.out.println("Closing Connection");
          osw.close();
          isr.close();
          server_server.close();
          server_socket.close();
      }
          
      catch(Exception e){
          e.printStackTrace();
          
      }
     
              
    
    }
    
}
