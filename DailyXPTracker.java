import java.util.ArrayList;
import java.util.Scanner;

public class DailyXPTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> taskNames = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        ArrayList<Integer> xpValues = new ArrayList<>();
        ArrayList<Boolean> completed = new ArrayList<>();

        int javaXP = 0;
        int financeXP = 0;
        int fitnessXP = 0;
        int otherXP = 0;

        while (true) {
            printMenu();

            int choice = Integer.valueOf(scanner.nextLine());

            if (choice == 1) {
                addTask(scanner, taskNames, categories, xpValues, completed);
            } else if (choice == 2) {
                viewTasks(taskNames, categories, xpValues, completed);
            } else if (choice == 3) {
                int gainedXP = completeTask(scanner, taskNames, categories, xpValues, completed);

                if (gainedXP > 0) {
                    String category = categories.get(getLastCompletedIndex(completed));

                    if (category.equalsIgnoreCase("Java")) {
                        javaXP += gainedXP;
                    } else if (category.equalsIgnoreCase("Finance")) {
                        financeXP += gainedXP;
                    } else if (category.equalsIgnoreCase("Fitness")) {
                        fitnessXP += gainedXP;
                    } else {
                        otherXP += gainedXP;
                    }
                }

            } else if (choice == 4) {
                viewXPSummary(javaXP, financeXP, fitnessXP, otherXP);
            } else if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("");
        System.out.println("=== Daily XP Tracker ===");
        System.out.println("1. Add task");
        System.out.println("2. View tasks");
        System.out.println("3. Complete task");
        System.out.println("4. View XP summary");
        System.out.println("5. Exit");
        System.out.print("Choose: ");
    }

    public static void addTask(
            Scanner scanner,
            ArrayList<String> taskNames,
            ArrayList<String> categories,
            ArrayList<Integer> xpValues,
            ArrayList<Boolean> completed) {

        System.out.print("Task name: ");
        String taskName = scanner.nextLine();

        System.out.print("Skill category: ");
        String category = scanner.nextLine();

        System.out.print("XP value: ");
        int xp = Integer.valueOf(scanner.nextLine());

        taskNames.add(taskName);
        categories.add(category);
        xpValues.add(xp);
        completed.add(false);

        System.out.println("Task added.");
    }

    public static void viewTasks(
            ArrayList<String> taskNames,
            ArrayList<String> categories,
            ArrayList<Integer> xpValues,
            ArrayList<Boolean> completed) {

        System.out.println("");
        System.out.println("=== Tasks ===");

        if (taskNames.size() == 0) {
            System.out.println("No tasks yet.");
            return;
        }

        for (int i = 0; i < taskNames.size(); i++) {
            String status = "[ ]";

            if (completed.get(i)) {
                status = "[X]";
            }

            System.out.println((i + 1) + ". " + status + " " 
                    + taskNames.get(i) + " - " 
                    + categories.get(i) + " - " 
                    + xpValues.get(i) + " XP");
        }
    }

    public static int completeTask(
            Scanner scanner,
            ArrayList<String> taskNames,
            ArrayList<String> categories,
            ArrayList<Integer> xpValues,
            ArrayList<Boolean> completed) {

        if (taskNames.size() == 0) {
            System.out.println("No tasks to complete.");
            return 0;
        }

        viewTasks(taskNames, categories, xpValues, completed);

        System.out.print("Which task number did you complete? ");
        int taskNumber = Integer.valueOf(scanner.nextLine());

        int index = taskNumber - 1;

        if (index < 0 || index >= taskNames.size()) {
            System.out.println("Invalid task number.");
            return 0;
        }

        if (completed.get(index)) {
            System.out.println("You already completed this task.");
            return 0;
        }

        completed.set(index, true);

        System.out.println("Completed: " + taskNames.get(index));
        System.out.println("You gained " + xpValues.get(index) + " " + categories.get(index) + " XP.");

        return xpValues.get(index);
    }

    public static int getLastCompletedIndex(ArrayList<Boolean> completed) {
        for (int i = completed.size() - 1; i >= 0; i--) {
            if (completed.get(i)) {
                return i;
            }
        }

        return -1;
    }

    public static void viewXPSummary(int javaXP, int financeXP, int fitnessXP, int otherXP) {
        int totalXP = javaXP + financeXP + fitnessXP + otherXP;

        System.out.println("");
        System.out.println("=== XP Summary ===");
        System.out.println("Java XP: " + javaXP);
        System.out.println("Finance XP: " + financeXP);
        System.out.println("Fitness XP: " + fitnessXP);
        System.out.println("Other XP: " + otherXP);
        System.out.println("Total XP: " + totalXP);

        System.out.println("Rank: " + getRank(totalXP));
    }

    public static String getRank(int totalXP) {
        if (totalXP < 50) {
            return "Beginner";
        } else if (totalXP < 150) {
            return "Locked In";
        } else if (totalXP < 300) {
            return "Serious";
        } else {
            return "Machine";
        }
    }
}
