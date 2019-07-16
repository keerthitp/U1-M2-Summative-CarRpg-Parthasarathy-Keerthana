import java.util.*;

public  class Car extends Vehicle implements Inventory {

    private String search;
    private int found;

    private int id = 1000;
    private Map<Integer, Car> carInventoryMap;
    private List<Car> carList = new ArrayList<>();
    private List<Integer> keyList = new ArrayList<>();

    private boolean isNumber;
    private Scanner scanner = new Scanner(System.in);

    public Car() {
        carInventoryMap = new HashMap();
    }

    public boolean isNumber(String str) {
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


    public  void printCarList(List<Car> carList, List<Integer> keyList) {

        int i = 0;
        //System.out.println("\n");
        if (carList.size() == 0){
            System.out.println("List empty");
        }

        System.out.println("ID \t Make \t Model \t Color \t Miles \t Year");
        //carList.clear();

        while (i < carList.size()) {

            System.out.println(keyList.get(i) + "\t" + carList.get(i).getMake() + "\t" +
                    carList.get(i).getModel() + "\t" +
                    carList.get(i).getColor() + "\t" +
                    carList.get(i).getMiles() + "\t" +
                    carList.get(i).getYear());
            i++;
        }

        carList.clear();
        keyList.clear();


    }

    public void clear(){

        found = 0;
        carList.clear();
        keyList.clear();

    }

    public  int searchCarsByMake() {

        clear();
        Iterator<Map.Entry<Integer, Car>> iterator = carInventoryMap.entrySet().iterator();

//List<Car> carList = new ArrayList<>();
        listCars();
        System.out.println("Search by Make, enter a make");

        search = scanner.nextLine();

        String make = search;
        Car tmpCar;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Car> carEntry = iterator.next();

            tmpCar = carEntry.getValue();
            if (tmpCar.getMake().equals(make)) {
                carList.add(tmpCar);
                keyList.add(carEntry.getKey());
                found = 1;

            }

            /*System.out.println(carEntry.getValue().getMake()+"\t" +
                    carEntry.getValue().getModel()+ "\t"+
                    carEntry.getValue().getColor()+ "\t"+
                    carEntry.getValue().getMiles()+ "\t"+
                    carEntry.getValue().getYear());

             */
        }
        printCarList(carList, keyList);
        return found;
    }


    public   void addCar() {
        clear();
        Scanner scanner = new Scanner(System.in);
        String make, model, color, year,milesOnOdometer ;
        int yearInt = 0, milesOnOdometerInt = 0, error = 0;
        Car carToAdd;
        //for (int i = 0; i < 2; i++) {
        // adding objects to the Hashmap
        carToAdd = new Car();
        //System.out.println("Enter the input for Car Object" + i + 1 + ": ");
        System.out.print("Make: ");
        make = scanner.nextLine();
        System.out.print("Model: ");
        model = scanner.nextLine();
        System.out.print("Color: ");
        color = scanner.nextLine();
        do {


            try {
                error = 0;
                System.out.print("Year: ");
                year = scanner.nextLine();
                yearInt = Integer.parseInt(year);


                if(year.length() != 4)
                    throw new IllegalArgumentException("4 digit year expected");
            } catch (NumberFormatException e2) {

                error = 1;
                System.out.println("Error: Enter number for year");
            } catch (IllegalArgumentException e){

                error =1;
                System.out.println("Error: "+ e);
            }

        }while (error !=0 );
        //scanner.nextLine();

        do {


            try {
                error = 0;
                System.out.print("Miles: ");
                milesOnOdometer = scanner.nextLine();
                milesOnOdometerInt = Integer.parseInt(milesOnOdometer);


            } catch (NumberFormatException e2) {

                error = 1;
                System.out.println("Error: Enter number for miles");

            }

        }while (error != 0) ;
        //scanner.nextLine();
        carToAdd.setColor(color);
        carToAdd.setMake(make);
        carToAdd.setModel(model);
        carToAdd.setMiles(milesOnOdometerInt);
        carToAdd.setYear(yearInt);
        carInventoryMap.put(id++, carToAdd);

    }

/*
    public  void listCars() {
        clear();
        Iterator<Map.Entry<Integer, Car>> iterator = carInventoryMap.entrySet().iterator();

        Iterator<Integer> keyIterator = carInventoryMap.keySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Car> carEntry = iterator.next();
            System.out.println(keyIterator.next() + "\t" + carEntry.getValue().getMake() + "\t" +
                    carEntry.getValue().getModel() + "\t" +
                    carEntry.getValue().getColor() + "\t" +
                    carEntry.getValue().getMiles() + "\t" +
                    carEntry.getValue().getYear());
        }

    }
*/

    public  void  listCars() {

        clear();

        Iterator<Map.Entry<Integer, Car>> iterator = carInventoryMap.entrySet().iterator();
//List<Car> carList = new ArrayList<>();

        Car tmpCar;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Car> carEntry = iterator.next();
            tmpCar = carEntry.getValue();
            carList.add(tmpCar);
            keyList.add(carEntry.getKey());
        }

        printCarList(carList,keyList);

    }


    public  boolean deleteCar() {

        clear();

        listCars();
        System.out.println("Enter car Id to delete car");
        int carId = scanner.nextInt();
        scanner.nextLine();

        Iterator<Map.Entry<Integer, Car>> iterator = carInventoryMap.entrySet().iterator();
//List<Car> carList = new ArrayList<>();

        Car tmpCar;
        boolean carFound = false;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Car> carEntry = iterator.next();
            tmpCar = carEntry.getValue();
            if (carEntry.getKey() == carId) {
                iterator.remove();
                //carInventoryMap.remove(userEnteredId); this will throw error when list gets modified other than
                // Iterator. Either break when using carInventorymap-remove or use iterator to removew
                carFound = true;
                // break;
            }
        }
        return carFound;
    }



    public  int searchCarsByMiles() {

        clear();

        int miles
                ;
        listCars();

        System.out.println("Enter the number of miles on the car for search");
        search = scanner.nextLine();

        isNumber = isNumber(search);

        if (isNumber == true)
            miles = Integer.parseInt(search);
        else {
            System.out.println("entered value is not a valid number");
            return 1;
        }

        // scanner.nextLine();

        Iterator<Map.Entry<Integer, Car>> iterator = carInventoryMap.entrySet().iterator();
//List<Car> carList = new ArrayList<>();

        Car tmpCar;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Car> carEntry = iterator.next();
            tmpCar = carEntry.getValue();
            if (tmpCar.getMiles() < miles) {
                carList.add(tmpCar);
                keyList.add(carEntry.getKey());
            }

            /*System.out.println(carEntry.getValue().getMake()+"\t" +
                    carEntry.getValue().getModel()+ "\t"+
                    carEntry.getValue().getColor()+ "\t"+
                    carEntry.getValue().getMiles()+ "\t"+
                    carEntry.getValue().getYear());

             */
        }
        printCarList(carList, keyList);
        return 0;
    }

    public  String  searchCarsByColor() {

        clear();

        int inputNum;
        listCars();
        System.out.println("Search by Color, enter a color");

        search = scanner.nextLine();

        //search = scanner.nextLine();


        Iterator<Map.Entry<Integer, Car>> iterator = carInventoryMap.entrySet().iterator();
//List<Car> carList = new ArrayList<>();

        Car tmpCar;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Car> carEntry = iterator.next();
            tmpCar = carEntry.getValue();
            if (tmpCar.getColor().equals(search)) {
                carList.add(tmpCar);
                keyList.add(carEntry.getKey());
            }

        }
        printCarList(carList, keyList);
        return null;
    }

    public  String searchCarsByYear() {

        clear();;
        int year;
        listCars();
        System.out.println("Search by Year, enter a year - 4 digit");

        search = scanner.nextLine();

        isNumber = isNumber(search);

        if (isNumber == true && search.length() == 4)
            year = Integer.parseInt(search);
        else {
            System.out.println("entered value is not a valid number for year");
            return null;
        }

        // scanner.nextLine();



        Iterator<Map.Entry<Integer, Car>> iterator = carInventoryMap.entrySet().iterator();
//List<Car> carList = new ArrayList<>();

        Car tmpCar;

        while (iterator.hasNext()) {
            Map.Entry<Integer, Car> carEntry = iterator.next();
            tmpCar = carEntry.getValue();
            if (tmpCar.getYear() == year) {
                carList.add(tmpCar);
                keyList.add(carEntry.getKey());
            }

        }
        printCarList(carList, keyList);
        return null;
    }


    public  String searchCarsByModel() {

        String model;
        clear();
        listCars();
        System.out.println("Search by Model, enter a model");

        model = scanner.nextLine();


        Iterator<Map.Entry<Integer, Car>> iterator = carInventoryMap.entrySet().iterator();
//List<Car> carList = new ArrayList<>();

        Car tmpCar;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Car> carEntry = iterator.next();
            tmpCar = carEntry.getValue();
            if (tmpCar.getModel().equals(model)) {
                carList.add(tmpCar);
                keyList.add(carEntry.getKey());
            }

            /*System.out.println(carEntry.getValue().getMake()+"\t" +
                    carEntry.getValue().getModel()+ "\t"+
                    carEntry.getValue().getColor()+ "\t"+
                    carEntry.getValue().getMiles()+ "\t"+
                    carEntry.getValue().getYear());

             */
        }

        printCarList(carList,keyList);
        return null;
    }


}
