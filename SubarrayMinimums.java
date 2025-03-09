class Solution {
    public int sumSubarrayMins(int[] arr) {
        int i, j, min = Integer.MAX_VALUE;
        Stack<Integer> st = new Stack<>();
        int nse[] = new int[arr.length];
        int pse[] = new int[arr.length];

        long sum = 0;

        for (i = 0; i < arr.length; i++) // stack of previous smaller elemtent
        {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for (i = arr.length - 1; i >= 0; i--) // stack of next equal and smallest element
        {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }

        int MOD = 1000000007;
        for (i = 0; i < arr.length; i++) {
            sum += (long) ((i - pse[i]) * (nse[i] - i)) % MOD * arr[i];
        }

        return (int) (sum % MOD + MOD) % MOD;

    }
}
