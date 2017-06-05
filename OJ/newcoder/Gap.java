package algsPractice.OJ.newcoder;

/**
 * Created by Scruel on 2017/3/18.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
 * 给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。
 * 测试样例：
 * [1,2,5,4,6],5
 * 返回：2
 * <p>
 * 解答：
 * 基于桶排序将数据分割到目标桶，会分割出n+1个桶，相邻最小即为当前桶的最大值与上一个桶的最小值的差值。空间复杂度为n
 * **排序**
 */

public class Gap {
    public static int maxGap(int[] A, int n) {
        int max = A[0];
        int min = A[0];
        for (int i = 0; i < n; i++) {
            if (max < A[i]) {
                max = A[i];
            }
            if (min > A[i]) {
                min = A[i];
            }
        }
        int[] maxBucket = new int[n + 1];
        int[] minBucket = new int[n + 1];
        double div = (max - min) / (double) n;
        for (int i = 0; i < n; i++) {
            int index = (int) ((A[i] - min) / div);
            if (maxBucket[index] < A[i]) maxBucket[index] = A[i];
        }
        for (int i = 0; i < n; i++) {
            int index = (int) ((A[i] - min) / div);
            if (minBucket[index] > A[i] || minBucket[index] == 0) minBucket[index] = A[i];
        }
        int tempMax = 0;
        max = maxBucket[0];
        for (int i = 0; i < n + 1; i++) {
            if (maxBucket[i] > max) {
                if (minBucket[i] - max > tempMax) tempMax = minBucket[i] - max;
                max = maxBucket[i];
            }
        }

        return tempMax;
    }

    public static void main(String[] args) {
        System.out.println(maxGap(new int[]{1, 2, 5, 4, 6}, 5));
        System.out.println(maxGap(new int[]{7778, 9763, 347, 8793, 4297}, 5));
        System.out.println(maxGap(new int[]{3429, 6401, 8559, 1052, 4775, 6220, 3593, 2406, 4995}, 9));
    }
}