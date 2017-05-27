package algsPractice.OJ;


import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/29.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #details
 */
public class POJ1013 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = 3;
        input.nextLine();
        for (int p = 0; p < n; p++) {
            String[] charsLeft = new String[m];
            String[] charsRight = new String[m];
            String[] status = new String[m];
            for (int i = 0; i < m; i++) {
                String temp = input.nextLine();
                String[] ss = temp.split("\\s+");
                charsLeft[i] = ss[0];
                charsRight[i] = ss[1];
                status[i] = ss[2];
            }

            boolean[] isJB = new boolean[12];
            boolean[] isJBlight = new boolean[12];
            for (int i = 0; i < 12; i++) {
                char jb = (char) ('A' + i);
                for (int j = 0; j < m; j++) {
                    //统计左边的“假币”数量
                    int left = 0;
                    int right = 0;
                    for (int k = 0; k < charsLeft[j].length(); k++) {
                        if (charsLeft[j].charAt(k) == jb)
                            left++;
                    }
                    for (int k = 0; k < charsRight[j].length(); k++) {
                        if (charsRight[j].charAt(k) == jb)
                            right++;
                    }
                    //这部分简单想一下就能想通了，关键是  if (isJB[i] && !isJBlight[i]) 中后面一个判断很容易忘记写
                    if ("up".equals(status[j])) {
                        if (left == right) {
                            isJB[i] = false;
                            break;
                        } else if (left < right) {
                            if (isJB[i] && !isJBlight[i]) {
                                isJB[i] = false;
                                break;
                            } else {
                                isJB[i] = true;
                                isJBlight[i] = true;
                            }
                        } else {
                            if (isJB[i] && isJBlight[i]) {
                                isJB[i] = false;
                                break;
                            } else {
                                isJB[i] = true;
                                isJBlight[i] = false;
                            }
                        }
                    } else if ("down".equals(status[j])) {
                        if (left == right) {
                            isJB[i] = false;
                            break;
                        } else if (left < right) {
                            if (isJB[i] && isJBlight[i]) {
                                isJB[i] = false;
                                break;
                            } else {
                                isJB[i] = true;
                                isJBlight[i] = false;
                            }
                        } else {
                            if (isJB[i] && !isJBlight[i]) {
                                isJB[i] = false;
                                break;
                            } else {
                                isJB[i] = true;
                                isJBlight[i] = true;
                            }
                        }
                    } else {
                        if (left != right) {
                            isJB[i] = false;
                            break;
                        }
                    }

                }
            }
            for (int i = 0; i < 12; i++) {
                if (isJB[i]) {
                    if (isJBlight[i])
                        System.out.println((char) ('A' + i) + " is the counterfeit coin and it is light.");
                    else
                        System.out.println((char) ('A' + i) + " is the counterfeit coin and it is heavy.");

                }
            }
        }

    }
}
