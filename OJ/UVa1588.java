package algsPractice.OJ;

import java.io.*;

/**
 * Created by Scruel on 2017/5/19.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class UVa1588 {

        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        static boolean check(char i, char j) {
                return i != '2' || j != '2';
        }

        static int getRes(String ds, String ts) {
                for (int i = 0; i < ds.length(); i++) {
                        boolean flag = true;
                        for (int j = 0; j < ts.length(); j++) {
                                if (i + j > ds.length() - 1) {
                                        return (ds.length() + ts.length() - j);
                                } else if (!check(ds.charAt(i + j), ts.charAt(j))) {
                                        flag = false;
                                        if (i == ds.length() - 1) return ds.length() + ts.length();
                                        break;
                                }
                        }
                        if (flag) {
                                return ds.length();
                        }
                }
                return 0;
        }

        public static void main(String[] args) throws IOException {
                String ds;
                while ((ds = bfr.readLine()) != null && !ds.isEmpty()) {
                        String ts = bfr.readLine();
                        int res = getRes(ds, ts);
                        int res2 = getRes(ts, ds);


                        bfw.write((res < res2 ? res : res2) + "\n");

                }

                bfr.close();
                bfw.close();
        }

}
