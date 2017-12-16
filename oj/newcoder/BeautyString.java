package algsPractice.oj.newcoder;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/24.  
 * Github : https://github.com/scruel
 * **dfs** **模式匹配**
 * <p>
 * 牛牛在书上看到一种字符串叫做回文串,当一个字符串从左到右和从右到左读都是一样的,就称这个字符串为回文串。牛牛又从好朋友羊羊那里了解到一种被称为优美的回文串的字符串,考虑一个长度为N只包含大写字母的字符串,写出它所有长度为M的连续子串(包含所有可能的起始位置的子串,相同的子串也要计入),如果这个字符串至少有K个子串都是回文串,我们就叫这个字符串为优美的回文串。现在给出一个N,牛牛希望你能帮他计算出长度为N的字符串有多少个是优美的回文串(每个位置都可以是’A’~’Z’的一个。)
 * <p>
 * 输入描述:
 * 输入数据包括三个整数N, M, K(2 ≤ N ≤ 11, 2 ≤ M ≤ N, 0 ≤ K ≤ 11).
 * <p>
 * 输出描述:
 * 输出一个整数,表示所求的字符串个数
 * <p>
 * 输入例子:
 * 2 2 1
 * <p>
 * 输出例子:
 * 26
 * 长度为2的字符串,它长度为2的子串只有它自身。长度为2的回文串有”AA”,”BB”,”CC”…”ZZ”,一共26种。
 */
public class BeautyString {
  //定义数组a为一种模式，a中a[i]与a[j]相同代表两个位置处为同一字符
  static int[] a = new int[12];
  static int n, m, k, cnt = 0;
  private static int count = 0;
  //定义P(26,i)代表使用i个字母所组成的每位互不相同的全排列，fac[0]=P(26,0)代表用了一个字母每位都不相同的全排列(=26种)，fac[1]=P(26,1)代表用了2个字母每位都不相同的全排列(=650种),.....
  private static long[] fac = new long[12];

  private static void sumString(int n, int m, int k, char[] chars, int index) {
    if (index == n) {
      int sum = 0;
      for (int i = 0; i < n - m + 1; i++) {
        //判断当前这个m长度的子字符串是否符合要求
        char[] temp = new char[m];
        //这里可以使用记忆搜索的方法来提高效率
        for (int j = 0; j < m; j++) {
          temp[j] = chars[j + i];
        }
        boolean flag = true;
        int lo = 0;
        int hi = m - 1;
        while (lo < hi) {
          if (temp[lo++] != temp[hi--]) {
            flag = false;
          }
        }
        if (flag) {
          sum++;
        }
      }
      if (sum >= k) {
        count++;
      }
      return;
    }
    for (int i = 0; i < 26; i++) {
      chars[index] = (char) ('a' + i);
      sumString(n, m, k, chars, index + 1);
    }
  }

  private static boolean check(int from) {
    for (int i = 0; i < m / 2; ++i) {
      if (a[from + i] != a[from + m - i - 1]) {
        return false;
      }
    }
    return true;
  }


  private static boolean check() {
    //检验模式
    int cnt = 0;
    for (int i = 0; i <= n - m; ++i) {
      if (check(i)) {
        ++cnt;
      }
    }
    return cnt >= k;
  }

  //num代表在n长度的字符串上用了几种不同的字母，num=0为用了1种，比如AAA，BBB；num=1为用了2种，比如ABA，CCB，依此类推(所有例子的n都为3)，注意，这里都是模式匹配！
  //pos代表当前是第几个字符完成了模式填充
  private static void dfs(int pos, int num) {
    if (pos == n) {
      if (check())
      //a模式下，有num个位置必须不同，其它的位置都只有按照（check后的可行的）模式匹配的1种选择，所以直接+即可
      {
        cnt += fac[num];
      }
      return;
    }
    else {
      //当前pos位置有num个数字可用，枚举当前层num种可能性，下一层会继续枚举穷尽

      //i<num，所以下面这个循环会枚举出(....,[0 - (n - 1)],[0 - n],....)的所有模式，例：{0, 0, 0}，{0, 0, 1}
      //要注意的是，枚举模式{0, 0, 1}，{0, 0, 2}表达的意思是一样的，所以下一层处理的不同字母数应该与当前层相同，即num不变
      for (int i = 0; i < num; i++) {
        a[pos] = i;
        dfs(pos + 1, num);
      }
      //pos位置的最后一个枚举，下一层会枚举出(....,[n],[0 - (n + 1)],....)的所有模式,例：{0, 1, 0}, {0, 1, 1},{0, 1, 2}，这样可以做到模式的不重复和不遗漏
      a[pos] = num;
      dfs(pos + 1, num + 1);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //                n = 3;
    //                m = 2;
    //                k = 1;
    n = scanner.nextInt();
    m = scanner.nextInt();
    k = scanner.nextInt();
    fac[0] = 1;
    for (int i = 1; i < 12; ++i) {
      fac[i] = fac[i - 1] * (27 - i);
    }
    dfs(0, 0);
    System.out.println(cnt);
  }
}
