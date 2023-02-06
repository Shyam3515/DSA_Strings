package strings;
public class FinalAdjacentDuplicates {
	String solve(String s)
    {
		int n=s.length();
        int i=0;
        String res="";
        int flag=0;
        while(i<n)
        {
        	//when it comes to last char, it wont satisfy the n-1,condition.
        	// So, directly it will move to else condition.
            if(i<n-1 && s.charAt(i)==s.charAt(i+1))//checks for adjacent duplicate
            {
            	//checks for long duplicates Ex:daaaab
                while(i<n-1 && s.charAt(i)==s.charAt(i+1)) {
                	i++;
                	//flag=1;//next iteration will happen only if flag==1 in first iteration
                }          
            }
            else {
                res+=s.charAt(i);//adding non adjacent duplicates in first iteration
            }
            i++;       
        }
       //System.out.println(flag+","+res);
        if(res.length()>1 && flag==1) {
        	return solve(res);
        }
        return res;
    }
	public static void main(String[] args) {
		String s="abccbccba";
		FinalAdjacentDuplicates dup=new FinalAdjacentDuplicates();
		String res=dup.solve(s);
		System.out.println("Result: "+res);

	}
}
