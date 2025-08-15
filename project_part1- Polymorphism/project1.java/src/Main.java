/**
 * Yenkel jaoui 324523045
 * Nofar Duchan 322599424
 */

import vehicle.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size, i, j = 0, option, maxSpeed, fuelConsumption, engineLife, numPass, num, type, counter = 0;
        String model, powerSource;
        boolean sailingDirection;
        System.out.println("Enter the number of vehicles you want to have in the dealership");
        size = sc.nextInt();
        Vehicle[] v = new Vehicle[size];
        for (i = 0; i < size; i++) {
            System.out.println("Choose the number of the type of vehicle:\n1.Jeep\n2.Frigate\n3.Spy Glider\n4.Game Glider");
            option = sc.nextInt();
            switch (option) {
                case 1: {
                    System.out.print("Enter model ");
                    model = sc.next();
                    System.out.print("Enter max speed ");
                    maxSpeed = sc.nextInt();
                    System.out.print("Enter fuel consumption ");
                    fuelConsumption = sc.nextInt();
                    System.out.print("Enter engine life ");
                    engineLife = sc.nextInt();
                    v[i] = new Jeep(model, maxSpeed, fuelConsumption, engineLife);
                    break;
                }
                case 2: {
                    System.out.println("Enter model");
                    model = sc.next();
                    System.out.println("Enter max speed");
                    maxSpeed = sc.nextInt();
                    System.out.println("Enter number of passengers");
                    numPass = sc.nextInt();
                    System.out.println("Enter if the sailing with the wind- enter 1, else enter 0");
                    num = sc.nextInt();
                    if (num == 1)
                        sailingDirection = true;
                    else
                        sailingDirection = false;
                    v[i] = new Frigate(model, maxSpeed, numPass, sailingDirection);
                    break;
                }
                case 3: {
                    System.out.println("Enter power source");
                    powerSource = sc.next();
                    v[i] = new SpyGlider(powerSource);
                    break;
                }
                case 4: {
                    v[i] = new GameGlider();
                    break;
                }
                default: {
                    System.out.println("Error number, try again");
                    i--;
                }
            }
        }
        while (true) {
            System.out.println("\nEnter one of the options");
            System.out.println("1. Buying a vehicle from the dealership");
            System.out.println("2. Taking vehicles for a test drive");
            System.out.println("3. Resetting the distance traveled by all vehicles");
            System.out.println("4. Changing the flag of all sailing vessels");
            System.out.println("5. Exit");
            option = sc.nextInt();
            switch (option) {
                case 1: {
                    for (i = 0; i < size; i++) {
                        j = i + 1;
                        System.out.println("VEHICLE " + j + ":");
                        System.out.println(v[i].toString() + "\n");
                    }
                    System.out.println("Choose the number of the type of vehicle:\n1.Jeep\n2.Frigate\n3.Spy Glider\n4.Game Glider");
                    type = sc.nextInt();
                    if (type == 1) {
                        System.out.println("Enter the details of the vehicle you want: ");
                        System.out.print("Enter model ");
                        model = sc.next();
                        System.out.print("Enter max speed ");
                        maxSpeed = sc.nextInt();
                        System.out.print("Enter fuel consumption ");
                        fuelConsumption = sc.nextInt();
                        System.out.print("Enter engine life ");
                        engineLife = sc.nextInt();
                        Vehicle choice = new Jeep(model, maxSpeed, fuelConsumption, engineLife);
                        if (delete(size, choice, v))
                        {
                            counter++;
                            size = size-1;
                        }
                    }
                    else if (type == 2) {
                        System.out.println("Enter the details of the vehicle you want: ");
                        System.out.print("Enter model ");
                        model = sc.next();
                        System.out.print("Enter max speed ");
                        maxSpeed = sc.nextInt();
                        System.out.print("Enter number of passengers ");
                        numPass = sc.nextInt();
                        System.out.print("Enter if the sailing with the wind- enter 1, else enter 0 ");
                        sailingDirection = sc.hasNext();
                        Vehicle choice = new Frigate(model, maxSpeed, numPass, sailingDirection);
                        if (delete(size, choice, v))
                        {
                            counter++;
                            size = size-1;
                        }
                    }
                    else if (type == 3) {
                        System.out.println("Enter the details of the vehicle you want: ");
                        System.out.print("Enter power source ");
                        powerSource = sc.next();
                        Vehicle choice = new SpyGlider(powerSource);
                        if (delete(size, choice, v))
                        {
                            counter++;
                            size = size-1;
                        }
                    }
                    else if (type == 4) {
                        System.out.println("No need to enter more details");
                        Vehicle choice = new GameGlider();
                        if (delete(size, choice, v))
                        {
                            counter++;
                            size = size-1;
                        }
                    }
                    else
                        System.out.println("error:(");
                    if (counter != 0)
                    {
                        j = 0;
                        System.out.println("The vehicle after the purchase:");
                        for (i = 0; i < size; i++) {
                            j = i + 1;
                            System.out.println("VEHICLE " + j + ":");
                            System.out.println(v[i].toString() + "\n");
                        }
                        counter = 0;
                    }
                    break;
                }
                case 2: {
                    System.out.println("Choose the number of the type of vehicle:\n1.Jeep\n2.Frigate\n3.Spy Glider\n4.Game Glider");
                    type = sc.nextInt();
                    if (type == 1) {
                        System.out.println("Enter the details of the vehicle you want to take to test drive: ");
                        System.out.print("Enter model ");
                        model = sc.next();
                        System.out.print("Enter max speed ");
                        maxSpeed = sc.nextInt();
                        System.out.print("Enter fuel consumption ");
                        fuelConsumption = sc.nextInt();
                        System.out.print("Enter engine life ");
                        engineLife = sc.nextInt();
                        Vehicle choice = new Jeep(model, maxSpeed, fuelConsumption, engineLife);
                        changeDistance(sc, choice, v, size);
                    }
                    else if (type == 2) {
                        System.out.println("Enter the details of the vehicle you want: ");
                        System.out.print("Enter model ");
                        model = sc.next();
                        System.out.print("Enter max speed ");
                        maxSpeed = sc.nextInt();
                        System.out.print("Enter number of passengers ");
                        numPass = sc.nextInt();
                        System.out.print("Enter if the sailing with the wind- enter 1, else enter 0 ");
                        sailingDirection = sc.hasNext();
                        Vehicle choice = new Frigate(model, maxSpeed, numPass, sailingDirection);
                        changeDistance(sc, choice, v, size);
                    }
                    else if (type == 3) {
                        System.out.println("Enter the details of the vehicle you want: ");
                        System.out.print("Enter power source ");
                        powerSource = sc.next();
                        Vehicle choice = new SpyGlider(powerSource);
                        changeDistance(sc, choice, v, size);
                    }
                    else if (type == 4) {
                        System.out.println("No need to enter more details");
                        Vehicle choice = new GameGlider();
                        changeDistance(sc, choice, v, size);
                    }
                    else
                        System.out.println("error:(");

                    break;
                }
                case 3: {
                    System.out.println("The distance resetting: ");
                    j = 0;
                    for (i = 0; i < size; i++) {
                        v[i].setDistanceMove(-v[i].getDistance());
                        j = i + 1;
                        System.out.println("VEHICLE " + j + ":");
                        System.out.println(v[i].toString() + "\n");
                    }
                    break;
                }
                case 4: {
                    String newFlag;
                    System.out.print("Enter a new flag for all sailing vessel: ");
                    newFlag = sc.next();
                    j = 0;
                    int count = 0;
                    for (i = 0; i < size; i++) {
                        if (v[i] instanceof Marine) {
                            ((Marine) v[i]).setFlag(newFlag);
                            count++;
                        }
                    }
                    if (count == 0)
                        System.out.println("There are no vessels in the agency!");
                    else {
                        System.out.println("All vehicles after chaining the flag:");
                        for (i = 0; i < size; i++) {
                            j = i + 1;
                            System.out.println("VEHICLE " + j + ":");
                            System.out.println(v[i].toString() + "\n");
                        }
                    }
                    break;
                }
                case 5: {
                    j = -1;
                    break;
                }
                default:
                    System.out.println("error typing, try again!");
            }
            if (j == -1) {
                System.out.println("Goodbye:)");
                break;
            }
        }
        sc.close();
    }
    public static boolean delete (int size, Vehicle choice, Vehicle []v)
    {
        /**A helper function that checks if the vehicle is in the dealership,
         * if so it deletes it from the dealership and returns a boolean value accordingly
         */
        for (int i = 0; i < size; i++) {
            if (choice.equals(v[i])) {
                System.out.println("The purchase was made successfully:)");
                v[i] = v[size - 1];
                v[size - 1] = null;
                return true;
            }
        }
        System.out.println("The vehicle is not in the agency:(");
        return false;
    }
    public static void changeDistance(Scanner sc, Vehicle choice, Vehicle [] v, int size)
    {
        /**An auxiliary function that updates the distance of vehicles selected by
         * the user according to input from the user and does not return anything
         */
        int count= 0;
        for (int i = 0; i < size; i++) {
            if (choice.equals(v[i])) {
                System.out.println("The car is in the dealership!");
                System.out.print("Enter the distance of the test drive: ");
                int test = sc.nextInt();
                v[i].setDistanceMove(test);
                System.out.println("The vehicle after changing the distance");
                System.out.println(v[i].toString());
                count++;
                break;
            }
        }
        if (count == 0)
            System.out.println("The vehicle is not in the agency:(");
    }
}





