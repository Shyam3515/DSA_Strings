/*
 * Video : https://www.youtube.com/watch?v=vhsxfQ7ih4c
 * 
 * Expected Time Complexity: O(N).
   Expected Auxiliary Complexity: O(1).
 */
package strings;

public class RotateBy2 {
	
	static void rotateByValue(String s1, String s2, int val) {
		int len=s1.length();
		System.out.println(len);
		int flag=0;
		if(len<val) {
			if(s1==s2) {
				System.out.println("True1");
			}
			else {
				System.out.println("False1");
			}
		}
		
		//Clock-wise rotation of String s1 by 2 positions.
		String s3=s1.substring(val,len);//First Four values => AMAZ
		s3=s3+s1.substring(0,val); // last Two => ON
		System.out.println(s3);
		//Anti Clock-wise rotation of String s1 by 2 positions.
		String s4=s1.substring(len-val,len);//Last two values => ON
		s4=s4+s1.substring(0,len-val); //First Four values => AMAZ
		System.out.println(s4);
		
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

	public static void main(String[] args) {
		String s1="AMAZON";
		String s2="AZONAM";
		int value = 2;
		rotateByValue(s1, s2, value);
		
	}
}
