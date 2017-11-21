package algsPractice.oj_t.leetcode;

/**
 * Created by Scruel on 2017/4/16.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #dp 环形dp--分割两部分解
 */
public class Leet213_HouseRobberII {

  public static void main(String[] args) {
    Leet213_HouseRobberII t = new Leet213_HouseRobberII();
    System.out.println(t.rob(new int[]{1}));//1
    System.out.println(t.rob(new int[]{1, 2, 1, 1}));//3
    System.out.println(t.rob(new int[]{1, 2, 1, 0}));//2
    System.out.println(t.rob(new int[]{1000, 4, 5, 6, 3, 123, 6, 7, 1}));
    System.out.println(t.rob(new int[]{1, 1, 1}));
    System.out.println(t.rob(new int[]{1, 1}));
    System.out.println(t.rob(new int[]{0}));
  }

  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    //这部分有分割思想，一个是尾取头不取，一个是头取尾不取
    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
  }

  //        public int rob(int[] arr, int lo, int hi) {
  //                int preRob = 0, preNotRob = 0, rob = 0, notRob = 0;
  //                for (int i = lo; i <= hi; i++) {
  //                        rob = preNotRob + arr[i];
  //                        notRob = Math.max(preRob, preNotRob);
  //
  //                        preNotRob = notRob;
  //                        preRob = rob;
  //                }
  //                return Math.max(rob, notRob);
  //        }

  public int rob(int[] nums, int lo, int hi) {
    //只有一个元素的时候，返回nums[0]
    if (hi - lo + 1 == 0) {
      return nums[0];
    }
    if (hi - lo + 1 < 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    dp[lo] = nums[lo];
    //找lo...hi之间的lo...i的最大值
    for (int i = lo + 1; i <= hi; i++) {
      dp[i] = Math.max(dp[i - 1], nums[i] + (i - 2 >= 0 ? dp[i - 2] : 0));
    }
    //                MyTools.print_r(dp);
    return dp[hi];
  }


}
