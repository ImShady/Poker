/**
 * methods for password encryption
 * Author: Shady Ibrahim
 */

package main;

public class methods
{
    public static String encrypt(String word)
    {	
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", numbers = "0123456789", wordFinal = "";
            
        for(int i = 0; i < word.length(); i++)
        {
            if(letters.contains(Character.toString(word.charAt(i))))
            {
                if((letters.indexOf(word.charAt(i))) + 3 > letters.length())
               {                    
                    wordFinal += letters.charAt(letters.indexOf(word.charAt(i)) - 3); 
               }
               else
               {
                    wordFinal += letters.charAt(letters.indexOf(word.charAt(i)) + 3);
               }
            }
            else if(letters.contains(Character.toString(word.toUpperCase().charAt(i))))
            {
               letters = letters.toLowerCase();
               if((letters.indexOf(word.charAt(i))) + 3 > letters.length())
               {
                    wordFinal += letters.charAt(letters.indexOf(word.charAt(i)) - 3);
                    letters = letters.toUpperCase();
               }
               else
               {
                    wordFinal += letters.charAt(letters.indexOf(word.charAt(i)) + 3);
                    letters = letters.toUpperCase();
               }
            }            
            else if(numbers.contains(Character.toString(word.charAt(i))))
            {
               if((numbers.indexOf(word.charAt(i))) + 3 > numbers.length())
               {
                    wordFinal += numbers.charAt(numbers.indexOf(word.charAt(i)) - 3); 
               }
               else
               {
                    wordFinal += numbers.charAt(numbers.indexOf(word.charAt(i)) + 3);
               }
            }
            else
            {
                wordFinal += word.charAt(i);
            }
        }
        return wordFinal;
    }
}