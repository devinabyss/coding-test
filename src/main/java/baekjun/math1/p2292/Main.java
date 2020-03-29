package baekjun.math1.p2292;

import java.util.Scanner;

public class Main {

    public static int soleve(int input){

        int max = 1;
        int count = 0;
        int gop = 0;


        for (int i = 0; max <= input; i++ ){





        }

        return count;
    }


    public static void main(String[] args) {



//        Scanner scanner = new Scanner(System.in);
//
//        int input = scanner.nextInt();
//        1
//        2-7 6 -> 2nd ->  2x1 +1
//        8-19 12 -> 3rd ->  9 11 13 15 17 19
//        20-37 18 -> 4th
//        38-61 24

        //System.out.println(scope);

        int[] inputs = {13, 25, 39};

        for(int input : inputs) {
            System.out.println(soleve(input));
        }

    }
}
