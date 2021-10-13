package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Entity
public class Reiziger {
    @Id
    @Column(name = "reiziger_id")
    private int id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboorteDatum;
    @OneToOne(mappedBy = "reiziger")
    private Adres adres;
    @OneToMany(mappedBy = "reiziger")
    private List<OVChipkaart> ovChipkaart;

//kijk naar hashmap
    public Reiziger(String naam, Date geboorteDatum) {
        String[] list=naam.split(" ");
        this.voorletters = list[0];
        this.tussenvoegsel = list[1];
        this.achternaam = list[2];

        this.geboorteDatum = geboorteDatum;
    }

    public Reiziger() {}


    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(Date geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam(){
        if(tussenvoegsel != null) {
            return (String.format("reiziger: %s. %s %s", voorletters, tussenvoegsel, achternaam));
        }
        else{
            return (String.format("reiziger: %s. %s", voorletters, achternaam));
        }    }

    @Override
    public String toString() {
        if(!Objects.equals(tussenvoegsel, "null")) {
            return (String.format("reiziger: %s. %s %s (%s)", voorletters, tussenvoegsel, achternaam, geboorteDatum));
        }
        else{
            return (String.format("reiziger: %s. %s (%s)", voorletters, achternaam, geboorteDatum));
        }
    }

}
