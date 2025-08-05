class Solution {
    public int adjustPivot(Map<String, Integer> tallyMap, Map<String, Integer> wordMap, int pivot, String s, int wordLen) {
        while (true) {
            boolean adjusted = false;

            for (String key : wordMap.keySet()) {
                if (tallyMap.getOrDefault(key, 0) > wordMap.get(key)) {
                    String word = s.substring(pivot, pivot + wordLen);
                    tallyMap.put(word, tallyMap.get(word) - 1);
                    pivot += wordLen;
                    adjusted = true;
                    break; // exit for-loop and check again from start
                }
            }

            if (!adjusted) break; // exit loop if no adjustment needed
        }

        return pivot;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int totalWords = words.length;
        int concatLen = wordLen * totalWords;

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {
            int pivot = offset;
            Map<String, Integer> tallyMap = new HashMap<>();

            for (int i = offset; i + wordLen <= s.length(); i += wordLen) {
                String word = s.substring(i, i + wordLen);

                if (wordMap.containsKey(word)) {
                    tallyMap.put(word, tallyMap.getOrDefault(word, 0) + 1);

                    if ((i + wordLen - pivot) == concatLen) {
                        int newPivot = adjustPivot(tallyMap, wordMap, pivot, s, wordLen);
                        if (pivot == newPivot) {
                            result.add(pivot);
                            String removeWord = s.substring(pivot, pivot + wordLen);
                            tallyMap.put(removeWord, tallyMap.get(removeWord) - 1);
                            pivot += wordLen;
                        } else {
                            pivot = newPivot;
                        }
                    }
                } else {
                    tallyMap.clear();
                    pivot = i + wordLen;
                }
            }
        }

        return result;
    }
}
