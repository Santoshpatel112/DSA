class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int bestEnd=nums[0];

        for(int i=1;i<nums.length;i++){
            int val1=nums[i]+bestEnd;
            int val2=nums[i];
            bestEnd=Math.max(val1,val2);

            max=Math.max(max,bestEnd);
        }
        return max;
    }
}