package com.example.datastructure.trie;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Trie")
class TrieTest {
  @Test
  @DisplayName("search")
  void testSearch() {
    Trie trie = new Trie();
    trie.insert("hello");
    trie.insert("eagle");
    trie.insert("mango");
    assertThat(trie.search("hello")).isTrue();
    assertThat(trie.search("hell")).isFalse();
  }

  @Test
  @DisplayName("startWith")
  void testStart_With() {
    Trie trie = new Trie();
    trie.insert("hello");
    trie.insert("eagle");
    trie.insert("mango");
    assertThat(trie.startsWith("hell")).isTrue();
    assertThat(trie.startsWith("mani")).isFalse();
  }
}
