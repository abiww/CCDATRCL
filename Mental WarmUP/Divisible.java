/* Mental - WarmUP #2
 * Finding numbers divisble by 3 & 5 from [1-100]
 * Edit the program; add statement to find numbers divible by 4 & 6 as well
 */

import java.util.ArrayList;
import java.util.List;

public class Divisible {
	
    public static void main(String[] args) {
    	List<Integer> threeFive = new ArrayList<>();
      List<Integer> fourSix = new ArrayList<>();
        
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
            	threeFive.add(i);
            }

            if (i % 4 == 0 && i % 6 == 0) {
            	fourSix.add(i);
            }
        }
        
      System.out.println("The numbers divisible by 3 and 5 from [1-100] are: " + threeFive);
    	System.out.print("The numbers divisible by 4 and 6 from [1-100] are: " + fourSix);
    }
}
