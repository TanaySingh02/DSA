public class Solution {
    public String removeKdigits(String num, int k) {
        int i,j=0,min=Integer.MAX_VALUE,anchor=0,curr=0;
        int need=num.length()-k,lastmin=0,limit=num.length()-k;
        char currchar;
        String result="";
        boolean flag=true;

        if(num.length()==k)
        return "0";
        //to check if array is sorted
        for (i = 1; i < num.length(); i++) {
            if (num.charAt(i) < num.charAt(i - 1)) 
                flag = false;
            }
        if(flag)
        {
            return num.substring(0,num.length()-k);
        }

        while(need!=0)
        {
            min=Integer.MAX_VALUE;
            for(j=anchor;j<=num.length()-need;j++)
            {
                currchar=num.charAt(j);
                curr=currchar-'0';
                if(curr<min)
                {
                    min=curr;
                    anchor=j+1;
                }
            }
            result+=min;
            need--;
        }


        // for(j=0;j<result.length();j++)
        //     {
        //         if(result.charAt(j)!='0')
        //         return result.substring(j,result.length());
        //         else 
        //         {
        //             if(j==result.length()-1)
        //             return "0";
        //         }

        result=result.replaceAll("^0+", "");
        if(result.isEmpty())
        return "0";
        else
        return result;
            }

        }