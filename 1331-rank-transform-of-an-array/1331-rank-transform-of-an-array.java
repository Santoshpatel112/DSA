class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int temp[]=new int[n];

        for(int i=0;i<n;i++){
            temp[i]=arr[i];
        }
        Arrays.sort(temp);
        HashMap<Integer,Integer>map=new HashMap<>();
        int rank=1;
        for(int i=0;i<n;i++){
            if(i>0 && temp[i-1] !=temp[i]){
                rank +=1;
            }
            map.put(temp[i],rank);
        }

        int ranks[]=new int[n];

        for(int i=0;i<n;i++){
            ranks[i]=map.get(arr[i]);
        }
        return ranks;
    }
}