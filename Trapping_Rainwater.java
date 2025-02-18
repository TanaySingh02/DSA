class Solution {
    public int trap(int[] height) {
        int i,l=0,r=height.length-1,lmax=0,rmax=0,trap=0;
        Stack<Integer> stl=new Stack<>();
        Stack<Integer> str=new Stack<>();

        // for(i=0;i<height.length-1;i++)
        // {
        //     if(height[i]<height[i+1])
        //     break;
        // }
        // if(i==height.length-1)
        // return 0;

        // for(i=0;i<height.length-1;i++)
        // {
        //     if(height[i]<height[i+1])
        //     continue;
        //     else
        //     break;
        // }
        // if(i==height.length-1)
        // return 0;

        // for(i=0;i<height.length-1;i++)
        // {
        //     if(height[i]>height[i+1])
        //     continue;
        //     else
        //     break;
        // }
        // if(i==height.length-1)
        // return 0;
        
        while(l<r)
        {
            lmax=Math.max(lmax,height[l]);
            rmax=Math.max(rmax,height[r]);

            if(lmax<rmax)
            {
                trap+=lmax-height[l];
                l++;
            }
            else
            {
                trap+=rmax-height[r];
                r--;
            }
        }
        
        // for(i=1;i<height.length-1;i++)
        // {
        //     l=i-1;
        //     r=i+1;
        //     while(l>=0)
        //     {
        //         if(height[l]>height[i])
        //         maxl=Math.max(maxl,height[l]);
        //         l--;
        //     } 
        //     while(r<height.length)
        //     {
        //         if(height[r]>height[i])
        //         maxr=Math.max(maxr,height[r]);
        //         r++;
        //     }
        //     minh=Math.min(maxr,maxl)-height[i];
        //     if(minh>0)
        //     trap+=minh;
        //     maxr=0;
        //     maxl=0;
        // }
        return trap;

    }
}