/* Laboratory Activity #1
 * Date: September 11 2023
 * Create a main class and 3 classes with specific functionality
 */

import java.util.Scanner;

//Main Class: Ask for number and string
public class Main {

	public static void main(String[] args) {
		System.out.print("Enter a number: ");
		Scanner scan = new Scanner(System.in);
    	int number = scan.nextInt();
    	
    	System.out.print("Enter a string: ");
    	Scanner scan2 = new Scanner(System.in);
    	String word = scan2.nextLine();
    	word = word.toLowerCase();
    	
    	Divisible divisible = new Divisible();
    	divisible.checkTwoThree(number);
    	
    	EvenOdd evenOdd = new EvenOdd();
    	evenOdd.checkEvenOdd(number);
    	
    	Palindrome palindrome = new Palindrome();
    	palindrome.checkPalindrome(word);
	}
}

//Class #1: Check if the number is divisible by 2 or 3
class Divisible {
	void checkTwoThree(int integer) {
		if (integer % 2 == 0) {
			System.out.println(integer + " is divisible by 2");
		} else if (integer % 3 == 0) {
			System.out.println(integer + " is divisible by 3");
		} else {
			System.out.println(integer + " is not divisible by 2 or 3");
		}
	}
}

//Class #2: Check if the number is even or odd
class EvenOdd {
	void checkEvenOdd(int integer) {
		if(integer % 2 == 0) {
			System.out.println(integer + " is an even number");
		} else {
			System.out.println(integer + " is an odd number");
		}
	}
}

//Class #3: Check if the word is palindrome or not
class Palindrome {
	void checkPalindrome(String string) {
		char[] ch = string.toCharArray();
		int num = 0;
		
		for(int i = 0; i < ch.length/2; i++) {
			if(ch[i] != ch[ch.length-1-i]) {
				num = 1; break;
			}
		}
		
		if(num == 0) {
			System.out.println("The word " + string + " is Palindrome");
		} else {
			System.out.println("The word " + string + " is not Palindrome");
		}
	}
}

