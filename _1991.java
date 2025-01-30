package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1991 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Node head = new Node('A', null, null);

        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insert(head, root, left, right);
        }
        pre(head);
        sb.append('\n');
        mid(head);
        sb.append('\n');
        post(head);
        sb.append('\n');

        System.out.println(sb);
    }

    static void insert(Node tmp, char root, char left, char right) {
        if(tmp.val == root) {
            tmp.left = (left == '.' ? null : new Node(left, null, null));
            tmp.right = (right == '.' ? null : new Node(right, null, null));
        }
        else {
            if(tmp.left != null) {
                insert(tmp.left, root, left, right);
            }

            if(tmp.right != null) {
                insert(tmp.right, root, left, right);
            }
        }
    }

    static void pre(Node n) {
        if(n == null) {
            return;
        }

        sb.append(n.val);
        pre(n.left);
        pre(n.right);
    }

    static void mid(Node n) {
        if(n == null) {
            return;
        }

        mid(n.left);
        sb.append(n.val);
        mid(n.right);
    }

    static void post(Node n) {
        if(n == null) {
            return;
        }

        post(n.left);
        post(n.right);
        sb.append(n.val);
    }

    static class Node {
        char val;
        Node left, right;

        public Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}