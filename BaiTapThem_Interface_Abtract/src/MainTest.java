public class MainTest {
    public static void main(String[] args) {
        Animal a = new Bolt();
        System.out.println(a.makeSound());
        Barkable b = new Bolt();
        System.out.println(b.bark());
        Runable r = new Bolt();
        System.out.println(r.run());

        Flyable f = new Siddeley();
        System.out.println(f.fly());
        Machine m = new Siddeley();
        System.out.println(m.start());



    }
}
