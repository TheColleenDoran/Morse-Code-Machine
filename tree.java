/*
 * Created By Colleen Doran
 * 7-13-23
 * 
 * A program to encipher and decipher morse code
 */

public class Tree {
    public Node pointer = null;
    public Node root = null;
   
// building Morse Code Binary Tree 
    public Tree buildMorseCodeTree() {
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


        return morseTree;
    }  
}