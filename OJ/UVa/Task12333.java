package algsPractice.OJ.UVa;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import static java.lang.Math.max;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #TLE #Trie #bigInteger TODO
 */
public class Task12333 {
    String[] bgs = new String[100000 + 5];

    BI add(BI a, BI b) {
        a.len = max(a.len, b.len);
//        printf("len:%d\n",a.len);
        int ed = a.len / 4 * 4;
        for (int i = 1; i <= ed; i += 4) {
            a.x[i] += b.x[i];
            a.x[i + 1] += b.x[i + 1];
            a.x[i + 2] += b.x[i + 2];
            a.x[i + 3] += b.x[i + 3];
        }
        for (int i = ed + 1; i <= a.len; i++)
            a.x[i] += b.x[i];

//        for(register int i=1;i<=a.len;i++) a.v[i]+=b.v[i];

        for (int i = 1; i <= a.len; i++) {
            if (a.x[i] >= 10) {
                a.x[i + 1] += a.x[i] / 10;
                a.x[i] %= 10;
            }
        }
        if (a.x[a.len + 1] != 0) ++a.len;
        return a;
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        bgs[0] = bgs[1] = "1";
        BI x = new BI();
        BI xf1 = new BI();
        x.x[1] = xf1.x[1] = 1;
        x.len = xf1.len = 1;
        BI[] bis = new BI[2];
        bis[0] = x;
        bis[1] = xf1;
        for (int i = 2; i <= 100000; i++) {
            int tmp = i & 1;
            bis[tmp] = add(bis[tmp], bis[tmp ^ 1]);
            String s = bis[tmp].toString();
            bgs[i] = s;
        }
        int T = in.nextInt();
        int kase = 0;
        while (kase++ != T) {
            out.write("Case #", kase, ": ");
            boolean f = false;
            String s = in.nextLine();
            for (int i = 0; i <= 100000 - 1; i++) {
                if (bgs[i].startsWith(s)) {
                    out.writeln(i);
                    f = true;
                    break;
                }
            }
            if (!f) out.writeln(-1);
        }
    }

    static class BI {
        int[] x = new int[24501];
        int len;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
//            for (int i = 1; i <= (Math.min(len, 41)); i++) {
//                sb.append(v[i]);
//            }

            for (int i = len; i >= Math.max(1, len - 40 + 1); i--) {
                sb.append(x[i]);
            }

            return sb.toString();
        }
    }
}
