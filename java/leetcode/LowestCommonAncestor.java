package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem
 *
 * @author miguel
 */
public class LowestCommonAncestor {

    static class Node {

        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class NodePath {

        Node current;
        List<Node> path;

        NodePath(Node node, List<Node> path) {
            this.current = node;
            this.path = path;
        }
    }

    static boolean equals(Node a, Node b) { // assuming data of a is distinct of data of b.
        return a.data == b.data;
    }

    static List<Node> buildPath(Node root, int goal) {
        NodePath np = new NodePath(root, new ArrayList<>());
        Queue<NodePath> nodes = new LinkedList<>();
        nodes.offer(np);

        while (!nodes.isEmpty()) {
            NodePath n = nodes.poll();
            List<Node> newPath = new ArrayList<>(n.path);
            newPath.add(n.current);
            if (n.current.data == goal) {
                return newPath;
            }
            if (n.current.left != null) {
                nodes.offer(new NodePath(n.current.left, newPath));
            }
            if (n.current.right != null) {
                nodes.offer(new NodePath(n.current.right, newPath));
            }
        }

        return new ArrayList<>();

    }

    /*
    class Node
    	int data;
    	Node left;
    	Node right;
     */
    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        List<Node> toV1 = buildPath(root, v1);
        List<Node> toV2 = buildPath(root, v2);
        int minimal = Math.min(toV1.size(), toV1.size());

        Node lowest = null;
        for (int i = 0; i < minimal; i++) {
            if (equals(toV1.get(i), toV2.get(i))) {
                lowest = toV1.get(i);
            } else {
                break;
            }
        }
        return lowest;
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Node root;
        int v1;
        int v2;
        try (Scanner scan = new Scanner(System.in)) {
            int t = scan.nextInt();
            root = null;
            while (t-- > 0) {
                int data = scan.nextInt();
                root = insert(root, data);
            }
            v1 = scan.nextInt();
            v2 = scan.nextInt();
        }
        Node ans = lca(root, v1, v2);
        System.out.println(ans.data);
    }

}
