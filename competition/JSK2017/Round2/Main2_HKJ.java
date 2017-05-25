package algsPractice.competition.JSK2017.Round2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.math.BigDecimal;

/**
 * Created by Scruel on 2017/5/24.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Main2_HKJ {
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    static StringBuilder tSB = new StringBuilder();
    static StringBuilder str = new StringBuilder();
    static BigDecimal b = new BigDecimal(1000000);

    public static void main(String[] args) throws IOException {

        bfr.readLine();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine se = manager.getEngineByName("js");
        String ts = bfr.readLine();
        for (int i = 0; i < ts.length(); i++) {
            char ch = ts.charAt(i);
            if (Character.isDigit(ch) || ch == '.') {
                tSB.append(ch);
            } else {

                if (tSB.length() != 0) {
                    str.append(new BigDecimal(tSB.toString()).multiply(b));
                    tSB.delete(0, tSB.length());
                }
                str.append(ch);
            }
        }
        if (tSB.length() != 0) {
            str.append(new BigDecimal(tSB.toString()).multiply(b));
            tSB.delete(0, tSB.length());
        }

        try {
            Object result = se.eval(str.toString());
            if (result instanceof Integer) {
                System.out.printf("%d", (Integer) result / 1000);
            } else {
//                                BigDecimal
                Double tmp = (Double) result / 1000.0;
                if (Math.floor(tmp) != tmp)
                    System.out.printf("%.6f", tmp);
                else
                    System.out.printf("%d", tmp.longValue());
            }
        } catch (ScriptException e) {
            System.out.println("No Answer");
        }
        bfr.close();
    }
}
