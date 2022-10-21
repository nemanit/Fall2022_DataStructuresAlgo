class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> emptyResultList = new ArrayList<>();

        resultList.add(emptyResultList);

        if(nums == null) {
            return resultList;
        }

        if(nums.length == 0) {
            return resultList;
        }

        List<List<Integer>> tempResultList = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            for(List<Integer> subResultList : resultList){
                List<Integer> subList = new ArrayList<>(subResultList);
                subList.add(nums[i]);

                tempResultList.add(subList);
            }
            resultList.addAll(tempResultList);
            tempResultList.clear();
        }

        return resultList;

    }
}