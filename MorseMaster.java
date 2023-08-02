public class MorseMaster {
    Tree decipherTree = Tree.buildMorseCodeTree(); //builds deciphering tree
    
    public String decipher(String code){ //taking in the morse code to be deciphered
        
        char[] bits = code.toCharArray(); //converting the String of morse code into an array of hopefully dots, dashes, and spaces
        char[] deciphered = new char[bits.length/2]; //creating and array for the deciphered characters
        int pen = 0; //pointer for deciphered array

        print(bits);

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
        print(deciphered);
        String message = deciphered.toString(); //converting  array of char to sting not working
        System.out.println("Message: " + message);
        return message;
    }

    public void print(char[] here){
        for(int i = 0; i < here.length; i++){
            System.out.print(here[i]);
        }
        System.out.print("\n");
    }
}
