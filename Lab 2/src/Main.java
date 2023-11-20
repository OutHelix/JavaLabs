public class Main {
    public static void main(String[] args) {
        Watch watch = new Watch("Apple", 500, "Black", "Leather", true);
        Smartphone smartphone = new Smartphone("Samsung", 1000, "Blue", "Android", 6);
        Laptop laptop = new Laptop("Dell", 1500, "Silver", 15, 8);
        watch.describeFeatures();
        System.out.println();
        watch.turnOn();
        watch.turnOff();
        System.out.println();
        smartphone.describeFeatures();
        System.out.println();
        laptop.describeFeatures();
        System.out.println();
        laptop.turnOn();
        System.out.println();
        System.out.println("Number of gadgets created: " + Gadgets.getCounter());
    }
}

abstract class Gadgets {
    protected String brand;
    protected int price;
    protected String color;

    private static int counter = 0;

    // Конструктор по умолчанию
    public Gadgets() {
        counter++; // Увеличиваем счетчик при создании объекта
    }

    public Gadgets(String brand, int price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
        counter++;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static int getCounter() {
        return counter;
    }


    public abstract void turnOn();

    public abstract void turnOff();

    public abstract void describeFeatures();
}

class Watch extends Gadgets {
    private String strapType;
    private boolean isWaterproof;

    public Watch(String brand, int price, String color, String strapType, boolean isWaterproof) {
        super(brand, price, color);
        this.strapType = strapType;
        this.isWaterproof = isWaterproof;
    }

    public String getStrapType() {
        return strapType;
    }

    public void setStrapType(String strapType) {
        this.strapType = strapType;
    }

    public boolean isWaterproof() {
        return isWaterproof;
    }

    public void setWaterproof(boolean isWaterproof) {
        this.isWaterproof = isWaterproof;
    }

    @Override
    public void turnOn() {
        System.out.println("Watch is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Watch is turned off.");
    }

    @Override
    public void describeFeatures() {
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + price);
        System.out.println("Color: " + color);
        System.out.println("Strap Type: " + strapType);
        System.out.println("Is Waterproof: " + isWaterproof);
    }

}

class Smartphone extends Gadgets {
    private String operatingSystem;
    private int screenSize;

    public Smartphone(String brand, int price, String color, String operatingSystem, int screenSize) {
        super(brand, price, color);
        this.operatingSystem = operatingSystem;
        this.screenSize = screenSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public void turnOn() {
        System.out.println("Smartphone is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Smartphone is turned off.");
    }

    @Override
    public void describeFeatures() {
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + price);
        System.out.println("Color: " + color);
        System.out.println("Operating System: " + operatingSystem);
        System.out.println("Screen Size: " + screenSize + " inches");
    }
}

class Laptop extends Gadgets {
    private int screenSize;
    private int ramSize;

    public Laptop(String brand, int price, String color, int screenSize, int ramSize) {
        super(brand, price, color);
        this.screenSize = screenSize;
        this.ramSize = ramSize;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    @Override
    public void turnOn() {
        System.out.println("Laptop is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Laptop is turned off.");
    }

    @Override
    public void describeFeatures() {
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + price);
        System.out.println("Color: " + color);
        System.out.println("Screen Size: " + screenSize + " inches");
        System.out.println("RAM Size: " + ramSize + " GB");
    }
}
