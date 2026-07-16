class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;

        int peak=Integer.MIN_VALUE;
        int index=0;
        for(int i=0;i<n;i++){
            if(arr[i] >peak){
                index=i;
                peak=arr[i];
            }
        }
        return index;
    }
}