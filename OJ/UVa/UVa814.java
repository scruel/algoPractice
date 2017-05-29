package algsPractice.OJ.UVa;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Scruel on 2017/4/21.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #simulate
 */
public class UVa814 {
    static HashSet<String> set = new HashSet<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        String[] rts;
        //section 1, get MTAs
        while (!"*".equals(s = bfr.readLine())) {
            rts = s.split("\\s+");
            String mta = rts[1];
            int n = Integer.parseInt(rts[2]);
            for (int i = 0; i < n; i++) {
                set.add(rts[i + 3] + "@" + mta);
            }
        }

        while (!"*".equals(s = bfr.readLine())) {
            //read sender and receiver
            bfr.readLine();
            rts = s.split("\\s+");
            String tmpMail = rts[0];
            int index = tmpMail.indexOf("@");
            String sName = tmpMail.substring(0, index);
            String sMTA = tmpMail.substring(index + 1, tmpMail.length());
            HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
            HashMap<Integer, String> reMap = new HashMap<Integer, String>();

            for (int i = 1; i < rts.length; i++) {
                tmpMail = rts[i];
                index = tmpMail.indexOf("@");
                String rName = tmpMail.substring(0, index);
                String rMTP = tmpMail.substring(index + 1, tmpMail.length());
                if (map.containsKey(rMTP)) {
                    if (!map.get(rMTP).contains(rName))
                        map.get(rMTP).add(rName);
                } else {
                    reMap.put(reMap.size(), rMTP);
                    LinkedList<String> tmpSet = new LinkedList<String>();
                    tmpSet.add(rName);
                    map.put(rMTP, tmpSet);
                }
            }

            //read content
            StringBuilder content = new StringBuilder();
            while (!"*".equals(s = bfr.readLine()))
                content.append("     " + s + "\n");

            for (int i = 0; i < reMap.size(); i++) {
                String rMTA = reMap.get(i);
                LinkedList<String> receiverList = map.get(rMTA);
                int vaildSum = 0;
                bfw.write("Connection between " + sMTA + " and " + rMTA + "\n");
                bfw.write("     HELO " + sMTA + "\n     250\n");
                bfw.write("     MAIL FROM:<" + sName + "@" + sMTA + ">\n     250\n");
                if (receiverList.size() > 0) {
                    for (int j = 0; j < receiverList.size(); j++) {
                        String rName = receiverList.get(j);
                        String tmpR = rName + "@" + rMTA;
                        bfw.write("     RCPT TO:<" + rName + "@" + rMTA + ">\n");
                        if (set.contains(tmpR)) {
                            vaildSum++;
                            bfw.write("     250\n");
                        } else {
                            bfw.write("     550\n");
                        }
                    }
                }
                if (vaildSum > 0) {
                    bfw.write("     DATA\n     354\n");
                    bfw.write(content.toString());
                    bfw.write("     .\n     250\n");
                }
                bfw.write("     QUIT\n     221\n");


            }


        }
        bfw.close();
        bfr.close();
    }
}
