public class StudentInfo {
    public static void main(String[] args){

        String name = "Adhithi";

        int grade1;
        grade1 = 1;

        int grade2;
        grade2 = 2;

        int grade3;
        grade3 = 3;

        int grade4;
        grade4 = 4;

        int grade5;
        grade5 = 5;

        double avg12;
        avg12 = (grade1 + grade2) /2;

        double avg34;
        avg34 = (grade3 + grade4) /2;

        double finalavg;
        finalavg = (avg12 + avg34 + grade5) /3;

        System.out.println(finalavg);
    }}