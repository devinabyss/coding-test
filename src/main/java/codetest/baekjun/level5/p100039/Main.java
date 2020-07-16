package codetest.baekjun.level5.p100039;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> scores = new ArrayList<>();
        while (scanner.hasNext()) {
            scores.add(scanner.nextInt());
        }
        int average = scores.stream().mapToInt(score -> score > 40 ? score : 40).sum() / scores.size();
        System.out.println(average);
    }
}
