class Solution {
    public void sortColors(int[] nums) {

        // Arrays.sort(nums);
        // int low=0;
        // int mid=0;
        // int high=nums.length-1;

        // while(mid<=high){
        //     if(nums[mid] == 0){
        //         int temp= nums[low];
        //         nums[low]=nums[mid];
        //         nums[mid]=temp;
        //         low ++;
        //         mid ++;

        //     }
        //     else if(nums[mid]==1){
        //         mid++;



        //     }

        //     else{
        //         int temp=nums[mid];
        //         nums[mid]=nums[high];
        //         nums[high]=temp;
        //         high--;
        //     }
        // }


        int n=nums.length;
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n-i-1; j++){
        //         if(nums[j]>nums[j+1]){
        //             int temp=nums[j];
        //             nums[j]=nums[j+1];
        //             nums[j+1]=temp;
        //         }
        //     }

        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        
    }

}
