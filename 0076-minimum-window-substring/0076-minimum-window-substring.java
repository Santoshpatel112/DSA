class Solution {
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();

        if(m<n){
            return "";
        }
        HashMap<Character,Integer>map=new HashMap<>();
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int start=0;
        int min=Integer.MAX_VALUE;
        int i=0;

        int count=map.size();

        for(int j=0;j<s.length();j++){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
            
            if(map.get(ch)==0){
                count--;
            }

            }
    
        while(count==0){
            if(j-i+1 < min){
                min=j-i+1;
                start=i;
            }

            char left=s.charAt(i);
            if(map.containsKey(left)){
                map.put(left,map.getOrDefault(left,0)+1);
                if(map.get(left) >0){
                    count ++;
                }
            }
            i++;
        }
        }
        return min==Integer.MAX_VALUE?"":s.substring(start,start+min);
    }
}