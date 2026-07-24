class Solution {
    public String compressedString(String word) {
        int count=1;
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<word.length();i++){
            if(word.charAt(i-1)==word.charAt(i) && count <9){
                count++;
            }
            else{
                
                sb.append(count);
                sb.append(word.charAt(i-1));
                count=1;
            }
        }
        if(count>=1){
            sb.append(count);
        }
        sb.append(word.charAt(word.length()-1));
        return sb.toString();
    }
}