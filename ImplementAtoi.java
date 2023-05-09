/*atoi means a to i => ascii to integer
 * 
 * Link : https://www.geeksforgeeks.org/write-your-own-atoi/
 * Video : https://www.youtube.com/watch?v=2UeeIMo913U
 * Question : The atoi() function in C takes a string (which represents an integer)
     as an argument and returns its value of type int. So basically the function 
     is used to convert a string argument to an integer.
	Syntax:  
	int atoi(const char strn)
	
 *
 *	
 *Complexity Analysis for all the above Approaches: 
	Time Complexity: O(n). 
	Only one traversal of string is needed.
	Space Complexity: O(1). 
	As no extra space is required.	
 */
package strings;

public class ImplementAtoi {
	/*
	 * Because, the literals are arranged in sequence. So if 0 was 48, 1 will be 49,
	 * 2 will be 50 etc.. in ASCII, then x would contain, ascii value of '9' minus
	 * the ascii value of '0' which means, ascii value of '9' would be 57 and hence,
	 * x would contain 57 - 48 = 9 . Also, char is an integral type.
	 */
	static int atoi(String s) {
		int sign=0,out=0;
		int n=s.length();
		
		for(int i=0;i<n;i++) {
			//Checking the first value
			if(i==0 && s.charAt(i)==45) {//ASCII value of '-' is 45.
				sign=1;
				System.out.println(s.charAt(i));
				continue;//As we got first value continue;
			}
			
			//we don't want to include any alphabets
			if(s.charAt(i)>='0' && s.charAt(i)<='9') {
				//System.out.println(s.charAt(i));
				if(i==0) {
					out=s.charAt(i)-48;
					//System.out.println("i1:"+out);
					}
				else {
					out=out*10 + (s.charAt(i)-48);
					//System.out.println("i:"+out);
				}
			}
			else {
				//If we found other than numbers returns -1.
				return -1;
			}	
		}
		//If sign=1; subtract out from zero;
		if(sign==1) {
			out=0-out;
		}
		return out;
	}

	public static void main(String[] args) {
		String s="-5068a";
		int Atoi=atoi(s);
		System.out.println("The converted number from String is: "+Atoi);
	}

}
