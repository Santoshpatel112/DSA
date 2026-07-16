class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        map.put(0,-1);
        int sum=0;
        for(int j=0;j<n;j++){
            sum +=nums[j];
            int val=sum%k;
            if(map.containsKey(val)){
                    if((j-map.get(val))>=2){
                        return true;
                    }
            }
            else{
                 map.put(sum%k,j);
            }
        }
        return false;
    }
}