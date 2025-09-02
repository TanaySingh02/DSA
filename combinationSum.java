import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        
        // Convert int[] to List<Integer>
        for (int num : candidates) nums.add(num);
        Collections.sort(nums); // sort for pruning & binary search
        
        backtrack(result, new ArrayList<>(), nums, target);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, List<Integer> candidates, int target) {
        if (target == 0 ) {
            result.add(new ArrayList<>(path));
            return;
        }

        int floorIndex = floorbs(candidates, target);
        if (floorIndex == -1) return;

        List<Integer> usableCandidates = candidates.subList(0, floorIndex + 1);
        
        for (int i = 0; i <= floorIndex; i++) {
            int candidate = usableCandidates.get(i);
            path.add(candidate);
            // Reuse same candidate: pass sublist starting from current
            backtrack(result, path, usableCandidates.subList(i, usableCandidates.size()), target - candidate);
            path.remove(path.size() -1); // backtrack
        }
    }

    private int floorbs(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
