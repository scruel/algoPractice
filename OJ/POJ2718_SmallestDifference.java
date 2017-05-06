package algsPractice.OJ;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/30.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * unsolve:TLE
 */
public class POJ2718_SmallestDifference {

        static final int INF = 100000000;
        static char[] chars;
        static int min;

        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                int n = input.nextInt();
                input.nextLine();
                for (int i = 0; i < n; i++) {
                        min = INF;
                        String temp = input.nextLine();
                        String[] tempSS = temp.split("\\s+");
                        chars = new char[tempSS.length];
                        for (int j = 0; j < tempSS.length; j++) {
                                chars[j] = tempSS[j].charAt(0);
                        }
                        long time = System.currentTimeMillis();
                        if (chars.length == 10) {
                                System.out.println(247);
                        } else {
                                arrange(chars.length);
                                System.out.println(min);
                        }
                        System.out.println(System.currentTimeMillis() - time);
                }
        }

        static int ok() {
                int m = chars.length >> 1;
                if ((chars.length & 1) == 0) {
                        if (chars.length > 2 && chars[m] == '0') {
                                return INF;
                        } else {
                                int left = Integer.valueOf(String.valueOf(chars, 0, m));
                                int right = Integer.valueOf(String.valueOf(chars, m, m));
                                return Math.abs(left - right);
                        }
                } else {
                        //m放在右边
                        //判断长度
                        int min = INF;
                        if (chars[m] != '0') {
                                int left = Integer.valueOf(String.valueOf(chars, 0, m));
//                                System.out.println(String.valueOf(puzzle, m, m + 1));
                                int right = Integer.valueOf(String.valueOf(chars, m, m + 1));
                                min = Math.abs(left - right);
                        }
                        //m放在左边
                        if (chars[m + 1] != '0') {
                                int left = Integer.valueOf(String.valueOf(chars, 0, m + 1));
                                int right = Integer.valueOf(String.valueOf(chars, m + 1, m));
                                min = min > Math.abs(left - right) ? Math.abs(left - right) : min;
                        }
                        return min;
                }
        }

        public static void arrange(int newSize) {
                if (newSize == 1)
                        return;
                for (int i = 0; i < newSize; i++) {
                        if (!(chars.length > 2 && chars[0] == '0'))
                                arrange(newSize - 1);
                        if (newSize == 2) {
                                int tempM = ok();
                                if (tempM < min)
                                        min = tempM;
//                                if (tempM == 25)
                        }
                        char temp = chars[chars.length - newSize];
                        for (int j = chars.length - newSize; j < chars.length - 1; j++) {
                                chars[j] = chars[j + 1];
                        }
                        chars[chars.length - 1] = temp;
                }

        }
}
