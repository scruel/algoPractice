package algsPractice.lib;

import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * Created by Scruel on 2017/5/26.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class InputReader {
    private final BufferedReader bfr;
    StringTokenizer st;
//    private final InputStream stream;
//    private byte[] buf = new byte[1024];
//    private int curChar;
//    private int numChars;

    public InputReader(InputStream stream) {
//        this.stream = stream;
        bfr = new BufferedReader(new InputStreamReader(stream), 1 << 16);
    }

    public String nextToken() {
        try {
            while (st == null || !st.hasMoreElements())
                st = new StringTokenizer(bfr.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public float nextFloat() {
        return Float.parseFloat(nextToken());
    }

    public BigDecimal nextBigDecimal() {
        return new BigDecimal(nextToken());
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
        for (int i = 0; i < size; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    public void nextIntArray(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            array[i] = nextInt();
        }
//        return array;
    }

    public double[] nextDoubleArray(int size) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = nextDouble();
        }
        return array;
    }

    public void nextDoubleArray(double[] array, int size) {
        for (int i = 0; i < size; i++) {
            array[i] = nextDouble();
        }
//        return array;
    }


//
//    public int read() {
//        if (this.numChars == -1) {
//            throw new InputMismatchException();
//        } else {
//            if (this.curChar >= this.numChars) {
//                this.curChar = 0;
//
//                try {
//                    this.numChars = this.stream.read(this.buf);
//                } catch (IOException var2) {
//                    throw new InputMismatchException();
//                }
//
//                if (this.numChars <= 0) {
//                    return -1;
//                }
//            }
//
//            return this.buf[this.curChar++];
//        }
//    }
//
//    public int peek() {
//        if (this.numChars == -1) {
//            return -1;
//        } else {
//            if (this.curChar >= this.numChars) {
//                this.curChar = 0;
//
//                try {
//                    this.numChars = this.stream.read(this.buf);
//                } catch (IOException var2) {
//                    return -1;
//                }
//
//                if (this.numChars <= 0) {
//                    return -1;
//                }
//            }
//
//            return this.buf[this.curChar];
//        }
//    }
//
//    public int readInt() {
//        int c;
//        for (c = this.read(); isSpaceChar(c); c = this.read()) {
//            ;
//        }
//
//        int sgn = 1;
//        if (c == 45) {
//            sgn = -1;
//            c = this.read();
//        }
//
//        int res = 0;
//
//        while (c >= 48 && c <= 57) {
//            res *= 10;
//            res += c - 48;
//            c = this.read();
//            if (isSpaceChar(c)) {
//                return res * sgn;
//            }
//        }
//
//        throw new InputMismatchException();
//    }
//
//    public long readLong() {
//        int c;
//        for (c = this.read(); isSpaceChar(c); c = this.read()) {
//            ;
//        }
//
//        int sgn = 1;
//        if (c == 45) {
//            sgn = -1;
//            c = this.read();
//        }
//
//        long res = 0L;
//
//        while (c >= 48 && c <= 57) {
//            res *= 10L;
//            res += (long) (c - 48);
//            c = this.read();
//            if (isSpaceChar(c)) {
//                return res * (long) sgn;
//            }
//        }
//
//        throw new InputMismatchException();
//    }
//
//    public String readString() {
//        int length = this.readInt();
//        if (length < 0) {
//            return null;
//        } else {
//            byte[] bytes = new byte[length];
//
//            for (int i = 0; i < length; ++i) {
//                bytes[i] = (byte) this.read();
//            }
//
//            try {
//                return new String(bytes, "UTF-8");
//            } catch (UnsupportedEncodingException var4) {
//                return new String(bytes);
//            }
//        }
//    }
//
//    public String readToken() {
//        int c;
//        while (isSpaceChar(c = this.read())) {
//            ;
//        }
//
//        StringBuilder result = new StringBuilder();
//        result.appendCodePoint(c);
//
//        while (!isSpaceChar(c = this.read())) {
//            result.appendCodePoint(c);
//        }
//
//        return result.toString();
//    }
//
//    public static boolean isSpaceChar(int c) {
//        return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
//    }
//
//    public char readCharacter() {
//        int c;
//        for (c = this.read(); isSpaceChar(c); c = this.read()) {
//            ;
//        }
//
//        return (char) c;
//    }
//
//    public double readDouble() {
//        int c;
//        for (c = this.read(); isSpaceChar(c); c = this.read()) {
//            ;
//        }
//
//        int sgn = 1;
//        if (c == 45) {
//            sgn = -1;
//            c = this.read();
//        }
//
//        double res = 0.0D;
//
//        while (true) {
//            if (!isSpaceChar(c) && c != 46) {
//                if (c != 101 && c != 69) {
//                    if (c >= 48 && c <= 57) {
//                        res *= 10.0D;
//                        res += (double) (c - 48);
//                        c = this.read();
//                        continue;
//                    }
//
//                    throw new InputMismatchException();
//                }
//
//                return res * Math.pow(10.0D, (double) this.readInt());
//            }
//
//            if (c == 46) {
//                c = this.read();
//
//                for (double m = 1.0D; !isSpaceChar(c); c = this.read()) {
//                    if (c == 101 || c == 69) {
//                        return res * Math.pow(10.0D, (double) this.readInt());
//                    }
//
//                    if (c < 48 || c > 57) {
//                        throw new InputMismatchException();
//                    }
//
//                    m /= 10.0D;
//                    res += (double) (c - 48) * m;
//                }
//            }
//
//            return res * (double) sgn;
//        }
//    }
//
//    public boolean isExhausted() {
//        int value;
//        while (isSpaceChar(value = this.peek()) && value != -1) {
//            this.read();
//        }
//
//        return value == -1;
//    }
//
//    public boolean readBoolean() {
//        return this.readInt() == 1;
//    }
//
//    public <E extends Enum<E>> Enum readEnum(Class<E> c) {
//        String name = this.readString();
//        if (name == null) {
//            return null;
//        } else {
//            Enum[] var3 = (Enum[]) c.getEnumConstants();
//            int var4 = var3.length;
//
//            for (int var5 = 0; var5 < var4; ++var5) {
//                E e = (E) var3[var5];
//                if (e.name().equals(name)) {
//                    return e;
//                }
//            }
//
//            throw new EnumConstantNotPresentException(c, name);
//        }
//    }
}
