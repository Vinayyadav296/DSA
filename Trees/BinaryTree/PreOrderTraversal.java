package Trees.BinaryTree;

public class PreOrderTraversal {
    static class Node { // tc--O(n)
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        static Node buildTree(int node[]) {
            idx++;
            if (node[idx] == -1) {
                return null;
            }
            Node newnode = new Node(node[idx]);
            newnode.left = buildTree(node);
            newnode.right = buildTree(node);
            return newnode;
        }
    }

    static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " "); // this will print the root node
        preOrderTraversal(root.left); // this will print the left subtree
        preOrderTraversal(root.right); // this will print the right subtree
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        preOrderTraversal(root);
    }
}
