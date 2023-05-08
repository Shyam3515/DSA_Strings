/*
 * Link : https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
 * 
 * Time Complexity : O(n)
   Space Complexity : O(n)
 */

package strings;

import java.util.HashMap;
import java.util.Set;

public class Anagrams {
	static boolean isAnagram(String a, String b) {
		if(a.length()!=b.length()) {
			return false;
		}
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<a.length();i++) {
			// Check if HashMap already contain current character or not
			if(map.containsKey(a.charAt(i))) {
				// If contains increase count by 1 for that character
				map.put(a.charAt(i),map.get(a.charAt(i))+1);
			}
			else {				
				// else put that character in map and set
                // count to 1 as character is encountered
                // first time
				map.put(a.charAt(i), 1);
			}
		}
		// Now loop over String b
        for (int i = 0; i < b.length(); i++) {
            // Check if current character already exists in
            // HashMap/map
            if (map.containsKey(b.charAt(i))) {
                // If contains reduce count of that
                // character by 1 to indicate that current
                // character has been already counted as
                // idea here is to check if in last count of
                // all characters in last is zero which
                // means all characters in String a are
                // present in String b.
                map.put(b.charAt(i),map.get(b.charAt(i)) - 1);
            } 
            else
            {
               return false;
            }
        }
     // Extract all keys of HashMap/map
        //we are checking for duplicates here with same length
        //if there are two same chars in any string, then we can't find it while removing
        //it from hash map
        Set<Character> keys = map.keySet();
        // Loop over all keys and check if all keys are 0.
        // If so it means it is anagram.
        for (Character key : keys) {
        	System.out.print(key+" ");
            if (map.get(key) != 0) {
                return false;
            }
        }
		return true;	
	}

	public static void main(String[] args) {
		 String str1 = "geeksforgeeks";
	     String str2 = "forgeeksgeeks";
	     
	  // Function call
	        if (isAnagram(str1, str2)) {
	            System.out.print("\nThe two strings are "
	                             + "anagram of each other");
	        }
	        else {
	        	System.out.print("\nThe two strings are "
                        + "not anagram of each other");
	        }
	}
}
