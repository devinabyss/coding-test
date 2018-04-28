package hackerrank.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

class GradingStudents {

    private static final Logger logger = LoggerFactory.getLogger(GradingStudents.class);

    static int[] gradingStudents(int[] grades) {

//
//        Arrays.stream(grades).forEach(grade -> {
//            grade = grade(grade);
//
//        });

        return Arrays.stream(grades).map(grade -> grade(grade)).toArray();

    }

    private static int grade(int grade) {

        if (grade < 38) {
            return grade;
        }

        int remain = grade % 5;
        logger.info("## remain : {}", remain);

        return remain > 2 ? grade + (5 - remain) : grade;

    }


    public static void main(String[] args) throws IOException {


        int[] grades = {73, 67, 38, 33};

        GradingStudents gradingStudents = new GradingStudents();

        int[] result = gradingStudents.gradingStudents(grades);

        logger.info(Arrays.toString(result));


    }
}
