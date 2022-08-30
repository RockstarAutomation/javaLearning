package tree;

public class BinarySearchTree {
    static class Node {
        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(Node val, Node parent) {
        if (val.key > parent.key) {
            if (parent.right == null) {
                parent.right = val;
            } else insert(val, parent.right);
        } else if (parent.left == null) {
            root.left = val;
        } else insert(val, parent.left);
    }

    void delete(Node val) {

    }

    boolean contains(int val, Node parent) {
        if (parent.key == val) {
            return true;
        } else if (parent.key < val) {
            return parent.right != null && (parent.right.key != val || contains(val, parent.right));
        } else return parent.left != null && (parent.left.key != val || contains(val, parent.left));
    }

    /*void delete (int val) {
        if(root.key == val) {
            Node old = root;
            root = root.right;
            root
        }
    }*/
}
