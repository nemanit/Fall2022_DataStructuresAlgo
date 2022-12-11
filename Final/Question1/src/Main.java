package Question1.src;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] givenWordsArray = {"eat","tea","tan","ate","nat","bat"};
        ArrayList<ArrayList<String>> result = groupAnagrams(givenWordsArray);

        for(ArrayList<String> list: result){
            System.out.println(list);
        }
    }

    // Time complexity is O(m*n) as we are sorting the characters in the words where m is the word length and n is the number of words
    // Space complexity is O(n) as we create a hashmap of n words at max;
    public static ArrayList<ArrayList<String>> groupAnagrams(String[] givenWordsArray) {

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        // if given words array is empty, just return empty list
        if(givenWordsArray.length == 0) {
            return result;
        }

        // hashmap used for storing anagram as key and list of anagram words in values
        HashMap<String, ArrayList<String>> anagramListOfWordsMap = new HashMap<>();

        for(int i = 0; i < givenWordsArray.length; i++) {
            String givenWord = givenWordsArray[i];
            char[] characterArray = givenWord.toCharArray();
            Arrays.sort(characterArray);

            // sorted character will be an anagram, easier to check if it exists in the hasmap or not
            String anagram = String.valueOf(characterArray);

            // if the anagram is not found, we create a new list with the given word
            if(!anagramListOfWordsMap.containsKey(anagram)) {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(givenWord);
                anagramListOfWordsMap.put(anagram, newList);
            } else {
                // if the anagram is found, we add the given word to already existing list of words
                ArrayList<String> existingList = anagramListOfWordsMap.get(anagram);
                existingList.add(givenWord);
                anagramListOfWordsMap.put(anagram, existingList);
            }
        }
        result.addAll(anagramListOfWordsMap.values());
        return result;
    }
}

