package cryptography;

public class Cipher {
	/* cipher object
	 *  do chars for indvidual get set you know
	 */
	private static String cipher;

	public Cipher(){
		for (int i = 1; i<=26; i++){
			cipher+='#';
		}
	}
	// takes array of 26 chars makes string
	public Cipher(char[] array){
		for (int i = 0; i<=25; i++){
			cipher+=array[i];			
		}
	}

	public static boolean worksWith(String string_1, String string_2){
		for (int i = 0; i<= 26; i++) {
			for (int j = 0; j<= 26; j++) {
				if (string_1.charAt(i)!='#'&&string_1.charAt(i)!=string_2.charAt(j)) { //if the characters....you know what it does
					return false;
				}
			}
		}
		return true;
	}

	public static String decodeCipher(String message, String cipher) {
		String abc="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String solved="";
		//fixing case for greater than alphabet length
		for(int i=0; i<message.length()-1; i++) {
			char letter=message.charAt(i); //picks next letter
			int y=message.indexOf(letter); //position of coded letter
			if (letter==" ".charAt(0)) {
				solved=solved+" ";
				continue;
			} else if(y!=-1){
				char codeletter=abc.charAt(y); //converts letter to code letter
				solved=solved + codeletter;
			} else if(y==-1){
				solved+=letter;
			}
		}
		return solved;
	}

	public static String combine(String cipher1, String cipher2) throws IllegalArgumentException{
		String finalCipher="";
		if (worksWith(cipher1, cipher2)==false){
			throw new IllegalArgumentException();
		}

		for (int i = 0; i<=25; i++){
			if (cipher1.charAt(i)!='#'){
				finalCipher+=cipher1.charAt(i);
			}
			else if(cipher2.charAt(i)!='#') {
				finalCipher+=cipher2.charAt(i);
			}
}


		return finalCipher;
	}
}


