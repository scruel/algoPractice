package algsPractice.newcoder;

import java.util.Stack;

/**
 * Created by Scruel on 2017/3/19.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class GetMinStack {
        private Stack<Integer> stackData = new Stack();
        private Stack<Integer> stackMin = new Stack();

        public static void main(String[] args) {
                GetMinStack gs = new GetMinStack();
                //["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]
                gs.push(3);
                System.out.println(gs.min());
                gs.push(4);
                System.out.println(gs.min());
                gs.push(2);
                System.out.println(gs.min());
                gs.push(3);
                System.out.println(gs.min());
                gs.pop();
                System.out.println(gs.min());
                gs.pop();
                System.out.println(gs.min());
                gs.pop();
                System.out.println(gs.min());
                gs.push(0);
                System.out.println(gs.min());

        }

        public void push(int node) {
                stackData.push(node);
                if (stackMin.isEmpty() || stackMin.peek() >= node)
                        stackMin.push(node);
        }

        public void pop() {
                int temp = stackData.pop();
                if (!stackMin.isEmpty() && stackMin.peek() == temp)
                        stackMin.pop();
        }

        public int top() {
                return stackData.peek();
        }

        public int min() {
                int temp = stackData.peek();
                if (!stackMin.isEmpty() && stackMin.peek() <= temp)
                        temp = stackMin.peek();
                return temp;
        }

}
