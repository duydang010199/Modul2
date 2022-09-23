import animal.Animal;
import animal.Chicken;
import animal.Tiger;
import edible.Edible;
import fruit.Apple;
import fruit.Fruit;
import fruit.Orange;

public class AbstractAndInterfaceTests {
        public static void main(String[] args) {
            Animal[] animals = new Animal[2];
            animals[0] = new Tiger();
            animals[1] = new Chicken();
            for (Animal animal: animals) {
                System.out.println(animal.makeSound());
                if (animal instanceof Chicken){
                    Edible edible = (Chicken) animal;
                    System.out.println(edible.howtoEat());
                }
            }
            Fruit[] fruit = new Fruit[2];
            fruit[0] = new Orange();
            fruit[1] = new Apple();
            for (Fruit fruits: fruit) {
                System.out.println(fruits.howtoEat());
            }
        }
}
