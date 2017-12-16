package algsPractice.oj.nod51;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;
import com.sun.xml.internal.messaging.saaj.soap.ver1_1.BodyElement1_1Impl;

/**
 * @author scruel
 * <p>
 * dfs 判断是否会断掉
 * 方法一：二分计算转判断 (nlogn)
 * 方法二：DFS时使用并查集
 * 方法三：Tarjan Lca - A linera-time algorithm for a special case disjoint set union.
 */
public class Task1307 {
  class Node {
    int parent, root, weight, hold;
    long sum;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      Node node = new Node();
      node.root = i;
      node.hold = in.nextInt();
      node.weight = in.nextInt();
      node.sum = node.weight;
      node.parent = in.nextInt();
      nodes[i] = node;
    }

    int max = n - 1;
    for (int i = n - 1; i >= 0; i--) {
      Node node = nodes[i];
      while (node.hold < node.sum) {
        // 超重了，开始从最后一根向上并查减少
        int root = max, id = max;
        while (nodes[root].root != root) {
          root = nodes[root].root;
        }
        while (nodes[id].root != root) {
          int cid = id;
          id = nodes[id].root;
          nodes[cid].root = root;
        }
        nodes[root].sum -= nodes[max].weight;
        max--;
      }

      if (node.parent != -1) {
        node.root = node.parent;
        nodes[node.parent].sum += node.sum;
      }
    }
    out.writeln(max + 1);
  }
}
