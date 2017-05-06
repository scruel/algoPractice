package algsPractice.OJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/27.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 智力题
 */
public class POJ1852_ants {
        public static void main(String[] args) {
                System.out.println(Arrays.binarySearch(new int[]{2, 3, 4, 6, 7}, 1));
                Scanner input = new Scanner(System.in);
                int n = input.nextInt();
                for (int i = 0; i < n; i++) {
                        solve(input);
                }
        }

        static void solve(Scanner input) {
                int l = input.nextInt();
                int n = input.nextInt();
                int[] x = new int[n];
                int[] xRe = new int[n];
                int min = Integer.MIN_VALUE;
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < n; i++) {
                        x[i] = input.nextInt();
                        int mul = l - x[i];
                        int tempMin = mul < x[i] ? mul : x[i];
                        int tempMax = mul > x[i] ? mul : x[i];
                        max = tempMax > max ? tempMax : max;
                        min = tempMin > min ? tempMin : min;
                }

                System.out.println(min + " " + max);
        }
}

