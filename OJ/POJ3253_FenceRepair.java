package algsPractice.OJ;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/28.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #greedy 取木板
 */
public class POJ3253_FenceRepair {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int n = input.nextInt();
//                int L = 0;
//                int[] ls = new int[n];
        for (int i = 0; i < n; i++) {
//                        ls[i] = input.nextInt();
            queue.add(input.nextInt());
//                        L += ls[i];
        }
//                Arrays.sort(9ls);
//                BigInteger sum = BigInteger.ZERO;
        long sum = 0;
        while (queue.size() > 1) {
            int p = queue.poll();
            int q = queue.poll();
            int temp = p + q;
            sum += temp;
            queue.add(temp);
        }
//                for (int i = 1; i < n; i++) {
//                        int len = ls[i - 1] + ls[i];
//                        ls[i] = len;
//                        //改为插入排序
//                        for (int j = i + 1; j < n; j++) {
//                                while (j < n && ls[j - 1] > ls[j]) {
//                                        int temp = ls[j - 1];
//                                        ls[j - 1] = ls[j];
//                                        ls[j] = temp;
//                                }
//                        }
//                        sum += len;
//                }
        System.out.println(sum);
    }
}
