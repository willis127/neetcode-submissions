class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> stored = new HashSet<Integer>();
        for (int num : nums) {
            if (stored.contains(num)) {
                return true;
            }else{
                stored.add(num);
            }
        }
        return false;
    }
}