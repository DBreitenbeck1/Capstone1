import java.util.Scanner;

public class Capstone1 {
	public static void main(String[] args) {
		Check c = new Check();
		//Note: the above method is found in the class 'Check' included in this project
		Scanner scanner = new Scanner(System.in);
		String entry ="";
		String out ="";
		
		String sub ="";
		String let="";
		String pre ="";
		String suff ="";
		String ay = "ay";
		String way = "way";

		char[] punct = {'.', ',', '!','?',';', ':',')','('};
		char[] vowels = {'a','e','i','o','u'};
		int remainder =0;
		int vowelIndex = 0;
		int entryLength =0;
		int y;
		int i =0;
		int vCheck;
		int x=0;
		boolean bigLoop = true;
		boolean littleLoop = true;
		char pun = ' ';
	
		System.out.println("Welcome to the Pig-Latin Translator!");
		System.out.println();
	
	do {
		String op ="";
		littleLoop=true;
		
		System.out.println("Enter a line to translate: ");
		entry = scanner.nextLine().trim();
			
		if (c.checker(entry)) {
		
			String[] splitEntry = entry.split(" ");
					
		for (x=0; x<splitEntry.length; x++) {
			vowelIndex = splitEntry[x].length();
			entryLength = splitEntry[x].length();
			remainder = splitEntry[x].length();
			out = "";
			pun = ' ';
			for (y=0; y<splitEntry[x].length(); y++) {
				for (int p=0; p<punct.length; p++)
				if (splitEntry[x].charAt(y) == punct[p]) {
					pun = splitEntry[x].charAt(y);
					remainder = remainder-1;
				}
			}
		
		for (i =0; i< splitEntry[x].length(); i++)	{
			for (y= 0; y < vowels.length; y++) {	
				vCheck = splitEntry[x].toLowerCase().indexOf(vowels[y]);
				if ((vCheck<vowelIndex) && (vCheck>-1)) {
					vowelIndex=vCheck;
					} 		
				}
			}		
						
				if (vowelIndex == 0) {
					sub = (splitEntry[x].substring(1, remainder));
					suff = way;
					let = splitEntry[x].substring(0,1);
					
				} else if (vowelIndex>0 && vowelIndex < entryLength) {
				entryLength = vowelIndex;
				sub = splitEntry[x].substring(entryLength, remainder);
				let = sub.substring(0,1);
				sub = sub.substring(1, sub.length());
				pre = splitEntry[x].substring(0, entryLength);
				suff = pre +ay;
								
				} else if (vowelIndex == splitEntry[x].length()) {
					entryLength = splitEntry[x].toLowerCase().indexOf('y');
					sub = splitEntry[x].substring(entryLength, remainder);
					let = sub.substring(0,1);
					sub = sub.substring(1, sub.length());
					pre = splitEntry[x].substring(0, entryLength);
					suff = pre +ay;			
				} 
				
				if (splitEntry[x].length()<2) {
					if ( (splitEntry[x].codePointAt(0) >=65) &&(splitEntry[x].codePointAt(0) <=90) ) {
					let = let.toUpperCase();
					sub = sub.toUpperCase();
					suff= suff.toUpperCase();
					}
				} else if ((splitEntry[x].codePointAt(0) >=65) &&(splitEntry[x].codePointAt(0) <=90) 
						&& !( (splitEntry[x].codePointAt(1) >=65) &&(splitEntry[x].codePointAt(1) <=90) ))
					
				{
					let = let.toUpperCase();
					sub = sub.toLowerCase();
					suff= suff.toLowerCase();
				} 	else if ((splitEntry[x].codePointAt(1) >=65) &&(splitEntry[x].codePointAt(1) <=90)) {
					let = let.toUpperCase();
					sub = sub.toUpperCase();
					suff= suff.toUpperCase();
				}
				
				if (pun !=' ') {
					out = (let + sub + suff + pun);
					} else {out = (let + sub + suff);}
				op = (op + out+ " "); 
			}	
		
		} else {
			op = entry;
		}
		
		System.out.println();
		System.out.println(op);
		System.out.println();
		
		do {
			System.out.println("Do you want to enter something else? [Y/N]");
			entry = scanner.nextLine().trim().toLowerCase();
			if (entry.startsWith("y")) {
				littleLoop=false;
				bigLoop=true;
			} else if (entry.startsWith("n")) {
				System.out.println("Arewellfay!");
				littleLoop=false;
				bigLoop=false;
			} else {
				System.out.println("Sorry, I didn't understand that");
			}

		}while(littleLoop);

	}while(bigLoop);
	
	scanner.close();
	
	}
		
}
