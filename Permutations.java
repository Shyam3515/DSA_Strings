/* ### Refer heap sort video for better understanding of recursion ### 
 * Link : https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * Link : https://www.javatpoint.com/java-program-to-ind-all-the-permutations-of-a-string
 * Video : https://www.youtube.com/watch?v=GuTPwotSdYw&t=807s
 * Video1 : https://www.youtube.com/watch?v=YK78FU5Ffjw
 * Question : Write a program to print all permutations of a given string
 * Description : 
 *    A permutation also called an “arrangement number” or “order,” 
 *    is a rearrangement of the elements of an ordered list S into a one-to-one correspondence with S itself.
 *    A string of length n has n! permutation. 
 *  
 * Algorithm:
 * 		To solve this problem, we need to understand the concept of backtracking.

		According to the backtracking algorithm:
		
		1) Fix a character in the first position and swap the rest of the character with the first character. 
		   Like in ABC, in the first iteration three strings are formed: ABC, BAC, and CBA by swapping A with A, B and C respectively.
		   
		2) Repeat step 1 for the rest of the characters like fixing second character B and so on.
		
		3) Now swap again to go back to the previous position. E.g., from ABC, we formed ABC by fixing B again, 
		   and we backtrack to the previous position and swap B with C. So, now we got ABC and ACB.
		   
		4) Repeat these steps for BAC and CBA, to get all the permutations.
		
 * Algorithm Paradigm: Backtracking 
 * Time Complexity: O(n*n!) Note that there are n! permutations and it requires O(n) time to print a permutation.
 * Auxiliary Space: O(r – l)
 * 		
 */
package strings;
//See data structures book for diagram last page from front.
public class Permutations {
	static int c=0;
	//Function for generating different permutations of the string    
	void permute(String str, int l,int end)
	{
		//Prints the permutations 
		if (l==end) {					
			System.out.println("Permuted String: "+str);
			c=c+1;	
		}
			
		else {
			for(int i=l;i<=end;i++) {
				//Swapping the string by fixing a character
				str=swap(str,l,i);
				//Recursively calling function generatePermutation() for rest of the character
				permute(str,l+1,end);
				 //Backtracking and swapping the characters again.    
				str=swap(str,l,i);
			}
		}
		
	}
	 //Function for swapping the characters at position 'i' with character at position 'j'.
	String swap(String str,int i,int j) {
		char temp;
		char[] charArray = str.toCharArray();
		//With this step you can see the flow of operations
		System.out.print(charArray);
		System.out.println(" => ("+i+","+j+")");
		temp = charArray[i] ;
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);	
	}

	public static void main(String[] args) {
		String str = "ABC";
        int n = str.length();
        Permutations permutation = new Permutations();
        permutation.permute(str, 0, n-1);
        System.out.println("Total number of Permutations");	
        System.out.println("with "+"length "+ n +" is : " + c);
	}

}
