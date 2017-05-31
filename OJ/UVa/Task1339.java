package algsPractice.OJ.UVa;


import java.io.*;
import java.util.Arrays;

/**
 * Created by Scruel on 2017/4/5.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 可排序--即忽略顺序
 * #string #sort #static
 */
public class Task1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        while (null != (s = bfr.readLine()) && s.length() != 0) {
            String s2 = bfr.readLine();
            int[] a1 = new int[256];
            int[] a2 = new int[256];
            for (int i = 0; i < s.length(); i++) {
                a1[s.charAt(i)]++;
                a2[s2.charAt(i)]++;
            }
            boolean flag = true;
            Arrays.sort(a1);
            Arrays.sort(a2);
            for (int i = 0; i < 256; i++) {
                if (a1[i] != a2[i]) flag = false;
            }
            if (flag) bfw.write("YES\n");
            else bfw.write("NO\n");
        }

        bfr.close();
        bfw.close();
    }
}
