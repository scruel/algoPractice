package algsPractice.oj_t.UVa.aoapc.bac2nd.ch5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #string #datastruct
 */
public class Task1597 {
  //    HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
  int wid = 0;
  String[][] docs;//存储文档原文
  DocWordMap[] dMap;//存储文档单词map
  String cl = "----------";
  String nf = "Sorry, I found nothing.";
  WordMap dMap2;//存储文档单词map

  public void solve1(int testNumber, InputReader in, OutputWriter out) {
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
          }
          else {
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
            if (kase++ > 0) {
              out.writeln(cl);
            }
            for (int k = 0; k < docs[j].length; k++) {
              if (docs[j][k] == null) {
                break;
              }
              out.writeln(docs[j][k]);
              flag = true;
            }
          }
        }
      }
      else if (s.contains("AND")) {
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
            if (kase++ > 0) {
              out.writeln(cl);
            }
            for (int k : tl)
              out.writeln(docs[j][k]);
          }
        }
      }
      else if (s.contains("OR")) {
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
            if (kase++ > 0) {
              out.writeln(cl);
            }
            for (int k : tl)
              out.writeln(docs[j][k]);
          }
        }
      }
      else {
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
            if (kase++ > 0) {
              out.writeln(cl);
            }
            for (int k : tl)
              out.writeln(docs[j][k]);
          }
        }
      }
      if (!flag) {
        out.writeln(nf);
      }

      out.writeln("==========");
    }
  }

  TreeSet<Pair> intersection(TreeSet<Pair> s1, TreeSet<Pair> s2) {
    TreeSet<Pair> set = new TreeSet<Pair>();
    TreeSet<Pair> set1 = new TreeSet<Pair>();
    set1.addAll(s1);
    TreeSet<Pair> set2 = new TreeSet<Pair>();
    set2.addAll(s2);
    if (set1.isEmpty() || set2.isEmpty()) {
      return set;
    }
    while (!set1.isEmpty() && !set2.isEmpty()) {
      Pair p1 = set1.first();
      Pair p2 = set2.first();
      if (p1.did == p2.did) {
        while (!set1.isEmpty() && p1.did == set1.first().did) {
          set.add(set1.pollFirst());
        }
        while (!set2.isEmpty() && p1.did == set2.first().did) {
          set.add(set2.pollFirst());
        }

      }
      else {
        while (!set1.isEmpty() && !set2.isEmpty()) {
          if (set1.first().did < set2.first().did) {
            set1.pollFirst();
          }
          else if (set1.first().did > set2.first().did) {
            set2.pollFirst();
          }
          else {
            break;
          }
        }
      }
    }
    return set;
  }

  TreeSet<Pair> union(TreeSet<Pair> s1, TreeSet<Pair> s2) {
    TreeSet<Pair> set1 = new TreeSet<Pair>();
    set1.addAll(s1);
    set1.addAll(s2);
    return set1;
  }

  TreeSet<Pair> find(String key) {
    if (dMap2.containsKey(key)) {
      return dMap2.get(key);
    }
    else {
      return new TreeSet<Pair>();
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    dMap2 = new WordMap();
    docs = new String[n][1505];
    for (int did = 0; did < n; did++) {
      String s;
      int lid = 0;
      while (!(s = in.nextLine()).equals("**********")) {
        docs[did][lid] = s;
        s = s.toLowerCase().replaceAll("[^a-z ]", " ");
        String[] rts = s.split("\\s+");
        Pair p = new Pair();
        p.did = did;
        p.lid = lid;
        //word in one line
        for (int j = 0; j < rts.length; j++) {
          if (dMap2.containsKey(rts[j])) {
            dMap2.get(rts[j]).add(p);
          }
          else {
            TreeSet<Pair> ts = new TreeSet<Pair>();
            ts.add(p);
            dMap2.put(rts[j], ts);
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
      TreeSet<Pair> ts1, ts2;
      if (s.charAt(0) == 'N') {
        s = s.substring(4, s.length());
        ts1 = find(s);
        if (ts1 != null) {
          boolean[] ds = new boolean[n];
          for (Pair p : ts1) {
            ds[p.did] = true;
          }
          for (int j = 0; j < n; j++) {
            if (!ds[j]) {
              if (kase++ > 0) {
                out.writeln(cl);
              }
              for (int k = 0; docs[j][k] != null; k++)
                out.writeln(docs[j][k]);
            }
          }
        }
        if (kase > 0) {
          flag = true;
        }
      }
      else {
        if (s.contains("AND")) {
          int index = s.indexOf("AND");
          String s1 = s.substring(0, index - 1);
          String s2 = s.substring(index + 4, s.length());
          ts1 = find(s1);
          ts2 = find(s2);
          ts1 = intersection(ts1, ts2);
        }
        else if (s.contains("OR")) {
          int index = s.indexOf("OR");
          String s1 = s.substring(0, index - 1);
          String s2 = s.substring(index + 3, s.length());
          ts1 = find(s1);
          ts2 = find(s2);
          ts1 = union(ts1, ts2);
        }
        else {
          ts1 = find(s);
        }
        if (!ts1.isEmpty()) {
          flag = true;
          int pd = ts1.first().did;
          for (Pair p : ts1) {
            if (pd != p.did) {
              pd = p.did;
              out.writeln(cl);
            }
            out.writeln(docs[p.did][p.lid]);
          }
        }
      }
      if (!flag) {
        out.writeln(nf);
      }
      out.writeln("==========");
    }
  }

  static class DocWordMap extends HashMap<String, HashSet<Integer>> {

  }

  static class Pair implements Comparable<Pair> {
    int did;
    int lid;

    @Override
    public int compareTo(Pair o) {
      if (this.did > o.did) {
        return 1;
      }
      else if (this.did < o.did) {
        return -1;
      }
      else if (this.lid > o.lid) {
        return 1;
      }
      else if (this.lid < o.lid) {
        return -1;
      }
      else {
        return 0;
      }
    }

    @Override
    public int hashCode() {
      int prime = 31;
      int res = 1;
      res = res * prime + did;
      res = res * prime + lid;
      return res;
    }


    @Override
    public boolean equals(Object obj) {

      return this.did == ((Pair) obj).did && this.lid == ((Pair) obj).lid;
    }
  }

  static class WordMap extends HashMap<String, TreeSet<Pair>> {

  }
}
