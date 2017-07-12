package algsPractice.OJ.UVa.ch5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #simulate
 */
public class Task101 {
    int n;
    LinkedList<Integer>[] blocksWorld;
    int[] index;

    //reset all blocks before top, and delete the top elements, but not reset
    void reSet(LinkedList<Integer> blocks, int top) {
        boolean flag = false;
        for (Iterator<Integer> iter = blocks.iterator(); iter.hasNext(); ) {
            int temp = iter.next();
            if (flag) {
                index[temp] = temp;
                blocksWorld[temp].add(temp);
                iter.remove();
            }
            if (temp == top) {
                flag = true;
                iter.remove();
            }
        }
    }


    void move(String opt, int a, int b) {
        if (a == b) return;
        //The not uniform mark v will cause errors, be sure to check
        //(not uniform)
        LinkedList<Integer> blocksA = blocksWorld[index[a]];
        LinkedList<Integer> blocksB = blocksWorld[index[b]];
        if (blocksA.contains(b) || blocksB.contains(a)) return;
        if ("onto".equals(opt)) {
            reSet(blocksB, b);
            blocksB.add(b);
        }
        reSet(blocksA, a);
        index[a] = index[b];
        blocksB.add(a);
    }

    void pile(String opt, int a, int b) {
        if (a == b) return;
        LinkedList<Integer> blocksA = blocksWorld[index[a]];
        LinkedList<Integer> blocksB = blocksWorld[index[b]];
        if (blocksA.contains(b) || blocksB.contains(a)) return;

        if ("onto".equals(opt)) {
            reSet(blocksB, b);
            blocksB.add(b);
        }

        boolean flag = false;
        for (Iterator<Integer> iter = blocksA.iterator(); iter.hasNext(); ) {
            int temp = iter.next();
            if (temp == a) flag = true;
            if (flag) {
                blocksB.add(temp);
                index[temp] = index[b];
                iter.remove();
            }
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = Integer.parseInt(in.readLine());
        blocksWorld = (LinkedList<Integer>[]) new LinkedList[n];
        index = new int[n];
        for (int i = 0; i < n; i++) {
            blocksWorld[i] = new LinkedList<Integer>();
            blocksWorld[i].add(i);
            index[i] = i;
        }
        String s;
        while ((s = in.readLine()) != null && s.length() != 0) {
            if ("quit".equals(s)) break;
            String[] rTs = s.split("\\s+");
            if ("move".equals(rTs[0])) {
                move(rTs[2], Integer.parseInt(rTs[1]), Integer.parseInt(rTs[3]));
            } else {
                pile(rTs[2], Integer.parseInt(rTs[1]), Integer.parseInt(rTs[3]));
            }
        }

        for (int i = 0; i < n; i++) {
            out.write(i + ":");

            for (int temp : blocksWorld[i])
                out.write(" " + temp);
            out.writeln();
        }
    }
}
