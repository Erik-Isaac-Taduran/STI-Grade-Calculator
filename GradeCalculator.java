import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Reminder: Grades are calculated as follows:");
        System.out.println("  - Prelims: 20%");
        System.out.println("  - Midterm: 20%");
        System.out.println("  - Pre Finals: 20%");
        System.out.println("  - Finals: 40%");
        System.out.println();

        // You can change the subject depenends on your schedule
        String[] subjects = {
            "Computer Programming 1",
            "Euthenics 1",
            "Introduction to Computing",
            "National Service Training Program 1",
            "P.E/PATHFIT 1: Movement Competency Training",
            "Purposive Communication",
            "The Contemporary World",
            "Understanding the Self"
        };

        double totalAverage = 0;

        // Loop through each subject
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ":");

            // Get grades for each term
            double prelims = getGrade(input, "  - Prelims: ");
            double midterm = getGrade(input, "  - Midterm: ");
            double preFinals = getGrade(input, "  - Pre Finals: ");
            double finals = getGrade(input, "  - Finals: ");

            // Calculate weighted average
            double average = (prelims * 0.2) + (midterm * 0.2) + (preFinals * 0.2) + (finals * 0.4);
            double gwa = getGWA(average);

            totalAverage += average;

            System.out.println("    Average: " + String.format("%.2f", average));
            System.out.println("    GWA: " + String.format("%.2f", gwa));
            System.out.println();
        }

        // Calculate final GWA
        double finalAverage = totalAverage / subjects.length;
        double finalGWA = getGWA(finalAverage);

        System.out.println("Final Average: " + String.format("%.2f", finalAverage));
        System.out.println("Total GWA: " + String.format("%.2f", finalGWA));

        input.close();
    }

    // This method asks for a valid number input
    public static double getGrade(Scanner input, String message) {
        while (true) {
            System.out.print(message);
            try {
                double grade = input.nextDouble();
                return grade;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next(); // clear wrong input
            }
        }
    }

    // This method converts average to GWA based on grade table
    public static double getGWA(double average) {
        if (average >= 97.5)
            return 1.0;
        else if (average >= 94.5)
            return 1.25;
        else if (average >= 91.5)
            return 1.5;
        else if (average >= 88.5)
            return 1.75;
        else if (average >= 85.5)
            return 2.0;
        else if (average >= 81.5)
            return 2.25;
        else if (average >= 77.5)
            return 2.5;
        else if (average >= 73.5)
            return 2.75;
        else if (average >= 69.5)
            return 3.0;
        else
            return 5.0;
    }
}
