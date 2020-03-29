package baekjun.level5.p5543;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] burgers = new int[3];
        int[] bevers = new int[2];
        for (int i = 0; i < 5; i++) {
            if (i < 3)
                burgers[i] = scanner.nextInt();
            else
                bevers[i - 3] = scanner.nextInt();
        }

        int cheapSetPrice = Arrays.stream(burgers).min().getAsInt() + Arrays.stream(bevers).min().getAsInt() - 50;

        System.out.println(cheapSetPrice);
    }
}
