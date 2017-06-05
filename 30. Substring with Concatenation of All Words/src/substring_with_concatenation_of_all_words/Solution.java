package substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> wordsmap = new HashMap<>();
        int length = s.length();
        int units = words.length;
        int unitlen = words[0].length();
        if ((length == 0) || (units == 0) || (unitlen == 0)) return result;
        for (String word : words) {
            if (wordsmap.containsKey(word)) {
                wordsmap.put(word, wordsmap.get(word) + 1);
            } else {
                wordsmap.put(word, 1);
            }
        }
        for (int i = 0; i <= length - units*unitlen; i ++) {
            HashMap<String, Integer> copymap = new HashMap<>(wordsmap);
            for (int j = 0; j < units; j ++) {
                String str = s.substring(i + j*unitlen, i + j*unitlen + unitlen);
                if (copymap.containsKey(str)) {
                    int value = copymap.get(str) - 1;
                    if (value > 0) copymap.put(str, value); else copymap.remove(str);
                    if (copymap.isEmpty()) {
                        result.add(i);
                        break;
                    }
                } else break;
            }
        }
        return result;
    }
}
