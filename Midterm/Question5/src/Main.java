package Question5.src;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] arr = {0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11};
        int[] values = {1,4,5,10};
        int[] answer = getStartOfEachValues(arr, values);

        for (int i = 0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }
    }


    // Time complexity O(n) as we traverse through arr only once assuming m is going to be less than n else it is O(m)
    // Space complexity O(m) as output of same size of values array is stored in another array
    // arr = [0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11]
    // values = [1,4,5,10]
    // output = [5, -1, 12, 17]
    private static int[] getStartOfEachValues(int[] arr, int[] values){
        int[] indexes = new int[values.length];

        for(int i = 0; i < values.length; i++) {
            indexes[i] = -1;
        }

        int indexOfValuesArray = 0;

        int i = 0;
        while (i < arr.length) {
            if(indexOfValuesArray >= values.length) {
                break;
            }
            int valueOfInterest = values[indexOfValuesArray];
            int valueofArr = arr[i];
            System.out.println("cool: valueOfInterest" + valueOfInterest);
            System.out.println("cool: valueofArr" + valueofArr);
            System.out.println("index"+ i);

            if(valueofArr < valueOfInterest) {
                i = i + 1;
                continue;
            } else if(valueofArr == valueOfInterest) {
                indexes[indexOfValuesArray] = i;
                indexOfValuesArray = indexOfValuesArray + 1;
                i = i + 1;
            } else if (valueofArr > valueOfInterest) {
                System.out.println("I came inside: " + i);
                while (valueofArr > valueOfInterest) {
                    i = i + 1;
                    valueofArr = arr[i];
                    indexOfValuesArray = indexOfValuesArray + 1;
                    valueOfInterest = values[indexOfValuesArray];
                }
            }
        }
        return indexes;
    }
}