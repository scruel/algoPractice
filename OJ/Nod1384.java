package algsPractice.OJ;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Scruel on 2017/4/7.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Nod1384 {
        static char[] array;
        static char[] res;
        static boolean[] book = new boolean[256];
        static boolean[] marked;
        static HashSet<String> set = new HashSet<String>();

        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                array = input.nextLine().toCharArray();
                marked = new boolean[array.length];
                res = new char[array.length];
                Arrays.sort(array);
//                dfs(0);
                _partiton(array.length);
                String[] s = new String[set.size()];
                int i = 0;
                for (String temp : set) {
                        s[i++] = temp;
                }
                Arrays.sort(s);
                for (String temp : s)
                        System.out.println(temp);
        }

        static void _partiton(int newSize) {
                if (newSize == 1) return;
                for (int i = 0; i < newSize; i++) {
                        _partiton(newSize - 1);
                        if (newSize == 2)
                                set.add(new String(array, 0, array.length));
                        int index = array.length - newSize;
                        char ch = array[index];
                        for (int j = index; j < array.length - 1; j++) {
                                array[j] = array[j + 1];
                        }
                        array[array.length - 1] = ch;
                }
        }

        static void dfs(int step) {
                if (step == array.length) {
                        set.add(new String(res, 0, array.length));
                        return;
                }

                for (int i = 0; i < array.length; i++) {
//                        if (!book[array[i]]) {
//                                book[array[i]] = true;
//                                resIndex[step] = array[i];
//                                step++;
//                                continue;
//                        }
                        if (!marked[i]) {
                                marked[i] = true;
                                res[step] = array[i];
                                dfs(step + 1);
                                //回溯
//                                book[array[i]] = false;
                                marked[i] = false;
                        }
                }
                return;
        }
}
