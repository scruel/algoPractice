package algsPractice.oj_t.newcoder;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/23.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 平衡数
 * 牛牛在研究他自己独创的平衡数，平衡数的定义是：将一个数分成左右两部分，分别成为两个新的数。
 * 左右部分必须满足以下两点：
 * 1，左边和右边至少存在一位。
 * 2，左边的数每一位相乘如果等于右边的数每一位相乘，则这个数称为平衡数。
 * 例如：1221这个数，分成12和21的话，1*2=2*1，则称1221为平衡数，再例如：1236这个数，可以分成123和1*2*3=6，所以1236也是平衡数。而1234无论怎样分也不满足平衡数。
 * 输入描述:
 * 输入一个正整数（int范围内）。
 * <p>
 * <p>
 * 输出描述:
 * 如果该数是平衡数，输出 "YES", 否则输出 "NO"。
 * <p>
 * 输入例子:
 * 1221
 * 1234
 * <p>
 * 输出例子:
 * YES
 * NO
 * **模式匹配** **dfs枚举**
 */
public class BalanceString {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    String s = String.valueOf(n);
    if (s.length() < 2) {
      System.out.println("NO");
      return;
    }
    char[] chars = s.toCharArray();
    //                System.out.println(s);

    int[] sum1 = new int[chars.length];
    sum1[0] = chars[0] - 48;
    for (int i = 1; i < chars.length; i++) {
      sum1[i] = (chars[i] - 48) * sum1[i - 1];
    }
    int[] sum2 = new int[chars.length];
    sum2[0] = chars[chars.length - 1] - 48;
    for (int i = 1; i < chars.length; i++) {
      sum2[i] = (chars[chars.length - i - 1] - 48) * sum2[i - 1];
    }
    // 1没考虑到后面都是0的情况，于是输出no，后面两个while循环解决了长度单数的问题
    // 2是没考虑到808这种数还没读完所有的数就输出yes的情况
    int p = chars.length - 1, q = chars.length - 1;
    while (p >= 0 && q >= 0) {
      if (sum1[p] < sum2[q]) {
        q--;
      }
      else if (sum1[p] > sum2[q]) {
        p--;
      }
      else if (p + q == chars.length - 2) {
        System.out.println("YES");
        return;
      }
      else {
        int tempP = p;
        int tempQ = q;
        while (tempP >= 0) {
          if (sum1[tempP] != sum2[q]) {
            break;
          }
          else if (tempP + q == chars.length - 2) {
            System.out.println("YES");
            return;
          }
          else {
            tempP--;
          }
        }
        while (tempQ >= 0) {
          if (sum1[p] != sum2[tempQ]) {
            break;
          }
          else if (p + tempQ == chars.length - 2) {
            System.out.println("YES");
            return;
          }
          else {
            tempQ--;
          }
        }
        q--;
        p--;
      }
    }
    System.out.println("NO");
  }
}
