class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ans=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0;
        map.put(0,1);
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum +=nums[i];
            int mod=sum%k;
            if(mod <0){
                mod =mod+k;
            }

            if(map.containsKey(mod)){
                ans +=map.get(mod);
            }
            map.put(mod,map.getOrDefault(mod,0)+1);
        }
        return ans;
    }
}