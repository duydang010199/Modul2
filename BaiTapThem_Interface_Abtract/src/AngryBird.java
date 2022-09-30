public class AngryBird extends Animal implements Flyable{
    @Override
    public String fly() {
        return "AngryBird: Fly!";
    }

    @Override
    public String makeSound() {
        return "AngryBird: Ec O Ec!";
    }
}
