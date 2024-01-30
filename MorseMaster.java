import java.lang.*;

public class MorseMaster {
    Tree decipherTree = Tree.buildMorseCodeTree(); //builds deciphering tree
    
    public String decipher(String code){ //converts morse code into plaintext
        
        char[] bits = code.toCharArray(); //converting the String of morse code into an array of hopefully dots, dashes, and spaces
        char[] deciphered = new char[bits.length/2]; //creating and array for the deciphered characters
        int pen = 0; //pointer for deciphered array

        try {
            char temp = '\0'; //sets temp to null character
            for(int i = 0; i < bits.length; i++){ //going character by character to decipher
                temp = decipherTree.checkChar(bits[i]);
                if(temp != '\0'){ //checkChar() has returned either a letter or a space
                    if(pen < deciphered.length){ //saves deciphered char if there is room in the decipherd array
                        deciphered[pen++] = temp;
                        temp = '\0';
                    }else{
                        //throw out of bounds exception, it shouldn't do this but just in case
                        throw new Exception("005: Deciphered message has exceeded character limit. Panic.");
                    }
                }
            }
            temp = decipherTree.checkChar(' '); //submits for last character
                if(temp != '\0'){ //checkChar() has returned either a letter or a space
                    if(pen < deciphered.length){ //saves deciphered char if there is room in the decipherd array
                        deciphered[pen++] = temp;
                        temp = '\0';
                    }else{
                        //throw out of bounds exception, it shouldn't do this but just in case
                        throw new Exception("005: Deciphered message has exceeded character limit. Panic.");
                    }
                }
            
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        String message = toString(deciphered);
        return message;
    }

    public String encipher(String message) { // converts plaintext into morse code
        String code = "";
        //do work here
        char[] bits = message.toCharArray();
        //figure out best way to encode
        //should be something better than a switch case or direct substitution
        return code;
    }

    public static String[][] makeMasterList() {
        String[][] morseToLetters = new String[26][2];
        char letter = 'a';

        for(int i = 0; i < 26; i++) {

            morseToLetters[i][0] = "" + letter;
            letter++;
        }

        return morseToLetters;
    }

    public void print(char[] here){
        for(int i = 0; i < here.length; i++){
            System.out.print(here[i]);
        }
        System.out.print("\n");
    }

    public String toString(char[] here){
        String result = "";
        for(int i = 0; i < here.length; i++){
            result = result + here[i];
        }
        result.trim();
        return result;
    }
}
