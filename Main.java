import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

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
            System.out.println("     IIUM HEALTH TRACKER    ");
            System.out.println("=================================");
            System.out.println("1.  Water Tracker Menu");
            System.out.println("2.  Sleep Tracker Menu");
            System.out.println("3.  View Rewards & Points");
            System.out.println("4.  Save Current Data");
            System.out.println("5. Exit Application");
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
                    System.out.println(" Invalid option! Please choose between 1 to 5.");
            }
        }
        
        scanner.close();
    }

  public class Gamification {

    Scanner input = new Scanner(System.in);
    
    String[] badges = {
        " Hydration Beginner ",
        " Sleep Champion ",
        " Healthy Streak ",
        " Wellness Master "
    };
    
    int[] xpRequired = {50, 100, 200, 500};
    boolean[] unlocked = {false, false, false, false};
    
    int totalXP = 0;
    int healthLevel = 1;
    
    public void addXP(int xp){
        totalXP += xp;
        
        System.out.println("\n You gained " + xp + " Health XP!");
        System.out.println("Current Total XP: " + totalXP);
        
        calculateLevel();
        checkBadges();
    }
          
    public void calculateLevel(){
    
        if(totalXP >= 500){
            healthLevel = 5;
        } else if(totalXP >= 300){
            healthLevel = 4;
        }else if(totalXP >= 200){
            healthLevel = 3;
        }else if(totalXP >= 100){
            healthLevel = 2;
        }else{
            healthLevel = 1;
        }
        
        System.out.println(" Current Health Level: " + healthLevel);
    }
        
    public void checkBadges(){
    
        for(int i = 0; i < badges.length; i++){
            if(totalXP >= xpRequired[i] && unlocked[i] == false){
                unlocked[i] = true;
                
                System.out.println("\n ACHIEVEMENT UNLOCKED!");
                System.out.println("Badge: " + badges[i]);
            }
        }
    }
    
    public void displayRewardsMenu(){
        
        int choice;
        do{
            System.out.println("\n==================================");
            System.out.println("           REWARDS MENU          ");
            System.out.println("\n==================================");
            System.out.println("1. View Total Health XP");
            System.out.println("2. View Health Level");
            System.out.println("3. View Badges");
            System.out.println("4. Simulation Earn XP");
            System.out.println("5. Back to Main Menu");
            System.out.println("Choose option: ");
            
            choice = input.nextInt();
            
            switch(choice){
                
                case 1 : System.out.println("\n Total Health XP: " + totalXP);
                break;
                
                case 2 : System.out.println("\n Current Health Level: " + healthLevel);
                break;
                
                case 3 : displayBadges();
                break;
                
                case 4: simulateXP();
                break;
                
                case 5: System.out.println("Returning to Main Menu...");
                break;
                
                default: System.out.println(" Invalid choice!");
                
            }
        }while(choice != 5);
    }
    
    public void displayBadges(){
        
        System.out.println("\n========== BADGES ==========");
        
        for(int i = 0; i < badges.length; i++){
            
            if(unlocked[i]){
                System.out.println("  " + badges[i]);
            }else{
                System.out.println(" Locked Badge ");
            }
        }
    }
    
    public void simulateXP(){
        
        System.out.println("\nChoose healthy activity: ");
        System.out.println("1. Drink enough water (+50 XP)");
        System.out.println("2. Sleep 8 hours (+70 XP)");
        System.out.println("3. Complete healthy routine (+120 XP)");
        System.out.println("Enter choice: ");
        
        int activity = input.nextInt();
        
        switch(activity){
            
            case 1: addXP(50);
            break;
            
            case 2: addXP(70);
            break;
            
            case 3: addXP(120);
            break;
            
            default:
                System.out.println(" Invalid activity!");
                        
        String name = "";
        String mood = "";
        int points = 0;

        try {
            System.out.print("Enter your name: ");
            name = input.nextLine();

            System.out.print("How are you feeling today? ");
            mood = input.nextLine();

            System.out.println("\nHello " + name + "!");
            System.out.println("Your mood today is: " + mood);

            if (mood.equalsIgnoreCase("happy")) {
                System.out.println("Great! Keep your positive energy.");
                points += 10;
            } else if (mood.equalsIgnoreCase("stress")) {
                System.out.println("Take a short break and relax.");
                points += 5;
            } else {
                System.out.println("Thank you for sharing your mood.");
                points += 3;
            }

            System.out.print("\nDid you sleep at least 6 hours? (yes/no): ");
            String sleep = input.nextLine();

            if (sleep.equalsIgnoreCase("yes")) {
                points += 10;
            }

            System.out.print("Did you study today? (yes/no): ");
            String study = input.nextLine();

            if (study.equalsIgnoreCase("yes")) {
                points += 10;
            }

            System.out.println("\nTotal Wellness Points: " + points);

            saveRecord(name, mood, points);
            viewRecord();

        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }

        input.close();
    }
            
    public static void saveRecord(String name, String mood, int points) {
        try {
            FileWriter fw = new FileWriter("wellness_record.txt", true);

            fw.write("Name: " + name +
                    " | Mood: " + mood +
                    " | Points: " + points + "\n");

            fw.close();

            System.out.println("Record saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving record.");
        }
    }

    public static void viewRecord() {
        try {
            File file = new File("wellness_record.txt");
            Scanner read = new Scanner(file);

            System.out.println("\n=== WELLNESS RECORD ===");

            while (read.hasNextLine()) {
                System.out.println(read.nextLine());
            }

            read.close();

        } catch (FileNotFoundException e) {
            System.out.println("No previous record found ");
        }
    }
}

    
        
        }
    }
 }
}
