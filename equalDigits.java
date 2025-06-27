class Solution {
    public boolean hasSameDigits(String s) {
        int i=0;
        String tp="";

        while(s.length()!=2)
            {
                StringBuilder sb= new StringBuilder(); 
                while(i+1!=s.length())
                    {
                        int a=s.charAt(i)-'0';
                        int b= s.charAt(i+1)-'0';
                        sb.append((a+b)%10);
                        i++;
                    }
                i=0;
                s=sb.toString();
            }
        if(s.charAt(0) == s.charAt(1))
            return true;
        else 
            return false;
    }
}©leetcode