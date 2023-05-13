/*
 * Link : https://www.geeksforgeeks.org/remove-duplicates-from-a-given-string/
 */
package strings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
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
        int len = s.length();
        
        for (int i = 0; i < len; i++)
        {
            char c = s.charAt(i);          
            System.out.println("c : "+c);   
           /* if c is present in str, it returns
            the index of c, else it returns -1
            */
           System.out.println("str:"+str.indexOf(c));
            if (str.indexOf(c) < 0)
            {
                /* adding c to str if -1 is returned */
                str += c;
            }
        }        
        return str;
	}
	
	//remove duplicates
	String removeAllDups(String str, int l) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		String s1 ="";
		for(int i=0;i<l;i++) {
			if(map.containsKey(str.charAt(i))){
				continue;
			}
			else {
				map.put(str.charAt(i), 1);
				s1+=str.charAt(i);
			}
		}
		return s1;
	}
		
	//Remove all similar
	String removeAllSimilarDups(String str, int l) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		String s1 ="";
		for(int i=0;i<=l;i++) {
			if(map.containsKey(str.charAt(i))){
				map.put(str.charAt(i),map.get(str.charAt(i)) - 1);
				//map.put(arr[i], map.get(arr[i]) + 1);
			}
			else {
				map.put(str.charAt(i), 1);
				s1+=str.charAt(i);
			}
		}
		System.out.println(map);
//		Set<Character> keys = map.keySet();
//		for(Character ch : keys) {
//			if(map.get(ch)==1)
//				s1+=ch;
//		}
		return s1;
	}

	public static void main(String[] args) {
		char str[] ="geeksforgeeks".toCharArray();
        int n=str.length;
        RemovingDuplicate rev=new RemovingDuplicate();
		rev.DuplicateRemoval(str,n);
		
		System.out.println("Method 2: "+method2());
		
		//remove duplicates
		String str1 = "geeksforgeeks";
		int length = str1.length();
		String s2 = rev.removeAllDups(str1,n-1);
		System.out.println("Remove All: "+s2);
		//Remove all similar
		String s3 = rev.removeAllSimilarDups(str1, length-1);
		System.out.println("Remove All Similar: "+s3);

	}
}
