package algsPractice.oj_t.UVa.aoapc.bac2nd.ch5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Scruel on 2017/4/15.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #simulate
 */
public class Task12096 {
  static HashMap<HashSet<Integer>, Integer> IDCache;
  static LinkedList<HashSet<Integer>> setcache;
  static Stack<Integer> res;

  //        static class Set {
  //                int size = 0;
  //
  //                @Override
  //                public boolean equals(Object obj) {
  //                        //测试两个对象是否是同一个对象，是的话返回true
  //                        if (this == obj) return true;
  //                        //测试检测的对象是否为空，是就返回false
  //                        if (obj == null) return false;
  //                        //测试两个对象所属的类是否相同，否则返回false
  //                        if (getClass() != obj.getClass()) return false;
  //                        //对otherObject进行类型转换以便和类A的对象进行比较
  //                        //对于值可能为null的属性，检测时应使用Object的equals方法，不为null的可以直接使用==检测
  //                        return obj.hashCode() == this.hashCode();
  //                }
  //
  //                @Override
  //                public int hashCode() {
  //                        return size;
  //                }
  //        }

  static int getID(HashSet<Integer> set) {
    if (IDCache.containsKey(set)) {
      return IDCache.get(set);
    }
    setcache.add(set);
    IDCache.put(set, IDCache.size());
    return IDCache.size() - 1;
  }


  static Collection intersection(Collection set1, Collection set2) {
    Collection set = new ArrayList();
    set.addAll(set1);
    set.removeAll(set2);
    set1.removeAll(set);
    return set1;
  }

  static Collection union(Collection set1, Collection set2) {
    set1.addAll(set2);
    return set1;
  }

  public static void main(String[] args) throws IOException {

    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
    IDCache = new HashMap<HashSet<Integer>, Integer>();
    setcache = new LinkedList<HashSet<Integer>>();
    int n = Integer.parseInt(bfr.readLine());
    while (n-- != 0) {
      res = new Stack<Integer>();
      int opNum = Integer.parseInt(bfr.readLine());
      while (opNum-- != 0) {
        String rT = bfr.readLine();
        if ("PUSH".equals(rT)) {
          int id = getID(new HashSet());
          res.push(id);
        }
        else if ("DUP".equals(rT)) {
          res.push(res.peek());
        }
        else {
          int p1 = res.pop();
          int p2 = res.pop();
          //这里必须是new，否则在add中，会导致IDcache和setcache中之前的对象也被改变
          HashSet<Integer> s1 = new HashSet<Integer>();
          HashSet<Integer> s2 = new HashSet<Integer>();
          s1.addAll(setcache.get(p1));
          s2.addAll(setcache.get(p2));
          HashSet<Integer> x = null;
          if ("UNION".equals(rT)) {
            x = (HashSet<Integer>) union(s1, s2);
          }
          else if ("INTERSECT".equals(rT)) {
            x = (HashSet<Integer>) intersection(s1, s2);
          }
          else if ("ADD".equals(rT)) {
            x = s2;
            x.add(getID(s1));
          }
          res.push(getID(x));
        }
        bfw.write(setcache.get(res.peek()).size() + "\n");
      }
      bfw.write("***\n");
    }
    bfw.close();
    bfr.close();
  }

}
