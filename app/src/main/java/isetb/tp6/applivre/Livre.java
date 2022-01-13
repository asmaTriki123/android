package isetb.tp6.applivre;

public class Livre {
    public int id;
    public String rubrique,auteur,titre;

    public Livre(int id, String rubrique, String auteur,String titre) {
        this.id = id;
        this.rubrique = rubrique;
        this.auteur= auteur;
        this.titre=titre;
    }


    public Livre( String rubrique, String auteur,String titre) {

        this.rubrique = rubrique;
        this.auteur= auteur;
        this.titre=titre;
    }

    public int getId() {
        return id;
    }

    public String getRubrique() {
        return rubrique;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRurique(String rurique) {
        this.rubrique = rubrique;
    }

    public void setAuteur(String autuer) {
        this.auteur = auteur;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
