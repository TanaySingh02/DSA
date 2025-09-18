// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]

import java.io.*;
import java.util.*;

class Solution
{

    public static List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result=new ArrayList<>();
        int n=nums.length, n1=0,n2=0,n3=0;
        List<Integer> list=new ArrayList<>(); 

        for(int i=0;i<n-2;i++)
        {
            for(int j=i+1;j<n-1;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    // System.out.println(nums[i]+" "+nums[j]+" "+nums[k]);
                    // if(nums[i]!=nums[j] && nums[j]!=nums[k] && nums[i]!=nums[k])
                    // {
                        
                        if(nums[i]+nums[j]+nums[k] ==0)
                        {
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            result.add(list);
                            list=new ArrayList<>();
                        }
                    // }
                }
            }
        }
        return result;

    }
    public static void main(String ar[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nums[]=new int[n];

        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        List<List<Integer>> result=new ArrayList<>();
        result=threeSum(nums);
        System.out.println("result: "+ result);
    }
}