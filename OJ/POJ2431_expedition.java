package algsPractice.OJ;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Scruel on 2016/4/9.
 * #structure
 */
public class POJ2431_expedition {
        public static void main(String[] args) {
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
                Scanner input = new Scanner(System.in);
                int n = 4;
                int l = 25;
                int p = 10;
                int[] a = {10, 14, 20, 21};
                int[] b = {2, 10, 2, 4};
                int ans = 0, position = 0, tank = p;

                for (int i = 0; i < n; i++) {
                        int d = a[i] - position;

                        while (tank - d < 0) {
                                if (pq.isEmpty()) {
                                        System.out.println(-1);
                                        return;
                                }
                                tank += pq.poll();
                                ans++;
                        }
                        pq.add(b[i]);
                        tank -= d;
                        position = a[i];
                }
                System.out.println(ans);

        }
}
