package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Product {
    @Id
    @Column(name = "product_nummer")
    private int productNummer;
    private String naam;
    private String beschrijving;
    private long prijs;
    @ManyToMany
    @JoinTable(
            name = "ov_chipkaart_product",
            joinColumns = @JoinColumn(name = "product_nummer", referencedColumnName = "product_nummer"),
            inverseJoinColumns = @JoinColumn(name = "kaart_nummer", referencedColumnName = "kaart_nummer")
    )
    private List<OVChipkaart> ovChipkaarten;

    public Product(int productNummer, String naam, String beschrijving, long prijs) {
        this.productNummer = productNummer;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }

    public Product() {

    }

    public int getProductNummer() {
        return productNummer;
    }

    public void setProductNummer(int productNummer) {
        this.productNummer = productNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public long getPrijs() {
        return prijs;
    }

    public void setPrijs(long prijs) {
        this.prijs = prijs;
    }

    public List<OVChipkaart> getOvChipkaarten() {
        return ovChipkaarten;
    }

    public List<Integer> getovChipKaartNummers() {
        List<Integer> nummers = new ArrayList<Integer>();
        for(OVChipkaart ovChipkaart : ovChipkaarten){
            nummers.add(ovChipkaart.getKaartNummer());
        }
        return nummers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNummer=" + productNummer +
                ", naam='" + naam + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", prijs=" + prijs +
                ", ovChipkaarten=" + ovChipkaarten +
                '}';
    }

    public void addOvChipkaart(OVChipkaart ovChipkaart  ) {
        this.ovChipkaarten.add(ovChipkaart);
    }
}
