package algsPractice.OJ.jisuanke;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task37629 {
    int[][] h = {{1, 0, 1}, {0, 0, 0}, {1, 1, 1}, {1, 1, 1}, {0, 1, 0}, {1, 1, 1}, {1, 1, 1}, {1, 0, 0}, {1, 1, 1}, {1, 1, 1}};
    int[][] s = {{1, 1, 1, 1}, {0, 1, 0, 1}, {0, 1, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {1, 0, 0, 1}, {1, 0, 1, 1}, {0, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 0, 1}};

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int k = in.nextInt();
        char[] chars = in.nextStringChars();

        //橫线
        String hs = getRep('-', k);
        String ws = getRep(' ', k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (h[chars[i] - 48][0] == 1) sb.append(String.format(" %s ", hs));
            else sb.append(String.format(" %s ", ws));
            if (i < chars.length - 1) sb.append(" ");
        }
        out.writeln(trimT(sb));

        for (int j = 0; j < k; j++) {
            sb.setLength(0);
            for (int i = 0; i < chars.length; i++) {
                if (s[chars[i] - 48][0] == 1) sb.append("|");
                else sb.append(" ");
                sb.append(ws);
                if (s[chars[i] - 48][1] == 1) sb.append("|");
                else sb.append(" ");
                if (i < chars.length - 1) sb.append(" ");
            }
            out.writeln(trimT(sb));
        }


        sb.setLength(0);
        for (int i = 0; i < chars.length; i++) {
            if (h[chars[i] - 48][1] == 1) sb.append(String.format(" %s ", hs));
            else sb.append(String.format(" %s ", ws));
            if (i < chars.length - 1) sb.append(" ");
        }
        out.writeln(trimT(sb));

        for (int j = 0; j < k; j++) {
            sb.setLength(0);
            for (int i = 0; i < chars.length; i++) {
                if (s[chars[i] - 48][2] == 1) sb.append("|");
                else sb.append(" ");
                sb.append(ws);
                if (s[chars[i] - 48][3] == 1) sb.append("|");
                else sb.append(" ");
                if (i < chars.length - 1) sb.append(" ");
            }
            out.writeln(trimT(sb));
        }

        sb.setLength(0);
        for (int i = 0; i < chars.length; i++) {
            if (h[chars[i] - 48][2] == 1) sb.append(String.format(" %s ", hs));
            else sb.append(String.format(" %s ", ws));
            if (i < chars.length - 1) sb.append(" ");
        }
        out.writeln(trimT(sb));
        out.writeln();
    }

    String trimT(StringBuilder sb) {
        return sb.toString();
//        int index = sb.length() - 1;
//        for ( ; index >= 0; index--) {
//            if (sb.charAt(index) != ' ') break;
//        }
//        return sb.substring(0, index + 1);
    }

    String getRep(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

}
