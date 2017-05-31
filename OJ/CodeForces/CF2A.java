package algsPractice.OJ.CodeForces;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class CF2A {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();

//        int n = Integer.parseInt(in.readString());
        int n = in.nextInt();
//                System.out.println("test");
        String[] winnerList = new String[n];
        int[] scoreList = new int[n];
        int count = 0;
        int max = 0, realMax = 0;//0为初始值，则不会出现负数胜利的情况

        for (int i = 0; i < n; i++) {
//            String[] rts = in.readLine().split("\\s+");
//            String name = rts[0];
//            int score = Integer.parseInt(rts[1]);
            String name = in.nextString();
            int score = in.nextInt();
            if (map.get(name) == null) map.put(name, score);
            else map.put(name, score + map.get(name));
            if (realMax < map.get(name))//得到第一个最大值的人
            {
                scoreList[count] = map.get(name);
                winnerList[count++] = name;
            }
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > max) max = e.getValue();
        }


        for (int i = 0; i < n; i++) {
            if (scoreList[i] >= max && map.get(winnerList[i]) == max) {
                out.write(winnerList[i]);
                return;
            }
        }
    }
}
