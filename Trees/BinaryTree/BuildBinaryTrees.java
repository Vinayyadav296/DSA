package Trees.BinaryTree;

public class BuildBinaryTrees {
    static class Node { // this class Node will represent each tree single node
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null; // left child=null
            this.right = null; // right child=null
        }
    }

    static class BinaryTree {
        static int idx = -1;

        static Node buildTree(int node[]) { // this function will return root node
            idx++;
            if (node[idx] == -1) {
                return null; // because -1 represents null node
            }
            Node newnode = new Node(node[idx]);
            newnode.left = buildTree(node);
            newnode.right = buildTree(node);
            return newnode; // this return root node
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        // if the tree is build correctly it will print 1
        // TC-- O(n)
    }
}
