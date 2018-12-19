//Liesbeth
package gorissen.vleminckx.timco.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class User {

    @NotBlank (message = "Gelieve uw naam in te vullen")
    private String surName;

    @NotBlank (message = "Gelieve uw voornaam in te vullen")
    private String name;

    @NotBlank (message = "Gelieve uw straatnaam in te vullen")
    private String street;

    @NotNull (message = "Gelieve uw huisnummer in te vullen")
    @DecimalMin(value = "0", message = "Verkeerd huisnummer")
    private int houseNumber;

    @NotBlank (message ="Gelieve de bus in te vullen")
    private String box;

    @NotNull (message = "Gelieve uw postcode in te vullen")
    @DecimalMin(value = "0", message = "Verkeerde postcode")
    private int postalCode;

    @NotBlank (message ="Gelieve uw woonplaats in te vullen")
    private String place;

    @NotBlank (message = "Gelieve uw e-mailadres in te vullen")
    @Email(message = "E-mailadres is niet geldig")
    private String email;

    public User() {
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
