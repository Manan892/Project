package General;

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
		
}