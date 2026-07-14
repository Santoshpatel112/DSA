class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        StringBuilder sb=new StringBuilder();

        ArrayList<Map.Entry<Character,Integer>>list=new ArrayList<>(map.entrySet());

        list.sort((a,b)->b.getValue()-a.getValue());

        for(Map.Entry<Character,Integer>entry:list){
            char ch=entry.getKey();
            int count=entry.getValue();
            while(count>0){
                sb.append(ch);
                count --;
            }
        }
        return sb.toString();
    }
}