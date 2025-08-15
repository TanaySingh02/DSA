class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> slist=new ArrayList<>();
        permutehelper(nums, list, slist);
        return list;
    }
    private void permutehelper(int[] nums, List<List<Integer>> list, List<Integer> slist) {
        if(slist.size()==nums.length)
        {
        list.add(new ArrayList<>(slist));
        return ;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(slist.contains(nums[i]))
            {
                continue;
            }
            slist.add(nums[i]);
            permutehelper(nums, list, slist);
            slist.remove(slist.size()-1);
        }   
        // return list;     
    }
}


