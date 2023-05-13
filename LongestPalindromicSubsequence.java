/*
 * Code with Alisha
 * Link:https://www.youtube.com/watch?v=fxwvVnBMN6I
 * 
 * Time complexity: O(N2). A nested traversal is needed.
   Auxiliary Space: O(N2). A matrix of size N*N is needed to store the table.
 */
package strings;

public class LongestPalindromicSubsequence {
	
	static int LPS(String s, int n) {
		int dp[][]=new int[n][n];
		
		int maxlength=0;
		int start=0;
		for(int diff = 0;diff<n;diff++) {
	            for(int i=0,j=i+diff; j<n; i++, j++)
	            {
	                if(i==j)
	                {
	                	dp[i][j]=1;
	                	maxlength=1;
	                	System.out.println("max1:"+maxlength);	                	
	                }
	                else if(diff==1 && s.charAt(i)==s.charAt(j)){ 	                
		                        dp[i][j]=(s.charAt(i)==s.charAt(j))?2:0;
		                        maxlength=2;
		                        System.out.println("max2:"+maxlength);	                	
	                }
	                else 
	                {
	                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]>0) {
	                        dp[i][j] = dp[i+1][j-1]+2; 
	                    }
	                }
	                     
	                if(dp[i][j]>0) {
	                	if(j-i+1>maxlength) {		                    	
	                        maxlength = j-i+1;
	                        start=i;
	                        System.out.println("max3:"+maxlength+" i: "+i+" j: "+j);	                   
	                     }
	                }           	                
	           } 
	    }
		System.out.println("Longest palindrome substring is from index: "
				+start+" to " +(start + maxlength - 1));
		 
	    return maxlength;
	}
	
	public static void main(String[] args) {
		String s="cabacaccacbabaca";
		int n=s.length();
		System.out.println("Length of LPS is: " +LPS(s,n));
	}
}
