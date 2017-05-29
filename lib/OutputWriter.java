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
    private PrintStream psOut = null;
    //    private BufferedWriter bfw;
    private StringBuilder stringBuilder = null;
    private int cnt = 0;

    public static void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        OutputWriter writer = new OutputWriter(System.out);
        writer.write("100");
        writer.close();
    }


    public OutputWriter(Writer out) {
        this.out = out;
        stringBuilder = new StringBuilder(1 << 16);
    }

    //
    public OutputWriter(OutputStream out) {
        this(new BufferedWriter(new OutputStreamWriter(out), 1 << 16));
        if (out instanceof java.io.PrintStream) {
            psOut = (PrintStream) out;
        }
    }

    //    public OutputWriter write(Object... objects) {
    public void write(Object... objects) {
//        try {
        for (int i = 0; i < objects.length; ++i) {
//                if (i != 0) {
//                    stringBuilder.append(32);
//                }
//                stringBuilder.append(Arrays.toString(objects[i].toString().getBytes("UTF-8")));
            stringBuilder.append(objects[i].toString());
            if (psOut == null) flush();
//            if (stringBuilder.length())
        }
//        return this;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void writeln(Object... objects) {
//    public OutputWriter writeln(Object... objects) {
        write(objects);
        write(10);
//        return this;
    }

    public void flush() {
        try {
            out.write(stringBuilder.toString());
            stringBuilder.setLength(0);
//            if (out instanceof StringWriter) {
//                 ((StringWriter)out).getBuffer().setLength(0);
//            }
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


//    private final OutputStream out;
//
//    public OutputWriter(OutputStream outputStream) {
//        out = outputStream;
//    }
//
//    public void print(Object... objects) {
//        try {
//            for (int i = 0; i < objects.length; ++i) {
//                if (i != 0) {
//                    out.write(32);
//                }
//
//                out.write(objects[i].toString().getBytes("UTF-8"));
//            }
//
//        } catch (IOException var3) {
//            throw new RuntimeException(var3);
//        }
//    }
//
//    public void printLine(Object... objects) {
//        print(objects);
//
//        try {
//            out.write(10);
//        } catch (IOException var3) {
//            throw new RuntimeException(var3);
//        }
//    }
//
//    public void close() {
//        try {
//            out.close();
//        } catch (IOException var2) {
//            throw new RuntimeException(var2);
//        }
//    }
//
//    public void flush() {
//        try {
//            out.flush();
//        } catch (IOException var2) {
//            throw new RuntimeException(var2);
//        }
//    }
//
//    public void printString(String s) {
//        if (s == null) {
//            printLine(new Object[]{Integer.valueOf(-1)});
//        } else {
//            try {
//                printLine(new Object[]{Integer.valueOf(s.getBytes("UTF-8").length), s});
//            } catch (UnsupportedEncodingException var3) {
//                throw new RuntimeException(var3);
//            }
//        }
//
//    }
//
//    public void printBoolean(boolean b) {
//        printLine(new Object[]{Integer.valueOf(b ? 1 : 0)});
//    }
//
//    public void printEnum(Enum e) {
//        printString(e == null ? null : e.name());
//    }

}
