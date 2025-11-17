package MVC.MVC.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class emne {

    @Id
    private String kode;
    private String navn;
    private Integer studiepoeng;
    private String type;
    private Integer antall;
    private char semester;

    public emne(String kode, String navn, Integer studiepoeng, String type, Integer antall, char semester) {
        this.kode = kode;
        this.navn = navn;
        this.studiepoeng = studiepoeng;
        this.type = type;
        this.antall = antall;
        this.semester = semester;
    }
    public emne() {}

    public String getKode() {
        return kode;
    }
    public void setKode(String kode) {
        this.kode = kode;
    }
    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public Integer getStudiepoeng() {
        return studiepoeng;
    }
    public void setStudiepoeng(Integer studiepoeng) {
        this.studiepoeng = studiepoeng;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Integer getAntall() {
        return antall;
    }
    public void setAntall(Integer antall) {
        this.antall = antall;
    }
    public char getSemester() {
        return semester;
    }
    public void setSemester(char semester) {
        this.semester = semester;
    }
}

