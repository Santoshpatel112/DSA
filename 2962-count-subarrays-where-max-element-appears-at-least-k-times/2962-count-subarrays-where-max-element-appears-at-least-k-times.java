class Solution {
    public long countSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        int left=0;
        int start=0;
        int count=0;
        int maxelement=nums[0];
        long maxcount=0;
        for(int num:nums){
             maxelement=Math.max(num,maxelement);
        }
        for(int right=0;right<n;right++){
            if(nums[right] ==maxelement){
                count++;
            }
            while(count >=k){
                maxcount +=n-right;
                if(nums[left]==maxelement){
                    count --;
                }
                left++;
            }
        }
        return maxcount;
    }
}