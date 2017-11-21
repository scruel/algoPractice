package algsPractice.oj_t.UVa.aoapc.bac2nd.ch3;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Scruel on 2017/4/4.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #string
 */
public class Task232 {
  static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
  static char[][] puzzle = new char[10][10];
  static int[][] nums = new int[10][10];
  static int r;
  static int c;

  static boolean ok(int i, int j) {
    if (puzzle[i][j] == '*') {
      return false;
    }
    if (i == 0 || j == 0) {
      return true;
    }
    return puzzle[i - 1][j] == '*' || puzzle[i][j - 1] == '*';
  }

  static void initNums() {
    //设置为0，并且在后面++sum，这样最后的结果会是与最后一个需要的值相同的，且也不会导致多运算，防止出错。
    int sum = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        //判断是否是起始点
        if (ok(i, j)) {
          nums[i][j] = ++sum;
        }
      }
    }
  }

  static void findAcross() throws IOException {
    bfw.write("Across\n");
    int num;
    for (int i = 0; i < r; i++) {
      int j = 0;
      while (j < c) {
        String result = "";
        //判断是否是起始点
        if (nums[i][j] != 0) {
          num = nums[i][j];
          while (j < c && puzzle[i][j] != '*') {
            result += puzzle[i][j++];
          }
          bfw.write(String.format("%3d", num) + "." + result + "\n");
        }
        else {
          j++;
        }
      }
    }
  }

  static void findDown() throws IOException {
    bfw.write("Down\n");
    int num;
    for (int i = 0; i < r; i++) {
      for (int k = 0; k < c; k++) {
        if (nums[i][k] != 0) {
          //往下打印
          String result = "";
          num = nums[i][k];
          int j = i;
          while (j < r && puzzle[j][k] != '*') {
            nums[j][k] = 0;
            result += puzzle[j++][k];
          }
          bfw.write(String.format("%3d", num) + "." + result + "\n");
        }
      }
    }
  }

  static void solve() throws IOException {
    int sum = 0;
    while (true) {
      String[] rTs = bfr.readLine().split(" ");
      String rT;
      r = Integer.parseInt(rTs[0]);
      if (r == 0) {
        break;
      }
      c = Integer.parseInt(rTs[1]);

      for (int i = 0; i < r; i++) {
        rT = bfr.readLine();
        for (int j = 0; j < c; j++) {
          puzzle[i][j] = rT.charAt(j);
        }
      }
      initNums();
      if (sum > 0) {
        bfw.write("\n");
      }
      bfw.write("puzzle #" + ++sum + ":\n");
      findAcross();
      findDown();
      //                        MyTools.print_r(arr);
    }
    bfr.close();
    bfw.close();
  }

  public static void main(String[] args) throws IOException {
    solve();
  }
}
