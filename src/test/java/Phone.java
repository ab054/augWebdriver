public class Phone {

    String model;
    String color;
    int amountOfMemory;
    int price;

    public Phone() {
        System.out.println("My own constructor been called");
    }

    public Phone(String model, int amountOfMemory, int price) {
        this.model = model;
        this.amountOfMemory = amountOfMemory;
        this.price = price;
    }

    public Phone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }


    public void call(String phoneNumber) {
        System.out.println(phoneNumber + " been called...");
    }

    public void sendMessage() {
        System.out.println("Message sent...");
    }
}
