class Solution {
    public int minLength(String s) {
        Stack<Character> st=new Stack<>();

        for(char c:s.toCharArray()){
            if(!(c=='D' || c=='B')){
                st.push(c);
            }
            else{
                if(!st.isEmpty()){
                    if(c=='B' && st.peek()=='A'){
                        st.pop();
                    }
                    else if(c=='D' && st.peek()=='C'){
                        st.pop();
                    }
                    else{
                        st.push(c);
                    }
                }
                else{
                    st.push(c);
                }
            }
        }
        return st.size();
    }
}