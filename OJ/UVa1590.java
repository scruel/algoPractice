package algsPractice.OJ;

import java.io.*;

/**
 * Created by Scruel on 2017/4/18.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #ipAddress #binary #string
 */
public class UVa1590 {

        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        static void solve1() throws IOException {
                String s;
                while ((s = bfr.readLine()) != null && s.length() != 0) {
                        int n = new Integer(s);
                        String[] rts = bfr.readLine().split("\\.");
                        String binaryS = ssTobinaryS(rts);
//                        bfw.write(binaryS + "\n");
                        int index = 31;
                        for (int i = 1; i < n; i++) {
                                rts = bfr.readLine().split("\\.");
                                int tmpI = 0;
                                String tmpS = ssTobinaryS(rts);
//                                bfw.write(tmpS + "\n");
                                for (; tmpI < 32; tmpI++) {
                                        if (tmpS.charAt(tmpI) != binaryS.charAt(tmpI)) {
                                                tmpI--;
                                                break;
                                        }
                                }
                                index = tmpI < index ? tmpI : index;
//                                bfw.write(index+"\n");
                        }

                        binaryS = binaryS.substring(0, index + 1);
                        for (int i = index + 1; i < 32; i++)
                                binaryS += "0";
                        bfw.write(binarySToIP(binaryS) + "\n");
                        binaryS = "";
                        for (int i = 0; i < index + 1; i++)
                                binaryS += "1";

                        for (int i = index + 1; i < 32; i++)
                                binaryS += "0";
//                bfw.write(new String(bits) + "\n");
                        bfw.write(binarySToIP(binaryS) + "\n");
                }
                bfr.close();
                bfw.close();
        }

        //优化暴力
        static void solve2() throws IOException {
                String s;
                while ((s = bfr.readLine()) != null && s.length() != 0) {
                        int n = new Integer(s);
                        String[] maxrtS = null;
                        String[] minrtS = null;

                        long min = Long.MAX_VALUE;
                        long max = -1;
//                        bfw.write(binaryS + "\n");
                        int index = 0;
                        for (int i = 0; i < n; i++) {
                                String[] rts = bfr.readLine().split("\\.");
                                long tmp = new Long(rts[0]) * (1 << 24) + new Long(rts[1]) * (1 << 16) + new Long(rts[2]) * (1 << 8) + new Long(rts[3]);
                                if (tmp < min) {
                                        min = tmp;
                                        maxrtS = rts;
                                }
                                if (tmp > max) {
                                        max = tmp;
                                        minrtS = rts;
                                }
//                                bfw.write(tmpS + "\n");
//                                bfw.write(index+"\n");
                        }
                        String maxS = ssTobinaryS(maxrtS);
                        String minS = ssTobinaryS(minrtS);
                        for (; index < 32; index++)
                                if (minS.charAt(index) != maxS.charAt(index))
                                        break;
                        index--;
                        maxS = maxS.substring(0, index + 1);
                        for (int i = index + 1; i < 32; i++)
                                maxS += "0";

                        bfw.write(binarySToIP(maxS) + "\n");
                        maxS = "";
                        for (int i = 0; i < index + 1; i++)
                                maxS += "1";

                        for (int i = index + 1; i < 32; i++)
                                maxS += "0";
//                bfw.write(new String(bits) + "\n");
                        bfw.write(binarySToIP(maxS) + "\n");
                }

                bfr.close();
                bfw.close();
        }

        static String ssTobinaryS(String[] ss) {


                String tmp = String.format("%8s", Integer.toBinaryString(new Integer(ss[0]))) + String.format("%8s", Integer.toBinaryString(new Integer(ss[1]))) + String.format("%8s", Integer.toBinaryString(new Integer(ss[2]))) + String.format("%8s", Integer.toBinaryString(new Integer(ss[3])));

                return tmp.replaceAll(" ", "0");
        }

        static String binarySToIP(String s) {
                String res = "";
                res += Integer.parseInt(s.substring(0, 8), 2) + ".";
                res += Integer.parseInt(s.substring(8, 16), 2) + ".";
                res += Integer.parseInt(s.substring(16, 24), 2) + ".";
                res += Integer.parseInt(s.substring(24, 32), 2);
                return res;
        }

        //位运算版
        static void solve3() throws IOException {
                String s;
                while ((s = bfr.readLine()) != null && s.length() != 0) {
                        int n = new Integer(s);
                        long min = ~(long) 0 >>> 32;
                        long max = 0;
                        for (int i = 0; i < n; i++) {
                                String[] rts = bfr.readLine().split("\\.");
                                long cur = (new Long(rts[0]) << 24) | (new Long(rts[1]) << 16) | (new Long(rts[2]) << 8) | new Long(rts[3]);
                                max = cur > max ? cur : max;
                                min = cur < min ? cur : min;
                        }
                        long mask = ~(long) 0 >>> 32;
                        for (int i = 0; i <= 32; ++i) {
                                if ((min & mask) == (max & mask)) {
                                        print_ip(min & mask);
                                        print_ip(mask);
                                        break;
                                }
                                mask &= ~(1 << i);
                        }
                }

                bfr.close();
                bfw.close();
        }

        static void print_ip(long ip) throws IOException {
                long mask = ((long) 1 << 8) - 1;
                bfw.write(String.format("%d.%d.%d.%d\n", ip >> 24, ip >> 16 & mask, ip >> 8 & mask, ip & mask));
        }

        public static void main(String[] args) throws IOException {
//                solve1();
//                solve2();
                solve3();
        }

}

