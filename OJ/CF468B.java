package algsPractice.OJ;


import algs4_new.MyTools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Scruel on 2017/4/20.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * http://codeforces.com/contest/468/problem/B
 */
public class CF468B {
        //        static int[] szA;
        static int[] id = new int[8];
        static int[] array = new int[8];
        static int n, a, b;
        //双向查询
        static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        //路径优化-AC
//        static int find(int p) {
//                return id[p] == p ? p : (id[p] = find(id[p]));
//        }
        //路径优化-AC
        static int find(int p) {
                int tmpP = p;
                while (p != id[p]) {
                        p = id[p];
                }
                while (tmpP != id[tmpP]) {
                        int t = tmpP;
                        tmpP = id[tmpP];
                        id[t] = p;
                }
                return p;
        }

        public static void main(String[] args) throws IOException {
                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
                String[] rts = bfr.readLine().split("\\s+");
                n = new Integer(rts[0]);
                a = new Integer(rts[1]);
                b = new Integer(rts[2]);
                rts = bfr.readLine().split("\\s+");
                for (int i = 1; i <= n; i++) {
                        array[i] = new Integer(rts[i - 1]);
                        map.put(array[i], i);
                }
                //多两个作为并查集A\B标识
                for (int i = 1; i <= n + 2; i++) {
                        id[i] = i;
                }
                int x;
                for (int i = 1; i <= n; i++) {
                        x = find(i);
                        //如果a-array[i]存在，则把array[i]和a-array[i]并入一个集合
                        if (map.containsKey(a - array[i]))
                                id[x] = find(map.get(a - array[i]));
                        else id[x] = find(n + 1);//否则将当前元素放入在B集合
                        x = find(i);
                        //如果b-array[i]存在，则把array[i]和b-array[i]并入一个集合
                        if (map.containsKey(b - array[i]))
                                id[x] = find(map.get(b - array[i]));
                        else id[x] = find(n + 2);//否则放在A集合
                }
                //两个集合有重复则不成立
                if (find(n + 1) == find(n + 2)) {
                        System.out.println("NO");
                } else {
                        System.out.println("YES");
                        System.out.print(find(1) == find(n + 1) ? 1 : 0);
                        for (int i = 2; i <= n; i++)
                                System.out.print(" " + (find(i) == find(n + 1) ? 1 : 0));
                }
                MyTools.print_r(id);
        }
}
