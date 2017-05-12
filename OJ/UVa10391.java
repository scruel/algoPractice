package algsPractice.OJ;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Scruel on 2017/4/27.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #structure
 */
public class UVa10391 {
        static String[] words = new String[120005];

        public static void main(String[] args) throws IOException {
                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

                String s;
                int n = 0;
                while ((s = bfr.readLine()) != null && !s.isEmpty()) {
                        words[n++] = s;
                }

                for (int i = 0; i < n; i++) {
                        if (words[i].length() == 1) continue;
                        for (int j = 1; j < words[i].length() - 1; j++) {
                                //也可以改为set
                                boolean pd1 = Arrays.binarySearch(words, 0, n, words[i].substring(0, j)) >= 0;
                                boolean pd2 = Arrays.binarySearch(words, 0, n, words[i].substring(j, words[i].length())) >= 0;
                                if (pd1 && pd2) {
                                        bfw.write(words[i] + "\n");
                                        break;
                                }
                        }
                }

                bfr.close();
                bfw.close();
        }


}
