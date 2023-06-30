package bst;

import java.util.*;

/** Trieda reprezentujuca binarny vyhladavaci strom samotny pomocou referencie na jeho koren. */
public class BinarySearchTree {
    private Node root;

    /** Metoda zisti, ci je binarny vyhladavaci strom prazdny. */
    public boolean isEmpty() {
        return root == null;
    }

    /** Metoda prida do binarneho vyhladavacieho stromu novy uzol s klucom key. */
    public void add(int key) {
        if (isEmpty()) {
            root = new Node(key);
        } else {
            root.addNode(new Node(key));
        }
    }

    /** Metoda zisti, ci binarny vyhladavaci strom obsahuje aspon jeden uzol s klucom key. */
    public boolean contains(int key) {
        if (isEmpty()) {
            return false;
        } else {
            return root.findNode(key) != null;
        }
    }

    /** Metoda najde najmensiu hodnotu kluca spomedzi vsetkych uzlov binarneho vyhladavacieho stromu. V pripade,
     *  ze je strom prazdny, metoda vyhodi vynimku (tuto jej cast je zatial mozne ignorovat). */
    public int minKey() {
        if (isEmpty()) {
            throw new NoSuchElementException();  // Vyhod vynimku: o tomto mechanizme sa budeme ucit az neskor.
        } else {
            return root.minNode().getKey();
        }
    }

    /** Metoda vrati pole klucov jednotlivych uzlov binarneho vyhladavacieho stromu v poradi inorder. */
    public int[] inorderKeys() {
        if (isEmpty()) {
            return null;
        } else {
            return root.inorderKeys();
        }
    }

}
