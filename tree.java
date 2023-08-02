/*
 * Created By Colleen Doran
 * 7-13-23
 * 
 * A program to encipher and decipher morse code
 */

public class Tree {
    public static Node pointer = null;
    public static Node root = null;
   
// building Morse Code Binary Tree 
    public static Tree buildMorseCodeTree() {
    //creating the Tree and setting the root
        Tree morseTree = new Tree();
        Node  newNode = new Node(' ');
        root = newNode;
    // filling in letters
        newNode = new Node('E');
        root.left = newNode;
        newNode.parent = root;
        pointer = newNode;
        newNode = new Node('I');
        pointer.left = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('S');
        pointer.left = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('H');
        pointer.left = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('5');
        pointer.left = newNode;
        newNode.parent = pointer;
        newNode = new Node('4');
        pointer.right = newNode;
        newNode.parent = pointer;

        pointer = pointer.parent; //on S
        newNode = new Node('V');
        pointer.right = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('3');
        pointer.right = newNode;
        newNode.parent = pointer;

        pointer = pointer.parent.parent; //on I
        newNode = new Node('U');
        pointer.right = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('F');
        pointer.left = newNode;
        newNode.parent = pointer;
        newNode = new Node(' ');
        pointer.right = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('2');
        pointer.right = newNode;
        newNode.parent = pointer;

        pointer = pointer.parent.parent.parent; //on E
        newNode = new Node('A');
        pointer.right = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('R');
        pointer.left = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('L');
        pointer.left = newNode;
        newNode.parent = pointer;
        newNode = new Node(' ');
        pointer.right = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('+');
        pointer.left = newNode;
        newNode.parent = pointer;

        pointer = pointer.parent.parent; //on A
        newNode = new Node('W');
        pointer.right = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('P');
        pointer.left = newNode;
        newNode.parent = pointer;
        newNode = new Node('J');
        pointer.right = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('1');
        pointer.right = newNode;
        newNode.parent = pointer;

        pointer = root; //on Root
        newNode = new Node('T');
        pointer.right = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('N');
        pointer.left = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('D');
        pointer.left = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('B');
        pointer.left = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('6');
        pointer.left = newNode;
        newNode.parent = pointer;
        newNode = new Node('=');
        pointer.right = newNode;
        newNode.parent = pointer;

        pointer = pointer.parent; //on D
        newNode = new Node('X');
        pointer.right = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('/');
        pointer.left = newNode;
        newNode.parent = pointer;

        pointer = pointer.parent.parent; //on N
        newNode = new Node('K');
        pointer.right = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('C');
        pointer.left = newNode;
        newNode.parent = pointer;
        newNode = new Node('Y');
        pointer.right = newNode;
        newNode.parent = pointer;

        pointer = pointer.parent.parent; //on T
        newNode = new Node('M');
        pointer.right = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('G');
        pointer.left = newNode;
        newNode.parent = pointer;
        pointer =newNode;
        newNode = new Node('Z');
        pointer.left = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('7');
        pointer.left = newNode;
        newNode.parent = pointer;

        pointer = pointer.parent; //on G
        newNode = new Node('Q');
        pointer.right = newNode;
        newNode.parent = pointer;

        pointer = pointer.parent; //on M
        newNode = new Node('O');
        pointer.right = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node(' ');
        pointer.left = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('8');
        pointer.left = newNode;
        newNode.parent = pointer;

        pointer = pointer.parent; //on O
        newNode = new Node(' ');
        pointer.right = newNode;
        newNode.parent = pointer;
        pointer = newNode;
        newNode = new Node('9');
        pointer.left = newNode;
        newNode.parent = pointer;
        newNode = new Node('0');
        pointer.right = newNode;
        newNode.parent = pointer;

        resetPointer();

        return morseTree;
    }  

    public static void resetPointer(){
        pointer = root;
    }

    public char checkChar(char given) throws Exception{
        char result = '\0'; //sets result to null character
        char toCheck = given;

        if(toCheck == ' '){
            //check if at root
            //check contents and if it has a parent
            //else throw exception
            if(pointer.letter == ' '){
                if(pointer == root){
                    result = ' ';
                    resetPointer();
                }else{
                    //throw exception
                    //pointer ended on an invalid node which means that the dot/dash order is incorrect
                    throw new Exception("001: Invalid morse code sequence. Please double check your spelling.");
                }
            }else{
                result = pointer.letter;
                resetPointer();
            }
        } else{
            //either dot or dash, move sides
            //if unsuported char, throw excetption
            if(toCheck == '.'){
                if(pointer.left != null){
                    pointer = pointer.left;
                }else{
                    //no left child
                    throw new Exception("002: Invalid morse code sequence. Please double check your spelling.");
                }
            }else if(toCheck == '-'){
                if(pointer.right != null){
                    pointer = pointer.right;
                }else{
                    //no right child exception
                    throw new Exception("003: Invalid morse code sequence. Please double check your spelling.");
                }
            }else{
                //unsupported character expection
                throw new Exception("004: Invalid morse code sequence. Please double check your spelling.");
            }
        }

        return result;
    }
}