package algsPractice.OJ;

import java.io.*;

/**
 * Created by Scruel on 2017/4/13.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * http://blog.csdn.net/crazysillynerd/article/details/43339157
 * #binary math big --> log
 */
public class UVa11809 {
        static final double EPSINON = 1e-4;
        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        static double[][] M = new double[20][40];
        static long[][] E = new long[20][40];

        public static void main(String[] args) throws IOException {
                String ts;
                for (int i = 0; i <= 9; i++) {
                        for (int j = 1; j <= 30; j++) {
                                double m = 1.0 - Math.pow(2, -1 - i);
                                double e = (1 << j) - 1;
                                double t = (Math.log10(m) + e * Math.log10(2));
                                E[i][j] = (long) t;
                                M[i][j] = Math.pow(10, t - E[i][j]);
                        }
                }
                while ((ts = bfr.readLine()) != null && !"0e0".equals(ts)) {
                        String[] rts = ts.toLowerCase().split("e");
                        double A = Double.parseDouble(rts[0]);
                        long B = Long.parseLong(rts[1]);
                        while (A < 1) {
                                A *= 10;
                                B -= 1;
                        }
                        for (int i = 0; i <= 9; i++) {
                                for (int j = 1; j <= 30; j++) {
                                        if (B == E[i][j] && (Math.abs(A - M[i][j]) < EPSINON || Math.abs(A / 10 - M[i][j]) < EPSINON)) {
                                                bfw.write(String.format("%d %d\n", i, j));
                                                break;
                                        }
                                }
                        }

                }
                bfr.close();
                bfw.close();
        }
}
