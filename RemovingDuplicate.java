/*
 * Link : https://www.geeksforgeeks.org/remove-duplicates-from-a-given-string/
 */
package strings;
import java.util.HashSet;
import java.util.LinkedHashSet;
public class RemovingDuplicate {
	
	void DuplicateRemoval(char str[],int n){
        // Create a set using String characters
        // excluding '\0'
        HashSet<Character> s = new LinkedHashSet<>(n - 1);
        // HashSet doesn't allow repetition of elements
        for (char x : str)
            s.add(x);

        // Print content of the set
        System.out.print("Method 1: ");
        for (char x : s)
            System.out.print(x);
        System.out.println();
	}
	
	static String method2() {
		 String s = "geeksforgeeks";
		 String str = new String();
		 //String str = "";
        int len = s.length();
         
        /*loop to traverse the string and
          check for repeating chars using
          IndexOf() method in Java
         */
        
        for (int i = 0; i < len; i++)
        {
            // character at i'th index of s
            char c = s.charAt(i);
            
            System.out.println("c : "+c);   
           /* if c is present in str, it returns
            the index of c, else it returns -1
            */
            
           System.out.println("str:"+str.indexOf(c));
            if (str.indexOf(c) < 0)
            {
            	//System.out.println("str:"+str.indexOf(c));
                /* adding c to str if -1 is returned */
                str += c;
            }
        }        
        return str;
	}

	public static void main(String[] args) {
		char str[] ="geeksforgeeks".toCharArray();
        int n=str.length;
        RemovingDuplicate rev=new RemovingDuplicate();
		rev.DuplicateRemoval(str,n);
		
		System.out.println("Method 2: "+method2());

	}
}
