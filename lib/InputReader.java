package algsPractice.lib;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.InputMismatchException;

/**
 * Created by Scruel on 2017/5/29.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class InputReader {
  //TODO 中文读写
  private static final int BUFFER_SIZE = 32768; // change to 1024;
  private InputStream stream;
  //    private final InputStream stream= new FileInputStream(new File("dec.in"));
  private final String charsetName = "UTF-8";
  private byte[] buf = new byte[BUFFER_SIZE];
  private CharBuffer charBuffer;
  //    private byte[] buf = new byte[1024];
  private int curChar;
  private int numChars;

  public InputReader(InputStream stream) {
    charBuffer = CharBuffer.allocate(BUFFER_SIZE);
    this.stream = stream;
  }

  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    int n = in.nextInt();
    System.out.println(n);
  }

  public int read() {
    if (numChars == -1) {
      // throw new InputMismatchException();
      return -1;
    }
    if (curChar >= numChars) {
      curChar = 0;
      try {
        numChars = stream.read(buf);
      } catch (IOException var1) {
        return -1;
      }
      if (numChars <= 0) {
        //throw new InputMismatchException();
        return -1;
      }
    }
    return buf[curChar++];
  }

  public char nextChar() {
    int c;
    while (isSpaceChar(c = read()))
      ;
    return (char) c;
  }
  //     String readString() {
  //        int length = nextInt();
  //        if (length < 0) {
  //            return null;
  //        } else {
  //            byte[] bytes = new byte[length];
  //
  //            for (int i = 0; i < length; ++i) {
  //                bytes[i] = (byte) nextString();
  //            }
  //
  //            try {
  //                return new String(bytes, charsetName);
  //            } catch (UnsupportedEncodingException var4) {
  //                return new String(bytes);
  //            }
  //        }
  //    }

  public int peek() {
    if (numChars == -1) {
      return -1;
    }
    else {
      if (curChar >= numChars) {
        curChar = 0;

        try {
          numChars = stream.read(buf);
        } catch (IOException var2) {
          return -1;
        }

        if (numChars <= 0) {
          return -1;
        }
      }

      return buf[curChar];
    }
  }

  public String nextLine() {
    int c;
    while (isEndline(c = read()) && c != -1) {
    }
    if (c == -1) {
      return null;
    }
    StringBuilder res = new StringBuilder();
    do {
      res.append((char) c);
    } while (!isEndline(c = read()));

    return res.toString();
  }

  public String readLine() {return nextLine();}

  public String nextString() {
    int c;
    while (isSpaceChar(c = read()) && c != -1) {
      ;
    }
    if (c == -1) {
      return null;
    }

    StringBuilder res = new StringBuilder();
    do {
      res.appendCodePoint(c);
    } while (!isSpaceChar(c = read()));

    return res.toString();
  }

  public char[] nextStringChars() {
    return nextString().toCharArray();
  }

  public int nextInt() {
    //        return Integer.parseInt(nextString());
    int c;
    while (isSpaceChar(c = read())) {
      ;
    }
    int sgn = 1;
    if (c == 45) {
      sgn = -1;
      c = read();
    }
    int res = 0;
    while (c >= 48 && c <= 57) {
      res *= 10;
      res += c - 48;
      c = peek();
      if (!isNumber(c)) {
        return res * sgn;
      }
      read();
    }
    throw new InputMismatchException();
  }

  public long nextLong() {
    //            return Long.parseLong(nextString());
    int c;
    while (isSpaceChar(c = read())) {
      ;
    }
    int sgn = 1;
    if (c == 45) {
      sgn = -1;
      c = read();
    }
    long res = 0L;
    while (c >= 48 && c <= 57) {
      res *= 10L;
      res += (long) (c - 48);
      c = peek();
      if (!isNumber(c)) {
        return res * (long) sgn;
      }
      read();
    }
    throw new InputMismatchException();
  }

  public double nextDouble() {
    //        return Double.parseDouble(nextString());
    int c;
    while (isSpaceChar(c = read())) {
      ;
    }
    int sgn = 1;
    if (c == 45) {
      sgn = -1;
      c = read();
    }

    double res = 0.0D;

    while (true) {
      if (!isSpaceChar(c) && c != 46) {
        //101='e' 69='E'
        if (c != 101 && c != 69) {
          if (c >= 48 && c <= 57) {
            res *= 10.0D;
            res += (double) (c - 48);
            c = read();
            continue;
          }
          throw new InputMismatchException();
        }

        return res * Math.pow(10.0D, (double) nextInt());
      }
      //46='.'
      if (c == 46) {
        c = peek();
        for (double m = 1.0D; isNumber(c); c = peek()) {
          if (c == 101 || c == 69) {
            return res * Math.pow(10.0D, (double) nextInt());
          }

          if (c < 48 || c > 57) {
            throw new InputMismatchException();
          }

          m /= 10.0D;
          res += (double) (c - 48) * m;
          read();
        }
      }

      return res * (double) sgn;
    }
  }

  public BigDecimal nextBigDecimal() {
    return new BigDecimal(nextString());
  }

  public BigInteger nextBigInteger() {
    return new BigInteger(nextString());
  }

  public BigInteger nextBigInteger(int radix) {
    return new BigInteger(nextString(), radix);
  }

  //    public char[] nextCharArray(int size) {
  //        char[] array = new char[size];
  //        for (int i = 0; i < size; i++) array[i] = nextChar();
  //        return array;
  //    }

  public int[] nextIntArray(int size) {
    int[] array = new int[size];
    for (int i = 0; i < size; i++)
      array[i] = nextInt();
    return array;
  }

  public void nextIntArray(int[] array, int size) {
    for (int i = 0; i < size; i++)
      array[i] = nextInt();
  }

  public int[][] nextIntMap(int n, int m) {
    int[][] map = new int[n][m];
    for (int i = 0; i < n; i++)
      map[i] = nextIntArray(m);
    return map;
  }

  public void nextIntMap(int[][] map, int n, int m) {
    for (int i = 0; i < n; i++)
      map[i] = nextIntArray(m);
  }

  public long[] nextLongArray(int size) {
    long[] array = new long[size];
    for (int i = 0; i < size; i++)
      array[i] = nextLong();
    return array;
  }

  public void nextLongArray(long[] array, int size) {
    for (int i = 0; i < size; i++)
      array[i] = nextLong();
    //        return array;
  }

  public long[][] nextLongMap(int n, int m) {
    long[][] map = new long[n][m];
    for (int i = 0; i < n; i++)
      map[i] = nextLongArray(m);
    return map;
  }

  public void nextLongMap(long[][] map, int n, int m) {
    for (int i = 0; i < n; i++)
      map[i] = nextLongArray(m);
  }

  public double[] nextDoubleArray(int size) {
    double[] array = new double[size];
    for (int i = 0; i < size; i++)
      array[i] = nextDouble();
    return array;
  }

  public void nextDoubleArray(double[] array, int size) {
    for (int i = 0; i < size; i++)
      array[i] = nextDouble();
  }

  public double[][] nextDoubleMap(int n, int m) {
    double[][] map = new double[n][m];
    for (int i = 0; i < n; i++)
      map[i] = nextDoubleArray(m);
    return map;
  }

  public void nextDoubleMap(double[][] map, int n, int m) {
    for (int i = 0; i < n; i++)
      map[i] = nextDoubleArray(m);
  }

  public String[] nextStringArray(int n) {
    String[] array = new String[n];
    for (int i = 0; i < n; i++)
      array[i] = nextString();
    return array;
  }

  public void nextStringArray(String[] array, int n) {
    for (int i = 0; i < n; i++)
      array[i] = nextString();
  }

  public char readCharacter() {
    int c;
    while (isSpaceChar(c = read())) {
      ;
    }
    return (char) c;
  }

  public boolean readBoolean() {return nextInt() == 1;}

  public <E extends Enum<E>> Enum readEnum(Class<E> c) {
    String name = nextString();
    if (name == null) {
      return null;
    }
    else {
      Enum[] var3 = c.getEnumConstants();
      int var4 = var3.length;

      for (int var5 = 0; var5 < var4; ++var5) {
        E e = (E) var3[var5];
        if (e.name().equals(name)) {
          return e;
        }
      }

      throw new EnumConstantNotPresentException(c, name);
    }
  }

  private boolean isNumber(int c) {
    return c >= 48 && c <= 57;
  }

  public boolean isExhausted() {
    int c;
    while (isSpaceChar(c = peek()) && c != -1) {
      read();
    }
    return c == -1;
  }

  private boolean isSpaceChar(int c) {
    return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
    //' ','\n','\r','\t'
  }

  private boolean isEndline(int c) {
    return c == 10 || c == 13 || c == -1;
  }
}
