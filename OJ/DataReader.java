package algsPractice.OJ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Scruel on 2017/4/15.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class DataReader {
        public static FileInputStream getDataReader() throws FileNotFoundException {
                return new FileInputStream("K:\\Program\\Programing\\javaDev\\myProjects\\Algorithm\\src\\algsPractice\\OJ\\data.txt");
        }

        public static void main(String[] args) throws Exception {
                FileInputStream fs = getDataReader();
                System.out.println(fs.read());
        }
}
