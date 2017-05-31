package algsPractice.competition.IQIYI;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Scruel on 2017/5/14.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Main2 {
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    //        static PriorityQueue<Integer> q = new PriorityQueue<Integer>();
    static int[] nums;

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(bfr.readLine());
        String[] rts = bfr.readLine().trim().split("\\s+");
        int n = rts.length;
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = -Integer.parseInt(rts[i]);
        }
        Arrays.sort(nums);
        long max = -nums[0];
        long res = 0;
        for (long i = max; i >= 1; i--) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (-nums[j] < i) break;
                long tmp = (-nums[j]) / i;
                cnt += tmp;
                if (cnt >= k) {
                    res = i;
                    break;
                }
            }
            if (res != 0) break;
        }


        bfw.write(String.format("%d", res));

        bfr.close();
        bfw.close();
    }
}
