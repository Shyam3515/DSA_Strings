/*
 * Link : https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * Video : https://www.youtube.com/watch?v=yZWmS6CXbQc
 * Video1 : https://www.youtube.com/watch?v=UflHuQj6MVA 
 * 
 * Question : Given a string, find the longest substring which is a palindrome. 
	For example, 
		Input: Given string :"forgeeksskeegfor", 
		Output: "geeksskeeg"
		
		Input: Given string :"Geeks", 
		Output: "ee"
 * 
 * Method 2: Dynamic Programming. 
	Approach: The time complexity can be reduced by storing results of sub-problems.
	 The idea is similar to this post.  
	
	1.Maintain a boolean table[n][n] that is filled in bottom up manner.
	2.The value of table[i][j] is true, if the substring is palindrome, otherwise false.
	3.To calculate table[i][j], check the value of table[i+1][j-1], if the value is true 
	  and str[i] is same as str[j], then we make table[i][j] true.
	4.Otherwise, the value of table[i][j] is made false.
	5.We have to fill table previously for substring of length = 1 and length =2 because 
	as we are finding , if table[i+1][j-1] is true or false , so in case of 
	(i) length == 1 , lets say i=2 , j=2 and i+1,j-1 doesn’t lies between [i , j] 
	(ii) length == 2 ,lets say i=2 , j=3 and i+1,j-1 again doesn’t lies between [i , j].
 
 *Complexity Analysis:  
	Time complexity: O(n^2). 
	  Two nested traversals are needed.
	Auxiliary Space: O(n^2). 
	  Matrix of size n*n is needed to store the dp array.
	  
 */
package strings;

public class LPS {
	// A utility function to print
    // a substring str[low..high]
    static void printSubStr(
        String str, int low, int high)
    {
        System.out.println(
            str.substring(
                low, high + 1));
    }
 
    // This function prints the longest
    // palindrome substring of str[].
    // It also returns the length of the
    // longest palindrome
    static int longestPalSubstr(String str)
    {
        // get length of input string
        int n = str.length();
 
        // table[i][j] will be false if
        // substring str[i..j] is not palindrome.
        // Else table[i][j] will be true
        boolean table[][] = new boolean[n][n];
 
        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;
 
        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
 
        // Check for lengths greater than 2.
        // k is length of substring
        for (int k = 3; k <= n; ++k) {
 
            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;
 
                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;
 
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is: ");
        printSubStr(str, start,
                    start + maxLength - 1);
 
        // return length of LPS
        return maxLength;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdcabcaacbacbaca";
        System.out.println("Length is: " + longestPalSubstr(str));
	}
}
