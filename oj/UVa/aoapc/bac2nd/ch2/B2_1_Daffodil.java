package algsPractice.oj.UVa.aoapc.bac2nd.ch2;

/**
 * Created by Scruel on 2017/11/19 019.
 * Github : https://github.com/scruel
 */
public class B2_1_Daffodil {
  public static void main(String[] args) {
    for (int i = 100; i < 1000; i++) {
      int sum = 0;
      int n = i;
      for (int j = 0; j < 3; j++) {
        sum += Math.pow(n % 10, 3);
        n /= 10;
      }
      if (sum == i) {
        System.out.println(i);
      }
    }
  }
}
