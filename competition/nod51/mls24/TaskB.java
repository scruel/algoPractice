package algsPractice.competition.nod51.mls24;


import java.io.*;

/**
 * Created by Scruel on 2017/4/26.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class TaskB {
        static int[][] nums = new int[25][105];
        static int res, n, m;
        static int[] tmpA = new int[25];

        public static void main(String[] args) throws IOException {
                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
                BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
                String[] rts = bfr.readLine().split("\\s+");
                n = new Integer(rts[0]);
                m = new Integer(rts[1]);
                for (int i = 0; i < m; i++) {
                        int tmp = new Integer(bfr.readLine());
                        nums[tmp - 1][++nums[tmp - 1][0]] = i + 1;
                }

                dfs(0);
                bfw.write(res + "");
                bfr.close();
                bfw.close();
        }

        //        static void dfs(int index) {
//                for (int num = 0; num < 50000; num++) {
//                        SecureRandom rm = new SecureRandom();
//                        for (int i = 0; i < n; i++) {
//                                tmpA[i] = nums[i][rm.nextInt(nums[i][0]) + 1];
//                        }
//                        int tmp = res;
//                        res = 0;
//                        sort();
//                        res = Math.max(res, tmp);
//                }
//        }
        static void dfs(int index) {
                if (index == n) {
                        int tmp = res;
                        res = 0;
                        sort(n);
                        res = Math.max(res, tmp);
                        return;
                }
                int maxSum = -1;
                int minSum = -1;
                //                int minSum = Integer.MAX_VALUE;
                for (int i = nums[index][0]; i >= 1; i--) {
                        tmpA[index] = nums[index][i];
                        int maxTmp = 0;
                        int minTmp = 0;
                        for (int j = 0; j < index + 1; j++) {
                                if (tmpA[index] < tmpA[j])
                                        minTmp++;
                        }
                        for (int j = index + 1; j < n; j++) {
                                if (tmpA[j] == 0) break;
                                if (tmpA[index] > tmpA[j])
                                        maxTmp++;
                        }

                        if (maxTmp >= maxSum || minTmp >= minSum) {
                                maxSum = maxTmp > maxSum ? maxSum : maxTmp;
                                minSum = minTmp > minSum ? minTmp : minSum;
                                dfs(index + 1);
                        }
                }
        }

        static void sort(int n) {
                int[] nums = new int[25];
                System.arraycopy(tmpA, 0, nums, 0, n);
                sort(nums, 0, n - 1);
        }

        static void sort(int[] nums, int lo, int hi) {
                if (lo >= hi) return;
                int mid = lo + (hi - lo) / 2;
                sort(nums, lo, mid);
                sort(nums, mid + 1, hi);
                merge(nums, lo, mid, hi);
        }

        static void merge(int[] nums, int lo, int mid, int hi) {
                int[] tmp = new int[hi + 1];
                System.arraycopy(nums, lo, tmp, lo, hi - lo + 1);
                int l = lo;
                int h = mid + 1;
                for (int i = lo; i < hi + 1; i++) {
                        if (l > mid) {
                                nums[i] = tmp[h++];
                        } else if (h > hi) {
                                nums[i] = tmp[l++];
                        } else if (tmp[l] <= tmp[h]) {
                                nums[i] = tmp[l++];
                        } else {
                                res += h - i;
                                nums[i] = tmp[h++];
                        }
                }
        }
}