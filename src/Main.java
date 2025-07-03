import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("MENU:");
        System.out.println("1. Add user");
        System.out.println("2. List users");
        System.out.println("3. Remove user");
        System.out.println("4. Exit");
        System.out.println("Option:");

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count=0;
        int choice;
        int ID;
        String name;
        String email;
        boolean exit = false;
        ArrayList<User> Users = new ArrayList<>();
        while(!exit) {
            menu();
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case (1):
                        System.out.println("Enter user name: ");
                        name = sc.nextLine();
                        if(!name.isEmpty()) {
                            if(name.matches("[a-zA-Z ]+")) {
                                System.out.println("Enter user email:");
                                email = sc.nextLine();
                                if(!email.isEmpty())
                                    if(email.contains("@"))
                                        Users.add(new User(++count, name, email));
                                    else
                                        System.out.println("Invalid email! Try again!");
                                else
                                    System.out.println("User email needed! Try again!");
                            }
                            else{
                                System.out.println("User name must not include invalid characters! Try again!");
                            }
                        }
                        else{
                            System.out.println("User name needed! Try again!");
                        }
                        break;
                    case (2):
                        if (!Users.isEmpty()) {
                            for (User user : Users)
                                System.out.println(user.toString());
                        } else {
                            System.out.println("No users to list!");
                        }
                        break;
                    case (3):
                        if (!Users.isEmpty()) {
                            System.out.println("Input user id: ");
                            if (sc.hasNextInt()) {
                                ID = sc.nextInt();
                                sc.nextLine(); // clear buffer

                                User userToRemove = null;

                                for (User user : Users) {
                                    if (user.getID() == ID) {
                                        userToRemove = user;
                                        break;
                                    }
                                }

                                if (userToRemove != null) {
                                    Users.remove(userToRemove);
                                    System.out.println("User removed successfully.");
                                } else {
                                    System.out.println("No user found with that ID.");
                                }
                            } else {
                                System.out.println("ID input has to be a number!");
                                sc.nextLine(); // clear buffer
                            }
                        } else {
                            System.out.println("No users to remove!");
                        }
                        break;
                    case (4):
                        exit = true;
                        break;
                    default: {
                        System.out.println("Invalid option! Try again!");
                        sc.nextLine();
                    }

                }
            }
            else {
                System.out.println("Please enter a number.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
