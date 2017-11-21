package algsPractice.competition.IQIYI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by Scruel on 2017/5/14.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Main3 {
  static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
  static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
  static PriorityQueue<Pair> q = new PriorityQueue<Pair>();
  static Pair[] pairs;
  static LinkedList<Pair> list = new LinkedList<Pair>();
  static int n;
  //        static int[] score;

  public static void main(String[] args) throws IOException {
    bfr.readLine();
    String[] rts = bfr.readLine().trim().split("\\s+");
    n = rts.length;
    pairs = new Pair[n];
    //                score = new int[n];
    for (int i = 0; i < n; i++) {
      pairs[i] = new Pair(i);
      pairs[i].num = Integer.parseInt(rts[i]);
    }
    int max = 0;
    int maxIndex = -1;
    pairs[0].score = pairs[0].num * pairs[1].num;
    max = Math.max(pairs[0].score, max);
    pairs[n - 1].score = pairs[n - 1].num * pairs[n - 2].num;
    max = Math.max(pairs[n - 1].score, max);
    for (int i = 1; i < n - 1; i++) {
      pairs[i].score = pairs[i - 1].num * pairs[i].num * pairs[i + 1].num;
      max = Math.max(pairs[i].score, max);
    }
    for (int i = 0; i < n; i++) {
      list.add(pairs[i]);
      q.add(pairs[i]);
    }
    int res = 0;

    while (!q.isEmpty()) {
      Pair tmp = q.poll();
      list.remove(tmp);
      int id = tmp.id;
      for (int i = id; i < list.size(); i++) {
        list.get(i).id--;
      }
      res += tmp.score;
      if (!q.isEmpty()) {
        Pair p;
        if (id != 0 && id != list.size()) {
          p = new Pair(id - 1);
          q.remove(p);
          p.score = getSc(id - 2) * getSc(id - 1) * getSc(id);
          q.add(p);
          p = new Pair(id);
          q.remove(p);
          p.score = getSc(id - 1) * getSc(id) * getSc(id + 1);
          q.add(p);
        }
        else if (id == 0) {
          p = new Pair(0);
          q.remove(p);
          p.score = getSc(0) * getSc(1);
          q.add(p);
        }
        else if (id == list.size()) {
          p = new Pair(list.size() - 1);
          q.remove(p);
          p.score = getSc(list.size() - 1) * getSc(list.size() - 2);
          q.add(p);
        }

      }

    }
    bfw.write(String.format("%d", res));
    bfr.close();
    bfw.close();
  }

  static int getSc(int i) {
    if (i == -1 || i >= list.size()) {
      return 1;
    }

    return list.get(i).num;
  }

  static class Pair implements Comparable<Pair> {
    int id;
    int num;
    int score;

    public Pair(int id) {
      this.id = id;
    }

    @Override
    public int compareTo(Pair o) {
      return o.score - this.score;
    }

    @Override
    public int hashCode() {
      return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
      Pair p = (Pair) obj;
      return this.id == p.id;
    }
  }
}
