/**
 * methods for password encryption Author: Shady Ibrahim
 */
package main;

public class methods {

    public static String encryptOld(String word) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", numbers = "0123456789", wordFinal = "";

        for (int i = 0; i < word.length(); i++) {
            if (letters.contains(Character.toString(word.charAt(i)))) {
                if ((letters.indexOf(word.charAt(i))) + 3 > letters.length()) {
                    wordFinal += letters.charAt(letters.indexOf(word.charAt(i)) - 3);
                } else {
                    wordFinal += letters.charAt(letters.indexOf(word.charAt(i)) + 3);
                }
            } else if (letters.contains(Character.toString(word.toUpperCase().charAt(i)))) {
                letters = letters.toLowerCase();
                if ((letters.indexOf(word.charAt(i))) + 3 > letters.length()) {
                    wordFinal += letters.charAt(letters.indexOf(word.charAt(i)) - 3);
                    letters = letters.toUpperCase();
                } else {
                    wordFinal += letters.charAt(letters.indexOf(word.charAt(i)) + 3);
                    letters = letters.toUpperCase();
                }
            } else if (numbers.contains(Character.toString(word.charAt(i)))) {
                if ((numbers.indexOf(word.charAt(i))) + 3 > numbers.length()) {
                    wordFinal += numbers.charAt(numbers.indexOf(word.charAt(i)) - 3);
                } else {
                    wordFinal += numbers.charAt(numbers.indexOf(word.charAt(i)) + 3);
                }
            } else {
                wordFinal += word.charAt(i);
            }
        }
        return wordFinal;
    }

    public static String encrypt(String password) {
        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "!", "#", "@", "$", "%", "^", "&", "*", "(", ")", "_", "+", "-", "=", "[", "]", ";", "'", ".", "/", "|", "}", "{", ":", "?", ">", "<", ".", "`", "~", ",", " "};
        String[] passarr = password.split("");
        String encrypted = "";
        int shift = (int) (1 + Math.random() * 9);
        encrypted = encrypted + shift;
        for (int i = 0; i < password.length(); i++) {
            for (int a = 0; a < array.length; a++) {
                if (passarr[i].equals(array[a])) {
                    if (a + shift > array.length) {
                        encrypted = encrypted + array[a + shift - array.length];
                    } else {
                        encrypted = encrypted + array[a + shift];
                    }
                }
            }
        }

        return encrypted;
    }

    public static String decrypt(String encrypted) {

        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "!", "#", "@", "$", "%", "^", "&", "*", "(", ")", "_", "+", "-", "=", "[", "]", ";", "'", ".", "/", "|", "}", "{", ":", "?", ">", "<", ".", "`", "~", ",", " "};
        String decrypted = "";
        int shift;
        String[] enc = encrypted.split("");
        System.out.println("the splittable:" + encrypted);
        System.out.println("It is: " + enc[0] + enc[1] + enc[2]);
        shift = Integer.parseInt(enc[0]);
        encrypted = "";
        for (int b = 1; b < enc.length; b++) {
            encrypted = encrypted + enc[b];
        }
        String[] encrypt = encrypted.split("");
        for (int c = 0; c < encrypted.length(); c++) {
            for (int d = 0; d < array.length; d++) {
                if (encrypt[c].equals(array[d])) {
                    if ((d - shift) < 0) {
                        decrypted = decrypted + array[d - shift + array.length];
                    } else {
                        decrypted = decrypted + array[d - shift];
                    }
                }
            }
        }
        System.out.println("Decrypted: " + decrypted);
        return decrypted;
    }
}
