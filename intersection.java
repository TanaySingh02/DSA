class Solution {
    public List<Integer> intersection(int[][] nums) {
        Set<Integer> result = new HashSet<>();
        
        for (int num : nums[0]) {
            result.add(num);
        }

        for (int i = 1; i < nums.length; i++) {
            Set<Integer> currentSet = new HashSet<>();
            for (int num : nums[i]) {
                currentSet.add(num);
            }
            result.retainAll(currentSet); 
        }

        List<Integer> output = new ArrayList<>(result);
        Collections.sort(output);
        return output;

        
    }
}