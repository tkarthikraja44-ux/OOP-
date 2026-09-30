// abstract class means we cannot create a direct object of Player.
// It is used as a parent class for ProPlayer and NormalPlayer.
abstract class Player {

    // private variables = encapsulation.
    // They cannot be directly accessed from outside this class.
    private int playerId;
    private String playerName;
    private int point;

    // static variable = one shared copy for all Player objects.
    static String gameName = "Battle Arena";

    // final variable = its value cannot be changed after initialization.
    final int MAX_LEVEL = 100;


    // Constructor of Player.
    // It initializes playerId, playerName and point.
    Player(int playerId, String playerName, int point) {

        // this.playerId = object's playerId
        // playerId = constructor parameter
        this.playerId = playerId;

        // Store the player's name in the object.
        this.playerName = playerName;

        // Store the player's points in the object.
        this.point = point;
    }


    // Getter method to access the private playerId.
    int getPlayerId() {
        return playerId;
    }


    // Getter method to access the private playerName.
    String getPlayerName() {
        return playerName;
    }


    // Getter method to access the private point.
    int getPoint() {
        return point;
    }


    // Method to add points to the player.
    void addPoints(int points) {

        // Add the given points to the existing points.
        point = point + points;
    }


    // Overloaded method.
    // Same method name but different parameters.
    void addPoints(int points, String reason) {

        // Add the given points to the existing points.
        point = point + points;

        // Display how many points were added.
        System.out.println("Points added: " + points);

        // Display why the points were added.
        System.out.println("Reason: " + reason);
    }


    // Abstract method.
    // Parent does not provide the implementation.
    // Child classes MUST implement this method.
    abstract void calculateRank();
}


// ProPlayer inherits from Player.
class ProPlayer extends Player {


    // Constructor of ProPlayer.
    ProPlayer(int playerId, String playerName, int point) {

        // Call the parent class constructor.
        // It initializes playerId, playerName and point.
        super(playerId, playerName, point);
    }


    // This method overrides the abstract method from Player.
    @Override
    void calculateRank() {

        // Get the player's points and check if they are 2000 or more.
        if (getPoint() >= 2000) {

            // If points are 2000 or more, rank is Diamond.
            System.out.println("Rank: Diamond");
        }

        // If the first condition is false, check this condition.
        else if (getPoint() >= 1500) {

            // If points are 1500 or more, rank is Platinum.
            System.out.println("Rank: Platinum");
        }

        // If previous conditions are false, check this condition.
        else if (getPoint() >= 1000) {

            // If points are 1000 or more, rank is Gold.
            System.out.println("Rank: Gold");
        }

        // If none of the above conditions are true.
        else {

            // Rank is Silver.
            System.out.println("Rank: Silver");
        }
    }
}


// NormalPlayer also inherits from Player.
class NormalPlayer extends Player {


    // Constructor of NormalPlayer.
    NormalPlayer(int playerId, String playerName, int point) {

        // Call the parent Player constructor.
        super(playerId, playerName, point);
    }


    // Override the abstract calculateRank() method.
    @Override
    void calculateRank() {

        // Check whether points are 1500 or more.
        if (getPoint() >= 1500) {

            // Rank is Diamond.
            System.out.println("Rank: Diamond");
        }

        // If false, check whether points are 1000 or more.
        else if (getPoint() >= 1000) {

            // Rank is Platinum.
            System.out.println("Rank: Platinum");
        }

        // If false, check whether points are 500 or more.
        else if (getPoint() >= 500) {

            // Rank is Gold.
            System.out.println("Rank: Gold");
        }

        // If all conditions are false.
        else {

            // Rank is Silver.
            System.out.println("Rank: Silver");
        }
    }
}


// Main class.
// Program execution starts from main().
public class Main {


    // Main method.
    // JVM starts executing the program from here.
    public static void main(String[] args) {


        // Parent reference = Player
        // Actual object = ProPlayer
        //
        // This is runtime polymorphism.
        Player p1 = new ProPlayer(101, "Karthik", 1200);


        // Parent reference = Player
        // Actual object = NormalPlayer
        //
        // This is also runtime polymorphism.
        Player p2 = new NormalPlayer(102, "Arun", 700);


        // Access the static gameName using the class name.
        System.out.println("Game: " + Player.gameName);


        // Print an empty line for better output formatting.
        System.out.println();


        // Call getPlayerName() to get Karthik's name.
        System.out.println("Player: " + p1.getPlayerName());


        // Call getPoint() to get Karthik's current points.
        System.out.println("Points: " + p1.getPoint());


        // Call addPoints(int).
        // Karthik's points increase by 500.
        p1.addPoints(500);


        // Display Karthik's updated points.
        System.out.println("After adding points: " + p1.getPoint());


        // Call calculateRank().
        //
        // p1 actually contains a ProPlayer object,
        // so ProPlayer's calculateRank() runs.
        p1.calculateRank();


        // Print an empty line.
        System.out.println();


        // Display Arun's name.
        System.out.println("Player: " + p2.getPlayerName());


        // Display Arun's current points.
        System.out.println("Points: " + p2.getPoint());


        // Call the overloaded addPoints() method.
        //
        // Two arguments are given:
        // 200 = points
        // "Won Match" = reason
        p2.addPoints(200, "Won Match");


        // Display Arun's updated points.
        System.out.println("Current Points: " + p2.getPoint());


        // Call calculateRank().
        //
        // p2 actually contains a NormalPlayer object,
        // so NormalPlayer's calculateRank() runs.
        p2.calculateRank();
    }
}
