import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        do {
            System.out.println("\nSelect a Hadith book by entering a number:");
            System.out.println("1: Bukhari");
            System.out.println("2: Muslim");
            System.out.println("3: IbnMajah");
            System.out.println("4: Tirmidhi");
            System.out.println("5: Random");

            int choice = scanner.hasNextInt() ? scanner.nextInt() : 0;
            scanner.nextLine();

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid selection. Please select a number between 1 and 5.");
                continue;
            }

            if (choice == 5) {
                choice = random.nextInt(4) + 1;
            }

            String filePath = switch (choice) {
                case 1 -> "bukhari.txt";
                case 2 -> "muslim.txt";
                case 3 -> "ibnmajah.txt";
                case 4 -> "tirmidhi.txt";
                default -> "";
            };

            HadithGenerator generator = new HadithGenerator(filePath);
            String hadithText = generator.getRandomHadith();
            if (hadithText != null) {
                System.out.println(HadithGenerator.wrapText(hadithText, 200));
            } else {
                System.out.println("No Hadith found.");
            }

            System.out.println("\nDo you want to generate another Hadith? (yes/no)");
        } while ("yes".equalsIgnoreCase(scanner.next().trim()));

        scanner.close();
        System.out.println("Program ended.");
    }
}
