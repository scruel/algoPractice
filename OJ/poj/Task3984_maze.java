package algsPractice.OJ.poj;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Scruel on 2017/3/28.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #bfs
 */
public class Task3984_maze {
    static int[][] maze;
    static Node[][] edgeTo = new Node[5][5];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        maze = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                maze[i][j] = input.nextInt();
            }
        }
        Queue<Node> queue = new ConcurrentLinkedQueue<Node>();
        Node startNode = new Node(0, 0);
        edgeTo[0][0] = startNode;
        queue.add(startNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            if (x == 4 && y == 4) break;
            //上下左右四种状态
            int nx = x - 1;
            int ny = y;
            if (nx >= 0 && nx < 5) {
                if (maze[nx][ny] == 0 && edgeTo[nx][ny] == null) {
                    queue.add(new Node(nx, ny));
                    edgeTo[nx][ny] = node;
                }
            }

            nx = x + 1;
            ny = y;
            if (nx >= 0 && nx < 5) {
                if (maze[nx][ny] == 0 && edgeTo[nx][ny] == null) {
                    queue.add(new Node(nx, ny));
                    edgeTo[nx][ny] = node;
                }
            }

            nx = x;
            ny = y + 1;
            if (ny >= 0 && ny < 5) {
                if (maze[nx][ny] == 0 && edgeTo[nx][ny] == null) {
                    queue.add(new Node(nx, ny));
                    edgeTo[nx][ny] = node;
                }
            }

            nx = x;
            ny = y - 1;
            if (ny >= 0 && ny < 5) {
                if (maze[nx][ny] == 0 && edgeTo[nx][ny] == null) {
                    queue.add(new Node(nx, ny));
                    edgeTo[nx][ny] = node;
                }
            }
        }
        System.out.println(startNode);
        Stack<Node> stack = new Stack<Node>();
        Node x = edgeTo[4][4];
        while (x.x != 0 || x.y != 0) {
            stack.push(x);
            x = edgeTo[x.x][x.y];
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("(4, 4)");

    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
