package algsPractice.dpExercise;

import java.util.Arrays;

/**
 * Created by Scruel on 2017/3/19.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * https://www.nowcoder.com/courses/1/3/12
 * **DP**
 * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
 * 测试样例：
 * "aabcb",5
 * 返回：3
 */

public class DistinctSubstring {
        public static int longestSubstring(String A, int n) {
                // write code here
                int[] R = new int[256];
                int[] lens = new int[n];
                Arrays.fill(R, -1);
                int max = 0;
                char[] chars = A.toCharArray();
                //初始化0位置需要考虑全面
                lens[0] = 1;
                R[chars[0]] = 0;
                for (int i = 1; i < n; i++) {
                        if (R[chars[i]] == -1)
                                lens[i] = lens[i - 1] + 1;
                        else
                                lens[i] = Math.min(i - R[chars[i]], lens[i - 1] + 1);
                        R[chars[i]] = i;
                        if (lens[i] > max) max = lens[i];
                }

                return max;
        }

        public static void main(String[] args) {
                System.out.println(longestSubstring("aabcb", 5));
        }
}