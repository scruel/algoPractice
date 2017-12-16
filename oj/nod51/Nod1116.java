package algsPractice.oj.nod51;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Scruel Tao
 *
 * 一个数 A 在 K 进制下，是 K - 1 的倍数。
 *
 * #math
 * 进制位拆分
 *
 * 因为 K % （K-1）= 1
 * 假设 A 的所有位 A[0]A[1]...A[n], 则 A = A[0] + A[1] * K + A[2] * K^2 + ... + A[n] * K^n
 * A % (K - 1) = (A[0] + A[1] * K + A[2] * K^2 + ... + A[n] * K^n) % (K - 1) = 0
 * 则统计所有位的和 Sn，当 Sn % (k - 1) = 0 时， 即为所求。
 */
public class Nod1116 {

  public static void main(String[] args) throws IOException {
    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
    //                Scanner input = new Scanner(System.in);
    //                String str = input.nextLine();
    char[] chars = bfr.readLine().toCharArray();
    long sum = 0;
    int max = 2;
    for (char aChar : chars) {
      if (aChar <= '9') {
        sum += aChar - '0';
        max = Math.max(max, aChar - '0');
      }
      else {
        sum += aChar - 'A' + 10;
        max = Math.max(max, aChar - 'A' + 10);
      }
    }
    //                max++;
    //                for (int i = max - 1; i <= 35; i++) {
    int res = 0;
    for (int i = max; i < 36; i++) {
      if (sum % i == 0) {
        res = i + 1;
        break;
      }
    }
    bfw.write(res == 0 ? "No Solution" : String.valueOf(res));
    bfw.close();
    bfr.close();
  }

}
