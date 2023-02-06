/*
 * Video : https://www.youtube.com/watch?v=vhsxfQ7ih4c
 * 
 * Expected Time Complexity: O(N).
   Expected Auxilary Complexity: O(1).
 */
package strings;

public class RotateBy2 {

	public static void main(String[] args) {
		String s1="AMAZON";
		String s2="AZONAM";
		int len=s1.length();
		System.out.println(len);
		int flag=0;
		if(len<2) {
			if(s1==s2) {
				System.out.println("True1");
			}
			else {
				System.out.println("False1");
			}
		}
		//Clock-wise rotation of String s1 by 2 positions.
		String s3=s1.substring(2,len);//First Four values
		s3=s3+s1.substring(0,2);
		//System.out.println(s3);
		//Anti Clock-wise rotation of String s1 by 2 positions.
		String s4=s1.substring(len-2,len);//Last two values
		s4=s4+s1.substring(0,len-2);
		//System.out.println(s4);
		
		for(int i=0;i<len;i++) {
			if(s3.charAt(i)==s2.charAt(i) || s4.charAt(i)==s2.charAt(i)) {
				flag=1;
			}
			else {
				flag=0;
			}
		}
		
		if(flag==1) {
			System.out.println("True2");
		}
		else {
			System.out.println("False2");
		}	
	}
}
