package generate_parentheses;

public class Solution_Edition1 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generate(result, "", 0, 0, n);
        return result;
    }
    
    public void generate(List<String> result, String str, int left, int right, int n) {
        if ((left == n) && (right == n)) {result.add(str);  return;}
        if (left < n) generate(result, str + '(', left + 1, right, n);
        if (left > right) generate(result, str + ')', left, right + 1, n);
    }
}
