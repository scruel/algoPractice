package algsPractice.OJ;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/31.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * greed
 */
public class POJ2431 {
        static int N;
        static int L;
        static int P;
        static Point[] points;

        static void solve() {
                PriorityQueue<Integer> queueB = new PriorityQueue<Integer>();
                Arrays.sort(points);
                int pos = 0;
                int res = 0;
                for (int i = N; i >= 0; i--) {
                        int d = L - points[i].a - pos;
                        while (P < d) {
                                if (queueB.isEmpty()) {
                                        System.out.println("-1");
                                        return;
                                } else {
                                        res++;
                                        P += 2000000 - queueB.poll();
                                }
                        }
                        P -= d;
                        pos = L - points[i].a;
                        queueB.add(2000000 - points[i].b);
                }
                System.out.println(res);
        }

        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                N = input.nextInt();
                points = new Point[N + 1];
                points[0] = new Point();
                for (int i = 1; i < N + 1; i++) {
                        points[i] = new Point();
                        points[i].a = input.nextInt();
                        points[i].b = input.nextInt();
                }
                L = input.nextInt();
                P = input.nextInt();
                solve();
        }

        static class Point implements Comparable<Point> {
                int a = 0;
                int b = 0;

                public int compareTo(Point o) {
                        return this.a - o.a;
                }
        }
}
