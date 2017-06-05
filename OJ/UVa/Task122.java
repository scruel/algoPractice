package algsPractice.OJ.UVa;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.LinkedList;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #tree #binary-tree
 */
public class Task122 {
    Node root;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s;
        while ((s = in.nextString()) != null && !s.isEmpty()) {
            root = new Node();
            boolean flag = true;
            while (!s.equals("()")) {
                int index = s.indexOf(",");
                Node p = root;
                String v = s.substring(1, index);
                String op = s.substring(index + 1, s.length() - 1);
                for (int i = 0; i < op.length(); i++) {
                    if (op.charAt(i) == 'L') {
                        if (p.left == null) p.left = new Node();
                        p = p.left;
                    } else if (op.charAt(i) == 'R') {
                        if (p.right == null) p.right = new Node();
                        p = p.right;
                    }
                }
                if (p.value != null) {
                    flag = false;
                    while (!in.nextString().equals("()")) ;
                    break;
                }
                p.value = v;
                s = in.nextString();
            }
            StringBuilder sb = new StringBuilder();
            if (flag) {
                LinkedList<Node> q = new LinkedList<Node>();
                q.add(root);
                while (!q.isEmpty()) {
                    Node n = q.poll();
                    if (n.value == null) {
                        flag = false;
                        break;
                    }
                    if (n.left != null) q.add(n.left);
                    if (n.right != null) { q.add(n.right);}
                    if (root == n) sb.append(n.value);
                    else sb.append(" " + n.value);
                }
                sb.append("\n");
            }
            if (flag) {
                out.write(sb.toString());
            } else {
                out.writeln("not complete");
            }
        }
    }

    static class Node {
        String value;
        Node left, right;
    }


    //array realize & memory pool
}
