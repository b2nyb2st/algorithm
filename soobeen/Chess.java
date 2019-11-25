package a;

import java.util.Scanner;

public class Chess {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		String[] chess = new String[row];
		
		for (int i = 0; i < chess.length; i++) {
			chess[i]=sc.next();
		}
		
		int min = count(chess,0,0);
		for (int i = 0; i <= row - 8; i++) {
			for (int j = 0; j <= col - 8; j++) {
				if(min > count(chess,i,j)) {
					min = count(chess,i,j);
				}
			}
		}
		
		System.out.println(min);

	}
	
	public static int count(String[] chess, int rstart, int cstart) {
		char a = chess[0].charAt(0);
		int count = 0;
		for (int i = rstart; i < rstart + 8; i++) {
			for (int j = cstart; j < cstart + 8; j++) {
				if((i+j)%2==0) {
					if(chess[i].charAt(j) != a) {
						count++;
					}
					
				} else {
					if(chess[i].charAt(j) == a) {
						count++;
					}
				}
			}
		}
		
		return count>(64-count)?(64-count):count;
	}
}
