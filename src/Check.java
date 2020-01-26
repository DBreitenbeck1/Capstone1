
public class Check {
	public static boolean checker(String a) {
		boolean c =false; 
		for (int j=0; j<a.length(); j++) {
			int t = a.codePointAt(j);
			if (t>=65 && t<=122)  {
			//checking for upper case letters
				c= true;
			} else if (t>=97 && t<=122) {
				//checking for lower case letters
				c=true;
				
			} else if ((t >=32 && t<=33) || (t == 46) ||(t ==63) || (t >=58 && t<=59)
					|| (t == 39)|| (t == 44) ||(t >=40 && t<=41) ) {
				//checking for punctuation
				c=true;
			} else {
				c=false;
				j=a.length();
				//break;
			}
		
	}	
		return c;	
}
}
