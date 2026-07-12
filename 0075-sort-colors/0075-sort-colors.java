class Solution {
    private void Swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
        int start=0;
        int idx=0;
        int end=nums.length-1;

        while(idx <=end){
            if(nums[idx]==2){
                Swap(nums,idx,end);
                end--;
            }
            else if(nums[idx]==0){
                Swap(nums,idx,start);
                start++;
                idx++;
            }
            else{
                idx++;
            }
        }
    }
}