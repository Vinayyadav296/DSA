package Trees.BinaryTree;

public class HeightOfTree {
    static class Node {
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

    static int heightOfTree(Node root) {
        if (root == null) { // base case for recursive function
            return 0;
        }
        int leftnode = heightOfTree(root.left); // this will calculate the height of the left subtree
        int rightnode = heightOfTree(root.right); // this will calculate the height of the right subtree
        int height = Math.max(leftnode, rightnode) + 1; // this calculate the total height of tree
        return height;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(heightOfTree(root));
    }
}
