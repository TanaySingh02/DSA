//Solution using Newton Raphson method
class Solution {
    public double squareRoot(int n, int p) {
        double x = n;
        double epsilon = Math.pow(10, -(p + 3));
        
        while (true) {
            double next = 0.5 * (x + n / x);
            if (Math.abs(next - x) < epsilon)
                break;
            x = next;
        }
        
        return truncate(x, p);
    }

    private double truncate(double value, int p) {
        double factor = Math.pow(10, p);
        return Math.floor(value * factor) / factor;
    }
}

// Solution using Binary Search Square root approach
class Solution {
    public double squareRoot(int n, int p) {
        int start = 0, end = n;
        double ans = 0.0;

        // Step 1: Binary search for integer part
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((long)mid * mid == n) {
                ans = mid;
                break;
            }
            if ((long)mid * mid < n) {
                ans = mid;  // possible answer
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Step 2: Refine for decimal places
        double increment = 0.1;
        for (int i = 0; i < p; i++) {
            while (ans * ans <= n) {
                ans += increment;
            }
            ans -= increment; // step back
            increment /= 10;
        }

        return ans;
    }
}


