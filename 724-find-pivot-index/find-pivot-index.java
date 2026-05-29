class Solution {
    public int pivotIndex(int[] nums) {
        int total=0;
        // int n=nums.length

        for(int i=0; i<nums.length; i++){
            total=total+nums[i];
        }

        int left=0;

        for(int i=0; i<nums.length; i++){
            int right=total-nums[i]-left;

            if(right==left){
                return i;
            }
            left=left+nums[i];
        }

        return -1;
    }
}