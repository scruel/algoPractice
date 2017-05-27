package algsPractice.OJ;


import java.io.*;
import java.util.*;

/**
 * Created by Scruel on 2017/4/25.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #离散化  中点
 */
public class UVa221 {
    static int maxn = 100 + 5;
    static Builder[] b = new Builder[maxn];
    static int n;
    static Double[] x = new Double[maxn * 2];

    static boolean cover(int i, double mx) {
        return b[i].x <= mx && b[i].x + b[i].w >= mx;
    }

    //判断建筑物i在x=mx处是否可见
    static boolean visible(int i, double mx) {
        if (!cover(i, mx)) return false;
        for (int k = 0; k < n; k++)
            //查看所有建筑
            //b[k].y < b[i].y 代表当前的建筑i是否在建筑k的后面
            //b[k].h >= b[i].h 代表的是当前的建筑i是否比建筑k矮
            //cover 代表的是当前的建筑i是否和建筑k重叠，也就是建筑i和建筑k都会会覆盖mx这个点的时候。
            if (b[k].y < b[i].y && b[k].h >= b[i].h && cover(k, mx)) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Double> set = new HashSet<Double>();
        int kase = 0;
        while ((n = Integer.parseInt(bfr.readLine())) != 0) {
            for (int i = 0; i < n; i++) {
                b[i] = new Builder();
                String[] rts = bfr.readLine().split("\\s+");
                b[i].id = i + 1;
                b[i].x = new Double(rts[0]);
                b[i].y = new Double(rts[1]);
                b[i].w = new Double(rts[2]);
                b[i].h = new Double(rts[4]);
                set.add(b[i].x);
                set.add(b[i].x + b[i].w);
//                                x[i * 2] = b[i].x;
//                                x[i * 2 + 1] = b[i].x + b[i].w;
            }
            Arrays.sort(b, 0, n);
            List<Double> list = new LinkedList<Double>(set);
            Collections.sort(list);
            list.toArray(x);
            System.out.println(x.length);
//                        int m = unique(x, x + n * 2) - x; //x坐标排序后去重，得到m个坐标
//                        (in java, m = pq.size())
            if (kase++ > 0)
                bfw.write("\n");
            bfw.write(String.format("For map #%d, the visible buildings are numbered as follows:\n%d", kase, b[0].id));
            for (int i = 1; i < n; i++) {
                boolean vis = false;
                for (int j = 0; j < set.size() - 1; j++)
                    if (visible(i, (x[j] + x[j + 1]) / 2)) {
                        //只要有任意一段满足可以显示即可。
                        vis = true;
                        break;
                    }
                if (vis) bfw.write(String.format(" %d", b[i].id));
            }
            bfw.write("\n");
        }
        bfw.close();
        bfr.close();
    }

    static class Builder implements Comparable<Builder> {
        double x, y, w, h;
        int id;

        //忽略深度，因为只需要考虑x，y坐标以及w宽度及高度
//                public Builder(int id, int x, int y, int w, int h) {
//                        this.id = id;
//                        this.w = w;
//                        this.x = x;
//                        this.y = y;
//                        this.h = h;
//                }

        @Override
        public int compareTo(Builder o) {
            if (o == null)
                return 0;
            Builder b = o;
            if (x == o.x) {
                if (y == o.y) {
                    return 0;
                } else {
                    return y < o.y ? -1 : 1;
                }
            } else {
                return x < o.x ? -1 : 1;
            }
        }
    }
}
