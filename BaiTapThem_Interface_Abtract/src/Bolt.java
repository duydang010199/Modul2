public class Bolt extends Animal implements Barkable,Runable {

    @Override
    public String bark() {
        return "Bolt: Go Go";
    }

    @Override
    public String run() {
        return "Bolt: run very fast";
    }

    @Override
    public String makeSound() {
        return "Bolt: Huuuuuuu!";
    }
}

