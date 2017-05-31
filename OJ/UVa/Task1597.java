package algsPractice.OJ.UVa;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task1597 {
    //    HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
    int wid = 0;
    String[][] docs;//存储文档原文
    DocWordMap[] dMap;//存储文档单词map
    String cl = "----------";
    String nf = "Sorry, I found nothing.";

    static class DocWordMap extends HashMap<String, HashSet<Integer>> {

    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        dMap = new DocWordMap[n];
        docs = new String[n][1505];
        for (int i = 0; i < n; i++) {
            String s;
            int lid = 0;
            dMap[i] = new DocWordMap();
            while (!(s = in.nextLine()).equals("**********")) {
                docs[i][lid] = s;
                s = s.toLowerCase().replaceAll("[^a-z ]", " ");
                String[] rts = s.split("\\s+");
                //word in one line
                for (int j = 0; j < rts.length; j++) {
                    if (dMap[i].containsKey(rts[j])) {
                        dMap[i].get(rts[j]).add(lid);
                    } else {
                        HashSet<Integer> ts = new HashSet<Integer>();
                        ts.add(lid);
                        dMap[i].put(rts[j], ts);
                    }

                }
                lid++;
            }
        }


        //parse commands
        int cn = in.nextInt();
        for (int i = 0; i < cn; i++) {
            String s = in.nextLine();
            int kase = 0;
            boolean flag = false;
            if (s.charAt(0) == 'N') {
                s = s.substring(4, s.length());
                for (int j = 0; j < n; j++) {
                    if (!dMap[j].containsKey(s)) {
                        if (kase++ > 0) out.writeln(cl);
                        for (int k = 0; k < docs[j].length; k++) {
                            if (docs[j][k] == null) break;
                            out.writeln(docs[j][k]);
                            flag = true;
                        }
                    }
                }
            } else if (s.contains("AND")) {
                int index = s.indexOf("AND");
                String s1 = s.substring(0, index - 1);
                String s2 = s.substring(index + 4, s.length());
                for (int j = 0; j < n; j++) {
                    TreeSet<Integer> tl = new TreeSet<Integer>();
                    if (dMap[j].containsKey(s1) && dMap[j].containsKey((s2))) {
                        for (Integer lid : dMap[j].get((s1))) {
                            tl.add(lid);
                            flag = true;
                        }
                        for (Integer lid : dMap[j].get((s2))) {
                            tl.add(lid);
                            flag = true;
                        }
                    }
                    if (!tl.isEmpty()) {
                        if (kase++ > 0) out.writeln(cl);
                        for (int k : tl)
                            out.writeln(docs[j][k]);
                    }
                }
            } else if (s.contains("OR")) {
                int index = s.indexOf("OR");
                String s1 = s.substring(0, index - 1);
                String s2 = s.substring(index + 3, s.length());
                for (int j = 0; j < n; j++) {
                    TreeSet<Integer> tl = new TreeSet<Integer>();
                    if (dMap[j].containsKey((s1))) {
                        for (Integer lid : dMap[j].get((s1))) {
                            tl.add(lid);
                            flag = true;
                        }
                    }
                    if (dMap[j].containsKey((s2))) {
                        for (Integer lid : dMap[j].get((s2))) {
                            tl.add(lid);
                            flag = true;
                        }
                    }
                    if (!tl.isEmpty()) {
                        if (kase++ > 0) out.writeln(cl);
                        for (int k : tl)
                            out.writeln(docs[j][k]);
                    }
                }
            } else {
                HashSet<String> tst = new HashSet<String>();
                for (int j = 0; j < n; j++) {
                    TreeSet<Integer> tl = new TreeSet<Integer>();
                    if (dMap[j].containsKey((s))) {
                        for (Integer lid : dMap[j].get((s))) {
                            tl.add(lid);
                            flag = true;
                        }
                    }
                    if (!tl.isEmpty()) {
                        if (kase++ > 0) out.writeln(cl);
                        for (int k : tl)
                            out.writeln(docs[j][k]);
                    }
                }
            }
            if (!flag) out.writeln(nf);

            out.writeln("==========");
        }
    }
}
