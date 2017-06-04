package algsPractice.competition.JSK2017.round2;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Scruel on 2017/5/21.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Main1 {
    static int[] nums = new int[4];

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
//                int p1 = input.nextInt();
//                int p2 = input.nextInt();
//                int p3 = input.nextInt();
//                int p4 = input.nextInt();

        for (int i = 0; i < 4; i++) {
            nums[i] = input.nextInt();
        }
        int fP = (input.nextInt() + 3) % 4;
        int fD = input.nextInt();

        int res = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                int nP = (i + j - 1) % 4;
                int nStart = Math.min(i, j);
                for (int k = 0; k < 3; k++) {
                    //take1
                    nStart++;
                    while (nStart > nums[nP]) {
                        nStart = nStart - nums[nP];
                        nP = (nP + 3) % 4;
                    }
                    //check1
                    if (nP == fP && nStart == fD) {
//                                                System.out.println(i + " " + j);
                        res++;
                    }
                    //take2
                    nStart += 7;
                    while (nStart > nums[nP]) {
                        nStart = nStart - nums[nP];
                        nP = (nP + 3) % 4;
                    }

                }

            }
        }
        System.out.println(res);
    }
}
