package algsPractice.competition.codem.p;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 * #simulate #unsloved
 */
public class TaskC {
  int MAXN = 500000 + 10;
  int[] ip, op;
  //删除index用alist比llist快，因为链表无法快速定位index
  ArrayList<Integer> al;
  //    LinkedList<Integer> al;
  //    int[] nums;
  //    HashMap<Integer, Integer> map;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    while (!in.isExhausted()) {
      al = new ArrayList<Integer>();
      ip = new int[MAXN];
      op = new int[MAXN];
      //            map = new HashMap<Integer, Integer>();
      int n = in.nextInt();
      boolean f = true;
      int res = -1;
      for (int i = 1; i <= n; i++) {
        String s = in.nextLine();
        if (!f) {
          continue;
        }
        char ch = s.charAt(0);
        if (ch == '?') {
          al.add(i);
        }
        else {
          int id = Integer.parseInt(s.split("\\s+")[1]);
          //take
          if (ch == 'I') {
            //hvnt t:ip == 0 && op rp
            //t hvnt use ip != 0 && op == 0****
            //t hv use ip == 0 && op != 0
            if (ip[id] != 0 && op[id] == 0) {
              int index = -Collections.binarySearch(al, ip[id]) - 1;
              if (index < al.size()) {
                al.remove(index);
              }
              else {
                f = false;
                res = i;
              }
              //                            boolean ff = false;
              //                            for (int j = 0; j < al.size(); j++) {
              //                                if (ip[id] < al.get(j)) {
              //                                    ff = true;
              //                                    al.remove(j);
              //                                    break;
              //                                }
              //                            }
              //                            f = ff;
              //                            if (!f) res = i;
            }
            ip[id] = i;
            op[id] = 0;
          }
          else {
            //hvnt t ip == -1 && op rp****
            //t hvnt use ip != -1 && op == -1
            //t hv use ip == -1 && op != -1****
            if (ip[id] == 0) {
              if (op[id] == 0) {
                int index = -Collections.binarySearch(al, ip[id]) - 1;
                if (index < al.size()) {
                  al.remove(index);
                }
                else {
                  f = false;
                  res = i;
                }
                //                                boolean ff = false;
                //                                for (int j = 0; j < al.size(); j++) {
                //                                    if (ip[id] < al.get(j)) {
                //                                        ff = true;
                //                                        al.remove(j);
                //                                        break;
                //                                    }
                //                                }
                //                                f = ff;
                //                                if (!f) res = i;
              }
              else {
                int index = -Collections.binarySearch(al, op[id]) - 1;
                if (index < al.size()) {
                  al.remove(index);
                }
                else {
                  f = false;
                  res = i;
                }
                //                                for (int j = 0; j < al.size(); j++) {
                //                                    if (op[id] < al.get(j)) {
                //                                        ff = true;
                //                                        al.remove(j);
                //                                        break;
                //                                    }
                //                                }
                //                                f = ff;
                //                                if (!f) res = i;
              }
            }
            op[id] = i;
            ip[id] = 0;
          }
        }
      }
      if (f) {
        out.writeln(-1);
      }
      else {
        out.writeln(res);
      }
    }
  }
}
