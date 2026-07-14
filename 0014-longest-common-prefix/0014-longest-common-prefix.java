class Solution {
    public static String Solve(String pre,String current){
        StringBuilder sb=new StringBuilder();
        int n=Math.min(pre.length(),current.length());

        for(int i=0;i<n;i++){
            if(pre.charAt(i)==current.charAt(i)){
                sb.append(pre.charAt(i));
            }
        }
        return sb.toString();
    }
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;

        String prefix=strs[0];

        for(int i=0;i<n;i++){
            prefix=Solve(prefix,strs[i]);
        }
        return prefix;
    }
}