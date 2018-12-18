package gorissen.vleminckx.timco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//Liesbeth
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String naam;

    @NotNull
    @DecimalMin(value = "0.0")
    private double prijs;

    @NotBlank
    private Diersoort diersoort;

    @NotBlank
    private Categorie categorie;

    @NotBlank
    private String omschrijving;


}
