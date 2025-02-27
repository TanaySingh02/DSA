
// LEETCODE 1248: COUNT THE NUMBER OF NICE SUBARRAYS

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int l=0,r=0,lcount=1,rcount=1,nice=0,c_odd=0;

        
        while(r<nums.length)
        {
            if(nums[r]%2!=0)
            {
                c_odd++;
                if(c_odd-k==0)
                {
                    while(r+1<nums.length && nums[r+1]%2==0 )
                    {
                        rcount++;
                        r++;
                    }
                    while(nums[l]%2==0 && l<r)
                    {
                        lcount++;
                        l++;
                    }
                    nice+=lcount*rcount;
                    lcount=1;
                    rcount=1;
                    l++;
                    r++;
                    c_odd--;
                }
                else
                r++;

            }
            else
            r++;
            
        }
        return nice;
        
    }
}
