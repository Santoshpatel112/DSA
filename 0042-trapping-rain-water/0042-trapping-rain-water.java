class Solution {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;
        int leftmax=0;
        int rightmax=0;

        int water=0;
        while(l<r){
            if(height[l]>leftmax){
                leftmax=Math.max(leftmax,height[l]);
            }
            if(height[r] >rightmax){
                rightmax=Math.max(rightmax,height[r]);
            }

            if(leftmax<rightmax){
                water=water+leftmax-height[l];
                l++;
            }
            else{
                water =water+rightmax-height[r];
                r--;
            }
        }
        return water;
    }
}