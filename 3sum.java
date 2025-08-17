class Solution {
   
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i, j, twosum = 0, left = 0, right = 0;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        List<List<Integer>> result = new ArrayList<>();

        for (int x : nums) {
            set.add(x);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        // System.out.println(set); 
       

        List<Integer> list = new ArrayList<>(set);
        // List<Integer> inner= new ArrayList<>();
        Collections.sort(list);
        i = 0;
        while (i!=list.size() && list.get(i) < 0) {
            j = list.size() - 1;
            while (j>=0 && list.get(j) > 0) {
                left = list.get(i);
                right = list.get(j);
                twosum = left + right;
                // System.out.println(left + "," + right + "," + twosum * -1);
                if (map.containsKey(twosum * -1)) {
                    if (left <= twosum * -1 && right >= twosum * -1) {
                        if (left == twosum * -1 || right == twosum * -1) {
                            if (map.get(twosum * -1) > 1)
                                result.add(List.of(left, right, twosum * -1));
                        } else
                            result.add(List.of(left, right, twosum * -1));

                    }
                }
                j--;
            }
            i++;
        }
        if(map.containsKey(0) && map.get(0)>=3)
        result.add(List.of(0,0,0));
        return result;
    }
}