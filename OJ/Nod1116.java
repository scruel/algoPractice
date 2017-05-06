package algsPractice.OJ;

import java.io.*;

/**
 * Created by Scruel on 2017/4/28.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Nod1116 {

        public static void main(String[] args) throws IOException {
                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
                BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
//                Scanner input = new Scanner(System.in);
//                String str = input.nextLine();
                char[] chars = bfr.readLine().toCharArray();
                long sum = 0;
                int max = 2;
                for (char aChar : chars) {
                        if (aChar <= '9') {
                                sum += aChar - '0';
                                max = Math.max(max, aChar - '0');
                        } else {
                                sum += aChar - 'A' + 10;
                                max = Math.max(max, aChar - 'A' + 10);
                        }
                }
//                max++;
//                for (int i = max - 1; i <= 35; i++) {
                int res = 0;
                for (int i = max; i < 36; i++) {
                        if (sum % i == 0) {
                                res = i + 1;
                                break;
                        }
                }
                bfw.write(res == 0 ? "No Solution" : String.valueOf(res));
                bfw.close();
                bfr.close();
        }

}
