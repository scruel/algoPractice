package practice.algsoj;

/**
 * Created by Scruel on 2017/4/13.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * **二进制转换**
 */
public class UVa11809 {
        static long solve(String s) {
                long sum = 0;
                long powSum = 1;
                for (int i = s.length() - 1; i >= 0; i--) {
                        if (s.charAt(i) == '1')
                                sum += powSum;
                        powSum *= 2;
                }

                return sum;
        }

        public static void main(String[] args) {
                String temp = "1111111111111111111111111111111111111111111111111111111111";
                System.out.println(solve(temp));
                System.out.println(Long.parseLong(temp, 2));

        }
}
