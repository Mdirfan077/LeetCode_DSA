class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hm=new HashSet<>();
        for(int val :nums){
            if(hm.contains(val)){
                return true;
            }
            else{
                hm.add(val);
            }
        }
        return false;

        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[i] ==nums[j]){
        //             return true;
        //         }
        //     }
        // }

        // return false;
    }
}
