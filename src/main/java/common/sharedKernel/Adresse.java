package common.sharedKernel;


public class Adresse implements ValueObject {

    private String description;

    private String numero;

    private String rue;

    private String ville;

    private String pays;

    public Adresse(String description, String numero, String rue, String ville, String pays) {
        this.description = description;
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.pays = pays;
    }

    public String getDescription() {
        return description;
    }

    public String getNumero() {
        return numero;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public String getPays() {
        return pays;
    }
}
