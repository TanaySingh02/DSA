import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int len = p.length();
        int[] pmap = new int[26];
        int[] smap = new int[26];

        for (char c : p.toCharArray()) {
            pmap[c -'a']++;
        }

        int i = 0;
        for (int k=0; k <s.length(); k++) {
            smap[s.charAt(k) -'a']++;
            if (k-i+1>len) {
                smap[s.charAt(i) -'a']--;
                i++;
            }
            if (k-i+1==len) {
                if (Arrays.equals(smap, pmap)) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}
