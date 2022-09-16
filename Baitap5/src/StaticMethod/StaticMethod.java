package StaticMethod;

public class StaticMethod {
    public static void main(String[] args) {
        Student.change(); // Gọi phương thức change()

        // Tạo đối tượng
        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Nam");

        // Gọi phương thức display()
        s1.display();
        s2.display();
        s3.display();
    }
}
