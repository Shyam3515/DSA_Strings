/*
 * Video : https://www.youtube.com/watch?v=nK7SLhXcqRo
 * Link : https://www.geeksforgeeks.org/naive-algorithm-for-pattern-searching/
 */

package strings;
import java.util.ArrayList;
import java.util.List;

public class StringSearch {
	static void search1(String txt, String pat) {
		System.out.println("*****Search1*****");
		 int M = pat.length(); //"abcz"
	        int N = txt.length(); //"adababczaefghhidabckigjdpiabcdabcasabcz"	 
	        /* A loop to slide pat one by one */
	        //as inner loop rotates (i+j) times, here we considered n-m in outer loop
	        System.out.println(M+","+N);
	        for (int i = 0; i <= N - M; i++) {	 
	            int j;	 
	            /* For current index i, check for pattern
	              match */
	            for (j = 0; j < M; j++)
	            	//as inner loop rotates (i+j) times, here we considered n-m in outer loop                 
	                if (txt.charAt(i + j) != pat.charAt(j)) {
	                    break; //when condition doesn't satisfy inner loop breaks
	                }
	            	if (j == M) { // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
	            	//When loop completes it means j increments to four and fails
	                System.out.println("Pattern found at index " + i);
	            	}
	        }
	    }
	
	
	static void search2() {//try in wrong method
		System.out.println("*****Search2*****");
		int c=0;
		List<Integer> list = new ArrayList<Integer>();
		String s1="abcz";//"abc ":maintain space in string if you have space in s2
		String s2="adbedcadaaazzbabczaefghhidabckigjdpiabcdabcasabcz";
		int n=s1.length();
		int n1=s2.length();
		int c1=0;
		int i=0;
		while(i<n1)//here while continues then for loop continues from first
		{           //then there wont be any problem even j increments for non-sync chars
		    for(int j=0;j<n;) 
		    {		        
			    if(i<n1 && (s1.charAt(j)==s2.charAt(i)))
			    {		
			    	 System.out.println("j:"+j);	    	
			         i++;
			         j++;
				     c=c+1;
				     System.out.println("j1:"+j);
				     if(c==n) 
				     {
				         list.add(i-n);
				         c1=c1+1;     
    					 System.out.println("char:"+s2.charAt(i-1)+","+(i-n));
    					 c=0;
    					 j=0;
				     }
			    }
			    else
			    {	
			    	j=0;
			        i++;
			        if(i>=(n1)) {
			        	break;
			        }
			    }
		    }
		}
		System.out.println("Count:"+c1);
		System.out.println("indexes are :"+list);
	}
	

	    public static void main(String[] args)
	    {
	        String txt = "ABABDABACDABABCABABABABDABACDABABCABAB";
	        String pat = "ABABCABAB";	        
	        search1(txt, pat);
	        //search2();
	    }
}
	


