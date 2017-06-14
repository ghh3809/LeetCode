package jump_game_ii;


public class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int last = 0, head = 0;
        int max = 0;
        while (true) {
        	if (head >= nums.length - 1) return step;
            step ++;
            for (int i = last; i <= head; i ++) {
                max = i + nums[i] > max ? i + nums[i] : max;
            }
            last = head + 1;
            head = max;
        }
    }
}