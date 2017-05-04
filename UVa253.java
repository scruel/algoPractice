package practice.algsoj;

import java.io.*;

/**
 * Created by Scruel on 2017/4/19.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class UVa253 {

        public static void main(String[] args) throws IOException {
                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

                String s;
                while ((s = bfr.readLine()) != null && s.length() != 0) {
                        if (solve(s))
                                bfw.write("TRUE\n");
                        else
                                bfw.write("FALSE\n");

                }
                bfw.close();
                bfr.close();
        }

        static boolean isSame(char[] cube1, char[] cube2) {
                for (int i = 0; i < 6; i++) {
                        if (cube1[i] != cube2[i])
                                return false;
                }
                return true;
        }

        static boolean solve2(String s) {
                char[] cube1 = s.substring(0, 6).toCharArray();
                char[] cube2 = s.substring(6, 12).toCharArray();
                boolean[] used = new boolean[3];
//                要檢驗兩個正方體的塗色是否相同，就檢查兩個正方體的三組對面(1-6,2-5,3-4)是否能夠根據交換順序(每一組對面內的兩個顏色可互換，三組對面的順序可交換)來達成相同的結果，即可得解。
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                                if (!used[j] &&
                                        ((cube2[j] == cube1[i] && cube2[5 - j] == cube1[5 - i]) ||
                                                cube2[5 - j] == cube1[i] && cube2[j] == cube1[5 - i])) {
                                        used[j] = true;
                                        break;
                                }
                        }
                }
                if (used[0] && used[1] && used[2])
                        return true;
                return false;
        }


        static boolean solve(String s) {
                char[] cube1 = s.substring(0, 6).toCharArray();
                char[] cube2 = s.substring(6, 12).toCharArray();
                //直接将转换的情况列出来，有的时候在条件比较小的时候，无需考虑规律，打表！！！
                int[][] dir = {{0, 1, 2, 3, 4, 5}, {1, 5, 2, 3, 0, 4}, {2, 1, 5, 0, 4, 3}, {3, 1, 0, 5, 4, 2},
                        {4, 0, 2, 3, 5, 1}, {5, 4, 2, 3, 1, 0}};


                //规律
                char[] temp = new char[6];
                for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                                temp[j] = cube1[dir[i][j]];
                        }
                        for (int j = 0; j < 4; j++) {
                                char cha;
                                cha = temp[1];
                                temp[1] = temp[2];
                                temp[2] = temp[4];
                                temp[4] = temp[3];
                                temp[3] = cha;
                                if (isSame(temp, cube2)) return true;
                        }
                }
                return false;
        }
}
