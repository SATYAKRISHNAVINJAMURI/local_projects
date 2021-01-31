package jdbc;
import java.sql.*; //import package
public class jdbcDDL {
	private static final String  UN = "root";
	private static final String PW = "@Ammananna9@";
	private static final String URL = "jdbc:mysql://localhost/iiitdm";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static void main(String[]args){
		Connection con = null;
		int i = 0;
		Statement st = null;
		String query = "CREATE TABLE depart(	departno int,	departname int,	location varchar(20),	primary key(departno));";
		//Register a Driver
		try{
			Class.forName(JDBC_DRIVER);  //registrating a driver
			con = DriverManager.getConnection(URL,UN,PW); //creating a connection
			st = con.createStatement(); //creating a statement
			i = st.executeUpdate(query); //executing a statement
			System.out.println("Total Rows effected - " + i );
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{ //close connection
			try{
				if(con != null){
					con.close();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(st != null){
					st.close();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
			
	}
	

}
