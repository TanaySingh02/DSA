import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        int i,curr;
        // num1=Integer.parseInt(a,2);
        // num2=Integer.parseInt(b,2);
        // return Integer.toBinaryString(num1+num2);
        BigInteger numa=new BigInteger(a,2);
        BigInteger numb=new BigInteger(b,2);
        System.out.println(numa);
        System.out.println(numb);
        int num1=0;
        int num2=0;
        // for(i=a.length()-1;i>=0;i--)
        // {
        //     curr=a.charAt(i)-'0';
        //     num1+=curr*Math.pow(2,(a.length()-1)-i);
        // }
        // for(i=b.length()-1;i>=0;i--)
        // {
        //     curr=b.charAt(i)-'0';
        //     num2+=curr*Math.pow(2,(b.length()-1)-i);
        // }
        BigInteger sum=numa.add(numb);
        return sum.toString(2);

    }
}