package algsPractice.OJ;

import java.util.HashMap;

/**
 * Created by Scruel on 2017/4/8.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 进制转换(从1开始的)
 */
public class LQSS2017_CQ5 {

        //static int n = 2054;
        //static int n = 26 * 26 + 26 * 2+2;
        static int n = 1 << 30;
        static char[] chars = " ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        static HashMap<Pair, Boolean> map = new HashMap<Pair, Boolean>();
        static int[] resIndex = new int[10000];

        //进制转换
        public static void main(String[] args) {
                solve1();
                int num = n;
                num--;
                dfs(0, 1, 0);
                int i = 0;
                String res = "";
                while (true) {
                        if (resIndex[i] == 0)
                                break;
                        res += chars[resIndex[i++]];
                }
                System.out.println(res);
        }

        static boolean dfs(int index, long n26, long sum) {
                //这样做是不划算的。
//                if (map.containsKey(new Pair(n26, sum)))
//                        return false;
                for (int i = 1; i <= 26; i++) {
                        resIndex[index] = i;
                        if (sum + i * n26 == n) {
                                return true;
                        } else if (sum + i * n26 > n) {
                                resIndex[index] = 0;
//                                map.put(new Pair(n26, sum), false);
                                return false;
                        }
                        if (dfs(index + 1, n26 * 26, sum + i * n26))
                                return true;
                }
                return false;
        }

        static void solve1() {
                int num = n;
                StringBuilder res = new StringBuilder("");
                //在循环中的String连接用StringBuilder比较好
                while (num > 0) {
                        int mod = num % 26;
                        if (mod == 0) mod = 26;
                        res.insert(res.length(), chars[mod]);
                        num = (num - mod) / 26;
                }
                System.out.println(res);
        }

        static class Pair {
                long n26;
                long sum;

                public Pair(long n26, long sum) {
                        this.n26 = n26;
                        this.sum = sum;
                }


                @Override
                public boolean equals(Object obj) {
                        Pair p = (Pair) obj;
                        return this.n26 == p.n26 && this.sum == p.sum;
                }

                @Override
                public int hashCode() {
                        int prime = 31;
                        int res = 1;
                        res = prime * res + (int) n26;
                        res = prime * res + (int) sum;
                        return res;
                }
        }
}
