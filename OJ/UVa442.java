package algsPractice.OJ;

import java.io.*;
import java.util.Stack;

/**
 * Created by Scruel on 2017/5/16.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class UVa442 {
        static Martix[] martixes = new Martix[256];
        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        static Stack<Martix> stack = new Stack<Martix>();

        public static void main(String[] args) throws IOException {
                int n = Integer.parseInt(bfr.readLine());
                String[] rts;
                for (int i = 0; i < n; i++) {
                        rts = bfr.readLine().trim().split("\\s+");
                        martixes[rts[0].charAt(0)] = new Martix(Integer.parseInt(rts[1]), Integer.parseInt(rts[2]));
                }
                String ts;
                while ((ts = bfr.readLine()) != null && !ts.isEmpty()) {
                        char[] s = ts.toCharArray();
                        boolean flag = true;
                        int res = 0;
                        for (int i = 0; i < s.length; i++) {
                                if (s[i] == ')') {
                                        Martix y = stack.pop();
                                        Martix x = stack.pop();
                                        if (x.b != y.a) {
                                                flag = false;
                                                break;
                                        }
                                        res += x.a * x.b * y.b;
                                        Martix z = new Martix(x.a, y.b);
                                        stack.push(z);
                                } else if (s[i] != '(') {
                                        int a = martixes[s[i]].a;
                                        int b = martixes[s[i]].b;
                                        Martix x = new Martix(a, b);
                                        stack.push(x);
                                }
                        }
                        bfw.write(String.format("%s\n", flag ? res : "error"));
                }

                bfr.close();
                bfw.close();
        }

        static class Martix {
                int a, b;

                public Martix(int a, int b) {
                        this.a = a;
                        this.b = b;
                }
        }

}
