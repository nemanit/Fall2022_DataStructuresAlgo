class Solution {
    List<List<Integer>> returnList = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int initialSum = 0;
        int initialIndex = 0;
        List<Integer> emptyArray = new ArrayList<Integer>();

        backTrackSum(initialSum, emptyArray, candidates, initialIndex, target);

        return returnList;
    }

    void backTrackSum(int currentSum, List<Integer> currentList,  int[] candidates, int currentIndex, int target) {

        if(currentSum == target) {
            List<Integer> returnSubList = new ArrayList<>(currentList);
            returnList.add(returnSubList);
            return;
        }

        for(int index=currentIndex;  index < candidates.length;  index++) {

            if(currentSum + candidates[index] <= target) {
                currentList.add(candidates[index]);

                backTrackSum(currentSum + candidates[index], currentList, candidates, index, target);

                currentList.remove(currentList.size()-1);
            }
        }
    }

}