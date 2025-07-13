class Solution {
    public int minimizeMax(int[] nums, int p) {
        int i=0,maxdiff=0;
        if(p==0)
        return 0;
        ArrayList<Integer> pair1 = new ArrayList<>();
        ArrayList<Integer> pair2 = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        Arrays.sort(nums);
        while(i<nums.length)
        {
            if(i!=nums.length-1)
            pair1.add(Math.abs(nums[i]-nums[i+1])); // pair_ahead
            if(i!=0)
            pair2.add(Math.abs(nums[i]-nums[i-1]));// pair_behind
            i+=2;
        }

        for(int val:pair1)
        System.out.print(val +" ");
        System.out.println();
        for(int val:pair2)
        System.out.print(val +" ");
        System.out.println();

        if(pair1.size()<p)
        {
            Collections.sort(pair1);
            return pair2.get(p-1);
        }
        else if(pair2.size()<p)
        {
            Collections.sort(pair1);
            return pair1.get(p-1);
        }
        else
        {
            // for(i=0;i<Math.min(pair1.size(),pair2.size());i++)
            // {
            //     result.add(Math.min(pair1.get(i),pair2.get(i)));
            // }
            // Collections.sort(result);
            


            for(int val:result)
            System.out.print(val +" ");
            return result.get(p-1);
        }
    }
}