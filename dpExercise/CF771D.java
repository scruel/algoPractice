package algsPractice.dpExercise;

import algs4.MyTools;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/29.  
 * Github : https://github.com/scruel
 * #unsolve
 * 首先初始化dp数组（d），将每个元素初始化为正无穷，这里我用了一个小技巧就是memset(d, 0x3F, sizeof(d));，这样就将d数组中的每个元素初始化为了一个足够大的数（0x3F3F3F3F）；
 * 由于在这道题中，不是"V"或"K"的字母都是等价的，所以统一把不是"V"或"K"的字母替换为"?"；
 * 接下来使用记忆化搜索的方式做动态规划；
 * 我设了4个维度的状态，分别是当前V的数量、当前K的数量、当前其他字符的数量和上一个被删除的字符是否是"V"；
 * 每次有三个转移方向：
 * 1. 删去第一个K
 * 2. 删去第一个V
 * 3. 删去第一个?（不是"V"或"K"的字母）
 * 每次转移删去一个字符并维护每个元素removed和总元素个数remain状态；
 * 值得注意的是，当最后一个删除的字符是"V"，时不能向"K"方向转移，因为这是一个被禁止的模式；
 * 最后，dp(0, 0, 0, 0)即为答案。
 * 由于转移路径不规则，使用记忆化搜索可以使代码思路更清晰，同时保证时间复杂度不增加（但无疑会增加常数）；
 * 本解决方案时间复杂度为O(n ^ 4)，但删除字符O(n)的复杂度是可以优化为O(1)的，只需多维护一个链表或记录每个位置"V"、"K"、"?"的前缀（或后缀）数量即可；
 * 优化后的时间复杂度可降至O(n ^ 3)。
 */
public class CF771D {
  static int[][][][] d = new int[76][76][76][2];
  static char[] a;
  static char[] ch = new char[4];
  static boolean[] removed = new boolean[76];
  static int INF = 0x3F3F3F3F;
  static int remain;

  static int dp(int v, int k, int r, int forbid) {
    int res = d[v][k][r][forbid];
    //                if (res != INF) {
    //                        return res;
    //                }
    if (remain == 0) {
      return 0;
    }
    for (int i = 0; i < 3; ++i) {
      if (ch[i] == 'K' && forbid != 0) {
        continue;
      }
      int cnt = 0;
      for (int j = 0; j < a.length; ++j) {
        if (!removed[j]) {
          if (a[j] == ch[i]) {
            removed[j] = true;
            --remain;
            res = Math.min(res, dp(v + ((ch[i] == 'V') ? 1 : 0), k + ((ch[i] == 'K') ? 1 : 0), r + ((ch[i] == '?') ? 1 : 0), ((ch[i] == 'V') ? 1 : 0)) + cnt);
            ++remain;
            removed[j] = false;
            break;
          }
          ++cnt;
        }
      }
    }
    return res;
  }


  static int solve(int n, String s) {
    char[] chars = s.toCharArray();
    int[][] dp = new int[n + 1][n + 1];
    //                dp[i][j]代表的是旋转代价

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (chars[j] == 'K' && chars[i] == 'V' && j > i) {
          //将V转移到K位置的旋转代价
          //                                        dp[i + 1][j + 1] = j - i;
          dp[i + 1][j + 1] = Math.max(Math.max(dp[i][j + 1], dp[i + 1][j]), j - i);
        }
        else if (chars[i] == 'K' && chars[j] == 'V' && j < i) {
          //                                        dp[i + 1][j + 1] = i - j;
          dp[i + 1][j + 1] = Math.max(Math.max(dp[i][j + 1], dp[i + 1][j]), i - j);
        }
        else {
          if (chars[i] != 'K' && chars[i] != 'V') {
            if (i > j && chars[j] == 'K') {
              dp[i + 1][j + 1] = i - j;
            }
            else if (i < j && chars[i] == 'V') {
              dp[i + 1][j + 1] = j - i;
            }
            else {
              dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]);
            }
          }
          else {
            //无需旋转
            dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
          }
          //                                        dp[i + 1][j + 1] = dp[i][j+1];
        }
      }
    }
    MyTools.print_r(dp);
    return dp[n][n];
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    input.nextLine();
    String s = input.nextLine();

    remain = n;
    a = s.toCharArray();
    for (int i = 0; i < 76; i++) {
      for (int j = 0; j < 76; j++) {
        for (int k = 0; k < 76; k++) {
          d[i][j][k][0] = 0x3F3F3F3F;
          d[i][j][k][1] = 0x3F3F3F3F;
        }
      }
    }

    //                memset(d, 0x3F, sizeof(d));
    for (int i = 0; i < n; ++i) {
      a[i] = a[i] == 'V' || a[i] == 'K' ? a[i] : '?';
    }
    //                printf("%d\n", dp(0, 0, 0, 0));

    //                if (s.indexOf("VK") == -1) {
    //                        System.out.println(0);
    //                        return;
    //                }
    ch = "VK?".toCharArray();
    System.out.println(dp(0, 0, 0, 0));
    //                System.out.println(solve3Dim(n, s));
  }
}
