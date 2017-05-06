package algsPractice.dpExercise;

/**
 * Created by Administrator on 2016/4/26.
 * **DP**
 */
//http://www.hawstein.com/posts/dp-novice-to-advanced.html
public class Coin_DP {
        public static void main(String[] args) {
                System.out.println(getMin(11));
        }

        public static int getMin(int n) {

                int[] dp = new int[n];
                dp[0] = 1;
                int[] coins = {1, 3, 5};//增加一个排序
                for (int i = 0; i < n; i++) {
                        int min = 999999999;
                        for (int j = 0; j < 3; j++) {
                                int y = i + 1;

                                if (y >= coins[j] && dp[y - coins[j]] < min) {
                                        if (y == coins[j])
                                                min = 0;//min=1的情况下，会发生重复叠加，导致结果出错
                                        else
                                                min = dp[y - 1 - coins[j]];
                                        //System.out.println(min + " ss" + i + dp[0]);
                                }

                        }
                        if (min == 999999999)
                                min = -1;

//                        if (y - coins[0] >= 0)
//                                temp = dp[y - coins[0]];//一种可用
//                        if (y - coins[1] >= 0 && y - coins[0] >= 0)
//                                temp = Math.min(dp[y - coins[0]], dp[y - coins[1]]);//两种可用
//                        if (y - coins[2] >= 0 && y - coins[1] >= 0 && y - coins[2] >= 0)
//                                temp = Math.min(Math.min(dp[y - coins[0]], dp[y - coins[1]]), dp[y - coins[2]]);//三种可用

                        dp[i] = min + 1;
                        //System.out.println(min + 1);
                }
                for (int i = 0; i < n; i++) {
                        System.out.print(dp[i] + " ");
                }
                System.out.println();
                return dp[n - 1];
        }
}
