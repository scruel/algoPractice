package algsPractice.competition;

import java.io.*;

/**
 * Created by Scruel on 2017/5/6.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Main {
        static int res, n;
        static String nS;

        public static void main(String[] args) throws IOException {
                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
                int t = new Integer(bfr.readLine());
                while (t-- > 0) {
                        nS = bfr.readLine().trim();
                        n = new Integer(nS);
                        res = Integer.MAX_VALUE;
                        if (!bfs("", nS.length() - 1))
                                bfw.write("None\n");
                        else
                                bfw.write(res + "\n");
                }
                bfr.close();
                bfw.close();

        }

        static boolean bfs(String m, int index) {
                if (index < 0)
                        return false;
                int tmpN = arrToInteger(nS, index);
                String tmpNS = String.valueOf(tmpN);
                boolean flag = false;
                for (int i = 0; i < 10; i++) {
                        int tmpM = new Integer(i + m);
                        String tmpMMS = String.valueOf(tmpM * tmpM);
                        //也可以替换为从index,length()-1进行判断
                        if (tmpMMS.endsWith(nS)) {
                                res = tmpM < res ? tmpM : res;
                                flag = true;
                                break;
                        }
                        if (tmpMMS.endsWith(tmpNS)) {
                                flag = bfs(i + m, index - 1);
                        }
                }
                return flag;
        }

        static int arrToInteger(String s, int index) {
                int res = 0;
                int tenPow = 1;
                for (int i = s.length() - 1; i >= index; i--) {
                        res += tenPow * (s.charAt(i) - 48);
                        tenPow *= 10;
                }
                return res;
        }
}
