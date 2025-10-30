// C11 - 17 % 11 = 6
// Визначити клас спортивний інвентар, який складається як мінімум з 5-и полів. (SportsEquipment) 
/* Створити клас із виконавчим методом, в якому створити масив з об’єктів класу визначеному варіантом (п. 2). 
Відсортувати масив, за одним з полів за зростанням, а за іншим — за спаданням, використовуючи при цьому стандартні засоби сортування (). 
Після цього знайти в масиві об’єкт, який ідентичний заданому. 
Всі змінні повинні бути описані та значення їх задані у виконавчому методі. 
Код повинен бути детально задокументований. 
Код повинен відповідати стандартам Java Code Conventions */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Клас SportsEquipment описує спортивний інвентар із п'ятьма характеристиками.
 */
class SportsEquipment {
    private String name;        // Назва інвентаря
    private String type;        // Тип спорту
    private double price;       // Ціна (грн)
    private double weight;      // Вага
    private String brand;       // Виробник (бренд)

    // Конструктор класу 
    public SportsEquipment(String name, String type, double price, double weight, String brand) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.weight = weight;
        this.brand = brand;
    }

    // Гетери для отримання полів
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getBrand() {
        return brand;
    }

    // Метод для зручного текстового відображення об'єкта.
    @Override
    public String toString() {
        return String.format("Name: %-10s | Type: %-10s | Price: %-7.2f | Weight: %-5.2f | Brand: %-10s",
                name, type, price, weight, brand);
    }

    // Перевизначений метод equals() — перевіряє, чи два об’єкти однакові за всіма полями.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Якщо це той самий об'єкт
        if (!(o instanceof SportsEquipment)) return false; // Якщо інший об'єкт
        SportsEquipment that = (SportsEquipment) o;
        // Порівняння всіх полів
        return Double.compare(that.price, price) == 0 &&
                Double.compare(that.weight, weight) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(brand, that.brand);
    }
    // Перевизначений метод hashCode(), який відповідає equals()
    @Override
    public int hashCode() {
        return Objects.hash(name, type, price, weight, brand);
    }
}

public class Lab3 {
    public static void main(String[] args) {
        // Створення масиву об'єктів спортивного інвентарю
        SportsEquipment[] equipments = {
                new SportsEquipment("Ball", "Football", 850.0, 0.45, "Adidas"),
                new SportsEquipment("Racket", "Tennis", 2200.0, 0.35, "Wilson"),
                new SportsEquipment("Helmet", "Cycling", 1500.0, 0.40, "Giro"),
                new SportsEquipment("Gloves", "Boxing", 1200.0, 0.50, "Everlast"),
                new SportsEquipment("Mat", "Yoga", 700.0, 1.20, "Reebok")
        };

        System.out.println("=== Початковий масив ===");
        Arrays.stream(equipments).forEach(System.out::println);

        // Сортування масиву за ціною (за зростанням)
        Arrays.sort(equipments, Comparator.comparingDouble(SportsEquipment::getPrice));
        System.out.println("\n=== Сортування за ціною (зростання) ===");
        Arrays.stream(equipments).forEach(System.out::println);

        // Сортування масиву за вагою (за спаданням)
        Arrays.sort(equipments, Comparator.comparingDouble(SportsEquipment::getWeight).reversed());
        System.out.println("\n=== Сортування за вагою (спадання) ===");
        Arrays.stream(equipments).forEach(System.out::println);

        // Створення об'єкта для пошуку
        SportsEquipment target = new SportsEquipment("Racket", "Tennis", 2200.0, 0.35, "Wilson");

        // Пошук ідентичного об'єкта в масиві
        boolean found = Arrays.stream(equipments).anyMatch(e -> e.equals(target));
        
        System.out.println("\n=== Результат пошуку ===");
        if (found) {
            System.out.println("Знайдено об’єкт: " + target);
        } else {
            System.out.println("Об’єкт не знайдено.");
        }
    }
}
