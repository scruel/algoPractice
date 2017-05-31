package algsPractice.OJ.UVa;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Scruel on 2017/4/15.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #enum #string-preprocessing
 */
public class Task1592 {
    static HashMap<String, Integer> map;
    static HashSet<Pair> pairSet;

    public static void main(String[] args) throws IOException {
//                BufferedReader bfr = new BufferedReader(new InputStreamReader(DataReader.getDataReader()));
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String rT;

        while ((rT = bfr.readLine()) != null && rT.length() != 0) {
            map = new HashMap<String, Integer>();
            pairSet = new HashSet<Pair>();
            String[] rTs = rT.split("\\s+");
            int n = Integer.parseInt(rTs[0]);
            int m = Integer.parseInt(rTs[1]);
            boolean flag = true;
            //rows
            for (int i = 0; i < n; i++) {
                rTs = bfr.readLine().split(",");
                if (flag) {
                    for (int j = 0; j < m; j++) {
                        if (!map.containsKey(rTs[j]))
                            map.put(rTs[j], map.size());
                    }

                    for (int j = 0; j < m; j++) {
                        if (!flag) break;
                        for (int k = j + 1; k < m; k++) {
                            int pairC1 = map.get(rTs[j]);
                            int pairC2 = map.get(rTs[k]);
                            Pair tmp = new Pair(pairC1, pairC2, i, j, k);
                            if (pairSet.contains(tmp)) {
                                bfw.write("NO\n");

                                Pair res = null;
                                for (Pair p : pairSet) {
                                    if (p.equals(tmp)) {
                                        res = p;
                                        break;
                                    }
                                }

                                bfw.write((res.p_r + 1) + " " + (i + 1) + "\n");
                                bfw.write((res.p1_c + 1) + " " + (res.p2_c + 1) + "\n");
                                flag = false;
                                break;
                            } else {
                                pairSet.add(tmp);
                            }
                        }
                    }
                }
            }
            if (flag)
                bfw.write("YES\n");
        }
        bfr.close();
        bfw.close();

    }

    static class Pair {
        int p1;
        int p_r;
        int p1_c;
        int p2;
        int p2_c;

        public Pair(int p1, int p2, int p_r, int p1_c, int p2_c) {
            this.p1 = p1;
            this.p2 = p2;
            this.p_r = p_r;
            this.p1_c = p1_c;
            this.p2_c = p2_c;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) return false;
            Pair tmp = (Pair) obj;
            return this.p1 == tmp.p1 && this.p2 == tmp.p2 &&
                this.p1_c == tmp.p1_c && this.p2_c == tmp.p2_c;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + p1;
            result = prime * result + p2;
            result = prime * result + p1_c;
            result = prime * result + p2_c;
//                        result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }
    }


}
