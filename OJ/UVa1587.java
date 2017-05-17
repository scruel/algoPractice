package algsPractice.OJ;

import java.io.*;
import java.util.*;

/**
 * Created by Scruel on 2017/5/17.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class UVa1587 {
        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        static Map<Box, Integer> map;

        public static void main(String[] args) throws IOException {
//                bfr = new BufferedReader(new InputStreamReader(DataReader.getDataReader()));
                String ts;
                while ((ts = bfr.readLine()) != null && !ts.isEmpty()) {
                        map = new HashMap<Box, Integer>();
                        String[] rts = ts.split("\\s+");
                        Box box = new Box();
                        box.a = Integer.parseInt(rts[0]);
                        box.b = Integer.parseInt(rts[1]);
                        map.put(box, 1);
                        for (int i = 0; i < 5; i++) {
                                rts = bfr.readLine().split("\\s+");
                                box = new Box();
                                box.a = Integer.parseInt(rts[0]);
                                box.b = Integer.parseInt(rts[1]);
                                if (map.containsKey(box))
                                        map.put(box, map.get(box) + 1);
                                else
                                        map.put(box, 1);
                        }
                        boolean ok;
                        if (map.size() > 3) {
                                ok = false;
                        } else {
                                boolean flag = true;
                                Set<Map.Entry<Box, Integer>> ey = map.entrySet();
                                LinkedList<Box> list = new LinkedList<Box>();
                                for (Map.Entry<Box, Integer> entry : ey) {
                                        list.add(entry.getKey());
                                        if ((entry.getValue() & 1) == 1) {
                                                flag = false;
                                                break;
                                        }
                                }
                                if (map.size() == 3 && flag) {
                                        Box b1 = list.get(0);
                                        Box b2 = list.get(1);
                                        Box b3 = list.get(2);
                                        int x = 0, y = 0;
                                        if (b1.a == b2.a) {
                                                x = b1.b;
                                                y = b2.b;
                                        } else if (b1.a == b2.b) {
                                                x = b1.b;
                                                y = b2.a;
                                        } else if (b1.b == b2.a) {
                                                x = b1.a;
                                                y = b2.b;
                                        } else if (b1.b == b2.b) {
                                                x = b1.a;
                                                y = b2.a;
                                        }
                                        ok = (b3.a == x && b3.b == y) || (b3.b == x && b3.a == y);


                                } else {
                                        ok = flag;
                                }

                                bfw.write(ok ? "POSSIBLE\n" : "IMPOSSIBLE\n");
                        }


                }

                bfr.close();
                bfw.close();
        }

        static class Box {
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
        }
}
