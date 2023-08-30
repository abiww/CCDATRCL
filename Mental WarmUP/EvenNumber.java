/* Mental - WarmUP #1
 * Finding even numbers from [1-100]
 * Edit the program; add statement to find odd numbers as well
 */

import java.util.ArrayList;
import java.util.List;

public class EvenNumber {
	
	public static void main(String[] args) {
		List<Integer> even = new ArrayList<>();
    List<Integer> odd = new ArrayList<>();
		
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0) {
				even.add(i);
			}
			
			if(i % 2 != 0) {
				odd.add(i);
			}
		}
		
		System.out.println("The even numbers from [1-100] are: " + even);
    System.out.print("The odd numbers from [1-100] are: " + odd);
	}
}
