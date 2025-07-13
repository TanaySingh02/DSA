class Solution {
    public int specialTriplets(int[] nums) {
        int mod = 1000000007;
        int i,j,k,pi=0,pk=0;
        long count=0;
        HashMap<Integer, Integer> premap=new HashMap<>();
        HashMap<Integer, Integer> postmap=new HashMap<>();
        premap.put(nums[0],1);
        for(k=2;k<nums.length;k++)
            {
                if(postmap.containsKey(nums[k]))
                    postmap.put(nums[k],postmap.get(nums[k])+1);
                else
                    postmap.put(nums[k],1);
            }
        
        for(j=1;j<nums.length-1;j++)
            {
                i=nums[j]*2; //double value to be found to make a triplet
                if(premap.containsKey(i))
                {
                    pi=premap.get(i);
                }
                if(postmap.containsKey(i))
                {
                    pk=postmap.get(i);
                }
                count = (count + ((1L * pi * pk) % mod)) % mod;
                pk=0;
                pi=0;
                // if(premap.containsKey(0))
                //     System.out.println(premap.get(0));
                // if(postmap.containsKey(0))
                //     System.out.println(postmap.get(0));
                // Now adjust both the hashmaps
                if(premap.containsKey(nums[j]))
                {
                    premap.put(nums[j],premap.get(nums[j])+1);
                }
                else
                    premap.put(nums[j],1);
                if(postmap.get(nums[j+1])==1)
                    postmap.remove(nums[j+1]);
                else
                    postmap.put(nums[j+1],postmap.get(nums[j+1])-1);
            }
        return (int)(count);
    }
}