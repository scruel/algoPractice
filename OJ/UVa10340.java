package algsPractice.OJ;

import java.io.*;

/**
 * Created by Scruel on 2017/4/13.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #loop #dp
 */
public class UVa10340 {
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));


    static boolean solve(String s1, String s2) {
//                char[] chars1 = s1.toCharArray();
//                char[] chars2 = s2.toCharArray();
//
//                int[][] dp = new int[s1.length() + 1][s2.length() + 1];
//                for (int i = 0; i < s1.length(); i++) {
//                        for (int j = 0; j < s2.length(); j++) {
//                                if (s1.charAt(i) == s2.charAt(j))
//                                        dp[i + 1][j + 1] = dp[i][j] + 1;
//                                else
//                                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
//                        }
//                }
//                return dp[s1.length()][s2.length()] == s1.length();

        int sum = 0;
        int j = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (j >= s2.length())
                break;
            while (j < s2.length()) {
                if (s1.charAt(i) == s2.charAt(j++)) {
                    sum++;
                    break;
                }
            }
        }
        return sum == s1.length();
    }


    public static void main(String[] args) throws IOException {
        String temp;
        while (null != (temp = bfr.readLine()) && temp.length() != 0) {
            String[] rTs = temp.split("\\s+");
            if (solve(rTs[0], rTs[1])) bfw.write("Yes\n");
            else bfw.write("No\n");
        }
        bfr.close();
        bfw.close();
    }
}
