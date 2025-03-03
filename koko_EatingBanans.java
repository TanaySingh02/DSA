// 875. Koko Eating Bananas

// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         Arrays.sort(piles);
//         int i,j,hours=0,low=1,high=piles[piles.length-1],mid=0;

//         if(h==piles.length)
//         return piles[piles.length-1];
//         if(piles.length==1)
//         return (int)Math.ceil(piles[0]/(h*1.0));

//         while(low<=high)
//         {
//             mid=(low+(high-low))/2;
//             hours=0;

//             // k=Math.min(piles[mid],((piles[low]+piles[high]))/2
//             for(int pile:piles)
//             hours+=(pile+mid-1)/mid;
            
//             // if(hours==h)
//             // {
//             //     k=Math.min(k,mid);
//             //     high=mid-1;
//             // }
//             if(hours<=h)
//             high=mid-1;
//             else
//             low=mid+1;

//         }
//         return low;
        
//     }
// }
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canEatInTime(piles, mid, h)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    public boolean canEatInTime(int piles[], int k, int h){
        int hours = 0;
        for(int pile : piles){
            int div = pile / k;
            hours += div;
            if(pile % k != 0) hours++;
        }
        return hours <= h;
    }
}
