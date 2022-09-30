public class McQueen extends Machine implements Runable{
    @Override
    public String start() {
        return "McQueen: V12";
    }

    @Override
    public String run() {
        return "McQueen: Fast and Furious!";
    }
}
