package algsPractice.OJ.newcoder;

/**
 * Created by Scruel on 2017/3/18.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * **字符串**
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
 * <p>
 * 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
 * <p>
 * 测试样例：
 * "ABCDE",5,3
 * 返回："DEABC"
 */
public class TranslationReverseString {
    public static void main(String[] args) {
        TranslationReverseString tr = new TranslationReverseString();
        System.out.println(tr.stringTranslation("RJXJYA", 6, 1));
    }

    public String stringTranslation(String A, int n, int len) {
        // write code here
        A = reverseString(A, 0, len - 1) + reverseString(A, len, n - 1);
        return reverseString(A, 0, n - 1);

    }

    private String reverseString(String A, int lo, int hi) {
        char[] array = A.toCharArray();
        int i = lo, j = hi;
        System.out.println(lo);
        System.out.println(hi);
        while (i < j) {
            char temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;
        }
        System.out.println(array);
        return String.valueOf(array, lo, hi - lo + 1);
    }
}