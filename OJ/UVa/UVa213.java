package algsPractice.OJ.UVa;

import java.io.*;

/**
 * Created by Scruel on 2017/4/5.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #binary  读取
 */
public class UVa213 {
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    static int[] lenStart = new int[7];
    static char[] chars;

    //花了较多时间在构架这个index查找上
    static void init() {
        int sum = 1;
        int n2 = 1;
        for (int i = 1; i < lenStart.length; i++) {
            n2 *= 2;
            sum += n2;
            lenStart[i] = sum - i - 1;
        }
    }

    //发现程序异常后做的read处理，只读0和1
    static void read(char[] chs) throws IOException {
        int sum = 0;
        while (sum != chs.length) {
            int ch = bfr.read();
            if (ch == -1) return;
            if (ch == 48 || ch == 49)
                chs[sum++] = (char) ch;
        }
    }


    public static void main(String[] args) throws IOException {
        init();
        String s;
        while (null != (s = bfr.readLine()) && s.length() != 0) {
            chars = s.toCharArray();
            //decode
            //重置
            char[] lenChar = new char[3];
            String res = "";
            while (true) {
                read(lenChar);
                int n = Integer.valueOf(String.valueOf(lenChar), 2);
                if (n == 0) break;
                char[] code = new char[n];
                while (true) {
                    read(code);
                    int codeN = Integer.valueOf(String.valueOf(code), 2);
                    //计算2^n-1即i为退出，当然也可以用注释的代码，但繁琐，这里要注意符号优先级。
                    if (codeN == (1 << n) - 1) break;
//                                        if (codeN == lenStart[n - 1] + n) break;
                    res += chars[codeN + lenStart[n - 1]];
                }
            }
            bfr.readLine();
            bfw.write(res + "\n");
        }
        bfr.close();
        bfw.close();
    }
}
