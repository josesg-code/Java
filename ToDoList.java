import java.util.*;
import java.io.*;

public class ToDoList {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        // Load tasks from file when program starts
        File file = new File("tasks.txt");
        if (file.exists()) {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                tasks.add(fileScanner.nextLine());
            }
            fileScanner.close();
        }

        int choice = 0;

        while (choice != 4) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter task: ");
                String task = scanner.nextLine();
                tasks.add(task);
                System.out.println("Added!");
            }

            else if (choice == 2) {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
            }

            else if (choice == 3) {
                System.out.print("Enter task number to delete: ");
                int num = scanner.nextInt();
                tasks.remove(num - 1);
                System.out.println("Deleted!");
            }

            // Save tasks back to file after every change
            FileWriter writer = new FileWriter("tasks.txt");
            for (String t : tasks) {
                writer.write(t + "\n");
            }
            writer.close();
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}