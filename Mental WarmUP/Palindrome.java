/* Mental - WarmUP #3
 * Identifying if a string is Palindrome or not
 * Edit the program; add statement to count the number of characters in the entered string.
 */

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
    	System.out.print("Enter String: ");
    	Scanner scan = new Scanner(System.in);
    	String str = scan.nextLine();
    	str = str.toLowerCase();
    	
    	int count = str.length();
    	char[] ch = str.toCharArray();
    	int num = 0;
		
		for(int i = 0; i < ch.length/2; i++) {
			if(ch[i] != ch[ch.length-1-i]) {
				num = 1; break;
			}
		}
		
		if(num == 0) {
			System.out.println("The word " + str + " is Palindrome");
			System.out.println("Count: " + count + " characters");
		} else {
			System.out.println("The word " + str + " is not Palindrome");
			System.out.println("Count: " + count + " characters");
		}
    }
}
