package pl.coderslab.charity.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static java.lang.Integer.parseInt;


//@NotNull : The CharSequence, Collection, Map or Array object is not null, but can be empty.
// @NotEmpty : The CharSequence, Collection, Map or Array object is not null and size > 0.
// @NotBlank : The string is not null and the trimmed length is greater than zero.

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value=1, message = "Niepoprawna liczba worków")
    @NotNull(message="Uzupełnij pole")
//    @Positive(message = "Niepoprawna liczba worków")
//    @Range(min= 1, message = "Niepoprawna liczba worków")

    private Integer quantity;

    @NotEmpty(message = "Wybierz co najmniej 1 kategorię")
    @ManyToMany
    private List<Category> categories;
    @javax.validation.constraints.NotNull(message = "Zaznacz istytucję")
    @ManyToOne
    private Institution institution;

    @NotBlank(message = "Uzupełniej pole")
    private String street;

    @NotBlank(message = "Uzupełnij pole")
    private String city;
    private String zipCode;


    @NotNull(message = "Uzupełnij pole")
    @Future(message = "Najwcześniejsza możliwa data odbioru to dzień jutrzejszy")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @NotNull(message = "Uzupełnij pole")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;
    private String pickUpComment;

    @NotBlank(message = "Uzupełnij pole")
    private String phone;

    public Donation() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
