class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxlen=1;
        int n=nums.length;

        for(int i=0;i<n;i++){
            int bitmask=0;
            for(int j=i;j<n;j++){
                if((bitmask & nums[j])!=0){
                    break;
                }
                bitmask |=nums[j];
                maxlen=Math.max(maxlen,j-i+1);
            }
        }
        return maxlen;
    }
}