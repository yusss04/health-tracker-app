import java.util.Scanner;

public class Gamification {

    Scanner input = new Scanner(System.in);
    
    String[] badges = {
        "💧 Hydration Beginner",
        "😴 Sleep Champion",
        "🔥 Healthy Streak",
        "🏆 Wellness Master"
    };
    
    int[] xpRequired = {50, 100, 200, 500};
    boolean[] unlocked = {false, false, false, false};
    
    int totalXP = 0;
    int healthLevel = 1;
    
    public void addXP(int xp){
        totalXP += xp;
        
        System.out.println("\n✨ You gained " + xp + " Health XP!");
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
        
        System.out.println("🏅 Current Health Level: " + healthLevel);
    }
        
    public void checkBadges(){
    
        for(int i = 0; i < badges.length; i++){
            if(totalXP >= xpRequired[i] && unlocked[i] == false){
                unlocked[i] = true;
                
                System.out.println("\n🎉 ACHIEVEMENT UNLOCKED!");
                System.out.println("Badge: " + badges[i]);
            }
        }
    }
    
    public void displayRewardsMenu(){
        
        int choice;
        do{
            System.out.println("\n==================================");
            System.out.println("          🏆 REWARDS MENU 🏆         ");
            System.out.println("\n==================================");
            System.out.println("1. View Total Health XP");
            System.out.println("2. View Health Level");
            System.out.println("3. View Badges");
            System.out.println("4. Simulation Earn XP");
            System.out.println("5. Back to Main Menu");
            System.out.println("Choose option: ");
            
            choice = input.nextInt();
            
            switch(choice){
                
                case 1 : System.out.println("\n✨ Total Health XP: " + totalXP);
                break;
                
                case 2 : System.out.println("\n🏅 Current Health Level: " + healthLevel);
                break;
                
                case 3 : displayBadges();
                break;
                
                case 4: simulateXP();
                break;
                
                case 5: System.out.println("Returning to Main Menu...");
                break;
                
                default: System.out.println("❌ Invalid choice!");
                
            }
        }while(choice != 5);
    }
    
    public void displayBadges(){
        
        System.out.println("\n========== BADGES ==========");
        
        for(int i = 0; i < badges.length; i++){
            
            if(unlocked[i]){
                System.out.println(" ✅ " + badges[i]);
            }else{
                System.out.println("🔒 Locked Badge ");
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
                System.out.println("❌ Invalid activity!");
        }
    }
}
