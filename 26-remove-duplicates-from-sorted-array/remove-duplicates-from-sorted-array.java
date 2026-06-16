class Solution {
    public int removeDuplicates(int[] nums) {
      LinkedHashSet<Integer> set = new LinkedHashSet<>();

      for(int num : nums){
        set.add(num);
      }
        int i=0; 
        for(int val: set){
            nums[i++]=val;
        }
        return set.size();
    }
}









































// int j=0;
//         for(int i=0; i<nums.length; i++){
//             if(nums[j] != nums[i]){
//                 j++;
//                 nums[j]=nums[i];
//             }

//         }
//         return ++j;