package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                        this.fireTableChanged(null);
                       
                       
                    
                        
            }
            result.getStatement().close();
            result.close();
            this.dataSource.releaseConnection();
            
            
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
            
            result.getStatement().close();
            result.close();
            this.dataSource.releaseConnection();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    /**
     * 
     * @param id 
     */
    public void updateProduitFromID(String id,String titre,String description,float prix,int stock){
        Connection con = this.dataSource.getConnection();
        PreparedStatement addUpdateProduit = null;
        
        try{
      con.setAutoCommit(false);
      addUpdateProduit = con.prepareStatement(QUERY.UPDATE_PRODUIT_BY_ID);
      
      // Update Produit
      addUpdateProduit.setString(1,titre);
      addUpdateProduit.setString(2, description);
      addUpdateProduit.setFloat(3,prix);
      addUpdateProduit.setInt(4, stock);
      addUpdateProduit.setInt(5,Integer.valueOf(id));
     
      addUpdateProduit.execute();
      con.commit();
        }catch (SQLException e ) {
      e.printStackTrace();
      
      
      if (con != null) {
        try {
          System.err.print("Transaction is being rolled back");
          con.rollback();
        } catch(SQLException excep) {
          excep.printStackTrace();
        }
      }
    } finally {
            try {
                if (addUpdateProduit != null) { addUpdateProduit.close(); }
                con.setAutoCommit(true);
                this.dataSource.releaseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
    
    
}