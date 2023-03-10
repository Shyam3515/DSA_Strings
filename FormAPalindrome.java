/* DYNAMIC PROGRAMMING
 * Link : https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
 * Video : https://www.youtube.com/watch?v=iQKeblfj6jc
 * 
 * Question : Given a string, find the minimum number of characters to be inserted
    to convert it to palindrome.
	For Example:
	ab: Number of insertions required is 1. bab or aba
	aa: Number of insertions required is 0. aa
	abcd: Number of insertions required is 3. dcbabcd
 * 
 * Expected Time Complexity: O(N2), N = |str|
   Expected Auxiliary Space: O(N2)
   
 */
package strings;

public class FormAPalindrome {
	static String reverse(String s1) {
		 String str=s1;
			String[] words=str.split("//s");
			String reverseword="";
			
			for(String w:words){ 
				StringBuilder sb=new StringBuilder(w);
			    sb.reverse(); 
			    reverseword=reverseword+sb.toString()+" "; 
			}
		return reverseword;	
	}
	
	static int palindromeForm(String s1,String s2,int n){
		int dptable[][]=new int[n+1][n+1];//dptable
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					dptable[i][j]=0;
				}
				else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dptable[i][j]=1+dptable[i-1][j-1];//diagonal element +1;
				}
				else {
					//max of two diagonal elements
					dptable[i][j]=Math.max(dptable[i-1][j],dptable[i][j-1]);
				}
			}
		}
		return dptable[n][n];	
	}
	public static void main(String[] args) {
	String s1="aasjkbdfk";
	int n=s1.length();
	String s2=reverse(s1);
	System.out.println(s2);
	int pal=palindromeForm(s1,s2,n);
	//System.out.println("No. of insertions  are: "+(pal));
	System.out.println("No. of insertions required are: "+(n-pal));
	}

}
