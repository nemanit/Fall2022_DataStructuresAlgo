class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> results = new ArrayList();

        if (n <= 0) {
            return results;
        }

        int initialStart = 0;
        int initialEnd = 0;
        StringBuilder emptyStringBuilder = new StringBuilder();
        backTrackParenthesis(results, emptyStringBuilder, initialStart, initialEnd, n);

        return results;
    }

    public void backTrackParenthesis(List<String> results, StringBuilder stringBuilder, int start, int end, int numberOfPairs) {

        if(stringBuilder.length() == numberOfPairs*2) {
            results.add(stringBuilder.toString());
            return;
        }

        if(start < numberOfPairs) {
            stringBuilder.append("(");
            backTrackParenthesis(results, stringBuilder, start+1, end, numberOfPairs);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

        if(end < start) {
            stringBuilder.append(")");
            backTrackParenthesis(results, stringBuilder, start, end+1, numberOfPairs);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

}