package algsPractice.OJ;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Scruel on 2017/5/11.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #greedy
 */
public class Nod1163 {
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        static Pair[] pairs;
        static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        public static void main(String[] args) throws IOException {
                int n = Integer.parseInt(bfr.readLine());
                pairs = new Pair[n];

                for (int i = 0; i < n; i++) {
                        String[] rts = bfr.readLine().split("\\s+");
                        pairs[i] = new Pair();
                        pairs[i].eT = Integer.parseInt(rts[0]);
                        pairs[i].weight = Integer.parseInt(rts[1]);
                }

                Arrays.sort(pairs);
                long ans = 0;
                for (int i = 0; i < n; i++) {
                        pq.add(pairs[i].weight);
                        ans += pairs[i].weight;
                        if (pq.size() > pairs[i].eT) ans -= pq.poll();
                }

                bfw.write(ans + "");
                bfr.close();
                bfw.close();
        }

        static class Pair implements Comparable<Pair> {
                int eT;
                int weight;

                @Override
                public int compareTo(Pair o) {
                        return this.eT - o.eT;
                }
        }


}
