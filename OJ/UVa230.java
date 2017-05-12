package algsPractice.OJ;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Scruel on 2017/4/27.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #simulate
 */
public class UVa230 {
        static HashMap<String, Book> bookMap = new HashMap<String, Book>();
        static List<Book> sortedShelf = new LinkedList<Book>();
        static List<Book> returnedShelf = new LinkedList<Book>();
        static List<Book> borrowedShelf = new LinkedList<Book>();

        public static void main(String[] args) throws IOException {
                BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

                String s;
                while ((s = bfr.readLine()) != null && !s.isEmpty()) {
                        if ("END".equals(s))
                                break;
                        Book book = new Book();
                        book.bookName = s.substring(1, s.indexOf("\"", 1));
                        book.author = s.substring(s.indexOf("by") + 3, s.length());
                        bookMap.put(book.bookName, book);
                        sortedShelf.add(book);
                }
                Collections.sort(sortedShelf);

                while ((s = bfr.readLine()) != null && !s.isEmpty()) {
                        if ("END".equals(s))
                                break;
                        if ("SHELVE".equals(s)) {
                                Collections.sort(returnedShelf);
                                while (!returnedShelf.isEmpty()) {
                                        Book tmp = returnedShelf.remove(0);
                                        sortedShelf.add(tmp);
                                        Collections.sort(sortedShelf);
                                        int index = sortedShelf.indexOf(tmp);
                                        if (index == 0) {
                                                bfw.write(String.format("Put \"%s\" first\n", tmp.bookName));
                                        } else {
                                                bfw.write(String.format("Put \"%s\" after \"%s\"\n", tmp.bookName, sortedShelf.get(index - 1).bookName));
                                        }
                                }
                                bfw.write("END\n");
                        } else {
//                                System.out.println(s.substring(8, s.length() - 1));
                                Book tmp = bookMap.get(s.substring(8, s.length() - 1));
                                if (s.contains("BORROW")) {
                                        sortedShelf.remove(tmp);
                                        borrowedShelf.add(tmp);
                                } else {

                                        borrowedShelf.remove(tmp);
                                        returnedShelf.add(tmp);
                                }
                        }
                }

                bfw.close();
                bfr.close();
        }

        static class Book implements Comparable<Book> {
                String author;
                String bookName;

                @Override
                public boolean equals(Object obj) {
                        Book tmp = (Book) obj;
                        return bookName.equals(tmp.bookName);
                }

                @Override
                public int compareTo(Book o) {
                        if (author.equals(o.author))
                                return bookName.compareTo(o.bookName);
                        return author.compareTo(o.author);
                }
        }

}
