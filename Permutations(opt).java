class Solution {
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if(nums.length==1)
        {
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        boolean[] marked=new boolean[nums.length];
        permutations(result,list,nums,marked);
        return result;
    }
    
    public static void permutations(List<List<Integer>> result,List<Integer> list,int[] nums, boolean[] marked)
    {
        if(list.size()==nums.length)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(marked[i]==true)
            continue;
            marked[i]=true;
            list.add(nums[i]);
            permutations(result,list,nums,marked);
            list.remove(list.size()-1);
            marked[i]=false;
        }
    }

}