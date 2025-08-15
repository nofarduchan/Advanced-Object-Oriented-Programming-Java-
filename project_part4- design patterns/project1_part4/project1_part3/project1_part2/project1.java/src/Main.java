///**
// * Nofar Duchan 322599424
// */
//
//import vehicle.*;
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int size, i, j = 0, option, num, type, counter = 0;
//        int maxSpeed, fuelConsumption, engineLife, numPass, numWheels, distance;
//        String model, powerSource, flag, wayType;
//        boolean sailingDirection;
//        System.out.println("Enter the number of vehicles you want to have in the dealership");
//        size = sc.nextInt();
//        Vehicle[] v = new Vehicle[size];
//        for (i = 0; i < size; i++) {
//            System.out.println("Choose the number of the type of vehicle:\n1.Jeep\n2.Frigate" +
//                    "\n3.Spy Glider\n4.Game Glider\n5.Amphibious\n6.Regular Bicycle\n7.Cruise ship" +
//                    "\n8. Hybrid plane\n9.Electric bicycle");
//            option = sc.nextInt();
//            switch (option) {
//                case 1: {
//                    System.out.print("Enter model ");
//                    model = sc.next();
//                    System.out.print("Enter max speed ");
//                    maxSpeed = sc.nextInt();
//                    System.out.print("Enter fuel consumption ");
//                    fuelConsumption = sc.nextInt();
//                    System.out.print("Enter engine life ");
//                    engineLife = sc.nextInt();
//                    v[i] = new Jeep(model, maxSpeed, fuelConsumption, engineLife);
//                    break;
//                }
//                case 2: {
//                    System.out.print("Enter model ");
//                    model = sc.next();
//                    System.out.print("Enter max speed ");
//                    maxSpeed = sc.nextInt();
//                    System.out.print("Enter number of passengers ");
//                    numPass = sc.nextInt();
//                    System.out.print("Enter if the sailing with the wind- enter 1, else enter 0 ");
//                    num = sc.nextInt();
//                    if (num == 1)
//                        sailingDirection = true;
//                    else
//                        sailingDirection = false;
//                    v[i] = new Frigate(model, maxSpeed, numPass, sailingDirection);
//                    break;
//                }
//                case 3: {
//                    System.out.print("Enter power source ");
//                    powerSource = sc.next();
//                    v[i] = new Spy_Glider(powerSource);
//                    break;
//                }
//                case 4: {
//                    v[i] = new Game_Glider();
//                    break;
//                }
//                case 5: {
//                    System.out.print("Enter model ");
//                    model = sc.next();
//                    System.out.print("Enter max speed ");
//                    maxSpeed = sc.nextInt();
//                    System.out.print("Enter number of passengers ");
//                    numPass = sc.nextInt();
//                    System.out.print("Enter num of wheels ");
//                    numWheels = sc.nextInt();
//                    System.out.print("Enter if the sailing with the wind- enter 1, else enter 0 ");
//                    num = sc.nextInt();
//                    if (num == 1)
//                        sailingDirection = true;
//                    else
//                        sailingDirection = false;
//                    System.out.print("Enter name of flag ");
//                    flag = sc.next();
//                    System.out.print("Enter fuel consumption ");
//                    fuelConsumption = sc.nextInt();
//                    System.out.print("Enter engine life ");
//                    engineLife = sc.nextInt();
//                    v[i] = new Amphibious(model, maxSpeed, numPass, numWheels, sailingDirection, flag, fuelConsumption, engineLife);
//                    break;
//                }
//                case 6: {
//                    System.out.print("Enter model ");
//                    model = sc.next();
//                    System.out.print("Enter max speed ");
//                    maxSpeed = sc.nextInt();
//                    System.out.print("Enter number of passengers ");
//                    numPass = sc.nextInt();
//                    System.out.print("Enter type of way ");
//                    wayType = sc.next();
//                    v[i] = new Regular_Bicycle(model, maxSpeed, numPass, wayType);
//                    break;
//                }
//                case 7: {
//                    System.out.print("Enter model ");
//                    model = sc.next();
//                    System.out.print("Enter max speed ");
//                    maxSpeed = sc.nextInt();
//                    System.out.print("Enter number of passengers ");
//                    numPass = sc.nextInt();
//                    System.out.print("Enter name of flag ");
//                    flag = sc.next();
//                    System.out.print("Enter fuel consumption ");
//                    fuelConsumption = sc.nextInt();
//                    System.out.print("Enter engine life ");
//                    engineLife = sc.nextInt();
//                    v[i] = new Cruise_Ship(model, maxSpeed, numPass, flag, fuelConsumption, engineLife);
//                    break;
//                }
//                default: {
//                    System.out.println("Error number, try again");
//                    i--;
//                }
//            }
//        }
//        while (true) {
//            System.out.println("\nEnter one of the options");
//            System.out.println("1. Buying a vehicle from the dealership");
//            System.out.println("2. Taking vehicles for a test drive");
//            System.out.println("3. Resetting the distance traveled by all vehicles");
//            System.out.println("4. Changing the flag of all sailing vessels");
//            System.out.println("5. Exit");
//            option = sc.nextInt();
//            switch (option) {
//                case 1: {
//                    for (i = 0; i < size; i++) {
//                        j = i + 1;
//                        System.out.println("VEHICLE " + j + ":");
//                        System.out.println(v[i].toString() + "\n");
//                    }
//                    System.out.println("Choose the number of the type of vehicle:\n1.Jeep\n2.Frigate" +
//                            "\n3.Spy Glider\n4.Game Glider\n5.Amphibious\n6.Regular Bicycle\n7.Cruise ship" +
//                            "\n8. Hybrid plane\n9.Electric bicycle");
//                    type = sc.nextInt();
//                    if (type == 1) {
//                        System.out.println("Enter the details of the vehicle you want: ");
//                        System.out.print("Enter model ");
//                        model = sc.next();
//                        System.out.print("Enter max speed ");
//                        maxSpeed = sc.nextInt();
//                        System.out.print("Enter fuel consumption ");
//                        fuelConsumption = sc.nextInt();
//                        System.out.print("Enter engine life ");
//                        engineLife = sc.nextInt();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        Vehicle choice = new Jeep(model, maxSpeed, fuelConsumption, engineLife);
//                        if (delete(size, choice, v, distance))
//                        {
//                            counter++;
//                            size = size-1;
//                        }
//                    }
//                    else if (type == 2) {
//                        System.out.println("Enter the details of the vehicle you want: ");
//                        System.out.print("Enter model ");
//                        model = sc.next();
//                        System.out.print("Enter max speed ");
//                        maxSpeed = sc.nextInt();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        System.out.print("Enter number of passengers ");
//                        numPass = sc.nextInt();
//                        System.out.print("Enter if the sailing with the wind- enter 1, else enter 0 ");
//                        sailingDirection = sc.hasNext();
//                        Vehicle choice = new Frigate(model, maxSpeed, numPass, sailingDirection);
//                        if (delete(size, choice, v, distance))
//                        {
//                            counter++;
//                            size = size-1;
//                        }
//                    }
//                    else if (type == 3) {
//                        System.out.println("Enter the details of the vehicle you want: ");
//                        System.out.print("Enter power source ");
//                        powerSource = sc.next();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        Vehicle choice = new Spy_Glider(powerSource);
//                        if (delete(size, choice, v, distance))
//                        {
//                            counter++;
//                            size = size-1;
//                        }
//                    }
//                    else if (type == 4) {
//                        //ystem.out.println("No need to enter more details");
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        Vehicle choice = new Game_Glider();
//                        if (delete(size, choice, v, distance))
//                        {
//                            counter++;
//                            size = size-1;
//                        }
//                    }
//                    else if (type == 5) {
//                        System.out.print("Enter model ");
//                        model = sc.next();
//                        System.out.print("Enter max speed ");
//                        maxSpeed = sc.nextInt();
//                        System.out.print("Enter number of passengers ");
//                        numPass = sc.nextInt();
//                        System.out.print("Enter num of wheels ");
//                        numWheels = sc.nextInt();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        System.out.print("Enter if the sailing with the wind- enter 1, else enter 0 ");
//                        num = sc.nextInt();
//                        if (num == 1)
//                            sailingDirection = true;
//                        else
//                            sailingDirection = false;
//                        System.out.print("Enter name of flag ");
//                        flag = sc.next();
//                        System.out.print("Enter fuel consumption ");
//                        fuelConsumption = sc.nextInt();
//                        System.out.print("Enter engine life ");
//                        engineLife = sc.nextInt();
//                        Vehicle choice = new Amphibious(model, maxSpeed, numPass, numWheels, sailingDirection, flag, fuelConsumption, engineLife);
//                        if (delete(size, choice, v, distance))
//                        {
//                            counter++;
//                            size = size-1;
//                        }
//                        break;
//                    }
//                    else if (type == 6) {
//                        System.out.print("Enter model ");
//                        model = sc.next();
//                        System.out.print("Enter max speed ");
//                        maxSpeed = sc.nextInt();
//                        System.out.print("Enter number of passengers ");
//                        numPass = sc.nextInt();
//                        System.out.print("Enter type of way ");
//                        wayType = sc.next();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        Vehicle choice = new Regular_Bicycle(model, maxSpeed, numPass, wayType);
//                        if (delete(size, choice, v, distance))
//                        {
//                            counter++;
//                            size = size-1;
//                        }
//                        break;
//                    }
//                    else if (type == 7) {
//                        System.out.print("Enter model ");
//                        model = sc.next();
//                        System.out.print("Enter max speed ");
//                        maxSpeed = sc.nextInt();
//                        System.out.print("Enter number of passengers ");
//                        numPass = sc.nextInt();
//                        System.out.print("Enter name of flag ");
//                        flag = sc.next();
//                        System.out.print("Enter fuel consumption ");
//                        fuelConsumption = sc.nextInt();
//                        System.out.print("Enter engine life ");
//                        engineLife = sc.nextInt();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        Vehicle choice = new Cruise_Ship(model, maxSpeed, numPass, flag, fuelConsumption, engineLife);
//                        if (delete(size, choice, v, distance))
//                        {
//                            counter++;
//                            size = size-1;
//                        }
//                        break;
//                    }
//                    else if(type == 9)
//                    {
//                        System.out.print("Enter model ");
//                        model = sc.next();
//                        System.out.print("Enter max speed ");
//                        maxSpeed = sc.nextInt();
//                        System.out.print("Enter number of passengers ");
//                        numPass = sc.nextInt();
//                        System.out.print("Enter type of way ");
//                        wayType = sc.next();
//                        System.out.print("Enter engine life ");
//                        engineLife = sc.nextInt();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        Vehicle choice = new Electric_Bicycle(model, maxSpeed, numPass, wayType, engineLife);
//                        if (delete(size, choice, v, distance))
//                        {
//                            counter++;
//                            size = size-1;
//                        }
//                        break;
//                    }
//                    else
//                        System.out.println("error:(");
//                    if (counter != 0)
//                    {
//                        j = 0;
//                        System.out.println("The vehicle after the purchase:");
//                        for (i = 0; i < size; i++) {
//                            j = i + 1;
//                            System.out.println("VEHICLE " + j + ":");
//                            System.out.println(v[i].toString() + "\n");
//                        }
//                        counter = 0;
//                    }
//                    break;
//                }
//                case 2: {
//                    System.out.println("Choose the number of the type of vehicle:\n1.Jeep\n2.Frigate" +
//                            "\n3.Spy Glider\n4.Game Glider\n5.Amphibious\n6.Regular Bicycle\n7.Cruise ship" +
//                            "\n8. Hybrid plane\n9.Electric bicycle");
//                    type = sc.nextInt();
//                    if (type == 1) {
//                        System.out.println("Enter the details of the vehicle you want to take to test drive: ");
//                        System.out.print("Enter model ");
//                        model = sc.next();
//                        System.out.print("Enter max speed ");
//                        maxSpeed = sc.nextInt();
//                        System.out.print("Enter fuel consumption ");
//                        fuelConsumption = sc.nextInt();
//                        System.out.print("Enter engine life ");
//                        engineLife = sc.nextInt();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        Vehicle choice = new Jeep(model, maxSpeed, fuelConsumption, engineLife);
//                        changeDistance(sc, choice, v, size, distance);
//                    }
//                    else if (type == 2) {
//                        System.out.println("Enter the details of the vehicle you want: ");
//                        System.out.print("Enter model ");
//                        model = sc.next();
//                        System.out.print("Enter max speed ");
//                        maxSpeed = sc.nextInt();
//                        System.out.print("Enter number of passengers ");
//                        numPass = sc.nextInt();
//                        System.out.print("Enter if the sailing with the wind- enter 1, else enter 0 ");
//                        sailingDirection = sc.hasNext();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        Vehicle choice = new Frigate(model, maxSpeed, numPass, sailingDirection);
//                        changeDistance(sc, choice, v, size, distance);
//                    }
//                    else if (type == 3) {
//                        System.out.println("Enter the details of the vehicle you want: ");
//                        System.out.print("Enter power source ");
//                        powerSource = sc.next();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        Vehicle choice = new Spy_Glider(powerSource);
//                        changeDistance(sc, choice, v, size, distance);
//                    }
//                    else if (type == 4) {
//                        //System.out.println("No need to enter more details");
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        Vehicle choice = new Game_Glider();
//                        changeDistance(sc, choice, v, size, distance);
//                    }
//                    else if (type == 5) {
//                        System.out.print("Enter model ");
//                        model = sc.next();
//                        System.out.print("Enter max speed ");
//                        maxSpeed = sc.nextInt();
//                        System.out.print("Enter number of passengers ");
//                        numPass = sc.nextInt();
//                        System.out.print("Enter num of wheels ");
//                        numWheels = sc.nextInt();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        System.out.print("Enter if the sailing with the wind- enter 1, else enter 0 ");
//                        num = sc.nextInt();
//                        if (num == 1)
//                            sailingDirection = true;
//                        else
//                            sailingDirection = false;
//                        System.out.print("Enter name of flag ");
//                        flag = sc.next();
//                        System.out.print("Enter fuel consumption ");
//                        fuelConsumption = sc.nextInt();
//                        System.out.print("Enter engine life ");
//                        engineLife = sc.nextInt();
//                        Vehicle choice = new Amphibious(model, maxSpeed, numPass, numWheels, sailingDirection, flag, fuelConsumption, engineLife);
//                        changeDistance(sc, choice, v, size, distance);
//                        break;
//                    }
//                    else if (type == 6) {
//                        System.out.print("Enter model ");
//                        model = sc.next();
//                        System.out.print("Enter max speed ");
//                        maxSpeed = sc.nextInt();
//                        System.out.print("Enter number of passengers ");
//                        numPass = sc.nextInt();
//                        System.out.print("Enter type of way ");
//                        wayType = sc.next();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        Vehicle choice = new Regular_Bicycle(model, maxSpeed, numPass, wayType);
//                        changeDistance(sc, choice, v, size, distance);
//                        break;
//                    }
//                    else if (type == 7) {
//                        System.out.print("Enter model ");
//                        model = sc.next();
//                        System.out.print("Enter max speed ");
//                        maxSpeed = sc.nextInt();
//                        System.out.print("Enter number of passengers ");
//                        numPass = sc.nextInt();
//                        System.out.print("Enter name of flag ");
//                        flag = sc.next();
//                        System.out.print("Enter fuel consumption ");
//                        fuelConsumption = sc.nextInt();
//                        System.out.print("Enter engine life ");
//                        engineLife = sc.nextInt();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        Vehicle choice = new Cruise_Ship(model, maxSpeed, numPass, flag, fuelConsumption, engineLife);
//                        changeDistance(sc, choice, v, size, distance);
//                        break;
//                    }
//                    else if(type == 8)
//                    {
//                        System.out.print("Enter model ");
//                        model = sc.next();
//                        System.out.print("Enter max speed ");
//                        maxSpeed = sc.nextInt();
//                        System.out.print("Enter number of passengers ");
//                        numPass = sc.nextInt();
//                        System.out.print("Enter num of wheels ");
//                        numWheels = sc.nextInt();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        System.out.print("Enter if the sailing with the wind- enter 1, else enter 0 ");
//                        num = sc.nextInt();
//                        if (num == 1)
//                            sailingDirection = true;
//                        else
//                            sailingDirection = false;
//                        System.out.print("Enter name of flag ");
//                        flag = sc.next();
//                        System.out.print("Enter fuel consumption ");
//                        fuelConsumption = sc.nextInt();
//                        System.out.print("Enter engine life ");
//                        engineLife = sc.nextInt();
//                        Vehicle choice = new Hybrid_Plane(model, maxSpeed, numPass, numWheels, sailingDirection, flag, fuelConsumption, engineLife);
//                        changeDistance(sc, choice, v, size, distance);
//                        break;
//                    }
//                    else if(type == 9)
//                    {
//                        System.out.print("Enter model ");
//                        model = sc.next();
//                        System.out.print("Enter max speed ");
//                        maxSpeed = sc.nextInt();
//                        System.out.print("Enter number of passengers ");
//                        numPass = sc.nextInt();
//                        System.out.print("Enter type of way ");
//                        wayType = sc.next();
//                        System.out.print("Enter engine life ");
//                        engineLife = sc.nextInt();
//                        System.out.print("Enter distance ");
//                        distance = sc.nextInt();
//                        Vehicle choice = new Electric_Bicycle(model, maxSpeed, numPass, wayType, engineLife);
//                        changeDistance(sc, choice, v, size, distance);
//                        break;
//                    }
//                    else
//                        System.out.println("error:(");
//
//                    break;
//                }
//                case 3: {
//                    System.out.println("The distance resetting: ");
//                    j = 0;
//                    for (i = 0; i < size; i++) {
//                        v[i].setDistanceMove(-v[i].getDistance());
//                        j = i + 1;
//                        System.out.println("VEHICLE " + j + ":");
//                        System.out.println(v[i].toString() + "\n");
//                    }
//                    break;
//                }
//                case 4: {
//                    String newFlag;
//                    System.out.print("Enter a new flag for all sailing vessel: ");
//                    newFlag = sc.next();
//                    j = 0;
//                    int count = 0;
//                    for (i = 0; i < size; i++) {
//                        if (v[i] instanceof Marine) {
//                            ((Marine) v[i]).setFlag(newFlag);
//                            count++;
//                        }
//                        else if (v[i] instanceof Amphibious) {
//                            ((Amphibious) v[i]).setFlag(newFlag);
//                            count++;
//                        }
//                    }
//                    if (count == 0)
//                        System.out.println("There are no vessels in the agency!");
//                    else {
//                        System.out.println("All vehicles after changing the flag:");
//                        for (i = 0; i < size; i++) {
//                            j = i + 1;
//                            System.out.println("VEHICLE " + j + ":");
//                            System.out.println(v[i].toString() + "\n");
//                        }
//                    }
//                    break;
//                }
//                case 5: {
//                    j = -1;
//                    break;
//                }
//                default:
//                    System.out.println("error typing, try again!");
//            }
//            if (j == -1) {
//                System.out.println("Goodbye:)");
//                break;
//            }
//        }
//        sc.close();
//    }
//    public static boolean delete (int size, Vehicle choice, Vehicle []v, int distance)
//    {
//        /**A helper function that checks if the vehicle is in the dealership,
//         * if so it deletes it from the dealership and returns a boolean value accordingly
//         */
//        choice.setDistanceMove(distance);
//        for (int i = 0; i < size; i++) {
//            if (choice.equals(v[i])) {
//                System.out.println("The purchase was made successfully:)");
//                v[i] = v[size - 1];
//                v[size - 1] = null;
//                return true;
//            }
//        }
//        System.out.println("The vehicle is not in the agency:(");
//        return false;
//    }
//    public static void changeDistance(Scanner sc, Vehicle choice, Vehicle [] v, int size, int distance)
//    {
//        /**An auxiliary function that updates the distance of vehicles selected by
//         * the user according to input from the user and does not return anything
//         */
//        int count= 0;
//        choice.setDistanceMove(distance);
//        for (int i = 0; i < size; i++) {
//            if (choice.equals(v[i])) {
//                System.out.println("The car is in the dealership!");
//                System.out.print("Enter the distance of the test drive: ");
//                int test = sc.nextInt();
//                v[i].setDistanceMove(test);
//                System.out.println("The vehicle after changing the distance");
//                System.out.println(v[i].toString());
//                count++;
//                break;
//            }
//        }
//        if (count == 0)
//            System.out.println("The vehicle is not in the agency:(");
//    }
//}
//
//
//
//
//
//
//
