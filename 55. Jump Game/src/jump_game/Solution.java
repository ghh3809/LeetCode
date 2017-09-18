package jump_game;

class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int maxPosi = 0;
        for (int i = 0; i < length - 1; i ++) {
            if (nums[i] == 0) {
                if (maxPosi > i) continue; else return false;
            } else {
                maxPosi = (i + nums[i] > maxPosi) ? i + nums[i] : maxPosi;
            }
        }
        return true;
    }
}
