/*
 * Link : https://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/
 * Video : https://www.youtube.com/watch?v=Q47UqiJKB7M
 * Question : Given a Roman numeral, the task is to find its corresponding decimal value.
	
	Example : 
		Input: IX
		Output: 9
		IX is a Roman symbol which represents 9
 
 *	Algorithm : 
 *		1.Split the Roman Numeral string into Roman Symbols (character).
		2.Convert each symbol of Roman Numerals into the value it represents.
		3.Take symbol one by one from starting from index 0: 
		  a.If current value of symbol is greater than or equal to the value of 
		    next symbol, then add this value to the running total.
		  b.else subtract this value by adding the value of next symbol to the running total.
		  
 * Time complexity – O(N)
   Auxiliary Space – O(1)		  	
 */
package strings;

import java.util.HashMap;

public class RomanToNumber {
		 
		// This function returns value
		// of a Roman symbol
		private static int romanToInt(String s)
		{
		HashMap<Character,Integer> roman = new HashMap<Character,Integer>()                                                     
			{{
			    put('I', 1);
			    put('V', 5);
			    put('X', 10);
			    put('L', 50);
			    put('C', 100);
			    put('D', 500);
			    put('M', 1000);
			}};
			
		    int sum = 0;
		    int n = s.length();
		    
		    for(int i = 0; i < n;)
		    {		         
		        // If present value is greater than next value,
		        // add the resultant to the sum variable.
		    	// XII = 10+1+1 =12
		        if (i == n - 1 || roman.get(s.charAt(i)) >=
		                          roman.get(s.charAt(i + 1)))
		        {
		        	sum += roman.get(s.charAt(i));
		            i++;
		        }
		        else
		        {	
		        	// If present value is less than next value,
			        // subtract present from next value and add the
			        // resultant to the sum variable.
		        	
		        	// IV = 5-1 = 4
		           sum += roman.get(s.charAt(i + 1)) - roman.get(s.charAt(i));         
		           i=i+2;
		        }
		    }
		    return sum;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "V";
	     
	    System.out.print("Integer form of Roman Numeral is " +
	                     romanToInt(input));
	}
}
