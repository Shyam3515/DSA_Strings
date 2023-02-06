/*
 * Link : https://www.geeksforgeeks.org/reverse-a-string-in-java/
 * 
 * Following are some interesting facts about String and StringBuilder classes : 
	1. Objects of String are immutable. 
	2. String class in Java does not have reverse() method, however StringBuilder class has built in reverse() method. 
	3. StringBuilder class do not have toCharArray() method, while String class does have toCharArray() method. 
	 
		1. The idea is to traverse the length of the string 
		2. Extract each character while traversing 
		3. Add each character in front of the existing string
  
 * 
 * // java program to reverse a word 
	import java.io.*;
	import java.util.Scanner;
	 
	class GFG {
	    public static void main (String[] args) {
	       
	        String str= "Geeks", nstr="";
	        char ch;
	       
	      System.out.print("Original word: ");
	      System.out.println("Geeks"); //Example word
	       
	      for (int i=0; i<str.length(); i++)
	      {
	        ch= str.charAt(i); //extracts each character
	        nstr= ch+nstr; //adds each character in front of the existing string
	      }
	      System.out.println("Reversed word: "+ nstr);
	    }
	}
 */
package strings;

public class StringOperations {
	
	void wordreverse(){
        String str="Welcome";
		String[] words=str.split("\\s");
		System.out.println("Word length: "+words.length);
		
		String reverseword="";
		
		for(String w:words){ //welcome
		
			StringBuilder sb=new StringBuilder(w);
		    sb.reverse(); //emoclew
		    
		    reverseword=reverseword+sb.toString()+" "; //emoclew
            //sb.setLength(0);
		}
		System.out.println(reverseword);
		System.out.println("******************");
    }
    
    void Stringandwordreverse(){
        String str="Welcome";
		String[] words=str.split("//s");
		System.out.println("Word length: "+words.length);
		
		String reverseword="";
		
		StringBuilder sb;
		for(String w:words){ //welcome
		
		    sb=new StringBuilder(w);
		    sb.reverse(); //emoclew
		    
		    reverseword=reverseword+sb.toString()+" "; //emoclew
		 // set length equal to '0'.
            sb.setLength(0); //every x iterations I want to empty it and start with an empty StringBuilder
		}
		System.out.println(reverseword);
		System.out.println("******************");
    }
    
    void wordswithgap(){
        String str="Welcome to java";
		String[] words=str.split("");
		System.out.println("Word length: "+words.length);
		String reverseword="";
	
		StringBuilder sb;
		for(String w:words){ //welcome
		    sb=new StringBuilder(w);
		    sb.reverse(); //emoclew
		    reverseword=reverseword+sb.toString()+" "; //emoclew
            //sb.setLength(0);
		}
		System.out.println(reverseword);
		System.out.println("******************");
    }
    
    void Stringreverse(){
        String str = "i like this program very much";
        String words[] = str.split(" ");
        System.out.println("Word length: "+words.length);                                
        String ans = "";
        for (int i = words.length - 1; i >= 0; i--)
        {
            ans += words[i] + " ";
        }
        System.out.println("Reversed String:");
        System.out.println(ans);//ans.substring(0, ans.length() - 1) //returns substring    
        System.out.println("******************");        
    }
    
    void stringReverseWithChar() {
    	String S = "i.like.this.program.very.much";
    	//System.out.println(S.substring(5,24));
    	String s2="";
    	int len= S.length();
    	int c=0;
    	int flag=0;
    	for(int i=len-1;i>=0;i--) {
    		if(S.charAt(i)=='.') {
    			//taken this condition to add dot after the first iteration.
    			if(flag==0) {
	    			len=len-c;// decreasing length by c,so we can add substr,from len to len+c.
	    			System.out.println(c+","+len);
	    			String s3=(S.substring(len,len+c));
	    			//System.out.println(s3);
	    			s2=s2+s3;
	    			s2=s2+".";
	    			c=0;
	    			flag=1;// added flag=1, to make sure it works for only 1st iteration
    			}
    			else {
    				len=len-c;
	    			System.out.println(c+","+len);
	    			String s3=(S.substring(len,len+c));
	    			//System.out.println(s3);
	    			s2=s2+s3;    			
	    			c=0;
    			}
    		}
    		c++;// to count when it doesn't met with dot	
    	}
    	s2+=(S.substring(0,len-1));
    	System.out.println(s2);
    }

	public static void main(String[] args) {
		StringOperations rev=new StringOperations();
		System.out.println("Word Reverse:");
		rev.wordreverse();
		System.out.println("String and Word Reverse:");
		rev.Stringandwordreverse();
		System.out.println("Gap between Words:");
		rev.wordswithgap();
		System.out.println("String Reverse:");
		rev.Stringreverse();
		System.out.println("String Reverse with chars:");
		rev.stringReverseWithChar();

	}
}
