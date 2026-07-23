class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;

        int last=1;
        int secondlast=0;
        
        for(int i=2;i<=n;i++){
            int cur=last+secondlast;
            secondlast=last;
            last=cur;
            
        }
        return last;
        
    }
}