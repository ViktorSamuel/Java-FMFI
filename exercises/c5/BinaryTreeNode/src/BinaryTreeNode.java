import java.util.*;

/** Genericka trieda reprezentujuca uzol binarneho stromu obsahujuci hodnotu nejakeho typu T. */
public class BinaryTreeNode<T> implements Iterable<BinaryTreeNode<T>> {
    /** Premenna data obsahuje hodnotu ulozenu v uzle; nasleduju referencie na otca, laveho syna a praveho syna. */
    private T data;
    private BinaryTreeNode<T> parent;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    /** Konstruktor, ktory vytvori uzol binarneho stromu obsahujuci hodnotu data, pricom referencie na otca a synov
     *  su inicializovane na null. */
    public BinaryTreeNode(T data) {
        this.data = data;
    }

    /** Metody get a set pre premennu data. */
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /** Metody get a set pre synov daneho uzla. Metody set prestavuju aj rodicov uzlov, ktore sa maju stat lavym synom
     * daneho uzla. */
    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    /** Metoda, ktora vrati najlavejsieho potomka daneho uzla. */
    public BinaryTreeNode<T> leftmostDescendant() {
        if (getLeft() == null) {
            return this;
        } else {
            return getLeft().leftmostDescendant();
        }
    }

    /** Metoda, ktora vrati naslednika daneho uzla pri ich usporiadani v poradi inorder. V pripade, ze ziaden naslednik
     * neexistuje, vrati metoda na vystupe null. */
    public BinaryTreeNode<T> successorNode() {
        if (getRight() != null) {
            return getRight().leftmostDescendant();
        } else {
            BinaryTreeNode<T> ancestor = this;
            while (ancestor.parent != null && ancestor == ancestor.parent.getRight()) {
                ancestor = ancestor.parent;
            }
            return ancestor.parent;
        }
    }

    /** Metoda, ktora vrati true prave vtedy, ked je instancia triedy Node, pre ktoru je metoda volana, predkom
     *  uzla, ktory metoda dostane ako argument.*/
    public boolean isAncestorOf(BinaryTreeNode<T> node) {
        while (node != null && node != this) {
            node = node.parent;
        }
        return node == this;
    }

    /** Metoda, ktora vrati iterator pre podstrom zakoreneny v danom uzle, postupne prechadzajuci uzly tohto podstromu
     * v poradi inorder. */
    public Iterator<BinaryTreeNode<T>> iterator() {
        return new Iterator<BinaryTreeNode<T>>(){
            BinaryTreeNode<T> treeNode = BinaryTreeNode.this.leftmostDescendant();

            @Override
            public boolean hasNext() {
                if(BinaryTreeNode.this.isAncestorOf(treeNode)) return true;
                return false;
            }

            @Override
            public BinaryTreeNode<T> next() {
                if (!hasNext()) throw new NoSuchElementException();

                try { return treeNode; }
                finally { treeNode = treeNode.successorNode(); }
            }
        };
    }
}
