class Solution {
    private boolean isNiceSubstring(String s){
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLowerCase(ch)){
                if(!s.contains(Character.toString(Character.toUpperCase(ch)))){
                    return false;
                }
            }
            else{
                if(!s.contains(Character.toString(Character.toLowerCase(ch)))){
                    return false;
                }
            }
        }
        return true;
    }
    public String longestNiceSubstring(String s) {
        String result="";
        int n=s.length();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String sub=s.substring(i,j);
                if(isNiceSubstring(sub)){
                    if(sub.length() >result.length()){
                        result=sub;
                    }
                }
            }
        }
        return result;
    }
}