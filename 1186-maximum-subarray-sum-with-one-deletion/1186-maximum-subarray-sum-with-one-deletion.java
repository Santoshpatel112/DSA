class Solution {
    public int maximumSum(int[] arr) {
        int nodelete=arr[0];
        int onedelete=Integer.MIN_VALUE;
        int n=arr.length;
        int result=arr[0];
        for(int i=1;i<n;i++){
            int prevnodelete=nodelete;
            int prevonedelete=onedelete;

            nodelete=Math.max(prevnodelete+arr[i],arr[i]);
            int v2;
            if(prevonedelete==Integer.MIN_VALUE){
                v2=arr[i];
            }
            else{
                v2=arr[i]+prevonedelete;
            }
            onedelete=Math.max(v2,prevnodelete);

            result=Math.max(result,Math.max(nodelete,onedelete));
        }
        return result;
    }
}