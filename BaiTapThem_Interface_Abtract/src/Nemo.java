public class Nemo extends Animal implements Swimable{
    @Override
    public String swim() {
        return "Nemo: swimming!";
    }

    @Override
    public String makeSound() {
        return "Nemo: riu riu!";
    }
}
