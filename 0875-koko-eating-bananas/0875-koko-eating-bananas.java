class Solution {
    boolean canEatBanana(int piles[],int mid,int h){
        int actualHour=0;
        for(int num:piles){
            actualHour +=num/mid;
            if(num%mid !=0){
                actualHour++;
            }
        }
        return actualHour <=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int max=0;
        for(int num:piles){
            if(max<num){
                max=num;
            }
        }
        int high=max;

        while(low<high){
            int mid=low+(high-low)/2;
            if(canEatBanana(piles,mid,h)){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}