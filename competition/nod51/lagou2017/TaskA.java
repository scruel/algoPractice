package algsPractice.competition.nod51.lagou2017;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * http://www.infocool.net/kb/OtherLanguage/201701/281274.html
 * #rule #math
 */
public class TaskA {

    long sum(int n) {
        int i = 1, l, cur, r, ans = 0;
        while (n / i != 0) {
            cur = (n / i) % 10;
            l = n / (i * 10);
            r = n - (n / i) * i;
            if (cur == 0) ans += l * i;
            else if (cur == 1) ans += l * i + r + 1;
            else ans += (l + 1) * i;
            i *= 10;
        }
        return ans;
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        out.write(sum(n));
    }
}
