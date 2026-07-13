class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> stotMap=new HashMap<>();
        HashMap<Character,Character> ttosMap=new HashMap<>();

        if(s.length() !=t.length()){
            return false;
        }

        for(int i=0;i<s.length();i++){
            char s1=s.charAt(i);
            char t1=t.charAt(i);
            if(!stotMap.containsKey(s1)){
                stotMap.put(s1,t1);
            }
            if(!ttosMap.containsKey(t1)){
                ttosMap.put(t1,s1);
            }


            if(stotMap.get(s1) !=t1 || ttosMap.get(t1) !=s1){
                return false;
            }
        }
        return true;
    }
}