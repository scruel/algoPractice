package algsPractice.OJ.UVa;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Scruel on 2017/5/17.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #easy sort
 */
public class Task1587 {
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

    static Box getBox(String str) {
        String[] rts = str.split("\\s+");
        Box box = new Box();
        int x = Integer.parseInt(rts[0]);
        int y = Integer.parseInt(rts[1]);
        if (x < y) {
            box.a = x;
            box.b = y;
        } else {
            box.a = y;
            box.b = x;
        }
        return box;

    }

    public static void main(String[] args) throws IOException {
//                bfr = new BufferedReader(new InputStreamReader(DataReader.getDataReader()));
        String ts;
        while ((ts = bfr.readLine()) != null && !ts.isEmpty()) {
            Box[] boxs = new Box[6];
            int cnt = 0;
            boxs[cnt++] = getBox(ts);
            for (int i = 0; i < 5; i++) {
                boxs[cnt++] = getBox(bfr.readLine());
            }
            boolean ok = true;
            Arrays.sort(boxs);
            //排序后检查规则，是否排成了ab ab ac ac bc bc这样两两相对的情况
            for (int i = 0; i < 6; i += 2) {
                if (boxs[i].a != boxs[i + 1].a || boxs[i].b != boxs[i + 1].b) {
                    ok = false;
                    break;
                }
            }
            //排序后必定按照ab、ac、bc的序列
            if (ok) {
                ok = (boxs[0].a == boxs[2].a && boxs[0].b == boxs[4].a &&
                    boxs[2].b == boxs[4].b);

            }
            bfw.write(ok ? "POSSIBLE\n" : "IMPOSSIBLE\n");
        }

        bfr.close();
        bfw.close();
    }

    static class Box implements Comparable<Box> {
        int a, b;

        @Override
        public boolean equals(Object obj) {
            Box b = (Box) obj;
            return (b.a == this.a && b.b == this.b) || (b.b == this.a && b.a == this.b);
        }

        @Override
        public int hashCode() {
            return a + b;
        }

        @Override
        public int compareTo(Box o) {
            if (this.a > o.a) return 1;
            else if (this.a < o.a) return -1;
            else return this.b - o.b;
        }
    }
}
