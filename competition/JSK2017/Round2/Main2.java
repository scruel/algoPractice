package algsPractice.competition.JSK2017.Round2;

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Scruel on 2017/5/21.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Main2 {

        static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        static Stack<String> stack = new Stack<String>();
        static Stack<String> tmpStack = new Stack<String>();
        static boolean isF = false;
        static StringBuilder numSB = new StringBuilder();


        public static void main(String[] args) throws IOException {
                String ts;
                int n = Integer.parseInt(bfr.readLine().trim());
//                while ((ts = bfr.readLine()) != null && !ts.isEmpty()) {
//
//                }
                ts = bfr.readLine();
                int index = 0;
                long res = 0;


                while (index < ts.length()) {
                        char ch = ts.charAt(index);
                        if (ch == '+') {
                                if (numSB.length() != 0) {

                                        Long l = (long) (Double.parseDouble(numSB.toString()) * 1000000);
                                        stack.push(String.valueOf(l));
                                }
                                stack.push("+");
                                numSB = new StringBuilder();
                        } else if (ch == '-') {
                                if (numSB.length() != 0) {

                                        Long l = (long) (Double.parseDouble(numSB.toString()) * 1000000);
                                        stack.push(String.valueOf(l));
                                }
                                stack.push("-");
                                numSB = new StringBuilder();
                        } else if (ch == '(') {
                                stack.push("(");
                        } else if (ch == ')') {
                                Long l = (long) (Double.parseDouble(numSB.toString()) * 1000000);
                                stack.push(String.valueOf(l));
                                numSB = new StringBuilder();
                                getKHValue();
                        } else {
                                if (ch == '.')
                                        isF = true;
                                numSB.append(ch);
                        }
                        index++;
                }

                res = getRes();
                if (isF) {
                        System.out.printf("%.6f", res / 1000000.0);
                } else {
                        System.out.printf("%d", res / 1000000);
                }
                bfr.close();
                bfw.close();
        }

        static long getRes() {
                while (stack.size() != 1) {
                        String n1 = stack.pop();
                        long nn1 = Long.parseLong(n1);
                        String op = stack.pop();
//                        if (op.equals("(")) {
//                                stack.push(String.valueOf(nn1));
//                                break;
//                        }
                        String n2 = stack.pop();
                        long nn2 = Long.parseLong(n2);
                        if (op.equals("-")) {
                                stack.push(String.valueOf(nn2 - nn1));
                        } else {
                                stack.push(String.valueOf(nn1 + nn2));
                        }
                }
                return (long) (Double.parseDouble(stack.pop()));
        }

        static void getKHValue() {

                String n1;
                while (!(n1 = stack.pop()).equals("(")) {
                        tmpStack.push(n1);
                }
                if (n1.equals("(")) {
                        tmpStack.push("(");
                }

                while (!(n1 = tmpStack.pop()).equals("(")) {
                        long nn1 = Long.parseLong(n1);
                        String op = tmpStack.pop();
                        if (op.equals("(")) {
                                tmpStack.push(String.valueOf(nn1));
                                break;
                        }
                        String n2 = tmpStack.pop();
                        long nn2 = Long.parseLong(n2);
                        if (op.equals("-")) {
                                tmpStack.push(String.valueOf(nn1 - nn2));
                        } else {
                                tmpStack.push(String.valueOf(nn1 + nn2));
                        }
                }
        }
}
