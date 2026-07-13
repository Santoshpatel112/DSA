class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer>map=new HashMap<>();

        for(char ch :s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(char ch:t.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
            }
        }
        int count =0;


        for(Map.Entry<Character,Integer>entry :map.entrySet()){
            if(entry.getValue()>0){
                count +=entry.getValue();
            }
        }

        return count;
    }
}