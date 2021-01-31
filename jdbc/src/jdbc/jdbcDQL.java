package jdbc;
import java.sql.*; //import package
public class jdbcDQL {
	private static final String  UN = "root";
	private static final String PW = "@Ammananna9@";
	private static final String URL = "jdbc:mysql://localhost/assignment";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static void main(String[]args){
		Connection con = null;
		int i = 0;
		Statement st = null;
		ResultSet rs = null;
		String query = "SELECT avg(eage),departno	FROM emp	GROUP BY departno;";
		//Register a Driver
		try{
			Class.forName(JDBC_DRIVER);  //registrating a driver
			con = DriverManager.getConnection(URL,UN,PW); //creating a connection
			st = con.createStatement(); //creating a statement
			rs = st.executeQuery(query); //executing a statement
			System.out.println();
			while(rs.next()){ //process the result
				i++;
				System.out.print(rs.getString(1)+ "                ");
				System.out.println(rs.getString(2)+ "                ");
				
			}
			System.out.println("Total Rows - " + i );
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
