/*
 *  Link  : https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
 *  Video : https://www.youtube.com/watch?v=D6dCOa_gMoY&t=1074s
 *  Video : https://www.youtube.com/watch?v=ziteu2FpYsA
 *  Question : Find the Sublist of a string using KMP algorithm
 *  
 *  ALGORITHM : 
 *      1) Compute the pre-process method in pattern string.
 *      2) if first char equal to second char increment both i and j
 *      3) if not (j!=0) lps[j]=0; i=0,j++;  
 *      4) In kmp search follow the same process as above
 *      
 * The time complexity of KMP algorithm is O(n) in the worst case.
 * The worst case complexity of the Naive algorithm is O(m(n-m+1)).
 *  
 */
package strings;
//JAVA program for implementation of KMP pattern
//searching algorithm
public class KMPSublistSearch {
	static void KMPSearch(String text,String pattern,int M,int N) {
		int j=0;// index for pat[]
		// create lps[] that will hold the longest
        // prefix suffix values for pattern
		// Preprocess the pattern (calculate lps[]
        // array
		int lpsArr[]=computelps(pattern,M);
		int i=0;// index for txt[]
		int flag=0;
		while(i<N) {
			if(pattern.charAt(j)==text.charAt(i)) {
				i++;
				j++;
			}
			else {
				if(j!=0) {  //if not matches and j!=0 
					j=lpsArr[j-1]; //Setting j=0, starting from first.			
				}
				else //if j=0,increment i.
					i=i+1;
			}	
			if(j==M) {
				//i-j, bcz we need to get starting index of pattern
				//while iterating as i moves to end of text, we should subtract it.
				System.out.println("The index is at: "+(i-j));
				j=lpsArr[j-1];//reset to zero after completion
				flag=1;
			}
		}
		if(j!=M && flag==0){
			System.out.println("Sublist not found...");
		}
	}
	
	static int[] computelps(String pattern,int M) {
		// length of the previous longest prefix suffix
		int i=0;
		int j=1;
		int lps[] = new int[M];
		lps[0]=0;// lps[0] is always 0
        // the loop calculates lps[i] for i = 1 to M-1
		
		while(j<M) { //CABCABDABAC
			if(pattern.charAt(i)==pattern.charAt(j)) {
				i++; 
				lps[j]=i;
				j++;
			}
			else{ // 0 0 0 1 2 3 0 0 0 0 1
				lps[j]=0; //if char not matches set it to zero;
				i=0; // After setting to zero ,we are making i as 0, 
				j++;
				// Actually this both methods give same answer...
				
			/*
			  if (i != 0) { // 0 0 0 1 2 3 0 0 0 0 1
                    i = lps[i - 1];
                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[j] = i;
                    j++;
                }
               */
			}
		}
		System.out.print("LPS Array: ");
		for (i = 0; i < lps.length; i++) { 			
            System.out.print(lps[i] + " "); 
		}
		System.out.println();	
		return lps;		
	}
	
	public static void main(String[] args) {
		 //String text="abcabxsergyeryreyabcaby";
		 //String pattern="abcaby";
		 String text = "GeeksForGeeks";
	     String pattern = "For";
		 int M=pattern.length();
		 int N=text.length();
		 //(new KMPSublistSearch()).KMPSearch(text,pattern,M,N);	
		 KMPSublistSearch.KMPSearch(text,pattern,M,N);
	}
}