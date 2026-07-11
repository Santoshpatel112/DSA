class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int num :nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        ArrayList<Map.Entry<Integer,Integer>>list=new ArrayList(map.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());
        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=0;i<k;i++){
            ans.add(list.get(i).getKey());
        }

        int Result[]=new int[k];
        for(int i=0;i<k;i++){
            Result[i]=ans.get(i);
        }
        return Result;
    }
}