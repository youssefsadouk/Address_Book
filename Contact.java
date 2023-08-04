
class Contact {
    private int id;
    private String nom, prenom,telephone, mail, adresse;
    private byte[] photo;
    public Contact(int id, String tel, String nom, String prenom, String mail, String adresse, byte[] photo){
        this.id = id;
        this.telephone = tel;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
        this.photo = photo;
    }
    
    public int getId(){
        return id;
    }
    public String getTel(){
        return telephone;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public String getMail(){
        return mail;
    }
    public String getAdresse(){
        return adresse;
    }
    public byte[] getPhoto(){
        return photo;
    }
}
