package algsPractice.OJ;

import java.io.*;

/**
 * Created by Scruel on 2017/4/21.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class UVa1593 {
        static String[][] strs = new String[1005][185];

        public static void main(String[] args) throws IOException {
                BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
                String s;
                int index = 0;
//                int maxLen = 0;
                int[] maxWLen = new int[185];
                while ((s = bfr.readLine()) != null && s.length() != 0) {
                        s = s.trim();
                        String[] rts = s.split("\\s+");
//                        maxLen = rts.length > maxLen ? rts.length : maxLen;
                        strs[index][0] = rts.length + "";
                        for (int i = 1; i <= rts.length; i++) {
                                maxWLen[i] = maxWLen[i] > rts[i - 1].length() ? maxWLen[i] : rts[i - 1].length();
                                strs[index][i] = rts[i - 1];
                        }
                        index++;
                }

                for (int i = 0; i < index; i++) {
                        int wLen = new Integer(strs[i][0]);
                        for (int j = 1; j < wLen; j++) {
                                String tmp = formatS(strs[i][j], maxWLen[j]);
                                bfw.write(tmp);
                        }
                        bfw.write(strs[i][wLen]);
//                        System.exit(0);
                        bfw.write("\n");
                }

                bfr.close();
                bfw.close();
        }

        static String formatS(String s, int maxLen) {
//                System.out.println(maxLen);4
                return String.format("%-" + (maxLen + 1) + "s", s);
        }
}
