package algsPractice.OJ;

import java.io.*;

/**
 * Created by Scruel on 2017/4/4.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #string
 */
public class UVa1368 {
        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        static int m;
        static int n;
        static char[] chars = "ACGT".toCharArray();
        static int[][] tb;

        static void solve() throws IOException {
                int item = Integer.parseInt(bfr.readLine());
                for (int t = 0; t < item; t++) {
                        String[] rTs = bfr.readLine().split(" ");
                        int m = Integer.parseInt(rTs[0]);
                        int n = Integer.parseInt(rTs[1]);
                        tb = new int[n][256];
                        for (int i = 0; i < m; i++) {
                                String s = bfr.readLine();
                                for (int j = 0; j < n; j++) {
                                        tb[j][s.charAt(j)]++;
                                }
                        }
                        String result = "";
                        int sum = 0;
                        for (int i = 0; i < n; i++) {
                                int a = tb[i][chars[0]];
                                int b = tb[i][chars[1]];
                                int c = tb[i][chars[2]];
                                int d = tb[i][chars[3]];
                                int max = max(a, b, c, d);
                                sum += a + b + c + d - max;
                                char ch = chars[3];
                                //这里按照ACGT顺序判断，找最合适的，找到了就不会更新了，所以保证了字典序最小
                                if (max == c)
                                        ch = chars[2];
                                if (max == b)
                                        ch = chars[1];
                                if (max == a)
                                        ch = chars[0];
                                result += ch;
                        }
                        bfw.write(result + "\n" + sum + "\n");
                }
                bfw.close();
                bfr.close();
        }

        static int max(int a, int b, int c, int d) {
                int max = a;
                max = b > max ? b : max;
                max = c > max ? c : max;
                max = d > max ? d : max;
                return max;
        }

        public static void main(String[] args) throws IOException {
                solve();
        }
}
