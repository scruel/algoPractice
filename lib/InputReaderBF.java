package algsPractice.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * Created by Scruel on 2017/5/26.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class InputReaderBF {
    private final BufferedReader bfr;
    StringTokenizer st;

    public InputReaderBF(InputStream stream) {
//        this.stream = stream;
        bfr = new BufferedReader(new InputStreamReader(stream), 32768);
    }

    public String nextString() {
        try {
            while (st == null || !st.hasMoreElements()) st = new StringTokenizer(bfr.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextString());
    }

    public long nextLong() {return Long.parseLong(nextString());}

    public double nextDouble() {
        return Double.parseDouble(nextString());
    }

    public float nextFloat() {
        return Float.parseFloat(nextString());
    }

    public BigDecimal nextBigDecimal() {
        return new BigDecimal(nextString());
    }

    public String nextLineSet() {
        String str = null;
        try {
            str = bfr.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        st = new StringTokenizer(str);
        return str;
    }

    public String readLine() {
        return nextLine();
    }

    public String nextLine() {
        try {
            return bfr.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int[] nextIntArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) array[i] = nextInt();
        return array;
    }

    public void nextIntArray(int[] array, int size) {
        for (int i = 0; i < size; i++) array[i] = nextInt();
    }

    public double[] nextDoubleArray(int size) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) array[i] = nextDouble();
        return array;
    }

    public void nextDoubleArray(double[] array, int size) {
        for (int i = 0; i < size; i++) array[i] = nextDouble();
    }
}
