class Solution {
    public static int maxsum(int nums[]){
        int n=nums.length;
        int bestEnd=nums[0];
        int max=nums[0];

        
        for(int i=1;i<n;i++){
            int v1=nums[i];
            int v2=bestEnd+nums[i];
            bestEnd=Math.max(v1,v2);
            max=Math.max(max,bestEnd);
        }
        return max;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int num:nums){
            sum +=num;
        }

        int MaxSum=maxsum(nums);
        int bestEnd=nums[0];
        int min=nums[0];

        for(int i=1;i<n;i++){
            int v1=nums[i];
            int v2=bestEnd+nums[i];
            bestEnd=Math.min(v1,v2);
            min=Math.min(bestEnd,min);
        }
        if(sum==min){
            return MaxSum;
        }
       return Math.max(sum-min,MaxSum);
    }
}