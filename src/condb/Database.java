package condb;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
//	public static void main(String[] a){
//		Connection cn =null;
//		cn = getConnection();
//		if(!cn.equals(null)){
//			System.out.println("สามารถติดต่อ DB ได้นะ");
//		}
//	}
	
	public static Connection getConnection(String vBCUser,String vBCPassword) { 
		String strUrl="jdbc:sqlserver://nebula.nopadol.com; databaseName=bcnp";
		//String strUrl="jdbc:sqlserver://192.168.0.7; databaseName=nebula";
        try  {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	Connection sqlcon = DriverManager.getConnection(strUrl, vBCUser, vBCPassword);        	
            return sqlcon;
        }
        catch(Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }

     public static void close(Connection sqlcon) {
        try  {
            sqlcon.close();
        }
        catch(Exception ex) {
        }
    }

}
