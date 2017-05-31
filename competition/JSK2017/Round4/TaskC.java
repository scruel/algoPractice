package algsPractice.competition.JSK2017.Round4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

public class TaskC {
    double EPS = 1e-6;
    int n;
    double[][] nums;

    class Pair implements Comparable<Pair> {
        double x;
        double y;
        double scale;
        double theta;

        @Override public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + Double.valueOf(x).hashCode();
            result = prime * result + Double.valueOf(y).hashCode();
            result = prime * result + Double.valueOf(scale).hashCode();
            result = prime * result + Double.valueOf(theta).hashCode();
//          result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override public boolean equals(Object obj) {
            Pair tm = (Pair) obj;
            if (Math.abs(this.x - tm.x) >= EPS) return false;
            if (Math.abs(this.y - tm.y) >= EPS) return false;
            if (Math.abs(this.scale - tm.scale) >= EPS) return false;
            if (Math.abs(this.theta - tm.theta) >= EPS) return false;
            return true;
        }

        @Override public int compareTo(Pair o) {
            if (this.hashCode() < o.hashCode()) return -1;
            else if (this.hashCode() > o.hashCode()) return 1;
            return 0;
        }
    }

    boolean check(double dx, double dy, double scale, double t) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            double x = nums[i][0];
            double y = nums[i][1];
            double xp = nums[i][2];
            double yp = nums[i][3];
            double xpp = scale * (x * Math.cos(t) - y * Math.sin(t)) + dx;
            double ypp = scale * (x * Math.sin(t) - y * Math.cos(t)) + dy;
            if (Math.abs(xp - xpp) < EPS && Math.abs(yp - ypp) < EPS) cnt++;
            if (cnt > n / 2) return true;
        }

        return false;
    }

    double C(double x, double y, double xp, double yp, double dx, double dy, double scale, double t) {
        double xpp = scale * (x * Math.cos(t) - y * Math.sin(t)) + dx;
        double ypp = scale * (x * Math.sin(t) - y * Math.cos(t)) + dy;
        return (xpp - xp) * (ypp - yp);
//        return (xp - xpp) + (yp - ypp);

    }


    public void solve(int testNumber, InputReader in, OutputWriter out) {

//        double x = 0;
//        double y = 0;
//        double t = 1.5707963268;
//        double dx = -1;
//        double dy = 1;
//        System.out.println((x * Math.cos(t) - y * Math.sin(t)) + " " +
//            (x * Math.sin(t) - y * Math.cos(t)));
////
        n = in.nextInt();
        double dx, dy;
//        Math.PI
        nums = new double[n][4];
        for (int i = 0; i < n; i++) {
//            double x = in.nextInt();
//            double y = in.nextInt();
//            double xp = in.nextInt();
//            double yp = in.nextInt();
            for (int j = 0; j < 4; j++)
                nums[i][j] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            dx = nums[i][2] - nums[i][0];
            dy = nums[i][3] - nums[i][1];

            for (int scale = 1; scale <= 10; scale++) {
                double lb = 0;
                double ub = 2 * Math.PI;
                int cnt = 0;
                while (ub - lb > 1 && cnt < 100000) {
                    double mid = (lb + ub) / 2.0;
                    if (C(nums[i][0], nums[i][1], nums[i][2], nums[i][3], dx, dy, scale, mid) > 0) lb = mid;
                    else ub = mid;
                    if (check(dx, dy, scale, mid)) {
//                        out.write(String.format("%.10f", mid) + "\n");
                        out.write(mid + "\n");
                        out.write(scale + "\n");
                        out.write(dx + " " + dy);
                        return;
                    }
                    cnt++;
                }
            }
        }

        out.write(0 + "\n");
        out.write(1 + "\n");
        out.write(0 + " " + 0);

//        if (flag) {
//            out.write(dx + " " + dy);
//        } else {
//            Pair mp = null;
//            int max = 0;
//            for (Map.Entry<Pair, Integer> en : map.entrySet()) {
//                if (en.getValue().compareTo(max) > 0) {
//                    max = en.getValue();
//                    mp = en.getKey();
//                }
//            }
//            out.write(mp.x + " " + mp.y);
//
//        }
    }
}
