public class Siddeley extends Machine implements Flyable{
    @Override
    public String fly() {
        return "Siddeley: Fly";
    }

    @Override
    public String start() {
        return "Siddeley: Turbofan!";
    }
}
