class Solution {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1])
            return nums[0];
        if (nums.length == 1)
            return nums[0];
        int result = 0;
        result = min(nums, 0, nums.length - 1);
        return result;
    }
    private int min(int[] nums, int i, int j){
        if (i + 1== j)
            return Math.min(nums[i], nums[j]);
        if (nums[(i + j) / 2] > nums[i] && nums[(i + j) / 2] > nums[j]) {
            return min(nums, (i + j) / 2, j);
        }
        if (nums[(i + j) / 2] < nums[i] && nums[(i + j) / 2] < nums[j]) {
            return min(nums, i, (i + j) / 2);
        }
        return Integer.MAX_VALUE;
    }
}
