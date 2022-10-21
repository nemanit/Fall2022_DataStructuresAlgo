class Solution {
    public int[] numsSameConsecDiff(int n, int k) {

        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        for (int i = 2; i <= n; ++i) {

            List<Integer> subNumberList = new ArrayList<>();

            for (int x : numberList) {

                int y = x % 10;
                if (y + k < 10) {
                    subNumberList.add(x * 10 + y + k);
                }

                if (k > 0 && y - k >= 0) {
                    subNumberList.add(x * 10 + y - k);
                }
            }
            numberList = subNumberList;
        }
        return numberList.stream().mapToInt(j->j).toArray();

    }
}