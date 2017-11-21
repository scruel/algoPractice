package algsPractice.oj.nod51;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Scruel on 2017/5/15.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #TODO
 */
public class Nod1380 {
  static int[] L = new int[99999];
  static int[] R = new int[99999];
  static long[] m = new long[99999];
  static TreeSet<Pair> set = new TreeSet<Pair>();
  //        static PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

  static void add(int x) {
    set.add(new Pair((m[x]), x));
    //                pq.add(new Pair((m[x]), x));
  }

  static void remove(int x) {
    set.remove(new Pair((m[x]), x));
    //                pq.remove(new Pair((m[x]), x));
  }

  static void del(int x) {
    remove(x);
    R[L[x]] = R[x];
    L[R[x]] = L[x];
  }

  public static void main(String[] args) throws IOException {
    //                BufferedReader bfr = new BufferedReader(new InputStreamReader(DataReader.getDataReader()), 1 << 16);
    MyScanner sc = new MyScanner();
    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      m[i] = sc.nextInt();
      add(i);
      L[(i + 1) % n] = i;
      R[i] = (i + 1) % n;
    }
    //                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    //                int n = Integer.parseInt(bfr.readLine());
    //                String s;
    //                String[] rts;
    //                int cnt = 0;
    //                while ((s = bfr.readLine()) != null && !s.isEmpty()) {
    //                        rts = s.trim().split("\\s+");
    //                        for (int j = 0; j < rts.length; j++) {
    //                                m[cnt] = Integer.parseInt(rts[j]);
    //                                add(cnt);
    //                                L[(cnt + 1) % n] = cnt;
    //                                R[cnt] = (cnt + 1) % n;
    //                                cnt++;
    //                        }
    //                }
    //


    long ans = 0;
    for (int i = 0; i < n / 3; i++) {
      int j = set.pollFirst().second;
      //                        int j2 = pq.poll().second;
      //                        System.out.println(j + "  " + j2);
      //                        System.out.println("---");
      long a = m[L[j]];
      long b = m[j];
      long c = m[R[j]];
      ans += b;
      del(L[j]);
      del(R[j]);
      remove(j);
      m[j] = a + c - b;
      add(j);
    }
    System.out.println(ans);
  }

  static class Pair implements Comparable<Pair> {
    long first;
    int second;

    public Pair(long first, int second) {
      this.first = first;
      this.second = second;
    }


    @Override
    public int compareTo(Pair o) {
      int cmp = 0;
      if (this.first < o.first) {
        cmp = 1;
      }
      else if (this.first > o.first) {
        cmp = -1;
      }
      return cmp == 0 ? this.second - o.second : cmp;

      //                        double tmpThis = this.second + this.first * 1e9;
      //                        double tmpO = o.second + o.first * 1e9;
      //                        if (tmpO > tmpThis)
      //                                return 1;
      //                        if (tmpO < tmpThis)
      //                                return -1;
      //                        return 0;
    }

    @Override
    public int hashCode() {
      return second;
    }

    @Override
    public boolean equals(Object obj) {
      Pair p = (Pair) obj;
      return p.hashCode() == this.hashCode();
    }
  }

  static class MyScanner {
    BufferedReader bfr;
    StringTokenizer st;

    public MyScanner() {
      bfr = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
      while (st == null || !st.hasMoreElements()) {
        st = new StringTokenizer(bfr.readLine());
      }
      return st.nextToken();
    }

    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
      return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
      return Double.parseDouble(next());
    }

    String nextLineSet() throws IOException {
      String str = bfr.readLine();
      st = new StringTokenizer(str);
      return str;
    }

    String nextLine() throws IOException {
      return bfr.readLine();
    }
  }
}
