package algsPractice.OJ;

import java.io.*;

/**
 * Created by Scruel on 2017/4/3.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 生成元（Digit Generator, ACM/ICPC Seoul 2005, UVa1583）
 * <p>
 * 如果x加上x的各个数字之和得到y，就说x是y的生成元。给出n（1≤n≤100000），求最小
 * 生成元。无解输出0。例如，n=216，121，2005时的解分别为198，0，1979。
 * <p>
 * 本题看起来是个数学题，实则不然。假设所求生成元为m。不难发现m<n。换句话说，
 * 只需枚举所有的m<n，看看有没有哪个数是n的生成元。
 * 可惜这样做的效率并不高，因为每次计算一个n的生成元都需要枚举n-1个数。有没有更
 * 快的方法？聪明的读者也许已经想到了：只需一次性枚举100000内的所有正整数m，标
 * 记“m加上m的各个数字之和得到的数有一个生成元是m”，最后查表即可。
 * <p>
 * 多组问题可以考虑 查表 的方法！
 */
public class UVa1583 {
        public static void main(String[] args) throws Exception {
                int MAX_N = 100005;
                int[] res = new int[MAX_N];
                for (int i = 1; i < MAX_N; i++) {
                        int x = i;
                        //累加当前位
                        int y = i;
                        while (x > 0) {
                                //累加每一位
                                y += x % 10;
                                x /= 10;
                        }
                        if (y < MAX_N && (res[y] == 0 || res[y] > i))
                                res[y] = i;
                }

                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
                String s = bfr.readLine();
                int n = new Integer(s);
                for (int i = 0; i < n; i++) {
                        bfw.write(res[new Integer(bfr.readLine())] + "\n");
                }
//                while ((s = bfr.readLine()) != null && s.length() != 0)
                bfr.close();
                bfw.close();
        }
}
