package algsPractice.OJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Scruel on 2017/4/14.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * **数据结构标准库**可以用stack做，更为直观，index也可以保存高度值，更为快速
 * 在题解中其实就是stack，一直在操作尾部，这里也可以使用removeLast和addLast来实现。
 */
public class UVa101TheBlocksProblem {
        static int n;
        static LinkedList<Integer>[] blocksWorld;
        static int[] index;
        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        public static void main(String[] args) throws IOException {
                n = new Integer(bfr.readLine());
                blocksWorld = new LinkedList[n];
                index = new int[n];
                for (int i = 0; i < n; i++) {
                        blocksWorld[i] = new LinkedList<Integer>();
                        blocksWorld[i].add(i);
                        index[i] = i;
                }
                String s;
                while ((s = bfr.readLine()) != null && s.length() != 0) {
                        if ("quit".equals(s))
                                break;
                        String[] rTs = s.split("\\s+");
                        if ("move".equals(rTs[0])) {
                                move(rTs[2], new Integer(rTs[1]), new Integer(rTs[3]));
                        } else {
                                pile(rTs[2], new Integer(rTs[1]), new Integer(rTs[3]));
                        }
                }

                for (int i = 0; i < n; i++) {
                        System.out.print(i + ":");

                        for (int temp : blocksWorld[i])
                                System.out.print(" " + temp);
                        System.out.println();
                }
                bfr.close();
        }

        //将top之前的所有木块归位，并将顶部的这个元素删除，但不归位
        public static void reSize(LinkedList<Integer> blocks, int top) {
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


        public static void move(String opt, int a, int b) {
                if (a == b) return;
                //index标记不统一会导致错误，一定要检查
                //
                LinkedList<Integer> blocksA = blocksWorld[index[a]];
                LinkedList<Integer> blocksB = blocksWorld[index[b]];
                if (blocksA.contains(b) || blocksB.contains(a)) return;
                if ("onto".equals(opt)) {
                        reSize(blocksB, b);
                        blocksB.add(b);
                }
                reSize(blocksA, a);
                index[a] = index[b];
                blocksB.add(a);
        }

        public static void pile(String opt, int a, int b) {
                if (a == b) return;
                LinkedList<Integer> blocksA = blocksWorld[index[a]];
                LinkedList<Integer> blocksB = blocksWorld[index[b]];
                if (blocksA.contains(b) || blocksB.contains(a)) return;

                if ("onto".equals(opt)) {
                        reSize(blocksB, b);
                        blocksB.add(b);
                }

                boolean flag = false;
                for (Iterator<Integer> iter = blocksA.iterator(); iter.hasNext(); ) {
                        int temp = iter.next();
                        if (temp == a)
                                flag = true;
                        if (flag) {
                                blocksB.add(temp);
                                index[temp] = index[b];
                                iter.remove();
                        }
                }
        }
}
