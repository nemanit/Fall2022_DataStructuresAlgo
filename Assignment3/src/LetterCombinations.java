class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> resultList = new ArrayList<>();


        if(digits == null) {
            return resultList;
        }

        if(digits.length() == 0) {
            return resultList;
        }


        // creating a hash map for easier lookup of numbers and characters
        Map<Character, String> numberCharacterMap = new HashMap<>();
        numberCharacterMap.put('2', "abc");
        numberCharacterMap.put('3', "def");
        numberCharacterMap.put('4', "ghi");
        numberCharacterMap.put('5', "jkl");
        numberCharacterMap.put('6', "mno");
        numberCharacterMap.put('7', "pqrs");
        numberCharacterMap.put('8', "tuv");
        numberCharacterMap.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        StringBuilder emptyStringBuilder = new StringBuilder();
        int initialIndex = 0;

        stringCombinations(initialIndex, digits, emptyStringBuilder, resultList, numberCharacterMap);

        return resultList;


    }

    private void stringCombinations(int index, String digits, StringBuilder stringBuilder, List<String> resultList, Map<Character, String> numberCharacterMap) {


        if(index == digits.length()) {
            resultList.add(stringBuilder.toString());
            return;
        }

        String string = numberCharacterMap.get(digits.charAt(index));
        for(int i = 0; i < string.length(); i++) {
            stringBuilder.append(string.charAt(i));
            stringCombinations(index + 1, digits, stringBuilder, resultList, numberCharacterMap);
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
    }

}