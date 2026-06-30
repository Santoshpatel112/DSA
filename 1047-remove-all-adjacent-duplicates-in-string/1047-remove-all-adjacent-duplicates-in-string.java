class Solution {
    public String removeDuplicates(String s) {
        if (s.isEmpty()) return "";
        Stack<Character> S=new Stack<>();
        S.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(!S.isEmpty() && S.peek()==s.charAt(i)){
                S.pop();
                continue;
            }
            else{
                S.push(s.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!S.isEmpty()){
            sb.append(S.pop());

        }
        return sb.reverse().toString();
    }
}