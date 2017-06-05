package algsPractice.OJ.newcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scruel on 2017/3/22.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * //https://www.nowcoder.com/study/vod/1/7/10
 * 折纸问题
 * **树的遍历**
 */
public class FoldPaper {
    public static String[] foldPaper(int n) {
        List<String> list = new ArrayList<String>();
        fold(1, n, true, list);
        String[] strings = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strings[i] = list.get(i);
            System.out.println(strings[i]);
        }
        return strings;
    }

    private static void fold(int i, int n, boolean down, List<String> list) {
        if (i > n) return;
        fold(i + 1, n, true, list);
        //子树都是左上右下，根节点为下
        list.add(down ? "down" : "up");
        fold(i + 1, n, false, list);
    }

    public static void main(String[] args) {
        foldPaper(3);
    }
}
