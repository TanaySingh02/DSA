class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int largest=-1;
        if(k == nums.length){
            int max = 0;
            for(int ele: nums){
                max = Math.max(ele, max);
            }
            return max;
        }
        if(k >= 2){
            if(map.get(nums[0]) == 1) largest = nums[0];
            if(map.get(nums[nums.length-1]) == 1 && largest < nums[nums.length-1]){
                largest = nums[nums.length-1];
            }
            return largest;
        }

        for(int ele: nums){
            if(map.get(ele)==1){
                largest = Math.max(largest, ele);
            }
        }
        
        return largest;
    }
}