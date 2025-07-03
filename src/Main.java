import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("MENU:");
        System.out.println("1. Add user");
        System.out.println("2. List users");
        System.out.println("3. Delete user");
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
            choice = sc.nextInt();
            switch (choice) {
                case (1):
                    System.out.println("Enter user name: ");
                    sc.nextLine();
                    name = sc.nextLine();
                    System.out.println("Enter user email:");
                    email = sc.nextLine();
                    Users.add(new User(++count, name, email));
                    break;
                case (2):
                    for (User user : Users)
                        System.out.println(user.toString());
                    break;
                case (3):
                    System.out.println("Input user id: ");
                    ID = sc.nextInt();
                    Users.remove(ID - 1);
                    break;
                case(4):
                    exit=true;

            }
        }

    }

}
