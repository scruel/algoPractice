package algsPractice.OJ;

import java.io.*;
import java.math.BigInteger;

/**
 * Created by Scruel on 2017/5/13.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Hackerrank_counterGame {
        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        static char[] binary;
        static BigInteger pow2 = new BigInteger("2").pow(63);

        public static void main(String[] args) throws IOException {
                int T = Integer.parseInt(bfr.readLine());
                while (T-- > 0) {
                        String nST = bfr.readLine();
                        BigInteger biT = new BigInteger(nST);
                        if (biT.compareTo(pow2) == 0) {
                                bfw.write("Louise\n");
                        } else {
                                int cnt = 0;
                                if (biT.compareTo(pow2) > 0) {
                                        biT = biT.subtract(pow2);
                                        cnt++;
                                }
                                long n = Long.parseLong(biT.toString());
                                binary = Long.toBinaryString(n).toCharArray();
//                        System.out.println(binary);
                                int index = 0;
                                //统计什么时候会出现2的幂次
                                for (int i = binary.length - 1; i >= 0; i--) {
                                        if (binary[i] != '0')
                                                break;
                                        index++;
                                }
                                cnt += index;
//                                System.out.println(cnt);
                                for (int i = 0; i < binary.length - index - 1; i++) {
                                        if (binary[i] == '1')
                                                cnt++;
                                }
//                                System.out.println(cnt);
                                if ((cnt & 1) == 0 && cnt != 0) {
                                        bfw.write("Richard\n");
                                } else {
                                        bfw.write("Louise\n");
                                }
                        }
                }

                bfr.close();
                bfw.close();
        }
}
