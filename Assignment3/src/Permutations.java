class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> emptyList = new ArrayList<>();
        backTrackPermute(resultList, emptyList, nums);
        return resultList;

    }
    private void backTrackPermute(List<List<Integer>> resultList, List<Integer> currentList, int [] nums){

        if(currentList.size() == nums.length){
            List<Integer> subResultList = new ArrayList<>(currentList);
            resultList.add(subResultList);
        }
        else {
            for(int index = 0; index < nums.length; index++){

                if(currentList.contains(nums[index])) {
                    continue;
                }

                currentList.add(nums[index]);

                backTrackPermute(resultList, currentList, nums);

                currentList.remove(currentList.size() - 1);
            }
        }
    }

}