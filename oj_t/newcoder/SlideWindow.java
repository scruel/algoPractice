package algsPractice.oj_t.newcoder;

import java.util.LinkedList;

/**
 * Created by Scruel on 2017/3/20.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * **优先队列**
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置。 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。 以数组为[4,3,5,4,3,3,6,7]，w=3为例。因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，第三个窗口[5,4,3]的最大值为5。第四个窗口[4,3,3]的最大值为4。第五个窗口[3,3,6]的最大值为6。第六个窗口[3,6,7]的最大值为7。所以最终返回[5,5,5,4,6,7]。
 * <p>
 * 给定整形数组arr及它的大小n，同时给定w，请返回res数组。保证w小于等于n，同时保证数组大小小于等于500。
 * <p>
 * 测试样例：
 * [4,3,5,4,3,3,6,7],8,3
 * 返回：[5,5,5,4,6,7]
 */
public class SlideWindow {
  public static int[] slide(int[] arr, int n, int w) {
    // write code here
    LinkedList<Integer> indexList = new LinkedList<Integer>();
    LinkedList<Integer> prelist = new LinkedList<Integer>();
    int sumW = 0;
    int num = 0;
    int[] result = new int[n - w + 1];
    for (int i = 0; i < n; i++) {
      sumW++;


      while (!prelist.isEmpty() && arr[i] >= prelist.getLast()) {
        prelist.removeLast();
        indexList.removeLast();
      }
      prelist.add(arr[i]);
      indexList.add(i);

      if (sumW == w) {
        sumW--;
        //失效了，移除
        if (i - indexList.getFirst() >= w) {
          prelist.removeFirst();
          indexList.removeFirst();
        }
        result[num++] = prelist.getFirst();
      }
    }

    //先将窗口滑动滑动固定到第一个
    return result;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
    for (int i : slide(arr, 8, 3)) {
      System.out.printf("%2d", i);
    }
  }
}
