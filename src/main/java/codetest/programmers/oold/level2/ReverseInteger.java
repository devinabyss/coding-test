package codetest.programmers.oold.level2;

/**
 * Created by HK on 2018-04-19.
 */
public class ReverseInteger {


    public int reverseInt(int n) {

        String origin = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        origin.chars().sorted().forEach(character -> sb.replace(0, sb.length(), Character.valueOf((char) character) + sb.toString()));

//        String str = String.valueOf(n);
//
//        int[] array = new int[str.length()];
//
//        for (int i = 0; i < str.length(); i ++) {
//            array[i] = Integer.valueOf(str.substring(i,i+1));
//        }
//
//        sort(array);
//
//        String result = "";
//        for(int i =0; i < array.length; i++){
//            result += String.valueOf(array[i]);
//        }

        return Integer.valueOf(sb.toString());
    }


    public void sort(int[] array) {

        if (array.length > 1) {
            sort(array, 0, array.length - 1);
        }
    }

    private void sort(int[] array, int low, int high) {

        int pivotPos = low + (high - low) / 2;
        int pivot = array[pivotPos];
        int originLow = low;
        int originHigh = high;

        while (low <= high) {
            while (array[low] > pivot) {
                low++;
            }

            while (array[high] < pivot) {
                high--;
            }

            if (low <= high) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
                low++;
                high--;
            }
        }

        if (originLow < high) {
            sort(array, originLow, high);
        }

        if (originHigh > low) {
            sort(array, low, originHigh);
        }

    }


    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverseInt(118372));
    }

}
