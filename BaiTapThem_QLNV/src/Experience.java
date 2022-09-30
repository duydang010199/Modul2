import java.time.LocalDate;
import java.util.List;

public class Experience extends Employee{
    private int yearOfExperience;
    private String proSkill;

    public Experience(int yearOfExperience, String proSkill){
        this.yearOfExperience = yearOfExperience;
        this.proSkill = proSkill;
    }
    public Experience(String id, String fullName, LocalDate birthDay, String phone, String email,
                      List<Certificate> certificates, int yearOfExperience, String proSkill){
        super(id, fullName, birthDay, phone, email, 0, certificates);
        this.yearOfExperience = yearOfExperience;
        this.proSkill = proSkill;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
    public void showInfo(){
    }



}
