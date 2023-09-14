package com.p01s0n0us.leetcode.replace_words;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        new Solution().replaceWords(Arrays.asList("cat", "bat", "rat"), "the cat was rat by the bat");

    }
}

class Solution {


    public String replaceWords(List<String> dictionary, String sentence) {
        Node dummy = new Node();

        for (String dict : dictionary) {
            build(dict, 0, dummy);
        }

        String[] words = sentence.split("\\s");
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            int i = 0;
            boolean matched = false;
            Node root = dummy;
            while (!root.children.isEmpty() && !root.word && i < word.length()) {
                char ch = word.charAt(i++);
                if (!root.children.containsKey(ch)) {
                    break;
                } else {
                    Node node = root.children.get(ch);
                    if (node.word) {
                        matched = true;
                        break;
                    } else {
                        root = node;
                    }
                }
            }

            if (matched) {
                words[j] = word.substring(0, i);
            }
        }

        return String.join(" ", words);
    }

    public void build(String word, int index, Node root) {
        if (index >= word.length()) {
            return;
        }

        char ch = word.charAt(index);

        Node node = new Node();
        node.letter = ch;
        node.word = index == word.length() - 1;

        if (root.children.isEmpty()) {
            root.children.put(node.letter, node);
            build(word, index + 1, node);
        } else {
            Node match = root.children.get(node.letter);

            if (match != null) {
                match.word |= node.word;
            } else {
                root.children.put(node.letter, node);
                match = node;
            }
            build(word, index + 1, match);
        }
    }
}


class Node {
    public char letter;

    public boolean word;

    public Map<Character, Node> children = new HashMap<>();

}