package algsPractice.OJ.UVa;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task12171 {
    static final double EPS = 1e-10;
    static final int INF = 0x3f3f3f3f;
    static final long INFL = 0x3f3f3f3f3f3f3f3fL;
    static final int MOD = 1000000007;
    int MAXN = 50 + 5;
    int MAXC = 1000 + 1;
    //original data
    int n;
    int[] x0 = new int[MAXN];
    int[] y0 = new int[MAXN];
    int[] z0 = new int[MAXN];
    int[] x1 = new int[MAXN];
    int[] y1 = new int[MAXN];
    int[] z1 = new int[MAXN];

    //discretization related
    int nx, ny, nz;
    int[] xs = new int[MAXN * 2];
    int[] ys = new int[MAXN * 2];
    int[] zs = new int[MAXN * 2];

    //floodfill related
    int dx[] = {1, -1, 0, 0, 0, 0};
    int dy[] = {0, 0, 1, -1, 0, 0};
    int dz[] = {0, 0, 0, 0, 1, -1};
    int[][][] color = new int[MAXN * 2][MAXN * 2][MAXN * 2];

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int T = in.nextInt();
        while (T-- > 0) {

        }
    }

    class Cell {
        int x, y, z;

        public Cell(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        boolean vaild() {
            return x >= 0 && x < nx - 1 && y >= 0 && y < ny - 1 && z >= 0 && z < nz - 1;
        }

        boolean solid() {
            return color[x][y][z] == 1;
        }

        boolean getVis() {
            return color[x][y][z] == 2;
        }

        void setVis() {
            color[x][y][z] = 2;
        }


//        Cell neighbor(int dir) {
//            return
//        }

    }
}
