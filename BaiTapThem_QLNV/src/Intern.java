import java.time.LocalDate;
import java.util.List;

public class Intern extends Employee{
    private String majors;
    private String semester;
    private String university_name;

    public Intern(String majors, String semester, String university_name){
        this.majors = majors;
        this.semester = semester;
        this. university_name = university_name;
    }
    public Intern(String id, String fullName, LocalDate birthDay, String phone, String email,
                  List<Certificate> certificates,
                  String majors, String semester, String university_name){
        super(id, fullName, birthDay, phone, email, 2, certificates);
        this.majors = majors;
        this.semester =semester;
        this.university_name = university_name;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public void showInfo(){}


}
