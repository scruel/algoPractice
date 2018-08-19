package algsPractice.lib;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Scruel Tao
 * @version 1.0
 */
public class InputReader {
  private final String charsetName = "UTF-8";
  private BufferedReader reader;
  private StringTokenizer tokenizer;

  public InputReader(InputStream stream) {
    tokenizer = null;
    try {
      reader = new BufferedReader(new InputStreamReader(stream, charsetName), 32768);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }

  public int read() {
    if (tokenizer != null && tokenizer.hasMoreTokens()) {
      throw new RuntimeException("Could not read new line during line operations.");
    }
    try {
      return reader.read();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public String readLine() {
    if (tokenizer != null && tokenizer.hasMoreTokens()) {
      throw new RuntimeException("Could not read new line during line operations.");
    }
    try {
      return reader.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public String nextString() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      String s = readLine();
      if (s == null) return null;
      tokenizer = new StringTokenizer(s);
    }
    return tokenizer.nextToken();
  }

  public int nextInt() {
    return Integer.parseInt(nextString());
  }

  public long nextLong() {
    return Long.parseLong(nextString());
  }

  public double nextDouble() {
    return Double.parseDouble(nextString());
  }
}
