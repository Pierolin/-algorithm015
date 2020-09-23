package algorithm015.Week_05;

import java.util.*;

public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        Queue<String> wordQueue = new LinkedList<>();
        Set<String> visitedSet = new HashSet<>();
        wordQueue.add(beginWord);
        visitedSet.add(beginWord);
        int steps = 1;

        while (!wordQueue.isEmpty()) {
            int size = wordQueue.size();
            for (int i = 0; i < size; i++) {
                String word = wordQueue.poll();
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chars[j] == c) continue;
                        chars[j] = c;
                        String tempWord = String.valueOf(chars);
                        if (tempWord.equals(endWord)) {
                            return steps + 1;
                        }
                        if (visitedSet.contains(tempWord)) {
                            continue;
                        }
                        if (wordSet.contains(tempWord)) {
                            wordQueue.add(tempWord);
                            visitedSet.add(tempWord);
                        }
                    }
                    chars[j] = originChar;
                }
            }
            steps++;
        }
        return 0;
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
