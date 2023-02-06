/*
 * Link:https://www.youtube.com/watch?v=fxwvVnBMN6I
 */
package strings;

public class LongestPalindromicSubsequence {
	static void printSubStr(String str, int low, int high)     
	    {
	        System.out.println(str.substring(low, high + 1));    
	    }	
	
	static int LPS(String s, int n) {
		int dp[][]=new int[n][n];
		
		int maxlength=0;
		//String ans = "";
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
		                        start=i;
		                        System.out.println("max2:"+maxlength);	                	
	                }
	                else 
	                {
	                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]>0) {
	                        dp[i][j] = dp[i+1][j-1]+2; 
	                        //System.out.println(dp[i][j]);
	                        
		                    if(j-i+1>maxlength) {		                    	
		                        maxlength = j-i+1;
		                        start=i;
		                        System.out.println("max3:"+maxlength+" i: "+i+" j: "+j);
		                        //ans = s.substring(i,maxlength);
		                        }
	                    } 
	                }	                
	           } 
	    }
		System.out.print("Longest palindrome substring is: ");
		 printSubStr(s, start,
                 start + maxlength - 1);
		//System.out.println("Ans: "+ans);
	    return maxlength;
	}
	
	public static void main(String[] args) {
		String s="cabbacaacbabaca";
		int n=s.length();
		System.out.println("Length is: " +LPS(s,n));
	}
}
