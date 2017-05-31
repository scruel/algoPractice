package algsPractice.competition.JSK2017.Round1;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Scruel on 2017/5/20.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Main1 {

    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
    static boolean[][] p = new boolean[7][7];

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextInt();
        for (int i = 0; i < n; i++) {
            int x = input.nextInt() + 3;
            int y = input.nextInt() + 3;
            p[x][y] = true;
        }
        int res = 0;
        for (int i = 0; i <= 6; i++) {
            int cnt = 0;
            for (int j = 0; j <= 6; j++) {
                if (i == 3) break;
                if (p[i][j]) cnt++;
            }
            if (cnt == 3) res++;
            cnt = 0;
            for (int j = 0; j <= 6; j++) {
                if (i == 3) break;
                if (p[j][i]) cnt++;
            }
            if (cnt == 3) res++;
        }

        if (p[0][3] && p[1][3] && p[2][3]) res++;
        if (p[4][3] && p[5][3] && p[6][3]) res++;
        if (p[3][6] && p[3][5] && p[3][4]) res++;
        if (p[3][0] && p[3][1] && p[3][2]) res++;


        System.out.println(res);
        bfr.close();
        bfw.close();
    }
}
