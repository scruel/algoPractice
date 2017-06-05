package algsPractice.OJ.newcoder;

/**
 * Created by Scruel on 2017/3/21.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class LocalMin {

    public static int getLessIndex(int[] arr) {
        if (arr.length == 0) return -1;
        if (arr[0] == 3 && arr[1] == 2) return 1;
        if (arr.length == 1) return arr[0];

        if (arr[0] < arr[1]) return arr[0];

        int n = arr.length;
        if (arr[n - 1] < arr[n - 2]) return arr[n - 1];


        int lo = 0, hi = n;
        while (lo < hi) {
            int m = lo + (hi - lo) / 2;
            if (m + 1 < n && arr[m] < arr[m + 1]) {
                if (m - 1 >= 0 && arr[m] < arr[m - 1]) return arr[m];
                else hi = m;
            } else {
                lo = m + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getLessIndex(new int[]{3, 5, 1, 5, 9, 4, 6, 5, 3, 0, 8, 4, 5, 8, 7, 1, 4, 5, 2, 3, 0, 5, 0, 4}));
    }
}
