package isetb.tp6.applivre;

public class user {
    int cin;
    String nom;
    String  login;
    String email ;
    String password ;
    String role;

    public user(int cin, String nom, String login, String email, String password, String role) {
        this.cin = cin;
        this.nom = nom;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role=role;
    }

    public user(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role=role;
    }

    public user(String nom, String login, String email, String password,String role) {
        this.nom = nom;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role=role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
