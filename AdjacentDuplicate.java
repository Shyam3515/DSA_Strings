package strings;

public class AdjacentDuplicate {
	String duplicateremoval(String s,int n,int l) 
	{
		String s1="";//create Empty String
		for(int i=0;i<n-1;i++) {
			//If next char not equals the present, add present to new string.
			if(s.charAt(i)!=s.charAt(i+1)) {
				char s2=s.charAt(i);
				s1+=s2;
			}
		}
		//we need to add last char always, because we iterate to till, last but one char
		s1+=s.charAt(n-1);
		return s1;	
	}
	
	String allAdjacentDup(String s,int n,int l) {
		String s1="";//create Empty String
		for(int i=0;i<n-1;i++) {
			//if l=1,means same two characters are present side by side
			//So,skip those two and move to next character
			//else,add that character to string
			if(s.charAt(i)==s.charAt(i+1)) {
				l++;
			}
			else if(l>0){
				l=0;
				continue;	
			}
			else {
				char s2=s.charAt(i);
				s1+=s2;
			}
		}
		//we need to check last char always, because we iterate to till last but one char
		if(s.charAt(n-1)!=s.charAt(n-2)) {
			char s2=s.charAt(n-1);
			s1+=s2;
		}
		return s1;
	}

	public static void main(String[] args) {
		String s="geeekkksforgeek";
		int n=s.length();
		AdjacentDuplicate dup=new AdjacentDuplicate();
		String res=dup.duplicateremoval(s, n,0);
		System.out.println("Result: "+res);
		String res1=dup.allAdjacentDup(s, n,0);
		System.out.println("Result: "+res1);
	}	
}