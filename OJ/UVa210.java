package algsPractice.OJ;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Scruel on 2017/5/5.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class UVa210 {
        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        static int[] value;
        static HashMap<Integer, LinkedList<Order>> programMap;
        static LinkedList<Integer> waitList;
        static LinkedList<Integer> blockList;
        //        static int n, assT, outT, lockT, unLockT, endT, programT;
        static int n;
        static boolean isLock = false;
        static int[] eTime;

        static int getType(String s) {
                if ("lock".equals(s))
                        return 3;
                if ("unlock".equals(s))
                        return 4;
                if ("end".equals(s))
                        return 5;
                if (s.startsWith("print"))
                        return 2;
//                else if (s.contains("="))
//                        return 1;
                return 1;
        }

        static Order getOrder(String s) {
                Order order = new Order();
                order.type = getType(s);
                order.remainTime = eTime[order.type];
                order.order = s;
                return order;
        }

        static void execute() throws IOException {
                while (!waitList.isEmpty() || !blockList.isEmpty()) {
                        int id;
                        if (!waitList.isEmpty())
                                id = waitList.removeFirst();
                        else
                                id = blockList.removeFirst();
                        LinkedList<Order> programList = programMap.get(id);
                        int remain = eTime[6];
                        boolean flag = false;
                        //当前程序时间片还未执行完毕
                        while (!programList.isEmpty()) {
                                Order order = programList.getFirst();
                                int orderTime = eTime[order.type];
                                //执行语句
//                                bfw.write("order(" + id + "):" + order.order + "\n");
//                                bfw.flush();
                                if (!executeOrder(id, order.type, order.order)) {
                                        //lock处理
                                        if (order.type == 4)
                                                programList.remove(order);
                                        flag = true;
                                        break;
                                }
                                remain -= orderTime;
                                programList.remove(order);
                                if (remain <= 0)
                                        break;
                        }
                        //程序指令还未执行完毕，重新加入等待队列
                        if (!flag && !programList.isEmpty())
                                waitList.add(id);


                }
        }

        static boolean executeOrder(int id, int type, String order) throws IOException {
                if (type == 1) {
                        String[] rts = order.split("\\s+");
                        value[rts[0].charAt(0)] = new Integer(rts[2]);
                } else if (type == 2) {
                        String[] rts = order.split("\\s+");
                        bfw.write(id + ": " + value[rts[1].charAt(0)] + "\n");
//                        bfw.flush();
                } else if (type == 3) {
                        if (!isLock) {
                                isLock = true;
                        } else {
                                blockList.add(id);
                                return false;
                        }
                } else if (type == 4) {
                        isLock = false;
//                        waitList.addFirst(id);
                        if (!blockList.isEmpty())
                                waitList.addFirst(blockList.removeFirst());
                }
                return true;

        }

        public static void main(String[] args) throws IOException {
                String tmpS;
                while ((tmpS = bfr.readLine()) == null || tmpS.isEmpty()) ;
                int t = new Integer(tmpS);
                while (t-- > 0) {

                        while ((tmpS = bfr.readLine()) == null || tmpS.isEmpty()) ;
                        String[] rts = tmpS.split("\\s+");
                        n = new Integer(rts[0]);
                        eTime = new int[7];
                        for (int i = 1; i < rts.length; i++) {
                                eTime[i] = new Integer(rts[i]);
                        }
                        value = new int[256];
                        programMap = new HashMap<Integer, LinkedList<Order>>();
                        waitList = new LinkedList<Integer>();
                        blockList = new LinkedList<Integer>();
                        for (int i = 1; i <= n; i++) {
                                LinkedList<Order> proList = new LinkedList<Order>();
                                programMap.put(i, proList);
                                while ((tmpS = bfr.readLine()) != null && !tmpS.isEmpty()) {
                                        proList.add(getOrder(tmpS));
                                        if ("end".equals(tmpS))
                                                break;
                                }
                                waitList.add(i);
                        }
                        execute();
                        if (t >= 1)
                                bfw.write("\n");
                }

                bfr.close();
                bfw.close();
        }

        static class Order {
                int id;
                int remainTime;
                int type;
                String order;
        }


}
