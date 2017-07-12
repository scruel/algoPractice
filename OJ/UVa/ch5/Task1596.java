package algsPractice.OJ.UVa.ch5;

import java.io.*;
import java.util.HashMap;

/**
 * Created by Scruel on 2017/4/27.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #recursion #simulate
 */
public class Task1596 {
    static HashMap<String, Integer> initMap;
    static HashMap<String, Integer> resMap;

    static String[] rep = new String[1005];


    public static void test() {
        resMap = new HashMap<String, Integer>();
        initMap = new HashMap<String, Integer>();
        initMap.put("b", 3);
        resMap.put("b[0]", 1);
        resMap.put("b[1]", 2);
        resMap.put("b[2]", 5);
        System.out.println(getRes("b[b[b[0]]]"));
    }

    public static void main(String[] args) throws IOException {
//                test();
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        int n = 0;
        resMap = new HashMap<String, Integer>();
        initMap = new HashMap<String, Integer>();
        while ((s = bfr.readLine()) != null && !s.isEmpty()) {
            //开始处理
            if (".".equals(s)) {
                if (n == 0)
                    break;

                boolean flag = true;
                for (int i = 0; i < n; i++) {
                    if (rep[i].contains("=")) {
                        String left = rep[i].substring(0, rep[i].indexOf("="));
                        String tmp = left.substring(left.indexOf("[") + 1, left.lastIndexOf("]"));
                        String right = rep[i].substring(rep[i].indexOf("=") + 1, rep[i].length());
                        String arrName = rep[i].substring(0, 1);
                        int key = getRes(tmp);
                        int value = getRes(right);
                        if (key == -1 || value == -1 || !initMap.containsKey(arrName) || initMap.get(arrName) <= key) {
                            flag = false;
                            bfw.write((i + 1) + "\n");
                            break;
                        } else {
                            resMap.put(arrName + "[" + key + "]", value);
                        }
                    } else {
                        String tmp = rep[i].substring(rep[i].indexOf("[") + 1, rep[i].lastIndexOf("]"));
                        initMap.put(rep[i].substring(0, 1), Integer.parseInt(tmp));
                    }
                }
                if (flag)
                    bfw.write("0\n");
                n = 0;
                resMap = new HashMap<String, Integer>();
                initMap = new HashMap<String, Integer>();
            } else {
                rep[n++] = s;
            }
        }
        bfw.close();
        bfr.close();
    }

    //递归查询情况
    static int getRes(String rep) {
        if (rep.matches("\\d+"))
            return Integer.parseInt(rep);
        String tmp = rep.substring(rep.indexOf("[") + 1, rep.lastIndexOf("]"));
        int res = getRes(tmp);
        String arrName = rep.substring(0, 1);
        if (!initMap.containsKey(arrName))
            return -1;
        if (initMap.get(arrName) <= res)
            return -1;
        rep = rep.replace(tmp, String.valueOf(res));
        if (resMap.containsKey(rep))
            return resMap.get(rep);
        else return -1;
    }
}
