public class Solution {
    public int checkDistribution(int[] quantities, int max)
    {
        int i,stores=0;
        for(int products: quantities)
        {
            stores+=(products/max);
            if(products%max!=0)
            stores++;
        }
        return stores;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int m=quantities.length;
        if(m==1 && n==1)
        return quantities[0];
        int low=1,high=0,required=0,mid=0, result;
        for(int products: quantities)
        {
            high=Math.max(high,products);
        }
        result=high;

        while(low<=high)
        {
            mid=(low+high)/2;
            required=checkDistribution(quantities, mid);
            if(required<=n)
            {
                result=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }
        return result;
        
    }
}

