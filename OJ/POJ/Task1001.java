package algsPractice.OJ.POJ;

import java.math.BigDecimal;
import java.util.Scanner;
//大整数乘法，当然还有自定义的写法

public class Task1001 {

    static void solve(BigDecimal a, int b) {
        String res = a.pow(b).toString();
        //99.999  25
        if (res.contains("E-")) {
            int num = Integer.parseInt(res.substring(res.indexOf("-") + 1, res.length()));
            res = res.substring(0, res.indexOf('.')) + res.substring(res.indexOf('.') + 1, res.indexOf("E"));

            for (int i = 0; i < num - 1; i++) {
                res = "0" + res;
            }
            res = "." + res;
        }

        if (res.startsWith("0.")) {
            res = res.substring(res.indexOf('.'), res.length());
        }

        if (a.compareTo(BigDecimal.ZERO) == 0) {
            res = "0";
        } else if (res.charAt(res.length() - 1) == '0') {
            //后导不为0
            while (res.charAt(res.length() - 1) == '0')
                res = res.substring(0, res.lastIndexOf("0"));
        }

        if (res.endsWith(".")) {
            res = res.substring(0, res.length() - 1);
        }

        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s;
        while (null != (s = input.nextLine()) && s.length() != 0) {
            String[] rTs = s.split("\\s+");
            BigDecimal a = new BigDecimal(rTs[0]);
            int b;
            if (rTs.length != 1)
                b = Integer.parseInt(rTs[1]);
            else
                b = input.nextInt();
            solve(a, b);
        }
    }

}