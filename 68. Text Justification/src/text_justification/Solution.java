package text_justification;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> result = new LinkedList<String>();
    	int startIndex = 0;
    	int sumLength = 0;
    	for (int index = 0; index < words.length; index ++) {
    		if (sumLength + words[index].length() <= maxWidth) {
    			sumLength += words[index].length() + 1;
    		} else {
    			int numBlanks = index - startIndex - 1;
    			int remainBlanks = maxWidth - sumLength + 1;
    			StringBuilder sb = new StringBuilder();
    			sb.append(words[startIndex]);
    			if (numBlanks == 0) {
    				for (int j = 0; j < remainBlanks; j ++) { sb.append(' '); }
    			} else {
    				int addBlankNumber = remainBlanks / numBlanks + 1;
        			int moreBlankNumber = remainBlanks % numBlanks;
        			for (int i = startIndex + 1; i < index; i ++) {
        				int blanks = addBlankNumber;
        				if (i - startIndex <= moreBlankNumber) { blanks ++; }
        				for (int j = 0; j < blanks; j ++) { sb.append(' '); }
        				sb.append(words[i]);
        			}
    			}
    			result.add(sb.toString());
    			startIndex = index;
    			sumLength = words[index].length() + 1;
    		}
    	}
    	StringBuilder sb = new StringBuilder();
		sb.append(words[startIndex]);
    	for (int index = startIndex + 1; index < words.length; index ++) {
			sb.append(' ' + words[index]);
    	}
    	for (int j = 0; j < maxWidth - sumLength + 1; j ++) {
    		sb.append(' ');
    	}
    	result.add(sb.toString());
        return result;
    }
    public static void main(String[] args) {
    	System.out.println(new Solution().fullJustify(new String[] {"This", "is", "an", "exampleaaa", "ofaaaaaaa", "text", "justification."}, 16));
    	System.out.println(new Solution().fullJustify(new String[] {""}, 16));
    }
}
