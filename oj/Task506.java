package algsPractice.oj;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 */
public class Task506 {
  OutputWriter out;
  HashMap<String, Integer> id;
  HashMap<Integer, String> name;
  //依赖表
  HashMap<Integer, LinkedList<Integer>> depMap;
  //被依赖表
  HashMap<Integer, LinkedList<Integer>> dep2Map;
  HashMap<Integer, Integer> status;
  LinkedList<Integer> installed;

  void init() {
    id = new HashMap<String, Integer>();
    name = new HashMap<Integer, String>();
    dep2Map = new HashMap<Integer, LinkedList<Integer>>();
    depMap = new HashMap<Integer, LinkedList<Integer>>();
    installed = new LinkedList<Integer>();
    status = new HashMap<Integer, Integer>();
  }

  int ID(String ns) {
    if (!id.containsKey(ns)) {
      id.put(ns, id.size());
      name.put(id.size() - 1, ns);
      status.put(id.size() - 1, 0);
      return id.size() - 1;
    }
    else {
      return id.get(ns);
    }
  }

  void install(int id, boolean top) {
    if (status.get(id) == 0 || top) {
      if (depMap.get(id) != null) {
        LinkedList<Integer> list = depMap.get(id);
        for (int cid : list) {
          install(cid, false);
        }
      }
      status.put(id, top ? 1 : 2);
      installed.add(id);
      out.writeln("   Installing " + name.get(id));
    }
  }

  void list() {
    for (int id : installed) {
      String ns = name.get(id);
      out.writeln("   " + ns);
    }
  }

  boolean needed(int id) {
    if (dep2Map.get(id) != null) {
      for (int cid : dep2Map.get(id)) {
        if (status.get(cid) != 0) {
          return true;
        }
      }
    }
    return false;
  }

  void remove(int id, boolean top) {
    if ((top || status.get(id) == 2) && !needed(id)) {
      status.put(id, 0);
      out.writeln("   Removing " + name.get(id));
      installed.remove((Integer) id);
      if (depMap.get(id) != null) {
        for (int cid : depMap.get(id)) {
          remove(cid, false);
        }
      }
    }
  }


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.out = out;
    String s;
    init();
    while ((s = in.nextLine()) != null && !s.isEmpty()) {
      out.writeln(s);
      String[] ss = s.split("\\s+");
      char ch = s.charAt(0);
      if (ch == 'D') {
        int fid = ID(ss[1]);
        if (!depMap.containsKey(fid)) {
          depMap.put(fid, new LinkedList<Integer>());
        }
        for (int i = 2; i < ss.length; i++) {
          int cid = ID(ss[i]);
          if (!dep2Map.containsKey(cid)) {
            dep2Map.put(cid, new LinkedList<Integer>());
          }
          dep2Map.get(cid).add(fid);
          depMap.get(fid).add(cid);
        }
      }
      else if (ch == 'I') {
        int id = ID(ss[1]);
        if (status.get(id) != 0) {
          out.writeln("   " + ss[1] + " is already installed.");
        }
        else {
          install(id, true);
        }
      }
      else if (ch == 'R') {
        int id = ID(ss[1]);
        if (status.get(id) == 0) {
          out.writeln("   " + ss[1] + " is not installed.");
        }
        else if (needed(id)) {
          out.writeln("   " + ss[1] + " is still needed.");
        }
        else {
          remove(id, true);
        }

      }
      else if (ch == 'L') {
        list();
      }
      else {
        init();
      }

    }
  }
}