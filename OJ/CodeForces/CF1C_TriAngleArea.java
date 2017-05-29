package algsPractice.OJ.CodeForces;

import java.util.Scanner;
//http://codeforces.com/problemset/problem/1/C

/**
 * Created by Administrator on 2016/3/29.
 * #geometry
 */
public class CF1C_TriAngleArea {
    static final double EPS = 1E-6;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        double x3 = in.nextDouble();
        double y3 = in.nextDouble();

        double a = distance(x1, y1, x2, y2);
        double b = distance(x1, y1, x3, y3);
        double c = distance(x2, y2, x3, y3);

        //海伦公式计算面积
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        //System.out.println(s);
        double r = a * b * c / Math.sqrt((a + b + c) * (b + c - a) * (c + a - b) * (a + b - c));//计算三角形外接圆半径
        double n = Math.PI / gcd(gcd(angle(a, b, c), angle(a, c, b)), angle(b, c, a));//边数

        double area = n / 2 * r * r * Math.sin(2 * Math.PI / n);//那么这就是一个正2π/A边形.
        System.out.println(String.format("%.8f", area));
        in.close();
    }

    static double gcd(double x, double y)//经过两次判断得到最大角,求这三个角的最大公约数为A
    {
        while (Math.abs(x) > EPS && Math.abs(y) > EPS) {
            if (x > y)
                x -= Math.floor(x / y) * y;
            else
                y -= Math.floor(y / x) * x;
        }
//                System.out.println("-----------------");
//                System.out.println(x + y);
        return x + y;
//                if (x > y)
//                        return y;
//                else
//                        return x;
    }

    static double angle(double a, double b, double c) {
        double result = Math.acos((a * a + b * b - c * c) / (2 * a * b));//(在三角形中cosA=(b^2+c^2-a^2)/(2*b*c) 余弦定理 )

        //System.out.println(result);
        return result;
    }

    static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));//计算两点间的距离
    }
}

