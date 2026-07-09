class Solution {
    public static int MaxSum(int nums[]){
        int n=nums.length;

        int max=nums[0];
        int bestend=nums[0];
        for(int i=1;i<n;i++){
            int v1=nums[i];
            int v2=nums[i]+bestend;
            bestend=Math.max(v1,v2);

            max=Math.max(bestend,max);
        }
        return max;
    }
     public static int MinSum(int nums[]){
        int n=nums.length;

        int min=nums[0];
        int bestend=nums[0];
        for(int i=1;i<n;i++){
            int v1=nums[i];
            int v2=nums[i]+bestend;
            bestend=Math.min(v1,v2);

            min=Math.min(bestend,min);
        }
        return min;
    }
    public int maxAbsoluteSum(int[] nums) {
        int maxsum=MaxSum(nums);
        int minsum=MinSum(nums);

        return Math.max(maxsum,Math.abs(minsum));
    }
}