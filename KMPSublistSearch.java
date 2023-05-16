/*
 *  Logic First => Video : https://www.youtube.com/watch?v=4jY57Ehc14Y&t=468s
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
		// create lps[] that will hold the longestPrefixSuffix[lps] values for pattern
		// Preprocess the pattern (calculate lps[]) array. Use of this array lps is
		// no need to start pattern from start if there is any prefix and suffix in pattern
		// You can directly start from the prefix from next iteration, if there is no match..
        
		int lpsArr[]=computelps(pattern,M);
		int i=0;// index for txt[]
		int flag=0;
		while(i<N) {
			if(pattern.charAt(j)==text.charAt(i)) {
				i++;
				j++;
			}     
			else {  
				if(j!=0) {  //if no matches found and j!=0 
					//if there is any prefix or suffix in previous value,that will be assigned to j.
					// otherwise as previous value will be Zero, j will be zero...
					j=lpsArr[j-1]; 	
					System.out.println("After: "+j);
				}
				else //if j=0,increment i.
					i=i+1;
			}	
			if(j==M) {
				//i-j, bcz we need to get starting index of pattern
				//while iterating as i moves to end of text, we should subtract it.
				System.out.println("The index is at: "+(i-j));
				j=lpsArr[j-1]; //going back to previous value in array...
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
		
		while(j<M) { //onions
			if(pattern.charAt(i)==pattern.charAt(j)) {
				i++; 
				lps[j]=i;
				j++;
				 //these print lines are to find how many iterations it takes

			}
			else{ 
				lps[j]=0; //if char not matches set it to zero;
				i=0; // After setting to zero ,we are making i as 0, 
				j++;

				// Actually this both methods give same answer...
				//but first one takes less iterations...
				
//			  if (i != 0) {
//                    i = lps[i - 1];
//                    // Also, note that we do not increment
//                    // i here
//                    System.out.println("3");
//                }
//                else // if (len == 0)
//                {
//                    lps[j] = i;
//                    j++;
//                    System.out.println("4");
//                } 
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
		 String text = "onionionspl";
	     String pattern = "onions";
		 int M=pattern.length();
		 int N=text.length();
		 //(new KMPSublistSearch()).KMPSearch(text,pattern,M,N);	
		 KMPSublistSearch.KMPSearch(text,pattern,M,N);
	}
}