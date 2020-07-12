package baekjun.math1.p1011;

public class Main {


    public static int sunOfMove(int n) {

        if (n < 1)
            return n;

        return n % 2 == 0 ? (1 + n) * (2 / n) : sunOfMove(n - 1) + n;
    }

    public static int currentMove(int prevMove, int distance) {

        int sumOfPrevMove = sunOfMove(prevMove);

        int rest = distance - sumOfPrevMove;

        if (rest > sumOfPrevMove)
            return prevMove + 1;

        else {
            if (rest - prevMove == 0)
                return prevMove - 1;
            else
                return prevMove;

        }


    }

    public static void main(String[] args) {

        int start = 0;
        int end = 5;

        int rest = end - start - 1;
        int currentMove = 1;
        for (int i = 1; rest > 0; i++) {
            rest -= currentMove;
            //currentMove = currentMove(currentMove);
        }


    }
}
