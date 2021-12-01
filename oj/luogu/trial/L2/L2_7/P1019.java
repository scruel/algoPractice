package algsPractice.oj.luogu.trial.L2.L2_7;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Scruel Tao
 */
public class P1019 {
  int maxn = 20 + 5;
  int n;
  String[] words = new String[maxn];
  Map<String, Integer> countMap = new HashMap<>();
  Map<String, Map<String, Integer>> valueMap = new HashMap<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    for (int i = 0; i < n; i++) {
      words[i] = in.readLine();
      countMap.put(words[i], 0);
    }
    String start = in.readLine();
    init(start);
    out.println(dfs(0, start));
  }

  private void init(String startWord) {
    Map<String, Integer> wordMap = new HashMap<>();
    valueMap.put(startWord, wordMap);
    for (int i = 0; i < n; i++) {
      if (words[i].startsWith(startWord)) {
        wordMap.put(words[i], 0);
      }
    }
    for (int i = 0; i < n; i++) {
      String word = words[i];
      wordMap = new HashMap<>();
      valueMap.put(word, wordMap);
      for (int j = 0; j < n; j++) {
        String cpWord = words[j];
        // if (i == j) continue;
        // 被包含关系不能组合
        // if (words[i].contains(words[j]) || words[j].contains(words[i])) continue;
        for (int k = word.length() - 1; k > 0; k--) {
          String sub = word.substring(k);
          if (cpWord.startsWith(sub)) {
            // 拼接代价 实际拼接后的长度要减去代价
            wordMap.put(cpWord, sub.length());
            break;
          }
        }
      }
    }
  }

  private int dfs(int len, String lastWord) {
    Map<String, Integer> valueWords = valueMap.get(lastWord);
    int max = len;
    for (Map.Entry<String, Integer> entry : valueWords.entrySet()) {
      String word = entry.getKey();
      int cost = entry.getValue();
      int cnt = countMap.get(word);
      if (cnt >= 2) { continue;}
      countMap.put(word, cnt + 1);
      int tl = len + word.length() - cost;
      max = Math.max(max, dfs(tl, word));
      countMap.put(word, cnt);
    }
    return max;
  }
}
