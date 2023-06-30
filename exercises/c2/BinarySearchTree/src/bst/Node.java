package bst;

import java.util.ArrayList;
import java.util.List;

/** Trieda reprezentujuca uzol binarneho vyhladavacieho stromu. Uzol je dany jeho celociselnym klucom key a referenciami
 *  na koren laveho a praveho podstromu. */
class Node {
    /** Celociselna hodnota kluca ulozena v uzle */
    private int key;

    /** Referencie na lavy a pravy podstrom */
    private Node left;
    private Node right;

    /** Konstruktor, ktory vytvori uzol s klucom key */
    public Node(int key) {
        this.key = key;
    }

    /** Metoda get pre kluc daneho uzla */
    public int getKey() {
        return key;
    }

    /** Metoda, ktora vlozi do podstromu zakoreneneho v danom uzle uzol node */
    public void addNode(Node node) {
        if (node.getKey() <= getKey()) {
            if (left == null) {
                left = node;
            } else {
                left.addNode(node);
            }
        } else {
            if (right == null) {
                right = node;
            } else {
                right.addNode(node);
            }
        }
    }

    /** Metoda, ktora vrati niektory z uzlov podstromu zakoreneneho v danom uzle, v ktorom je ulozena hodnota key.
     *  Ak taky uzol neexistuje, vrati null. */
    public Node findNode(int key) {
        if (key == getKey()) {
            return this;
        } else if (key < getKey() && left != null) {
            return left.findNode(key);
        } else if (key > getKey() && right != null) {
            return right.findNode(key);
        } else {
            return null;
        }
    }

    /** Metoda, ktora vrati niektory spomedzi uzlov podstromu zakoreneneho v danom uzle s minimalnou hodnotou */
    public Node minNode() {
        
        // Vas kod piste sem
        if(left == null) return this;
        return left.minNode();

    }

    /** Metoda, ktora vrati pole klucov jednotlivych uzlov podstromu zakoreneneho v danom uzle v poradi inorder */
    public int[] inorderKeys() {
        
        // Vas kod piste sem
       List<Integer> keys = new ArrayList<>();

        inorderKeys(this, keys);

        int[] result = new int[keys.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = keys.get(i);
        }

        return result;
    }
    private void inorderKeys(Node node, List<Integer> keys){
        if (node != null) {
            inorderKeys(node.left, keys);
            keys.add(node.key);
            inorderKeys(node.right, keys);
        }
    }
}
