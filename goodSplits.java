class Solution {
    public int numSplits(String s) {
        int i, good=0;
        HashMap<Character, Integer> left=new HashMap<>();
        HashMap<Character, Integer> right=new HashMap<>();
        boolean found=false;

        for(char curr: s.toCharArray())
        right.put(curr,right.getOrDefault(curr,0)+ 1);

        if(right.size()==1)
        return s.length()-1;

        for(char curr: s.toCharArray())
        {
            left.put(curr,left.getOrDefault(curr,0)+1);
            right.put(curr,right.get(curr)-1);
            if(right.get(curr)==0)
            right.remove(curr);
            if(left.size()==right.size())
            {
                found=true;
                good++;
            }
            else
            {
                if(found==true)
                break;
            }
        }

        return good;


    }
}