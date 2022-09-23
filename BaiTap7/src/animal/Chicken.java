package animal;

import edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: Cục tát, Cục tats...!";
    }

    @Override
    public String howtoEat() {
        return "Chicken: Có thể hấp!";
    }
}
