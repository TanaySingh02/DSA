// 735. Asteroid Collision

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int i,flag=0;
        Stack<Integer> st=new Stack<>();

        for(i=0;i<asteroids.length;i++)
        {
            if(st.isEmpty())
            st.push(asteroids[i]);
            else
            {
                while(!st.isEmpty() && st.peek()>0 && asteroids[i]<0)
                {
                    if(Math.abs(st.peek())<Math.abs(asteroids[i]))
                    {
                        st.pop();
                    }
                    else if(Math.abs(st.peek())==Math.abs(asteroids[i]))
                    {
                        st.pop();
                        flag=1;
                        break;
                    }
                    else
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                st.push(asteroids[i]);
                else
                flag=0;
            }  
        }
        int result[] = new int[st.size()];
          int s=st.size();
          while(!st.isEmpty())
          {
            result[--s]=st.pop();
          }
        return result;

        
    }
}