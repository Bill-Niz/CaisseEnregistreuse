package Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public  class ProduitRepository extends Repository  {
    
    
    private float prixTotal= 0;
    
    public ProduitRepository(DataModel dataSource) {
        super();
        this.setDataSource(dataSource);
        
          
        
    }
    /**
     * 
     * @param produit 
     */
   public void add(Produit produit){
       super.add(produit);
       this.prixTotal += produit.getQuantiteAchete()*produit.getPrix();
       
   }
   /**
    * 
    * @param produit 
    */
   public void remove(Produit produit){
        super.remove(produit);
        this.prixTotal -= produit.getPrix();
    }

    @Override
    public String toString() {
        return "ProduitRepository{" + this.myList.toString() + ",\n PrixTotal= " +this.prixTotal + '}';
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 1) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * 
     * @return 
     */
   public  float getPrixTotal() {
        return this.prixTotal;
    }
    /**
     * 
     * @return Produit
     */
    public Produit getProduitById(String idProduit){
        Produit prod = null;
        for(Object obj : this.myList){
            Produit p = (Produit)obj;
            if(p.getID().equals(idProduit)){
                prod = p;
                break;
            }
        }
        return prod;
    }
    /**
     * 
     */
    public synchronized void  loadData() {
        String query = QUERY.LIST_PRODUIT;
        ResultSet result = null;
        Statement state ;
        try {
            state = this.dataSource.getConnection().createStatement();
            result = state.executeQuery(query);
            ResultSetMetaData resultMeta = result.getMetaData();
            
            colCount = resultMeta.getColumnCount();
            headers = new String[colCount];
            for (int h = 1; h <= colCount; h++) {
                headers[h - 1] = resultMeta.getColumnName(h).toUpperCase();
            }
            
            while(result.next()){
                    
                        String ID = result.getString("idproduit");
                        String titre = result.getString("titre");
                        float prix = result.getFloat("prix");
                        int stock = result.getInt("stock");
                       
                        Produit p = new Produit(ID,titre, prix, stock,0);
                        add(p);
                        
                         // Ajout des données brutes
                        String[] record = new String[colCount];
                        for (int i = 0; i < colCount; i++) {
                            record[i] = result.getString(i + 1);
                        }
                        this.TableList.addElement(record);
                       
                    
                        
            }
            
            //result.close();
            //result.getStatement().close();
            //this.dataSource.getConnection().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
     * @param factureRef 
     */
    public void loadProduitFromFacture(String factureRef){
        ResultSet result;
        String query = QUERY.LIST_FACTURE_PRODUIT+factureRef;
        Statement state ;
        try {
            
            state = this.dataSource.getConnection().createStatement();
            result = state.executeQuery(query);
            ResultSetMetaData resultMeta = result.getMetaData();
            
            colCount = resultMeta.getColumnCount();
            headers = new String[colCount];
            for (int h = 1; h <= colCount; h++) {
                headers[h - 1] = resultMeta.getColumnName(h).toUpperCase();
            }
            
            while(result.next()){
                    
                        String ID = result.getString("produit_idproduit");
                        String titre = result.getString("titre");
                        float prix = result.getFloat("prix");
                        int quantiteAchete = result.getInt("quantite");
                        
                        Produit p = new Produit(ID,titre, prix, 0,quantiteAchete);
                        add(p);
                        
                         // Ajout des données brutes
                        String[] record = new String[colCount];
                        for (int i = 0; i < colCount; i++) {
                            record[i] = result.getString(i + 1);
                        }
                        this.TableList.addElement(record);
                        fireTableChanged(null);
                    
                        
            }
            //result.close();
            //result.getStatement().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
}