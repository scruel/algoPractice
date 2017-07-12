package algsPractice.OJ.UVa.ch5;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Scruel on 2017/4/26.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #easy #math
 */
public class Task1595 {
    static HashMap<Integer, LinkedList<Integer>> map;


    static void solve() throws IOException {

        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine());
        while (t-- > 0) {
            map = new HashMap<Integer, LinkedList<Integer>>();
            int n = Integer.parseInt(bfr.readLine());
            for (int i = 0; i < n; i++) {
                String[] rts = bfr.readLine().split("\\s+");
                int x = Integer.parseInt(rts[0]) * 2;
                int y = Integer.parseInt(rts[1]);
                if (map.containsKey(y)) {
                    map.get(y).add(x);
                } else {
                    //保存x坐标
                    LinkedList<Integer> tmp = new LinkedList<Integer>();
                    tmp.add(x);
                    map.put(y, tmp);
                }
            }
            int mid = 1000000;
            boolean flag = true;
            for (Integer i : map.keySet()) {
                LinkedList<Integer> tmp = map.get(i);
//                                if (tmp.size() != 1 && tmp.size() % 2 != 0) {
//                                        flag = false;
//                                        break;
//                                }
                Collections.sort(tmp);
                //比两边对称点
                for (int j = 0; j <= tmp.size() / 2; j++) {
                    int tmpMid = (tmp.get(j) + tmp.get(tmp.size() - j - 1)) / 2;
                    if (mid == 1000000)
                        mid = tmpMid;
                    if (tmpMid != mid) {
                        flag = false;
                        break;
                    }
                    mid = tmpMid;
                }
            }
            if (flag)
                bfw.write("YES\n");
            else
                bfw.write("NO\n");

        }
        bfr.close();
        bfw.close();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
