import java.time.LocalDate;
import java.util.List;

public class Fresher extends Employee {
    private LocalDate graduation_date;
    private String graduation_rank;
    private String education;


    public Fresher(LocalDate graduation_date, String graduation_rank, String education) {
        this.graduation_date = graduation_date;
        this.graduation_rank = graduation_rank;
        this.education = education;
    }

    public Fresher(String id, String fullName, LocalDate birthDay, String phone, String email,
                   List<Certificate> certificates, LocalDate graduation_date, String graduation_rank, String education) {
        super(id, fullName, birthDay, phone, email, 1, certificates);
        this.graduation_date = graduation_date;
        this.graduation_rank = graduation_rank;
        this.education = education;
    }

    public LocalDate getGraduation_date() {
        return graduation_date;
    }

    public void setGraduation_date(LocalDate graduation_date) {
        this.graduation_date = graduation_date;
    }

    public String getGraduation_rank() {
        return graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        this.graduation_rank = graduation_rank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void showInfo() {

    }
}
