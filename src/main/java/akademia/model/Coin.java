package akademia.model;

import akademia.controllers.MetalController;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DecimalFormat;

import static akademia.controllers.MetalController.finalGold;
import static akademia.controllers.MetalController.finalSilver;
import static akademia.controllers.MetalController.finalUsd;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Coin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String name;

  @Column
  private String series;

  @Column
  private Integer value;

  @Column
  private String country;

  @Column
  private String hallmark;

  @Column
  private String stamp;

  @Column
  private String dimansion;

  @Column
  private String mass;

  @Column
  private Integer emission;

  @Column
  private String emissiondate;

  @Column
  private String emissionprise;

  @Column
  private String buyprise;

  @Column
  private String awers;

  @Column
  private String rewers;

  @Column
  private String note;

  public Coin() {
  }

  public Coin( String name, String series, Integer value, String country,
               String hallmark, String stamp, String dimansion, String mass,
               Integer emission, String emissiondate, String emissionprise, String buyprise, String awers,
               String rewers, String note) {
    this.name = name;
    this.series = series;
    this.value = value;
    this.country = country;
    this.hallmark = hallmark;
    this.stamp = stamp;
    this.dimansion = dimansion;
    this.mass = mass;
    this.emission = emission;
    this.emissiondate = emissiondate;
    this.emissionprise = emissionprise;
    this.buyprise = buyprise;
    this.awers = awers;
    this.rewers = rewers;
    this.note = note;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSeries() {
    return series;
  }

  public void setSeries(String series) {
    this.series = series;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getHallmark() {
    return hallmark;
  }

  public void setHallmark(String hallmark) {
    this.hallmark = hallmark;
  }

  public String getStamp() {
    return stamp;
  }

  public void setStamp(String stamp) {
    this.stamp = stamp;
  }

  public String getDimansion() {
    return dimansion;
  }

  public void setDimansion(String dimansion) {
    this.dimansion = dimansion;
  }

  public String getMass() {
    return mass;
  }

  public void setMass(String mass) {
    this.mass = mass;
  }

  public Integer getEmission() {
    return emission;
  }

  public void setEmission(Integer emission) {
    this.emission = emission;
  }

  public String getEmissiondate() {
    return emissiondate;
  }

  public void setEmissiondate(String emissiondate) {
    this.emissiondate = emissiondate;
  }

  public String getEmissionprise() {
    return emissionprise;
  }

  public void setEmissionprise(String emissionprise) {
    this.emissionprise = emissionprise;
  }

  public String getBuyprise() {
    return buyprise;
  }

  public void setBuyprise(String buyprise) {
    this.buyprise = buyprise;
  }

  public String getAwers() {
    return awers;
  }

  public void setAwers(String awers) {
    this.awers = awers;
  }

  public String getRewers() {
    return rewers;
  }

  public void setRewers(String rewers) {
    this.rewers = rewers;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getAlloy() {
    String stringToTrim = getHallmark();
    String trimmed = stringToTrim.substring(0,2);
    return trimmed;
  }
  public String convertMassToMetal() {
    DecimalFormat df = new DecimalFormat("####.###");
    String output;
    String alloy = getAlloy();
    float getMass = (Float.parseFloat(getMass()));
    MetalController metalController = null;
    float getUsd = finalUsd;
    float getGoldGram = (float) (finalGold / 31.1034768);
    float getSilverGram = (float) (finalSilver / 31.1034768);

    if (alloy.equalsIgnoreCase("Au")) {
      return output = df.format(getMass * getGoldGram * getUsd);
    } else if (alloy.equalsIgnoreCase("Ag")) {
      return output = df.format(getMass * getSilverGram * getUsd);
    } else if (alloy.equalsIgnoreCase("MN") || alloy.equalsIgnoreCase("Cu") ||alloy.equalsIgnoreCase("Al") ) {
      return "Stop nieinwestycyjny";
    } else {
      output = "Błąd stopu";
      return output;
    }
  }

  @Override
  public String toString() {
    return "Coin{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", series='" + series + '\'' +
        ", value=" + value +
        ", country='" + country + '\'' +
        ", hallmark='" + hallmark + '\'' +
        ", stamp='" + stamp + '\'' +
        ", dimansion='" + dimansion + '\'' +
        ", mass='" + mass + '\'' +
        ", emission=" + emission +
        ", emissiondate='" + emissiondate + '\'' +
        ", emissionprise='" + emissionprise + '\'' +
        ", buyprise='" + buyprise + '\'' +
        ", awers='" + awers + '\'' +
        ", rewers='" + rewers + '\'' +
        ", note='" + note + '\'' +
        '}';
  }
}
