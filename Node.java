public class Node {
    Node left = null;
    Node right = null;
    Node parent = null;
    char letter = ' ';

    Node (char with){
        letter = with;
    }

    Node(Node left, Node right, char with){
        left = this.left;
        right = this.right;
        letter = with;
    }

}
