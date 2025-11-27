package raskGjennomgang.raskGjennomgang.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Forfatter {

    @NotBlank(message = "Navn må fylles ut")
    @Size(min = 2, max = 30, message = "Navn må være mellom 2 og 30 tegn")
    private String navn;

    @NotBlank(message = "E-post må fylles ut")
    @Email(message = "Ugyldig e-postadresse")
    private String email;

    public Forfatter() {
    }

    public void setNavn( String navn ) {
        this.navn = navn;
    }
    public String getNavn() {
        return navn;
    }
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
}
