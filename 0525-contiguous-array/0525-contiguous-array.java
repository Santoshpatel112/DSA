class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
    
        int zero=0;
        int ones=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zero++;
            }
            else{
                ones++;
            }
            int diff=zero-ones;
            if(diff==0){
                ans =Math.max(ans,i+1);
            }
            if(!map.containsKey(diff)){
                map.put(diff,i);
            }
            else{
                int j=map.get(diff);
                ans=Math.max(ans,i-j);
            }
        }
        return ans;
    }
}