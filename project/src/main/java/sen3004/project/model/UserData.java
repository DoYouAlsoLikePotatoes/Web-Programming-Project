package sen3004.project.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "person")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "fname")
    private String firstName;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "lname")
    private String lastName;

    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "td")
    private LocalDate date;

    @NotEmpty
    @Column(name = "cname")
    private String companyOptions;

    @NotEmpty
    @Column(name = "mname")
    private String deviceModel;

    @NotNull
    @Column(name = "rating")
    private String rating;

    @Size(max = 200)
    @Column(name = "review")
    private String review;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCompanyOptions() {
        return this.companyOptions;
    }

    public void setCompanyOptions(String companyOptions) {
        this.companyOptions = companyOptions;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return this.review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
