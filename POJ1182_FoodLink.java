package practice.algsoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Scruel on 2017/4/2.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * union
 */
public class POJ1182_FoodLink {
        static int[] selfUf;
        static int[] eatUf;
        static int res;
        static int n;
        static int k;

        static int findSelf(int i) {
                int tempI = i;
                while (i != selfUf[i]) {
                        i = selfUf[i];
                }
                while (tempI != selfUf[tempI]) {
                        tempI = i;
                }
                return i;
        }

        //TODO 找不到的情况
        //查找i是否吃j
        static boolean findEat(int i, int j) {
                while (i != eatUf[i]) {
                        i = eatUf[i];
                        if (i == j) return true;
                }
                return false;
        }

        static boolean connectedSelf(int i, int j) {
                return findSelf(i) == findSelf(j);
        }

        static boolean union(int op, int i, int j) {
                if (j >= n || i >= n || i < 0 || j < 0) return false;
                if (op == 1) {
                        //查看是否是eat关系
                        if (findEat(i, j))
                                return false;
                        if (findEat(j, i))
                                return false;
                        int rj = findSelf(j);
                        int ri = findSelf(i);
                        if (rj == ri) return true;
                        selfUf[i] = rj;
                        //连接到root
                } else {
                        if (i == j) return false;
                        //查看是否是self关系
                        if (connectedSelf(i, j))
                                return false;
                        //查看是谁吃谁
//                        if (findEat(i, j))
//                                return true;
//                        if (findEat(j, i))
//                                return false;
                        int ri = findSelf(i);
                        int rj = findSelf(j);
                        eatUf[i] = j;
                }
                return true;
        }


        static void solve() {
                Scanner input = new Scanner(System.in);
                n = input.nextInt();
                eatUf = new int[n];
                selfUf = new int[n];
                for (int i = 0; i < n; i++) {
                        eatUf[i] = i;
                        selfUf[i] = i;
                }
                k = input.nextInt();
                for (int i = 0; i < k; i++) {
                        if (!union(input.nextInt(), input.nextInt() - 1, input.nextInt() - 1))
                                res++;
                }
                System.out.println(res);
        }


        //题解
        static int find(int x) {
                int tempX = x;
                while (x != par[x]) {
                        x = par[x];
                }

                while (tempX != par[tempX]) {
                        int temp = tempX;
                        tempX = par[tempX];
                        par[temp] = x;
                }

                return x;

//                if (par[x] == x)
//                        return x;
//                else
//                        return par[x] = find(par[x]);
        }

        static void unite(int x, int y) {
                x = find(x);
                y = find(y);
                if (x == y) return;
                if (rank[x] < rank[y]) {
                        par[x] = y;
                } else {
                        par[y] = x;
                        if (rank[x] == rank[y])
                                rank[x]++;
                }
        }

        static boolean same(int x, int y) {
                return find(x) == find(y);
        }

        static void init(int n) {
                par = new int[n];
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                        par[i] = i;
                }
        }

        static int[] par;
        static int[] rank;
        static int[] T;
        static int[] X;
        static int[] Y;

        static void solveR() throws IOException {
//                Scanner input = new Scanner(System.in);
                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
                String[] s = bfr.readLine().split(" ");
                n = new Integer(s[0]);
                k = new Integer(s[1]);
//                n = 50000;
//                k = 100000;
                T = new int[k];
                X = new int[k];
                Y = new int[k];
                init(3 * n);
                Random rm = new Random();
                for (int i = 0; i < k; i++) {
                        s = bfr.readLine().split(" ");
                        T[i] = new Integer(s[0]);
                        X[i] = new Integer(s[1]);
                        Y[i] = new Integer(s[2]);
//                        T[i] = rm.nextInt(n);
//                        X[i] = rm.nextInt(n);
//                        Y[i] = rm.nextInt(n);
                }

                int ans = 0;
                for (int i = 0; i < k; i++) {
                        int t = T[i];
                        int x = X[i] , y = Y[i];
                        if (x < 0 || n <= x || y < 0 || y >= n) {
                                ans++;
                                continue;
                        }
                        //不能反着吃，即2吃1的情况下，1吃不了2
                        if (t == 1) {
                                //x和y属于同一类 的信息
                                if (same(x, y + n) || same(x, y + 2 * n)) {
                                        ans++;
                                } else {
                                        unite(x, y);
                                        unite(x + n, y + n);
                                        unite(x + n * 2, y + n * 2);
                                }
                        } else {
                                //x吃y 的信息
                                if (same(x, y) || same(x, y + 2 * n)) {
                                        ans++;
                                } else {
                                        unite(x, y + n);
                                        unite(x + n, y + 2 * n);
                                        unite(x + 2 * n, y);
                                }
                        }
                }

                System.out.println(ans);
        }


        public static void main(String[] args) throws IOException {
//                long time = System.currentTimeMillis();
                solveR();
//                System.out.println(System.currentTimeMillis() - time);
        }
}
