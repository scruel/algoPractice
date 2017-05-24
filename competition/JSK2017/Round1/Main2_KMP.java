package algsPractice.competition.JSK2017.Round1;

import java.io.*;

/**
 * Created by Scruel on 2017/5/20.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Main2_KMP {

        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        static int n, a, b, L, R;
        static StringBuilder txt = new StringBuilder(1 << 16);
        static int[] next;
        static int res = 0;
        static String pat;

        static void search(int index) {
                int i = index;
                int j = 0;
                while (i < txt.length()) {
                        if (j == -1 || txt.charAt(i) == pat.charAt(j)) {
                                ++i;
                                ++j;
                        } else {
                                j = next[j];
                        }

                        if (j == pat.length()) {
                                res++;
                                j = next[j];
                        }

                }


        }

        static void initNext() {
                int n = pat.length();
                next = new int[n + 1];
                next[0] = -1;
                int k = -1;
                int j = 0;
                while (j < n) {
                        if (k == -1 || pat.charAt(j) == pat.charAt(k)) {
                                ++k;
                                ++j;
//                                next[j] = k;
//                                while (next[j] >= 0 && pat.charAt(j) == pat.charAt(next[j])) {
//                                        next[j] = next[next[j]];
//                                }


//                                if (pat.charAt(j) == pat.charAt(k)) {
                                next[j] = k;   //之前只有这一行
//                                } else {
                                //因为不能出现p[j] = p[next[j]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
//                                        next[j] = next[k];
//                                }
                        } else {
                                k = next[k];
                        }
                }
        }

        static char getChar(int w) {
                if (L <= w && w <= R) {
                        if ((w & 1) == 0)
                                return 'A';
                        else
                                return 'T';
                } else {
                        if ((w & 1) == 0)
                                return 'G';
                        else
                                return 'C';
                }
        }

        public static void main(String[] args) throws IOException {
                String[] rts = bfr.readLine().trim().split("\\s+");
                n = Integer.parseInt(rts[0]);
                a = Integer.parseInt(rts[1]);
                b = Integer.parseInt(rts[2]);
                L = Integer.parseInt(rts[3]);
                R = Integer.parseInt(rts[4]);
                pat = bfr.readLine();

                int lastW = b;
                txt.append(getChar(lastW));
                for (int i = 1; i < n; i++) {
                        int w = (lastW + a) % n;
//                        System.out.println(w);
                        txt.append(getChar(w));
                        lastW = w;
                }
                initNext();
                search(0);
                //本题只要不重复找就行了，直接在kmp中查找并统计，以免丢失kmp的价值
//                while (res != -1) {
//                        cnt++;
//                        res = search(res + 1);
//                }

                bfw.write(res + "");
                bfr.close();
                bfw.close();
        }
}
