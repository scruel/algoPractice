package algsPractice.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/24.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 组装三角形
 * 牛牛手里有N根木棒,分别编号为1~N,现在他从N根里想取出三根木棒，使得三根木棒构成一个三角形,你能计算出牛牛有多少种取法吗?(考虑两种取法中使用的木棒编号有一个不一样就认为是不同的取法)。
 * 输入描述:
 * 首先输入一个正整数N，接下来的一行共有N个正整数表示每个木棒的长度。
 * <p>
 * N ≤ 50, 木棒的长度 ≤ 10000.
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数表示方法数。
 * <p>
 * 输入例子:
 * 5
 * 1 2 3 4 5
 * <p>
 * 输出例子:
 * 3
 */
public class CombineTriangles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        System.out.println(solve(arr));
        System.out.println(solve2(arr));
    }

    private static int solve(int[] arr) {
        int cnt = 0;
        Arrays.sort(arr);
        //二分查找降低复杂度到O(n^2logn)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int num = Arrays.binarySearch(arr, arr[i] + arr[j]);
                if (num < 0) num = -(num + 2);
                if (arr[num] == arr[i] + arr[j]) {
                    cnt += num - j - 1;
                    //去除binarySearch返回的index值不是相等情况中第一个出现的位置的错误统计
                    for (int k = num - 1; k >= j; k--) {
                        if (arr[num] == arr[k]) cnt--;
                        else break;
                    }
                } else if (arr[num] < arr[i] + arr[j]) cnt += num - j;
            }
        }
        return cnt;
    }

    private static int solve2(int[] arr) {
        int cnt = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] > arr[k]) {
//                                                System.out.println(arr[i] + " "+ arr[j]+ " "+arr[k]);
                        cnt++;
                    } else {
                        break;
                    }
                }
            }
        }
        return cnt;
    }
}
