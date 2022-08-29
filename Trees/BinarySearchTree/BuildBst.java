package Trees.BinarySearchTree;

import java.util.ArrayList;

public class BuildBst {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // time complexity of insert is O(H) -- big o of height of tree
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val); // if the root is null means there is no node present then create a new node
                                  // which is root node here
            return root;
        }
        if (val < root.data) {
            root.left = insert(root.left, val); // if value<root data then insert it into left subtree
        } else {
            root.right = insert(root.right, val); // if value>root data then insert it into right subtree
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Searching a value in BST
    // time complexity of searching in BST is O(height) of tree
    public static Boolean search(Node root, int key) {
        if (root == null) { // if root is null then return false
            return false;
        }
        if (key < root.data) { // if key<root then search in left subtree
            return search(root.left, key);
        } else if (root.data == key) { // if key == root then return the root
            return true;
        } else {
            return search(root.right, key); // if key>root then search in right subtree
        }

    }

    public static Node delete(Node root, int val) {
        if (val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else {
            // case1--> root.data=val -->when the node has no left and right child i.e the
            // node to be deleted is root node
            if (root.left == null && root.right == null) {
                return null;
            }
            // case2-->either the left child of the node to be deleted is null or the right
            // child is null
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // case3-->
            Node IS = inorderSuccesor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node inorderSuccesor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // here the range is inclusive i.e X and Y are included in the print range
    public static void printInRange(Node root, int X, int Y) {
        if (root == null) {
            return;
        }
        if (root.data >= X && root.data <= Y) {
            printInRange(root.left, X, Y);
            System.out.println(root.data + " ");
            printInRange(root.right, X, Y);
        } else if (root.data >= Y) {
            printInRange(root.left, X, Y);
        } else {
            printInRange(root.right, X, Y);
        }
    }

    // print all root to leaf path

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        // if the node at which you are present is a leaf node
        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            // non- leaf
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        // int[] values = { 5, 1, 3, 4, 2, 7 };
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        // if (search(root, 5)) {
        // System.out.println("value found in BST");
        // } else {
        // System.out.println("value not found in BST");
        // }
        // delete(root, 4);
        // inorder(root);
        // printInRange(root, 6, 10);
        // printRoot2Leaf(root, new ArrayList<>());
    }
}
