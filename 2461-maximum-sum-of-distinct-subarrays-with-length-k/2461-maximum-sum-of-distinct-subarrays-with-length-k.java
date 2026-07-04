class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxsum=0;
        long sum=0;
        int left=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            while(set.contains(nums[i]) || set.size()==k){
                set.remove(nums[left]);
                sum -=nums[left];
                left++;
            }
            sum +=nums[i];
            set.add(nums[i]);
        if(set.size()==k){
            maxsum =Math.max(maxsum,sum);
        }
        }
        return maxsum;
    }
}