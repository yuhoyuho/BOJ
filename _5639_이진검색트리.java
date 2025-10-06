package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _5639_이진검색트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int num = Integer.parseInt(line);
        Node root = new Node(num);

        while((line = br.readLine()) != null && !line.isEmpty()) {
            int value = Integer.parseInt(line);
            insert(root, value);
        }
        postorder(root);
    }

    static void postorder(Node node) {
        if(node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.println(node.num);
    }

    static void insert(Node parent, int value) {
        Node child = new Node(value);

        if(child.num < parent.num) {
            if(parent.left == null) {
                parent.left = child;
            }
            else {
                insert(parent.left, value);
            }
        }
        else {
            if(parent.right == null) {
                parent.right = child;
            }
            else {
                insert(parent.right, value);
            }
        }
    }

    static class Node {
        int num;
        Node left, right;

        public Node(int num) {
            this.num = num;
        }
    }
}
