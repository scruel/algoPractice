package algsPractice.OJ;


import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/29.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 枚举
 * //TODO 高斯消元解法
 */
public class POJ1222 {

        int[][] puzzle = new int[5][6];
        int[][] result = new int[5][6];

        public static void main(String[] args) {
                POJ1222 poj1222 = new POJ1222();
                Scanner input = new Scanner(System.in);
                int n = input.nextInt();
                for (int i = 0; i < n; i++) {
                        System.out.println("PUZZLE #" + (i + 1));
                        for (int j = 0; j < 5; j++) {
                                for (int k = 0; k < 6; k++) {
                                        poj1222.puzzle[j][k] = input.nextInt();
                                }
                        }
                        poj1222.dfs(0);
                        for (int j = 0; j < 5; j++) {
                                for (int k = 0; k < 6; k++) {
                                        System.out.print(poj1222.result[j][k] + " ");
                                }
                                System.out.println();
                        }
                }
        }

        boolean canFilp(int i, int j) {
                return i >= 0 && i < 5 && j >= 0 && j < 6;
        }

        void flip(int[][] puzzle, int i, int j) {
                puzzle[i][j] = puzzle[i][j] == 0 ? 1 : 0;
                if (canFilp(i + 1, j)) {
                        puzzle[i + 1][j] = puzzle[i + 1][j] == 0 ? 1 : 0;
                }
                if (canFilp(i - 1, j)) {
                        puzzle[i - 1][j] = puzzle[i - 1][j] == 0 ? 1 : 0;
                }
                if (canFilp(i, j + 1)) {
                        puzzle[i][j + 1] = puzzle[i][j + 1] == 0 ? 1 : 0;
                }
                if (canFilp(i, j - 1)) {
                        puzzle[i][j - 1] = puzzle[i][j - 1] == 0 ? 1 : 0;
                }
        }

        boolean ok() {
//                int[][] resultTemp = result.clone();
//                int[][] puzzleTemp = puzzle.clone();
                int[][] resultTemp = new int[5][6];
                int[][] puzzleTemp = new int[5][6];
                for (int i = 0; i < 6; i++) {
                        resultTemp[0][i] = result[0][i];
                }
                for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 6; j++)
                                puzzleTemp[i][j] = puzzle[i][j];
                }
                for (int i = 0; i < 6; i++) {
                        if (resultTemp[0][i] == 1) {
                                flip(puzzleTemp, 0, i);
                        }
                }
                for (int i = 1; i < 5; i++) {
                        for (int j = 0; j < 6; j++) {
                                if (puzzleTemp[i - 1][j] == 1) {
                                        resultTemp[i][j] = 1;
                                        flip(puzzleTemp, i, j);
                                }
                        }
                }
                for (int i = 0; i < 6; i++) {
                        if (puzzleTemp[4][i] == 1)
                                return false;
                }
                for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 6; j++)
                                puzzleTemp[i][j] = puzzle[i][j];
                }
                result = resultTemp.clone();
                return true;
        }

        //1 --> 0
        boolean dfs(int pos) {
                if (pos == 6) {
                        return ok();
                }
                for (int i = 0; i < 2; i++) {
                        result[0][pos] = i;
                        if (dfs(pos + 1))
                                return true;
                }
                return false;
        }
}
