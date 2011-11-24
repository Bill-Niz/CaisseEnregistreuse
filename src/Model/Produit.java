package Model;

import java.util.Observable;
import java.util.Observer;


public class Produit {

  private String ID;
  private String titre;
  private float prix;
  private int stock;
  private int quantiteAchete;

    public Produit(String ID, String titre, float prix, int stock, int quantiteAchete) {
        this.ID = ID;
        this.titre = titre;
        this.prix = prix;
        this.stock = stock;
        this.quantiteAchete = quantiteAchete;
    }

  
  
  

  
    /**
     * 
     * @return Prix
     */
    public float getPrix() {
        return prix;
    }
    /**
     * 
     * @param prix 
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }
    /**
     * 
     * @return quantiteAchete 
     */
    public int getQuantiteAchete() {
        return quantiteAchete;
    }
    /**
     * 
     * @param quantiteAchete 
     */
    public void setQuantiteAchete(int quantiteAchete) {
        this.quantiteAchete = quantiteAchete;
    }
    /**
     * 
     * @return Le stock
     */
    public int getStock() {
        return stock;
    }
    /**
     * 
     * @param stok 
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    /**
     * 
     * @return Le titre
     */
    public String getTitre() {
        return titre;
    }
    /**
     * 
     * @param titre 
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Produit{" + "titre=" + titre + ", prix=" + prix + ", stok=" + stock + ", quantiteAchete=" + quantiteAchete + '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
  
  

  
}