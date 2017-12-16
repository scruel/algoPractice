package algsPractice.lib;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;

/**
 * Created by Scruel on 2017/5/26.  
 * Github : https://github.com/scruel
 */
public class OutputWriter {
  protected Writer out = null;
  private PrintStream stream = null;
  //    private BufferedWriter bfw;
  //    private int cnt = 0;

  public OutputWriter(Writer writer) {
    this.out = writer;
  }

  public OutputWriter(OutputStream out) {
    this(new BufferedWriter(new OutputStreamWriter(out), 1 << 16));
    if (out instanceof java.io.PrintStream) {
      stream = (PrintStream) out;
    }
  }

  public void write(Object... objects) {
    for (int i = 0; i < objects.length; ++i) {
      try {
        out.write(objects[i].toString());
        if (stream == null) {
          out.flush();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void writeln(Object... objects) {
    write(objects);
    write('\n');
  }

  public void writef(String f, Object... objects) {
    write(String.format(f, objects));
  }

  public void close() {
    try {
      out.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
