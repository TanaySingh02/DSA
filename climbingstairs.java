// import java.M
class Solution {
    public int climbStairs(int n) {
       

        int i,t1=1,t2=1,sum=t1+t2;
        if(n==1)
        return 1;
        for(i=0;i<n-2;i++)
        
        {
            t1=t2;
            t2=sum;
            sum=t1+t2;
            
        }
        return sum;
        
    }
}