// class Solution {
//     public int removeDuplicates(int[] nums) {
//       LinkedHashSet<Integer> set = new LinkedHashSet<>();

//       for(int num : nums){
//         set.add(num);
//       }
//         int i=0; 
//         for(int val: set){
//             nums[i++]=val;
//         }
//         return set.size();
//     }
// }




class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;

        for(int j=1; j<nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }

        return i+1;
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