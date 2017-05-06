package algsPractice.newcoder;

import java.util.ArrayList;

/**
 * Created by Scruel on 2017/3/19.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 双栈排序
 */
public class TwoStacksSort {
        public static ArrayList<Integer> twoStacksSort(int[] numbers) {
                // write code here
                int[] help = new int[numbers.length];
                int n = numbers.length;
                int i = 0, j = n;//栈的当前指针
                int cur;
                while (i < n) {
                        //++为出栈，--为进栈
                        //弹出栈中的第一个元素，下移index
                        cur = numbers[i++];

                        if (j == n) {
                                // 将弹出元素压入help栈顶
                                help[--j] = cur;
                        } else if (cur <= help[j]) {
                                // 将弹出元素压入help栈顶
                                help[--j] = cur;
                        } else if (cur > help[j]) {
                                // 弹出help栈中的元素，并将其压入到主栈栈顶，直到cur小于等于help栈顶元素
                                while (j < n && cur > help[j]) {
                                        numbers[--i] = help[j++];
                                }
                                // 将弹出元素压入help栈顶
                                help[--j] = cur;
                        }
                        //主栈全部倒入了help栈，排序完毕，这里为了避免重复遍历，在下方进行倒入操作。
//                        if (i >= n) {
//
//                        }

                }
                //结束后help结果为倒序，然后全部倒入主栈中即可

                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int m = 0; m < n; m++) {
                        list.add(help[n - m - 1]);
                }

                return list;
        }

        public static void main(String[] args) {
//                System.out.println(twoStacksSort(new int[]{1, 2, 3, 4, 5}));
//                System.out.println(twoStacksSort(new int[]{3, 2, 1, 4, 5}));
                System.out.println(twoStacksSort(new int[]{3, 2, 5, 4, 1}));
//                System.out.println(twoStacksSort(new int[]{54695, 46580, 6418, 52304, 5595, 5149, 51943, 11454, 23596, 6444, 61037, 94146, 50220, 98642, 97292, 57898, 11745, 7286, 31224, 5160, 41550, 25277, 59350, 53353, 68663, 9642, 30406, 5396, 3222, 67194, 7124, 54247, 15077, 97688, 36939, 62888, 80307, 65467, 6882, 97071, 39652, 38268, 88226, 89088, 92198, 39003, 9858, 73803, 83078, 24648, 49891, 34551, 57649, 24443, 30685, 68740, 55407, 53155, 87465, 89282, 41856, 96218, 37292, 24551, 67663, 31715, 46363, 25573, 61921, 56333, 69576, 55919, 19818, 26409, 21590, 70392, 67648, 36909, 89175, 74443, 41856, 11755, 24788, 25975, 25116, 57360, 80998, 62093, 40691, 91189, 29337, 68914, 57653, 64272, 53653, 5975, 27967, 59600, 25803, 13937, 93725, 26457, 16603, 18360, 79926, 63243, 94958, 45131}));
        }
}
