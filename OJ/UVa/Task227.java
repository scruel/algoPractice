package algsPractice.OJ.UVa;

import java.io.*;

/**
 * Created by Scruel on 2017/4/4.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #string
 */
public class Task227 {
    static char[][] puzzle = new char[10][10];
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
    static int spaceX = 0;
    static int spaceY = 0;
    static int sum = 0;
    static boolean OK;
    static char[] dir = " ABRL".toCharArray();
    static int[] ha = new int[300];
    //  1.使用字符表对应方式来去下一步情况，这样还可以防止非法输入
    static int dy[] = {0, -1, 1, 0, 0};
    static int dx[] = {0, 0, 0, 1, -1};

    static void fillPuz(String s, int y) throws IOException {
        String temp = s;
        if (temp.length() >= 5) {
            temp = s.substring(0, 5);
            puzzle[y] = temp.toCharArray();
            if (temp.indexOf(" ") != -1) {
                spaceY = y;
                spaceX = temp.indexOf(" ");
            }
        } else {
            while (temp.length() < 4) {
                temp += bfr.readLine();
            }
            if (temp.length() == 4 && temp.indexOf(' ') == -1) {
                puzzle[y][0] = s.charAt(0);
                puzzle[y][1] = s.charAt(1);
                puzzle[y][2] = s.charAt(2);
                puzzle[y][3] = s.charAt(3);
                puzzle[y][4] = ' ';
                spaceY = y;
                spaceX = 4;
            } else if (temp.length() != 5) {
                temp += bfr.readLine();
                temp = temp.substring(0, 5);
                puzzle[y] = temp.toCharArray();
                if (temp.indexOf(" ") != -1) {
                    spaceY = y;
                    spaceX = temp.indexOf(" ");
                }
            } else {
                puzzle[y] = temp.toCharArray();
                if (temp.indexOf(" ") != -1) {
                    spaceY = y;
                    spaceX = temp.indexOf(" ");
                }
            }
        }
    }

    //以后的读入都这样，防止意外情况
    static String readLine() throws IOException {
        String res = bfr.readLine();
        while (res.length() == 0) {
            res = bfr.readLine();
        }
        return res;
    }

    static void solve() throws IOException {
        String s;
        s = readLine();
        while (true) {
            if ("Z".equals(s))
                break;
            fillPuz(s, 0);
            s = readLine();
            fillPuz(s, 1);
            s = readLine();
            fillPuz(s, 2);
            s = readLine();
            fillPuz(s, 3);
            s = readLine();
            fillPuz(s, 4);

            //迷宫读入完毕，下面进行迷宫操作
            boolean flag = true;
            while (true) {
                s = readLine();
                for (int i = 0; i < s.length(); i++) {
                    switch (s.charAt(i)) {
                        case 'A':
                            if (!exch(spaceX, spaceY - 1))
                                flag = false;
                            break;
                        case 'R':
                            if (!exch(spaceX + 1, spaceY))
                                flag = false;
                            break;
                        case 'B':
                            if (!exch(spaceX, spaceY + 1))
                                flag = false;
                            break;
                        case 'L':
                            if (!exch(spaceX - 1, spaceY))
                                flag = false;
                            break;
                        case '0':
                            break;
                        //再次强调，他说不会有的东西，一定会有！！！有就为非法输入，直接返回非法！
//                                                default:
//                                                        flag = false;
//                                                        break;
                    }

                }
                if (s.charAt(s.length() - 1) == '0') break;
                if (!flag) {
                    while (true) {
                        s = readLine();
                        if (s.charAt(s.length() - 1) == '0') break;
                    }
                    break;
                }

            }
            //检查输出的时候必须要核对完全
            bfw.write("Puzzle #" + ++sum + ":\n");
            if (flag) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 4; j++) {
                        bfw.write(puzzle[i][j] + " ");
                    }
                    bfw.write(puzzle[i][4] + "\n");
                }
            } else {
                bfw.write("This puzzle has no final configuration." + "\n");
            }
            s = readLine();
            if ("Z".equals(s))
                break;
            bfw.write("\n");

        }

        bfr.close();
        bfw.close();
    }

    static boolean exch(int x, int y) {
        if (x < 0 || y < 0 || x >= 5 || y >= 5)
            return false;
        puzzle[spaceY][spaceX] = puzzle[y][x];
        puzzle[y][x] = ' ';
        spaceX = x;
        spaceY = y;
        return true;
    }

    static boolean init() throws IOException {
        OK = true;
        for (int i = 0; i < 5; i++) {
//                        gets(puzzle[i]);
            puzzle[i] = new char[5];
            //考虑读入数据的问题
            char[] bf = bfr.readLine().toCharArray();
            for (int j = 0; j < 5; j++) {
                puzzle[i][j] = ' ';
            }
            for (int j = 0; j < bf.length && j < 5; j++) {
                puzzle[i][j] = bf[j];
            }
            //只有一个字母的情况，即为Z的情况
            if (bf.length == 1)
                return false;
//                        if (puzzle[i][0] == 'Z')
//                                return false;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (puzzle[i][j] == ' ') {
                    spaceX = j;
                    spaceY = i;
                }
            }
        }
        return true;
    }

    static void run(int t) {
        if (!OK) return;
        //取出
        int nx = spaceX + dx[t], ny = spaceY + dy[t];
        if (t == 0 || nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
            OK = false;
            return;
        }
        exch(nx, ny);
    }


    static void solve2() throws IOException {
        for (int i = 0; i < 5; i++) {
            //保存字符表对应编号，对应dx，dy的具体情况
            ha[dir[i]] = i;
        }

        while (init()) {
            boolean flag = false;
//                        while (scanf("%s%*c", bf)) { 读入一个字符串并忽略其后的一个字符
            String s;
            while ((s = bfr.readLine()).length() != 0) {
                for (int i = 0; i < s.length(); i++) {
//                                        if(bf[i]=='0'&&!bf[i+1]){
                    if (s.charAt(i) == '0') {
                        flag = true;
                        break;
                    }
                    run(ha[s.charAt(i)]);
                }
                if (flag) break;
            }

            if (sum > 0)
                bfw.write("\n");
            bfw.write("Puzzle #" + ++sum + ":\n");
            if (!OK) {
                bfw.write("This puzzle has no final configuration.\n");
            } else {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 4; j++) {
                        bfw.write(puzzle[i][j] + " ");
                    }
                    bfw.write(puzzle[i][4] + "\n");
                }
            }
        }
        bfw.close();
        bfr.close();
    }


    public static void main(String[] args) throws IOException {
        solve2();
    }
}
