class Solution {
    public int search(int[] nums, int target) {
        int result = binSearch(nums, 0, nums.length - 1, target);
        return result;
    }
    private int binSearch(int[] nums, int i, int j, int target){
        if (target == nums[i])
            return i;
        if (target == nums[j])
            return j;
        if (target == nums[(i + j) / 2])
            return (i + j) / 2;
        if (i + 1 >= j)
            return -1;
        int midIdx = (i + j) / 2;
        int mid = nums[midIdx];
        if (nums[i] < nums[j]) {
            if (target < mid)
                return binSearch(nums, i, midIdx, target);
            else
                return binSearch(nums, midIdx, j, target);
        } else {
            if (nums[i] <  mid) {   //left increamental
                if (nums[i] < target && target < mid)
                    return binSearch(nums, i, midIdx, target);
                else
                    return binSearch(nums, midIdx, j, target);
            } else {    //right increamental
                if (mid< target && target < nums[j])
                    return binSearch(nums, midIdx, j, target);
                else
                    return binSearch(nums, i, midIdx, target);
            } 
        }
    }
}
