class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int zeroIdx = -1;
        int nonZeroProduct = 1;
        int[] resultArr = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            int num = nums[i];
            if(num == 0){
                zeroCount++;
                zeroIdx = i;
            }else{
                nonZeroProduct = nonZeroProduct * nums[i];
            }
        }
        if(zeroCount > 1){
            //do nothing
        }
        if(zeroCount == 1){
            resultArr[zeroIdx] = nonZeroProduct;
        }
        if(zeroCount == 0){
            for(int i = 0; i < nums.length ; i++){
                resultArr[i] = nonZeroProduct / nums[i] ;
            }
        }
        return resultArr;
    }
}  
