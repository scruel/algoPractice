package algsPractice.newcoder;

/**
 * Created by Scruel on 2017/3/23.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 有2k只球队，有k-1个强队，其余都是弱队，随机把它们分成k组比赛，每组两个队，问两强相遇的概率是多大？
 * <p>
 * 给定一个数k，请返回一个数组，其中有两个元素，分别为最终结果的分子和分母，请化成最简分数
 * <p>
 * <p>
 * 测试样例：
 * 4
 * 返回：[3,7]
 * <p>
 * 把8支队伍分成强队（A、B、C、D）和弱队（A‘、B’、C‘、D’），首先考虑全组合：A可以选择剩下的7支队伍，剩下6支队伍假设为（B、C、D）和弱队（B’、C‘、D’），B选择可以选5支队伍，然后剩下的可以选3支，剩下两队就不用选了，总共为7*5*3。
 * 要构成强弱，则需要从弱队中选出k-1个队伍和k+1个强队匹配。
 * <p>
 * **排列组合**
 */
public class Championship {
    public static void main(String[] args) {
//                System.out.println(new Championship().calc(2));
        System.out.println(new Championship().calc(3)[0]);
        System.out.println(new Championship().calc(3)[1]);
    }

    public int[] calc(int k) {
        // write code here
        int fz = calcC(k + 1, k - 1) * factorial(k - 1);
        System.out.println(calcC(k + 1, k - 1));
        int fm = 1;
        for (int i = 1; i < 2 * k; i += 2)
            fm *= i;
        int part = gcd(fz, fm);
        return new int[]{fm / part - fz / part, fm / part};
    }

    public int gcd(int m, int n) {
        if (m % n == 0) return n;
        m %= n;
        return gcd(n, m);
    }

    public int factorial(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

    public int calcC(int m, int n) {
        int fz = 1;
        int fm = 1;
        for (int i = 1; i <= n; i++) {
            fz *= (m - i + 1);
            fm *= i;
        }
        return fz / fm;
    }
}
