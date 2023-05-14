/*
 * Link : https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * Video : https://www.youtube.com/watch?v=RqxIXM6eyiY&list=PLLT4EuYB4kIah6F-m0v-zfrQKg1G1zAJC&index=10
 * 
 * Question : Given a string str, find the length of the longest substring without
    repeating characters. 

	Example:	
	For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.
	 
 * Method 3 ( Linear Time ): Using this solution the problem can be solved in linear
      time using the window sliding technique. Whenever we see repetition, we remove
      the window till the repeated string.
      
 * Time Complexity: O(n) since we slide the window whenever we see any repetitions.
   Auxiliary Space: O(1)     
 */
package strings;

public class LongestDistinctCharacters {
	
	static String final_str;
	static String before_str;
	public static int longestUniqueSubsttr(String str)
    {
        String test = "";
        // Result
        int maxLength = -1;
 
        // Return zero if string is empty
        if (str.isEmpty()) {
            return 0;
        }
        // Return one if string length is one
        else if (str.length() == 1) {
        	final_str = str;
            return 1;
        }
        for (char c : str.toCharArray()) {
            String current = String.valueOf(c);
            
            // If string already contains the character
            // Then substring after repeating character
            if (test.contains(current)) {        	 
            	//actually we are getting test.length() after substringing it.
            	//it removes till the given index value
                test = test.substring(test.indexOf(current) + 1);                                 
                System.out.println("Test: "+test);              
            } 
            test = test + String.valueOf(c);
            maxLength = Math.max(test.length(), maxLength);
            if(test.length()==maxLength) {
            	final_str=test;
            }
            System.out.println("Final Test: "+test);          
        }
        return maxLength;
    }
 
    // Driver code
    public static void main(String[] args)
    {
        String str = "sshyam";
        int len = longestUniqueSubsttr(str);
        System.out.println("The length of the longest non-repeating character substring is: " + len);                                         
        System.out.println("Final String: "+final_str);
    }
}

