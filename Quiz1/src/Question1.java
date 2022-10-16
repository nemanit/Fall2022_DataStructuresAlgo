class Solution {
    public void rotate(int[] nums, int k) {

        int lengthOfArray = nums.length;

        if (k < 0) {
            return;
        }

        if (lengthOfArray <= 1) {
            return;
        }

        int[] temporaryArray = new int[lengthOfArray];


        for (int index = 0; index < lengthOfArray; index++) {
            temporaryArray[(index + k) % nums.length] = nums[index];
        }

        // copy all elements from temporary array to nums
        for (int index = 0; index < lengthOfArray; index++) {
            nums[index] = temporaryArray[index];
        }

        return;
    }
}


