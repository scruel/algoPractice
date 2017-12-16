package algsPractice.oj.newcoder;

/**
 * Created by Scruel on 2017/3/19.  
 * Github : https://github.com/scruel
 * **字符串**
 */
public class Replacement {
  public static void main(String[] args) {
    Replacement rp = new Replacement();
    System.out.println(rp.replaceSpace("Mr John Smith", 13));
  }

  public String replaceSpace(String iniString, int length) {
    // write code here
    int space = 0;
    char[] chars = iniString.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == ' ') {
        space++;
      }
    }
    int n = length + space * 2 - 1;
    char[] newChars = new char[n + 1];
    for (int i = length - 1; i >= 0; i--) {
      if (chars[i] == ' ') {
        newChars[n--] = '0';
        newChars[n--] = '2';
        newChars[n--] = '%';
      }
      else {
        newChars[n--] = chars[i];
      }
    }

    return String.valueOf(newChars);
  }
}
