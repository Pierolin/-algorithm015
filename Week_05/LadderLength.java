package algorithm015.Week_05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderLength {
    int count = 1;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, Integer> used = new HashMap<>();
        findNext(beginWord, endWord, wordList, used);
        return count;
    }

    private void findNext(String beginWord, String endWord, List<String> wordList, Map used) {
        // TPDR

        for (int i = 0; i < wordList.size(); i++) {
            String key = wordList.get(i);
            if (used.containsKey(key)) continue;
            String word = wordList.get(i);
            if (isNext(beginWord, word)) {
                count++;
                used.put(key, 1);
                if (word.equals(endWord)) {
                    return;
                } else {
                    findNext(word, endWord, wordList, used);
                }
                break;
            }
        }
    }

    private boolean isNext(String wordA, String wordB) {
        char[] charsA = wordA.toCharArray();
        char[] charsB = wordB.toCharArray();
        int diffCount = 0;
        for (int i = 0; i < charsA.length; i++) {
            if (charsA[i] != charsB[i]) {
                if (diffCount > 0) return false;
                diffCount++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LadderLength ladderLength = new LadderLength();
        List<String> wordList = new ArrayList<>();

        String beginWord = "hit";
        String endWord = "cog";
        wordList.add("cog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("dog");
        wordList.add("hot");
        wordList.add("dot");





        int length = ladderLength.ladderLength(beginWord, endWord, wordList);
        System.out.println("length: " + length);
    }
}
