package lab6;

import java.util.*;
import lab5.*;


public class Lab6 {
    public static void main(String[] args) {

        // 1. Порожній конструктор
        LinkedSet<Composition> set1 = new LinkedSet<>();
        set1.add(new RockComposition("Thunder Road", 290));
        set1.add(new PopComposition("Good Goodbye", 223));

        System.out.println("Set 1:");
        set1.print();

        // 2. Конструктор з одним елементом
        LinkedSet<Composition> set2 = new LinkedSet<>(
                new JazzComposition("Autumn Leaves", 391)
        );

        // 3. Конструктор зі стандартною колекцією
        List<Composition> list = Arrays.asList(
                new ClassicalComposition("Dawn", 159),
                new PopComposition("Mantra", 137)
        );

        LinkedSet<Composition> set3 = new LinkedSet<>(list);

        System.out.println("\nSet 3:");
        set3.print();

        System.out.println("\nContains 'Dawn'? " + set3.contains(new ClassicalComposition("Dawn", 159)));
        System.out.println("Size = " + set3.size());
    }
}
