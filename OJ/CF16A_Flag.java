package algsPractice.OJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Scruel on 2017/4/14.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #easy
 */
public class CF16A_Flag {
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] rTs = bfr.readLine().split("\\s+");
        int n = Integer.parseInt(rTs[0]);
        int m = Integer.parseInt(rTs[1]);
        char lastChar = ' ';
        for (int i = 0; i < n; i++) {
            char[] chars = bfr.readLine().toCharArray();
            //check adjacent horizontal rows color
            if (lastChar == chars[0]) {
                System.out.println("NO");
                return;
            }
            lastChar = chars[0];
            //check horizontal row color
            for (int j = 1; j < m; j++) {
                if (chars[j] != lastChar) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
