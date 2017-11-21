package algsPractice.dpExercise;

import java.util.Scanner;

/**
 * Created by Scruel on 2016/3/29.
 * **DP**
 * #unsolve
 */
public class CF2B {
  static int min = 999999999;
  static int size, z_x = -1, z_y = -1;
  static String re = "";
  static int[][] nums_2;
  static int[][] nums_5;
  static int[][] dp_2;
  static int[][] dp_5;

  static boolean b = false;

  public static void main(String[] args) {
    //                Random rm = new Random();
    //                System.out.println(100);
    //                for (int i = 0; i <100; i++)
    //                {
    //                        for (int j = 0; j <100; j++)
    //                        {
    //                                System.out.print(rm.nextInt(999)+" ");
    //                        }
    //                        System.out.println();
    //                }
    Scanner input = new Scanner(System.in);
    size = input.nextInt();
    nums_2 = new int[size][size];
    nums_5 = new int[size][size];
    dp_2 = new int[size][size];
    dp_5 = new int[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        int count_2 = 0, count_5 = 0;
        int num = input.nextInt();
        if (num == 0) {
          nums_2[i][j] = nums_5[i][j] = 1;
          z_x = z_x == -1 ? i : z_x;
          z_y = z_y == -1 ? j : z_y;
          min = 1;
        }
        else {
          while (num % 2 == 0) {
            num /= 2;
            count_2++;
          }
          nums_2[i][j] = count_2;
          if (count_2 != 0) {
            num *= count_2 * 2;
          }
          while (num % 5 == 0) {
            num /= 5;
            count_5++;
          }
          nums_5[i][j] = count_5;
        }

      }

    }
    inDParray(nums_2, dp_2);
    inDParray(nums_5, dp_5);
    min = dp_2[size - 1][size - 1] < dp_5[size - 1][size - 1] ? dp_2[size - 1][size - 1] : dp_5[size - 1][size - 1];
    dfs();
    System.out.println(min);
    System.out.println(re);
  }

  public static void dfs() {
    dfs(0, 0, "", 0, 0);
  }

  private static void inDParray(int[][] matrix, int[][] dp) {
    dp[0][0] = matrix[0][0];

    for (int j = 1; j < size; j++)
      dp[0][j] = dp[0][j - 1] + matrix[0][j];
    for (int i = 1; i < size; i++)
      dp[i][0] = dp[i - 1][0] + matrix[i][0];

    for (int i = 1; i < size; i++) {
      for (int j = 1; j < size; j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
      }
    }
  }

  public static boolean dfs(int i, int j, String result, int count_2, int count_5) {
    if (min == 1 && z_x == i && z_y == j) {
      while (++i < size)
        re += "D";
      while (++j < size)
        re += "R";
      return true;
    }

    count_2 += nums_2[i][j];
    count_5 += nums_5[i][j];
    if (i > 1 && j > 1 && (dp_2[i][j] - nums_2[i][j] != dp_2[i - 1][j] || dp_5[i][j] - nums_5[i][j] != dp_5[i - 1][j])) {
      return false;
    }
    int count = count_2 < count_5 ? count_2 : count_5;
    //System.out.println(i + " " + j + "--" + count);
    System.out.println(result);
               /* if (count > min)//第一个出口
                {
                        System.out.println(i + " " + j + " " + count);
                        if (result.charAt(result.length() - 1) == 'D')
                        {
                                nums_2[i - 1][j] += nums_2[i][j];
                                nums_5[i - 1][j] += nums_5[i][j];
                        } else
                        {
                                nums_2[i][j - 1] += nums_2[i][j];
                                nums_5[i][j - 1]+= nums_5[i][j];
                        }
                        return false;
                }*/


    if (i == size - 1 && j == size - 1)//主要出口，当达到右下角时判断是否是最小count，如果是则赋值，然后返回
    {
      System.out.println(111);
      if (count <= min) {
        re = result;
        return true;
      }

    }

    if (i + 1 < size) {
      if (dfs(i + 1, j, result + "D", count_2, count_5)) {
        return true;
      }
    }

    if (j + 1 < size) {
      if (dfs(i, j + 1, result + "R", count_2, count_5)) {
        return true;
      }
    }

    return false;
  }

}