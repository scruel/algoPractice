package algsPractice.OJ.POJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/28.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #greedy  P47
 */
public class Task3069_SarumanArmy {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            int R = input.nextInt();
            int n = input.nextInt();
            if (R == -1 && n == -1) return;

            int[] pos = new int[n];
            for (int i = 0; i < n; i++) {
                pos[i] = input.nextInt();
            }
            Arrays.sort(pos);
            int i = 0;
            int cnt = 0;
            while (i < n) {
                //找标记点
                int start = pos[i];
                while (i < n - 1 && pos[i + 1] <= start + R) {
                    i++;
                }
                //找下一个点
                start = pos[i];
                while (i < n - 1 && pos[i + 1] <= start + R) {
                    i++;
                }
                i++;
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
