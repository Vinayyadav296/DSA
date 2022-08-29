package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
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

    static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currentnode = q.remove();
            if (currentnode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.println(currentnode.data + " ");
                if (currentnode.left != null) {
                    q.add(currentnode.left);
                }
                if (currentnode.right != null) {
                    q.add(currentnode.right);
                }
            }
        }

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        levelOrderTraversal(root);
    }

}
