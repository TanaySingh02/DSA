//LEETCODE 455. Assign Cookies

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l=g.length-1,r=s.length-1,count=0;

        while(l!=-1 && r!=-1)
        {
            if(g[l]>s[r])
            l--;
            else
            {
                count++;
                l--;
                r--;
            }
        }
        return count;
        
    }
}