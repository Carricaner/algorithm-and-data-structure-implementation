package com.example.datastructure.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

  private final TrieNode root;

  public Trie() {
    root = new TrieNode(null);
  }

  public void insert(String word) {
    TrieNode current = root;
    for (char c : word.toCharArray()) {
      TrieNode node = current.getChildren().get(c);
      if (node == null) {
        node = new TrieNode(c);
        current.getChildren().put(c, node);
      }
      current = node;
    }
    current.isEndOfWord = true;
  }

  public boolean search(String word) {
    TrieNode current = root;
    for (char c : word.toCharArray()) {
      TrieNode node = current.getChildren().get(c);
      if (node == null) {
        return false;
      }
      current = node;
    }
    return current.isEndOfWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode current = root;
    for (char c : prefix.toCharArray()) {
      TrieNode node = current.getChildren().get(c);
      if (node == null) {
        return false;
      }
      current = node;
    }
    return true;
  }

  static class TrieNode {
    private final Character data;
    private final Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode(Character data) {
      this.data = data;
      this.children = new HashMap<>();
    }

    public boolean isEndOfWord() {
      return isEndOfWord;
    }

    public Character getData() {
      return data;
    }

    public Map<Character, TrieNode> getChildren() {
      return children;
    }
  }
}
