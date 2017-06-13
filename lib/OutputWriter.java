package algsPractice.lib;


import java.io.*;
import java.util.Arrays;

/**
 * Created by Scruel on 2017/5/26.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class OutputWriter {
    protected Writer out = null;
    boolean debug = false;
    private PrintStream psOut = null;
    //    private BufferedWriter bfw;
    private StringBuilder stringBuilder = null;
//    private int cnt = 0;

    public OutputWriter(Writer out) {
        this.out = out;
        stringBuilder = new StringBuilder(1 << 16);
    }

    public OutputWriter(OutputStream out) {
        this(new BufferedWriter(new OutputStreamWriter(out), 1 << 16));
        if (out instanceof java.io.PrintStream) {
            psOut = (PrintStream) out;
        }
    }

    public static void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        OutputWriter writer = new OutputWriter(System.out);
        writer.write("100");
        writer.close();
    }

    public void write(Object... objects) {
        for (int i = 0; i < objects.length; ++i) {
            stringBuilder.append(objects[i].toString());
            if (debug) System.out.print(objects[i]);
            if (psOut == null) flush();
        }
    }

    public void writeln(Object... objects) {
        write(objects);
        write('\n');
    }

    public void writef(String f, Object... objects) {
        write(String.format(f, objects));
    }


    public void flush() {
        try {
            out.write(stringBuilder.toString());
            stringBuilder.setLength(0);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            out.write(stringBuilder.toString());
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
