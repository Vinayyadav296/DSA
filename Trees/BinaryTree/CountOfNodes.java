package Trees.BinaryTree;

public class CountOfNodes {
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

    static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftcount = countOfNodes(root.left); // count the nodes in left subtree
        int rightcount = countOfNodes(root.right); // count the nodes in the right subtree
        return leftcount + rightcount + 1; // total nodes
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(countOfNodes(root));
    }
}
