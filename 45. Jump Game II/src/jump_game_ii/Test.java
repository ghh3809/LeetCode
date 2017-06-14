package jump_game_ii;

public class Test {
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] nums = new int[25002];
		for (int i = 0; i <= 25000; i ++) {
			nums[i] = 25000-i;
		}
		nums[25000] = 1;
		nums[25001] = 0;
		System.out.println(s.jump(nums));
	}
}
