package algsPractice.competition.JSK2017.Round2;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Main2 {
    StringBuilder sb = null;
    HashMap<String, String[]> eMap = null;
    boolean isF;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String result, exp;
        sb = new StringBuilder();
        eMap = new HashMap<String, String[]>();
        isF = false;
        int n = Integer.parseInt(in.readLine().trim());
        for (int i = 0; i < n; i++) {
            String ts = in.readLine();
            int t = ts.indexOf('(');
            int t2 = ts.indexOf(')');
            String fn = ts.substring(0, t);
            String[] ve = new String[2];
            ve[0] = ts.substring(t + 1, t2);
            ve[1] = ts.substring(ts.indexOf('=') + 1, ts.length());
            eMap.put(fn, ve);
        }
        exp = in.readLine();
        for (String fn : eMap.keySet()) {
            while (exp.contains(fn)) {
                int t = exp.indexOf(fn);
                int srt = exp.indexOf("(", t);
                String vs = "(" + getPairS(exp, srt) + ")";
                String[] ve = eMap.get(fn);
//                ve[1].replace(ve[0], vs);
                String e = ve[1];
                e = "(" + e.replace(ve[0], vs) + ")";
                exp = exp.substring(0, t).concat(e).concat(exp.substring(srt + vs.length(), exp.length()));
            }
        }


        BigDecimal res;
        try {
            res = getRes(exp, true);
            DecimalFormat df = new DecimalFormat("0.000000");
            if (isF || new BigDecimal(res.longValue()).compareTo(res) != 0) {
                result = String.format("%s", df.format(res));
            } else {
                result = String.format("%d", res.longValue());
            }
        } catch (Exception e) {
//            e.printStackTrace();
            result = "No Answer";
        }
        out.write(result);
    }

    // 优先级   符号		运算顺序
    // 2		* / %	从左至右
    // 3		+ -		从左至右
    // 4		=		从右至左
    int rank(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/' || ch == '%') {
            return 2;
        } else if (ch == '^') {
            return 3;
        } else {
            return 0;
        }
    }

    String getPairS(String exp, int srt) {
        int cntS = 1;
        int cntE = 0;
        int end;
        for (end = srt + 1; ; end++) {
            if (exp.charAt(end) == '(') cntS++;
            else if (exp.charAt(end) == ')') cntE++;
            if (cntS == cntE) break;
        }
        return exp.substring(srt + 1, end);
    }

    BigDecimal getRes(String exp, boolean fChange) throws Exception {
        if (exp.startsWith("-")) exp = "0" + exp;
        Stack<BigDecimal> nS = new Stack<BigDecimal>();
        Stack<Character> opS = new Stack<Character>();
        LinkedList<String> pList = new LinkedList<String>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if ((ch != '+' && ch != '-' && ch != '(' && ch != ')')) {
                if (fChange && ch == '.') isF = true;
                if (exp.indexOf("int", i) == i) {
                    int srt = exp.indexOf("(", i);
                    String ps = getPairS(exp, srt);
                    i = srt + ps.length() + 1;
                    String s = getRes(ps, false).toString();
                    if (s.contains(".")) {
                        s = s.substring(0, s.indexOf("."));
                    }
                    sb.append(s);

                } else if (exp.indexOf("float", i) == i) {
                    int srt = exp.indexOf("(", i);
                    String ps = getPairS(exp, srt);
                    i = srt + ps.length() + 1;
                    String s = getRes(ps, false).toString();
                    if (fChange) isF = true;
                    if (!s.contains(".")) s += ".0";
                    sb.append(s);
//                    while (ch != ')') {
//                        sb.append(ch);
//                        ch = exp.charAt(++i);
//                    }
//                    sb.append(")");
                } else {
                    sb.append(ch);
                }
            } else {
                if (sb.length() != 0) {
                    pList.add(sb.toString());
                    sb.delete(0, sb.length());
                }
                if (ch == '(') {
                    opS.push(ch);
                } else if (ch == ')') {
//                    if (opS.peek() != '(') {
                    while (opS.peek() != '(') pList.add(String.valueOf(opS.pop()));
                    opS.pop();
//                        if (opS.peek() != '(')
//                            pList.add(String.valueOf(opS.pop()));
//                    } else {
//                        opS.pop();
//                    }
                } else if (ch != ' ') {
                    while (!opS.empty() && rank(opS.peek()) >= rank(ch)) {
                        pList.add(String.valueOf(opS.pop()));
                    }
                    opS.push(ch);
                }
            }
        }
        if (sb.length() != 0) {
            pList.add(sb.toString());
            sb.delete(0, sb.length());
        }
        while (!opS.isEmpty()) pList.add(String.valueOf(opS.pop()));
        for (int i = 0; i < pList.size(); i++) {
            String s = pList.get(i);
            if ("−".equals(s) || "-".equals(s)) {
                BigDecimal b = nS.pop();
                nS.push(nS.pop().subtract(b));
            } else if ("+".equals(s)) {
                nS.push(nS.pop().add(nS.pop()));
            } else if ("^".equals(s)) {
                BigDecimal b = nS.pop();
                nS.push(nS.pop().pow(b.intValue()));
            } else if ("/".equals(s)) {
                BigDecimal b = nS.pop();
                nS.push(nS.pop().divide(b));
            } else if ("*".equals(s)) {
                nS.push(nS.pop().multiply(nS.pop()));
            } else {
                nS.push(new BigDecimal(s));
            }

        }

        return nS.pop();
    }
}
