package algsPractice.newcoder;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Scruel on 2017/3/18.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 以非字典序方式对字符排序（不考虑长度）
 * **字符串**
 */
public class PriorString {
        public String findSmallest(String[] strs, int n) {
                // write code here
                Arrays.sort(strs, new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                                String s1 = o1 + o2;
                                String s2 = o2 + o1;
                                return s1.compareTo(s2);
                        }
                });

                String res = "";
                for (int i = 0; i < n; i++) {
                        res += strs[i];
                }
                return res;
        }
}
