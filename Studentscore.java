import java.util.Scanner;

public class Studentscore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter student's score (0-100): ");
        int score = sc.nextInt();
        
        char grade;
        String feedback;
        
        if (score >= 90) {
            grade = 'A';
            feedback = "Excellent!";
        } else if (score >= 80) {
            grade = 'B';
            feedback = "Very good!";
        } else if (score >= 70) {
            grade = 'C';
            feedback = "Good!";
        } else if (score >= 60) {
            grade = 'D';
            feedback = "Satisfactory";
        } else if (score >= 50) {
            grade = 'E';
            feedback = "Passed, but study harder";
        } else {
            grade = 'F';
            feedback = "Failed, please retake";
        }
        
        System.out.println("\nGrade: " + grade);
        System.out.println("Feedback: " + feedback);
        
        sc.close();
    }
}