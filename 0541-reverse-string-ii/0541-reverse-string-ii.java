class Solution {
    public static String reverse(String str , int k){
        int end=Math.min(k,str.length());
        StringBuilder sb=new StringBuilder();
        for(int i=end-1;i>=0;i--){
            sb.append(str.charAt(i));
        }

        for(int i=end;i<str.length();i++){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public String reverseStr(String s, int k) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<n){
            int end=Math.min(i+2*k ,n);
            String str=s.substring(i,end);
            sb.append(reverse(str,k));
            i +=2*k;
        }
        return sb.toString();
    }
}