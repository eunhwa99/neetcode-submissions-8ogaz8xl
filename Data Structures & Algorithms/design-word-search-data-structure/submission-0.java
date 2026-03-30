
class TrieNode {

  TrieNode[] children = new TrieNode[26];
  boolean endOfWord = false;
}

class WordDictionary {

  TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new TrieNode();
      }
      cur = cur.children[c - 'a'];
    }
    cur.endOfWord = true;
  }

  public boolean search(String word) {
    TrieNode cur = root;
    Queue<TrieNode> que = new LinkedList<>();
    que.add(cur);
    for (char c : word.toCharArray()) {
      int size = que.size();
      while (size-- > 0) {
        cur = que.poll();
        if (c == '.') {
          for (int i = 0; i < 26; i++) {
            if (cur.children[i] != null) {
              que.add(cur.children[i]);
            }
          }
        } else {
          if (cur.children[c - 'a'] != null) {
            que.add(cur.children[c - 'a']);
          }
        }
      }
    }
    while (!que.isEmpty()) {
      cur = que.poll();
      if (cur.endOfWord) {
        return true;
      }
    }
    return false;
  }
}

