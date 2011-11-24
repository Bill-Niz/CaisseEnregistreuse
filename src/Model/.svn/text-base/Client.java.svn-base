package Model;



public class Client {
  /* {author=Bill Nizeyimana, version=1.0}*/
    
  private String nom;
  private String prenom;
  private Panier panier;
  private int fidelite;
  private String ID;
  private FactureRepository listFacture;
  
  
  /**
   * 
   */
  public Client(DataModel dataModel){
      this.panier = new Panier(dataModel);
     
  }
/**
   * 
   * @param ID
   * @param nom
   * @param prenom
   * @param fidelite
   * @param dataModel 
   */
    public Client(String ID,String nom, String prenom, int fidelite,DataModel dataModel) {
        this.nom = nom;
        this.prenom = prenom;
        this.fidelite = fidelite;
        this.ID = ID;
        this.panier = new Panier(dataModel);
        
       
    }
  
  
    /**
     * 
     */
    public void loadFacture(DataModel dataModel){
        this.listFacture = new FactureRepository(dataModel);
        this.listFacture.loadFactureFromUser(this.ID);
    }

     /**
   * 
   * @return 
   */
    @Override
    public String toString() {
        return "Client{" + "nom=" + nom + ",\n prenom=" + prenom + ", panier=" + panier.toString() + ",\n listFacture=" + listFacture.toString() + "}\n";
    }
  
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getFidelite() {
        return fidelite;
    }

    public void setFidelite(int fidelite) {
        this.fidelite = fidelite;
    }

    public FactureRepository getListFacture() {
        return listFacture;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
}