package generate_parentheses;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        result.add("");
        left.add(0);
        right.add(0);
        for (int i = 0; i < 2*n; i ++) {
            List<String> newresult = new ArrayList<String>();
            List<Integer> newleft = new ArrayList<Integer>();
            List<Integer> newright = new ArrayList<Integer>();
            for (int j = 0; j < result.size(); j ++) {
                String str = result.get(j);
                int l = left.get(j).intValue();
                int r = right.get(j).intValue();
                if (l < n) {
                    newresult.add(str + '(');
                    newleft.add(l + 1);
                    newright.add(r);
                }
                if (l > r) {
                    newresult.add(str + ')');
                    newleft.add(l);
                    newright.add(r + 1);
                }
            }
            result = newresult;
            left = newleft;
            right = newright;
        }
        return result;
    }
}
