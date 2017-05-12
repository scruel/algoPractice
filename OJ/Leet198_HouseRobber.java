package algsPractice.OJ;

/**
 * Created by Scruel on 2017/4/16.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #dp
 */
public class Leet198_HouseRobber {
        //        static int rob(int[] arr) {
//                int[][] dp = new int[num.length + 1][2];
//                for (int i = 1; i <= num.length; i++) {
//                        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
//                        dp[i][1] = num[i - 1] + dp[i - 1][0];
//                }
//                return Math.max(dp[num.length][0], dp[num.length][1]);
//        }
        static int rob(int[] nums) {
                int n = nums.length;
                if (n == 0) return 0;
                int[] dp = new int[n];
                dp[0] = nums[0];

//                for (int i = 1; i < n; i++) {
//                        for (int j = 0; j <= i; j++) {
//                                dp[i] = Math.max(dp[i], arr[j] + (j - 2 >= 0 ? dp[j - 2] : 0));
//                        }
//                }

                //dp[i] 为0...i的最大值
                for (int i = 1; i < n; i++) {
                        dp[i] = Math.max(dp[i - 1], nums[i] + (i - 2 >= 0 ? dp[i - 2] : 0));
                }
                return dp[n - 1];
        }
//        static int rob(int[] arr) {
//                int n = arr.length;
//                if (n == 0) return 0;
//                int[] dp = new int[n];
//                dp[n - 1] = arr[n - 1];
//
//                for (int i = n - 2; i >= 0; i--) {
//                        for (int j = i; j < n; j++) {
//                                dp[i] = Math.max(dp[i], arr[j] + (j + 2 < n ? dp[j + 2] : 0));
//                        }
//                }
//                return dp[0];
//        }
//
//        static int rob(int[] arr) {
//                int n = arr.length;
//                int[][] dp = new int[n + 1][n + 1];
//
//                //i表示当前有nums中的几个房子，j表示是否偷第j个房子
//                for (int i = 0; i < n; i++) {
//                        for (int j = 0; j < n; j++) {
//                                //偷当前房子
//                                for (int k = j - 1; k >= 0; k--) {
//                                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i + 1][k]);
//                                }
//                                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1] + arr[j], dp[i][j]);
//                        }
//                }
//                return dp[n][n];
//        }


        public static void main(String[] args) {

                System.out.println(rob(new int[]{4, 2, 3, 1}));
                System.out.println(rob(new int[]{4, 3, 2, 1}));
        }
}
