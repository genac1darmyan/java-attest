import java.util.*;

class Laptop {
    private String brand;
    private int ram; // ОЗУ44
    private int hdd; // Объем ЖД
    private String os; // Операционная система
    private String color; // Цвет

    public Laptop(String brand, int ram, int hdd, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }
    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

public class LaptopStore {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Dell", 8, 512, "Windows", "Black"));
        laptops.add(new Laptop("Apple", 16, 256, "MacOS", "Silver"));
        laptops.add(new Laptop("HP", 8, 1024, "Windows", "Grey"));
        laptops.add(new Laptop("Lenovo", 4, 512, "Linux", "Black"));
        laptops.add(new Laptop("Asus", 16, 1024, "Windows", "Blue"));

        filterLaptops(laptops);
    }
    public static void filterLaptops(Set<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        String criteria = scanner.nextLine();

        switch (criteria) {
            case "1":
                System.out.println("Введите минимальное значение ОЗУ:");
                filters.put("ram", scanner.nextLine());
                break;
            case "2":
                System.out.println("Введите минимальный объем ЖД:");
                filters.put("hdd", scanner.nextLine());
                break;
            case "3":
                System.out.println("Введите необходимую операционную систему:");
                filters.put("os", scanner.nextLine());
                break;
            case "4":
                System.out.println("Введите цвет:");
                filters.put("color", scanner.nextLine());
                break;
            default:
                System.out.println("Некорректный ввод.");
                return;
        }
        
        for (Laptop laptop : laptops) {
            boolean matches = true;

            if (filters.containsKey("ram") && laptop.getRam() < Integer.parseInt(filters.get("ram"))) {
                matches = false;
            }
            if (filters.containsKey("hdd") && laptop.getHdd() < Integer.parseInt(filters.get("hdd"))) {
                matches = false;
            }
            if (filters.containsKey("os") && !laptop.getOs().equalsIgnoreCase(filters.get("os"))) {
                matches = false;
            }
            if (filters.containsKey("color") && !laptop.getColor().equalsIgnoreCase(filters.get("color"))) {
                matches = false;
            }

            if (matches) {
                System.out.println(laptop);
            }
        }
    }
}
