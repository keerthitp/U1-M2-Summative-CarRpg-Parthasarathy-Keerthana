import java.util.Map;
import java.util.Scanner;

public class CarInventoryMain {

    public static Car car = new Car();
    public static void main(String[] args) {

        Car car = new Car();
        int userEnteredId = 1000;
        boolean contMainOp = true, isNumber = false;
        Scanner scanner = new Scanner(System.in);
        String input;
        int inputNum;

        while (contMainOp) {
            System.out.println("1. Add \t 2. Delete \t 3. List \t 4. Search \t 5. Exit");
            isNumber = true;
            input = scanner.nextLine();
            isNumber = car.isNumber(input);

            if (isNumber == true && input.length()>= 1)
                inputNum = Integer.parseInt(input);
            else {
                System.out.println("Invalid number");
                break;
            }

            //inputNum = Integer.parseInt(input);
            switch (inputNum) {
                case 1:
                    //Adding
                    car.addCar();
                    //addCar(carInventoryMap);
                    break;
                case 2:
                    //Delete
                    car.listCars();
                    boolean carFound = car.deleteCar();
                    if (carFound == true) {
                        System.out.println("Car deleted");
                        car.listCars();
                    }
                    break;
                case 3:
                    //List
                    //listCars(carInventoryMap);
                    car.listCars();
                    break;
                case 4:
                    // Search

                    System.out.println("Search by 1. Make 2. Model 3. Color 4: Year 5. Miles");
                    String searchStr;
                    int searchNum;
                    searchStr = scanner.nextLine();
                    if (isNumber(searchStr) == true) {
                        inputNum = Integer.parseInt(searchStr);
                        String search;
                        switch (inputNum) {
                            case 1:
                                int returnErr = car.searchCarsByMake();

                                break;
                            case 2:
                                System.out.println("Search by Model, enter a model");
                                car.listCars();
                                search = scanner.nextLine();
                                car.searchCarsByModel();
                                break;

                            case 3:
                                car.searchCarsByColor();
                                break;

                            case 4:


                                car.searchCarsByYear();
                                break;

                            case 5:

                                car.searchCarsByMiles();
                                break;

                            default:
                                System.out.println("Entered value is not within range");
                                break;

                        }
                    }


                    break;
                case 5:
                    System.out.println("Exiting the program");
                    contMainOp = false;
                    break;
                default:
                    System.out.println("Enter a valid number");

            }

            //scanner.nextLine();

        }


        // addCar(carInventoryMap);

        //    carInventoryMap.
        //listCars(carInventoryMap);

//        searchCarsByMake(carInventoryMap, "nissan");
//        searchCarsByModel(carInventoryMap, "rav");
//        searchCarsByColor(carInventoryMap, "red");
//        searchCarsByYear(carInventoryMap, 2000);
//        searchCarsByMiles(carInventoryMap, 10000);


    }


    public static boolean isNumber(String str) {
        boolean isNumber = true;
        //input = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                isNumber = false;
                break;

            }

        }

        return isNumber;

    }


}

