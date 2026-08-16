package General;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class ReadWrite {
	
	Scanner sc = new Scanner(System.in);
	
	int scanInt() {
		return sc.nextInt();
	}	
	float scanFloat() {
		return sc.nextFloat();
	}
	double scanDouble() {
		return sc.nextDouble();
	}
	boolean scanBool() {
		return sc.nextBoolean();
	}
	String scanString() {
		return sc.nextLine();
	}
	
	private final static String url = "jdbc:mysql://localhost:3306/library";
	private final static String user = "root";
	private final static String password = "";
	
	public static Connection connect() throws SQLException{
		return  DriverManager.getConnection(url, user, password);
	}
		
}
