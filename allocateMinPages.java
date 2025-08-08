class Solution {

    public int allocateBooks(int arr[], int mid) {
        int a = 1;        
        int maxsum = 0;   

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid) {
                return Integer.MAX_VALUE; // Can't assign this book to any student update maximum/mid
            }

            if (maxsum + arr[i] > mid) {
                a++;                  // Allocated to new student
                maxsum = arr[i];      
            } else {
                maxsum += arr[i];
            }
        }

        return a;
    }

    public int findPages(int[] arr, int k) {
        int i, max = 0, sum = 0, a = 0;

        if (arr.length < k)
            return -1;

        for (i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]); 
            sum += arr[i];               
        }

        int low = max, high = sum, mid, result = -1;

        while (low <= high) {
            mid = (low + high) / 2;
            a = allocateBooks(arr, mid);

            if (a <= k) {
                result = mid;     // Valid maximum but need to minimize it more for minimum maximum
                high = mid - 1;
            } else {
                low = mid + 1;    // Need more maximum per student
            }
        }

        return result;
    }
}