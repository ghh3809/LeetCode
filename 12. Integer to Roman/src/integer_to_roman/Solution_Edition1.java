package integer_to_roman;

public class Solution_Edition1 {
    public String intToRoman(int num) {
        StringBuilder s = new StringBuilder();
        int temp = num / 1000;
        num = num - temp * 1000;
        for (int i = 0; i < temp; i ++) {
            s.append('M');
        }
        temp = num / 100;
        num = num - temp * 100;
        intToChar(temp, 2, s);
        temp = num / 10;
        num = num - temp * 10;
        intToChar(temp, 1, s);
        intToChar(num, 0, s);
        return s.toString();
    }
    
    public void intToChar(int a, int digit, StringBuilder s) {
        if (a == 0) return;
        char[] one = new char[]{'I', 'X', 'C', 'M'};
        char[] five = new char[]{'V', 'L', 'D'};
        switch (a) {
            case 8:
                s.append(five[digit]);
            case 3:
                s.append(one[digit]);
            case 2:
                s.append(one[digit]);
            case 1:
                s.append(one[digit]);
                break;
            case 7:
                s.append(five[digit]);
                s.append(one[digit]);
                s.append(one[digit]);
                break;
            case 6:
                s.append(five[digit]);
                s.append(one[digit]);
                break;
            case 5:
                s.append(five[digit]);
                break;
            case 4:
                s.append(one[digit]);
                s.append(five[digit]);
                break;
            case 9:
                s.append(one[digit]);
                s.append(one[digit + 1]);
                break;
        }
    }
}
