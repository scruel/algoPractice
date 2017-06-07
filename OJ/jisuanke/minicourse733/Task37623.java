package algsPractice.OJ.jisuanke.minicourse733;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task37623 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int l1 = in.nextInt();
        int r1 = in.nextInt();
        int l2 = in.nextInt();
        int r2 = in.nextInt();
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums, l1 - 1, r1);
        Arrays.sort(nums, l2 - 1, r2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < n - 1; i++) {
            out.write(nums[i] + " ");
        }
        out.writeln(nums[n - 1]);

    }
}
