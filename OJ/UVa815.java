package algsPractice.OJ;

import java.io.*;
import java.util.PriorityQueue;

/**
 * Created by Scruel on 2017/4/21.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #thinking priorityQueue
 */
public class UVa815 {
    //        static int[][] arr;
    static PriorityQueue<Integer> pq;
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int round = 0;
        while (true) {
            pq = new PriorityQueue<Integer>();
            String[] rts = bfr.readLine().split("\\s+");
            n = Integer.parseInt(rts[0]);
            m = Integer.parseInt(rts[1]);
            if (n == 0 && m == 0)
                break;
//                        if (round > 0) bfw.write("\n");
            bfw.write("Region " + ++round + "\n");
//                        arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                rts = bfr.readLine().split("\\s+");
                for (int j = 0; j < m; j++) {
                    pq.add(Integer.parseInt(rts[j]));
//                                        arr[i][j] = Integer.parseInt(rts[j]);
                }
            }

            k = Integer.parseInt(bfr.readLine());
            int sumSameH = 0;
            double waterH = pq.peek();

            //不用pq直接sort做
            while (!pq.isEmpty()) {
                int currH = pq.peek();
                int nextH = pq.peek();
                while (nextH == currH) {
                    currH = pq.poll();
                    if (!pq.isEmpty())
                        nextH = pq.peek();
                    else
                        nextH = Integer.MAX_VALUE / 90000;
                    //对于k=0的情况，做额外处理
                    if (k != 0)
                        sumSameH++;
                }
                int tmp = (nextH - currH) * sumSameH * 100;
                if (k > tmp) {
                    waterH = nextH;
                    k -= tmp;
                } else {
                    //未分完
                    if (sumSameH != 0)
                        waterH += k / (double) sumSameH / 100.0;
                    break;
                }
            }
            //k为立方，尽量少使用乘法，避免精度溢出
            bfw.write(String.format("Water level is %.2f meters.\n", Math.round(waterH * 100) / 100.0));
//                        System.out.println(1e-9);
            bfw.write(String.format("%.2f percent of the region is under water.\n\n", Math.round(sumSameH / (double) (n * m) * 10000) / 100.0));
        }
        bfr.close();
        bfw.close();


    }
}
