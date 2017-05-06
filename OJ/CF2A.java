package algsPractice.OJ;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Scruel on 2016/3/29.
 * http://codeforces.com/problemset/problem/2/A
 */
public class CF2A {
        public static void main(String[] args) {

                Scanner input = new Scanner(System.in);
                HashMap<String, Integer> map = new HashMap<String, Integer>();


                int n = input.nextInt();
//                System.out.println("test");
                String[] winnerList = new String[n];
                int[] scoreList = new int[n];
                int count = 0;
                int max = 0, realMax = 0;//0为初始值，则不会出现负数胜利的情况

                for (int i = 0; i < n; i++) {
                        String name = input.next();
                        int score = input.nextInt();
                        if (map.get(name) == null)
                                map.put(name, score);
                        else
                                map.put(name, score + map.get(name));
                        if (realMax < map.get(name))//得到第一个最大值的人
                        {
                                scoreList[count] = map.get(name);
                                winnerList[count++] = name;
                        }

                }

                Set<String> set = map.keySet();
                for (Iterator<String> iter = set.iterator(); iter.hasNext(); ) {
                        String key = iter.next();
                        if (map.get(key) > max)
                                max = map.get(key);
                }


                for (int i = 0; i < n; i++) {
                        if (scoreList[i] >= max && map.get(winnerList[i]) == max) {
                                System.out.println(winnerList[i]);
                                return;
                        }
                }

        }
}