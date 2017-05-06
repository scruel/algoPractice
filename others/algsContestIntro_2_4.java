package algsPractice.others;

/**
 * Created by Scruel on 2017/4/13.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class algsContestIntro_2_4 {
        public static void main(String[] args) {
//                int n = 2;
//                int m = 4;
                //这里需要注意到n和m的范围，在对i初始化的时候需要设置为long（也可以设置为int，但需强转），否则i * i时会有溢出风险，导致结果计算不正确。
                int n = 65536;
                int m = 655360;
                double res = 0.0;
                for (long i = n; i <= m; i++) {
                        res += 1.0 / (i * i);
                }
                System.out.printf("%.5f", res);
        }
}
