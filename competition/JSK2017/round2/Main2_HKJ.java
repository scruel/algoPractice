package algsPractice.competition.JSK2017.round2;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import javax.script.*;
import java.util.regex.Pattern;

/**
 * Created by Scruel on 2017/5/26.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Main2_HKJ {

    public static Pattern floatPattern = Pattern.compile("[0-9]+\\.[0-9]*|parseFloat\\(.*\\)");
    private static int cnt = 31;

    String convertStatement(String s) {
        return s.replace("int", "parseInt").replace("float", "parseFloat");
    }

    String replaceFloat(String s) {
        String a = s, b;
        while ((b = a.replaceFirst("[0-9]+\\.[0-9]+", "1e" + (cnt++))) != a) {
            a = b;
        }
        while ((b = a.replaceFirst("parseFloat", "1e" + (cnt++) + " + xxxxxxxxxxx")) != a) {
            a = b;
        }
        return a.replaceAll("xxxxxxxxxxx", "parseFloat").replaceAll("parseInt", "0*");
    }

    String convert(String s) {
        return "function " + convertStatement(s.replaceFirst("=", "{ return ")) + ";}";
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int T = 1;
//        int T = input.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("ECMAScript");
            Bindings bind = engine.createBindings();
            engine.setBindings(bind, ScriptContext.ENGINE_SCOPE);
            ScriptEngine engine2 = new ScriptEngineManager().getEngineByName("ECMAScript");
            Bindings bind2 = engine2.createBindings();
            engine2.setBindings(bind2, ScriptContext.ENGINE_SCOPE);

            try {
                while (n-- > 0) {
                    String c = convert(in.nextLine());
                    engine.eval(c);
                    engine2.eval(replaceFloat(c));
                }
            } catch (ScriptException e) {
                e.printStackTrace();
            }
            try {
                String c = convertStatement(in.nextLine());
                Object ret = engine.eval(c);
                Object ret2 = engine2.eval(replaceFloat(c));
                if ((ret2 instanceof Double)) {
                    if ((Double) ret2 > 1e30 || (Double) ret2 < -1e30) {
                        out.write(String.format("%.6f\n", ret));
                    } else if (ret instanceof Integer) {
                        out.write(String.format("%d\n", ret));
                    } else if (Double.isNaN((Double) ret)) {
                        out.write("No Answer");
                    } else {
                        out.write(String.format("%.0f\n", ret));
                    }
                } else if (ret instanceof Integer) {
                    out.write(String.format("%d\n", ret));
                } else if (Double.isNaN((Double) ret)) {
                    out.write("No Answer");
                } else {
//                    out.write("No Answer");
                    out.write(String.format("%0.f\n", ret));
                }
            } catch (Exception e) {
                out.write("No Answer");
//                System.out.println("No Answer" + e.toString());
            }
        }
    }
}
