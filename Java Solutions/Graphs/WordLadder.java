import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * lengths are the same
 * endword must be in list, start word may NOT be in list
 * 
 * ex. 
 * Input: beginWord = "hit", endWord = "cog", 
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if (!wordList.contains(endWord)) 
            return 0;
        /**
         * What should be in our adjList?
         * keys should be ho*, h*t, *ot
         * the lists should be words that have that key
         */
        Map<String, List<String>> adjList = new HashMap<>();
        wordList.add(beginWord);

        // Initialize the adjacency list
        for (String word : wordList){

            StringBuilder sb = null;
            String key;
            List<String> values;

            // Create each key
            for (int i = 0; i < word.length(); i++){

                // Create the key by replacing a single character with a star
                sb = new StringBuilder(word);
                sb.setCharAt(i, '*');
                key = sb.toString();

                if (adjList.containsKey(key))
                    values = adjList.get(key);          
                else
                    values = new ArrayList<>();

                values.add(word);
                adjList.put(key, values);

            }

        }

        // A queue of words we should explore
        // Can we get from the beginWord to the endWord?
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        // Keep track of words we already explored
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int steps = 1;

        StringBuilder sb = null;

        while (!q.isEmpty()){

            steps++;

            // Remember to save the current size of the queue before exploring
            int size = q.size();

            // Explore each word in the queue
            for (int i = 0; i < size; i++){

                String str = q.poll();
                // If we check visited set here, it takes way longer. Why?
                //visited.add(str);

                // Check every variation of the word
                for (int j = 0; j < str.length(); j++){

                    sb = new StringBuilder(str);
                    sb.setCharAt(j,'*');

                    // If the pattern exists in our adjList,
                    // Add the words that match the pattern to the queue
                    for (String word : adjList.get(sb.toString())){

                        // If we found the endWord, we are finished
                        if (word.equals(endWord))
                            return steps;
                        
                        // If we already explored the word, don't add it to our queue
                        if (visited.contains(word))
                            continue;

                        // Otherwise, add the new word to the queue and
                        // our visited set
                        q.offer(word);
                        visited.add(word);

                    }
                }
            }
        }

        return 0;
        
    }
}
