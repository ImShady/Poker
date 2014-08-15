package main;

import java.util.Scanner;

public class Encrypt {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		String encrypted = "";
		String decrypted = "";
		int  shift = (int) (1 +Math.random()*9);
		encrypted = encrypted + shift;
		System.out.print("press 1 to encrypt a password and 2 to decrypt a password");
		String inp = input.nextLine();
		boolean inp1 = true;
		boolean incr = true;
		
		while(inp1 == true){
			if(inp.equals("1")){
				incr = true;
				inp1 = false;
			}
			else if(inp.equals("2")){
				incr = false;
				inp1 = false;
			}
			else{
				System.out.println("please input a proper input (press 1 to encrypt a password and 2 to decrypt a password)");
				inp = input.nextLine();
				System.out.println(inp);
			}
		}
		
		String[] array = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0","!","#","@","$","%","^","&","*","(",")","_","+","-","=","[","]",";","'",".","/","|","}","{",":","?",">","<",".","`","~",","," "};
		
		
		
		
		if(incr == true){
			System.out.println("please enter the password you would like to encrypt");
			String password = input.nextLine();
			String[] passarr = password.split(""); 
			for(int i = 0; i < password.length(); i++){
				for(int a = 0; a < array.length; a++){
					if(passarr[i].equals(array[a])){
						if(a + shift > array.length){
							encrypted = encrypted + array[a+shift-array.length];	
						}
						else{
							encrypted = encrypted + array[a+shift];
						}
					}
				}
			}
			System.out.println("Your encrypted password is: " + encrypted);
		}
		
		
		if(incr == false){
			System.out.println("please enter the password you would like to decrypt");
			encrypted = input.nextLine();
			String[] enc = encrypted.split(""); 
			shift = Integer.parseInt(enc[0]);
			encrypted = "";
			for(int b = 1; b < enc.length; b++){
				encrypted = encrypted + enc[b];
			}
			String[] encrypt = encrypted.split(""); 
			for(int c = 0; c < encrypted.length(); c++){
				for(int d = 0; d < array.length; d++){
					if(encrypt[c].equals(array[d])){
						if((d-shift) < 0){
							decrypted = decrypted + array[d-shift+array.length];
						}
						else{
							decrypted = decrypted + array[d-shift];
						}
					}
				}
			}
			System.out.println("Your decrypted password is: " + decrypted);		
		}
	}
}

