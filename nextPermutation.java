class Solution {
    public void nextPermutation(int[] arr) {
        int i, j, pivot=0,pos=-1,sub=0;
        
        for(i=0;i<arr.length-1;i++)
        {
            if(arr[i+1]>arr[i])
            pos=i;
        }
        // System.out.println(pos);
        if(pos==-1)
        Arrays.sort(arr);
        else
        {
            for(i=pos+1;i<arr.length;i++)
            {
                if(arr[pos]<arr[i])
                {
                    if(sub==0)
                    {
                    sub=arr[i];
                    pivot=i;
                    }
                    else if(sub>arr[i])
                    {
                    sub=arr[i];
                    pivot=i;
                    }
                }
            }
            // System.out.println(pivot+" "+ sub);
            int temp=arr[pos];
            arr[pos]=sub;
            arr[pivot]=temp;
            
            Arrays.sort(arr, pos+1,arr.length);
        }
        // int i,j,temp=0,flag=-1,min=0;
        // for(i=nums.length-1;i>0;i--)
        // {
        //     if(nums[i]>nums[i-1])
        //     {
        //         flag=0;
        //         break;
        //     }
        //     }
        // if(flag==0)
        // {
        //     min=i;
        //     for(j=i;j<nums.length-1;j++)
        //     {
        //         if(nums[j]<nums[j+1] && nums[j]>nums[i-1])
        //         min=j;
        //         // else
        //         // min=j+1;
        //     }
        //     //swap
        //     temp=nums[i-1];
        //     nums[i-1]=nums[min];
        //     nums[min]=temp;
        //     Arrays.sort(nums,i,nums.length);
        // }
        // else
        // Arrays.sort(nums);
    }
}