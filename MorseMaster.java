public class MorseMaster {
    Tree decipherTree = Tree.buildMorseCodeTree(); //builds deciphering tree
    
    public String decipher(String code){ //taking in the morse code to be deciphered
        
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
                    }
                }
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        }

        String message = deciphered.toString();
        return message;
    }
}
