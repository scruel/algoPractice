package algsPractice.OJ;

import java.io.*;

/**
 * Created by Scruel on 2017/4/17.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 细节题 枚举，滑动窗口
 * #graph
 */
public class UVa201 {
    static int[] sideH;
    static int[] sideV;
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    //
//        static void solve() throws IOException {
//                //check if no solutions
//                boolean flag = false;
//                for (int i = 1; i < n; i++) {
//                        //check squares in size i
//                        //start at (j,k)
//                        int bits = 0;
//                        for (int j = 0; j <= n - i - 1; j++) {
//                                for (int k = 0; k <= n - i - 1; k++) {
//                                        if (check(j, k, i)) {
//                                                flag = true;
//                                                bits++;
//                                        }
//                                }
//                        }
//                        if (bits > 0)
//                                bfw.write(bits + " square (s) of size " + i + "\n");
//                }
//                if (!flag)
//                        bfw.write("No completed squares can be found.\n");
//        }
//
//        static boolean check(int sx, int sy, int sz) {
//                //check sides is connected or not.
//                for (int i = 0; i < sz; i++) {
//                        //check up sides
//                        if (sideH[sx][sy + i] == 0)
//                                return false;
//                        //check down sides
//                        if (sideH[sx + sz][sy + i] == 0)
//                                return false;
//                        //check left sides
//                        if (sideV[sx + i][sy] == 0)
//                                return false;
//                        //check right sides
//                        if (sideV[sx + i][sy + sz] == 0)
//                                return false;
//                }
//                return true;
//        }
//
//        public static void main(String[] args) throws IOException {
//                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//
//                int pNum = 0;
//                String s;
//
//                while ((s = bfr.readLine()) != null && s.length() != 0) {
//                        if (pNum > 0)
//                                bfw.write("\n**********************************\n\n");
//                        bfw.write("Problem #" + ++pNum + "\n\n");
//                        n = Integer.parseInt(s);
//                        sideH = new int[n][n];
//                        sideV = new int[n][n];
////                for (int i = 0; i < n * n; i++) sideH[i] = i;
//                        int ops = Integer.parseInt(bfr.readLine());
//                        for (int i = 0; i < ops; i++) {
//                                String[] rTs = bfr.readLine().split("\\s+");
//                                int p = Integer.parseInt(rTs[1]) - 1;
//                                int q = Integer.parseInt(rTs[2]) - 1;
//                                if ("H".equals(rTs[0])) {
//                                        sideH[p][q] = 1;
//                                } else if ("V".equals(rTs[0])) {
//                                        sideV[q][p] = 1;
//                                }
//                        }
//                        solve();
//                }
//                bfr.close();
//                bfw.close();
//        }
    static boolean connectedH(int p, int q) {
        return sideH[p] == q;
    }

    static boolean connectedV(int p, int q) {
        return sideV[p] == q;
    }

    static void unionV(int p, int q) {
        if (p < q) sideV[p] = q;
        else sideV[q] = p;
    }

    static void unionH(int p, int q) {
        if (p < q) sideH[p] = q;
        else sideH[q] = p;
    }

    static void solve() throws IOException {
        //check if no solutions
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            //check squares in size i
            //start at (j,k)
            int res = 0;
            for (int j = 0; j <= n - i - 1; j++) {
                for (int k = 0; k <= n - i - 1; k++) {
                    if (check(j, k, i)) {
                        flag = true;
                        res++;
                    }
                }
            }
            if (res > 0)
                bfw.write(res + " square (s) of size " + i + "\n");
        }
        if (!flag)
            bfw.write("No completed squares can be found.\n");
    }

    static boolean check(int sx, int sy, int sz) {
        //check sides is connected or not.
        int tmp = sx * n + sy;
        for (int i = 0; i < sz; i++) {
            //check up sides
            if (!connectedH(tmp + i, tmp + i + 1))
                return false;
            //check left sides
            if (!connectedV(tmp + i * n, tmp + i * n + n))
                return false;
        }
        //check down sides
        tmp = sx * n + sy + sz * n;
        for (int i = 0; i < sz; i++) {
            if (!connectedH(tmp + i, tmp + i + 1))
                return false;
        }
        //check right sides
        tmp = sx * n + sy + sz;
        for (int i = 0; i < sz; i++) {
            if (!connectedV(tmp + i * n, tmp + i * n + n))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int pNum = 0;
        String s;

        while ((s = bfr.readLine()) != null && s.length() != 0) {
            if (pNum > 0)
                bfw.write("\n**********************************\n\n");
            bfw.write("Problem #" + ++pNum + "\n\n");
            n = Integer.parseInt(s);
            sideH = new int[n * n];
            sideV = new int[n * n];
//                for (int i = 0; i < n * n; i++) sideH[i] = i;
            int ops = Integer.parseInt(bfr.readLine());
            for (int i = 0; i < ops; i++) {
                String[] rTs = bfr.readLine().split("\\s+");
                int p = Integer.parseInt(rTs[1]) - 1;
                int q = Integer.parseInt(rTs[2]) - 1;
                if ("H".equals(rTs[0])) {
                    sideH[p] = q;
                } else if ("V".equals(rTs[0])) {
                    sideV[p] = q;
                }
            }
            solve();
        }
        bfr.close();
        bfw.close();
    }
}
