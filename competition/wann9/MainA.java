package algsPractice.competition.wann9;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/5/6.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class MainA {
        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                int x = input.nextInt();
                int y = input.nextInt();
                int n = input.nextInt();
                double m = Math.sqrt(n * n + n * n);
//                if ((x == 0 && y == 0) || (x == n && y == 0) || (x == 0 && y == n) || (x == n && y == n)) {
//
//                        System.out.printf("%.6f", m);
//                        return;
//                }
//                double zx = distance(x, y, 0, 0);//左下
//                double yx = distance(x, y, n, 0);//右下
//                double zs = distance(x, y, 0, n);//右下
                double ys = 2 * Math.sqrt(4 * x * x + 4 * y * y);//右上
                System.out.println(ys);
//                if (x == y) {
//                        System.out.print(m + zs + yx);
//                        return;
//                }
//                if (x + y == n) {
//                        System.out.print(m + zx + ys);
//                        return;
//                }
//
//
////                System.out.println(m);
////                System.out.printf("%.6f\n", m + zx + ys);
////                System.out.printf("%.6f\n", m + zs + yx);
//                System.out.print(m + zx + ys > m + zs + yx ? m + zs + yx : m + zx + ys);
        }

        public static double distance(int x1, int y1, int x2, int y2) {
                return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        }
}
