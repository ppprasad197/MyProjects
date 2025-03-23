package InterviewPrep;

public class PrintFriendsNames {
    public static void main(String[] args) {
        // Check if exactly 3 arguments are provided
        if (args.length != 3) {
            System.out.println("Please provide exactly 3 friends' names.");
            return;
        }

        // Get the friends' names from the arguments
        String friend1 = args[0];
        String friend2 = args[1];
        String friend3 = args[2];

        // Print the names in reverse order with the desired format
        System.out.println("Hi " + friend3 + ", " + friend2 + " and " + friend1);
    }
}

