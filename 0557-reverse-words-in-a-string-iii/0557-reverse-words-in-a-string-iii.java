class Solution {
    public static String Reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
    public String reverseWords(String s) {
        s=s.trim();
        String str[]=s.split("\\s+");
        for(int i=0;i<str.length;i++){
            str[i]=Reverse(str[i]);
        }
        return String.join(" ",str);
    }
}