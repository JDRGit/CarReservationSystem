import java.util.ArrayList;
import java.util.Scanner;

class Car {
    private String make; // Make of the car
    private String model; // Model of the car
    private int year; // Year of the car
    private boolean available; // Availability of the car

    public Car(String make, String model, int year, boolean available) {
        this.make = make; // Set the make of the car
        this.model = model; // Set the model of the car
        this.year = year; // Set the year of the car
        this.available = available; // Set the availability of the car
    }

    public String getMake() {
        return make; // Return the make of the car
    }

    public String getModel() {
        return model; // Return the model of the car
    }

    public int getYear() {
        return year; // Return the year of the car
    }

    public boolean isAvailable() {
        return available; // Return the availability of the car
    }

    public void setAvailable(boolean available) {
        this.available = available; // Set the availability of the car
    }

    public String toString() {
        return make + " " + model + " " + year; // Return the details of the car
    }
}

class CarReservationSystem {
    private static ArrayList<Car> inventory = new ArrayList<>(); // Inventory of cars

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object to read user input

        // Initialize inventory
        inventory.add(new Car("Toyota", "Camry", 2020, true)); // Add a new car to the inventory
        inventory.add(new Car("Honda", "Accord", 2021, true));
        inventory.add(new Car("Ford", "Mustang", 2019, false));
        inventory.add(new Car("Chevrolet", "Camaro", 2022, true));
        inventory.add(new Car("Tesla", "Model S", 2023, true));

        while (true) {
            System.out.println("Enter 1 to view available cars"); // Print the menu
            System.out.println("Enter 2 to reserve a car");
            System.out.println("Enter 0 to exit"); // Exit the program

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableCars(); // Call the method to view available cars
                    break; // Break out of the switch statement
                case 2:
                    reserveCar(); // Call the method to reserve a car
                    break;
                case 0:
                    System.exit(0); // Exit the program
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void viewAvailableCars() {
        System.out.println("Available cars:");
        for (Car car : inventory) { // Iterate through the inventory of cars
            if (car.isAvailable()) { // Check if the car is available for reservation
                System.out.println(car); // Print the details of the available car
            }
        }
    }

    private static void reserveCar() {
        Scanner sc = new Scanner(System.in); // Scanner object to read user input

        System.out.print("Enter make of car to reserve: "); // Prompt the user to enter the make and model of the car to reserve
        String make = sc.next();
        System.out.print("Enter model of car to reserve: "); // Prompt the user to enter the make and model of the car to reserve
        String model = sc.next();

        for (Car car : inventory) { // Iterate through the inventory of cars
            if (car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model) && car.isAvailable()) {
                // Check if the car matches the user's input and is available for reservation
                car.setAvailable(false); // Set the availability of the car to false (reserved)
                System.out.println("Reservation successful."); // Print a success message
                return;
            }
        }

        System.out.println("Car not found or already reserved."); // Print an error message if the car is not found or already reserved
    }
}

