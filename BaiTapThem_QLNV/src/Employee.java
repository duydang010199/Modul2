import java.time.LocalDate;
import java.util.List;

public abstract class Employee {
    private String id;
    private String fullName;
    private LocalDate birthDay;
    private String phone;
    private String email;
    private int type;
    private int count;
    private List<Certificate> certificates;

    public Employee(){}

    public Employee(String id, String fullName, LocalDate birthDay, String phone, String email,
                    int type, List<Certificate> certificates){
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.count++;
        this.certificates = certificates;
    }


    public void showInfo(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    @Override
    public String toString() {
        return "Employee {id: " + id
                + ", FullName: " + fullName
                + ", Birthday: " + birthDay
                + ", Phone: " + phone
                + ", Email: " + email
                + ", Type" + type
                + ", Count: " + count
                + ", Certificates" + certificates + "}";
    }
}
