import java.util.Scanner;

public class Main {public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        WaterTracker water = new WaterTracker();
        SleepTracker sleep = new SleepTracker();
        Gamification rewards = new Gamification();
        FileManager fileManager = new FileManager();
        
        // Contoh: Auto-load data lama semasa app baru dibuka (Tugas Member 4)
        System.out.println("Loading data... Please wait.");
        fileManager.loadData();
        
        boolean running = true;
        
        while (running) {
            System.out.println("\n=================================");
            System.out.println("    🟢 IIUM HEALTH TRACKER 🟢   ");
            System.out.println("=================================");
            System.out.println("1. 💧 Water Tracker Menu");
            System.out.println("2. 😴 Sleep Tracker Menu");
            System.out.println("3. 🏆 View Rewards & Points");
            System.out.println("4. 💾 Save Current Data");
            System.out.println("5. ❌ Exit Application");
            System.out.print("Choose an option (1-5): ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Panggil fungsi dalam WaterTracker.java (Tugas Member 3)
                    water.displayWaterMenu();
                    break;
                    
                case 2:
                    // Panggil fungsi dalam SleepTracker.java (Tugas Member 3)
                    sleep.displaySleepMenu();
                    break;
                    
                case 3:
                    // Panggil fungsi dalam Gamification.java (Tugas Member 2)
                    rewards.displayRewardsMenu();
                    break;
                    
                case 4:
                    // Panggil fungsi dalam FileManager.java (Tugas Member 4)
                    fileManager.saveData();
                    break;
                    
                case 5:
                    System.out.println("\nThank you for using IIUM Health Tracker. Stay healthy! Bye.");
                    running = false;
                    break;
                    
                default:
                    System.out.println("❌ Invalid option! Please choose between 1 to 5.");
            }
        }
        
        scanner.close();
    }
}
