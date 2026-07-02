class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[]=new int[26];
        
        int count=0;
        for(char ch:tasks){
            freq[ch-'A']++;
            count =Math.max(count,freq[ch-'A']);
        }
        int ans=(count-1)*(n+1);
        for(int i=0;i<26;i++){
            if(count==freq[i]){
                ans++;
            }
        }
        return ans>tasks.length?ans:tasks.length;
    }
}