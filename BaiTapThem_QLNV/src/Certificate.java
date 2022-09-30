import java.time.LocalDate;

public class Certificate {
    private String certificateID;
    private String certificateName;
    private String certificateRank;
    private LocalDate certificateDate;

    public Certificate(String certificateID, String certificateName, String certificateRank, LocalDate certificateDate){
        this.certificateID = certificateID;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificateDate = certificateDate;
    }

    public String getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(String certificateID) {
        this.certificateID = certificateID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public LocalDate getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(LocalDate certificateDate) {
        this.certificateDate = certificateDate;
    }

    @Override
    public String toString() {
        return "Certificate {ID: " + certificateID
                + ", Name: " + certificateName
                + ", Rank: " + certificateRank
                + ", Date: " + certificateDate + "}";
    }
}
