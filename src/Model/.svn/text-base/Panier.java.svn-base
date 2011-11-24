package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Array.*;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class Panier extends AbstractTableModel{
    protected Vector TableList;
    protected String[] headers = new String [] {
        "Articles", "Quantité", "Prix", "Total"
    };
    private ProduitRepository listProduit;
    
    
    public Panier(DataModel dataModel){
        this.TableList = new Vector();
        this.listProduit = new ProduitRepository(dataModel);
    }
    /**
     * 
     * @param produit 
     */
    public void add(Produit produit){
        this.listProduit.add(produit);
        String[] record = new String[4];
        record[0] = produit.getTitre();
        record[1] = produit.getQuantiteAchete()+"";
        record[2] = produit.getPrix()+"";
        record[3] = (produit.getQuantiteAchete()*produit.getPrix())+"";
        this.TableList.addElement(record);
        fireTableChanged(null);
        
    }
    /**
     * 
     * @param IdUSer
     * @param remise 
     */
    public void validerPanier(FactureRepository fact,String IdUSer,int remise){
        DataModel dataModel = new DataModel();
        Connection con = dataModel.getConnection();
        PreparedStatement addFacture = null;
        PreparedStatement addListProduit = null;
        PreparedStatement addUpdateStock = null;
        PreparedStatement addUpdateFidelite = null;
        
        
        String reference = "";
        
        
        try {
      con.setAutoCommit(false);
      addFacture = con.prepareStatement(QUERY.PREPARED_STATEMENT_ADD_FACTURE);
      
      // Add new Facture
      addFacture.setInt(1,Integer.valueOf(IdUSer));
      addFacture.setInt(2, remise);
      addFacture.execute();
      con.commit();
      
      Statement state = con.createStatement();
      ResultSet result = state.executeQuery(QUERY.LAST_INSERT_ID);
      con.commit();
     
      result.next();
      reference = result.getString("LAST_INSERT_ID()");
      
      
      addListProduit = con.prepareStatement(QUERY.PREPARED_STATEMENT_ADD_LIST);
      addUpdateStock = con.prepareStatement(QUERY.UPDATE_STOCK_FROM_PRODUIT);
      
      for(Object obj : this.listProduit.getMyList()){
          Produit p = (Produit)obj;
          addListProduit.setInt(1, Integer.valueOf(p.getID()));
          addListProduit.setInt(2, Integer.valueOf(reference));
          addListProduit.setInt(3, Integer.valueOf(IdUSer));
          addListProduit.setInt(4,p.getQuantiteAchete());
          addListProduit.setFloat(5, p.getPrix());
          addListProduit.execute();
          
          //Update stock
          result = state.executeQuery(QUERY.STOCK_FROM_PRODUIT+p.getID());
          result.next();
          int stock = result.getInt("stock");
          stock -= p.getQuantiteAchete();
          
          System.err.println(stock);
          
          addUpdateStock.setInt(1, stock);
          addUpdateStock.setInt(2, Integer.valueOf(p.getID()));
          addUpdateStock.executeUpdate();
          
          con.commit();
          
      }
      //UpDAte fidelite
       addUpdateFidelite = con.prepareStatement(QUERY.UPDATE_FIDELITE_FROM_USER);
       result = state.executeQuery(QUERY.FIDELITE_FROM_USER+IdUSer);
       result.next();
       int fidelite = result.getInt("fidelite");
       fidelite += 1;
       
       addUpdateFidelite.setInt(1, fidelite);
       addUpdateFidelite.setInt(2, Integer.valueOf(IdUSer));
       addUpdateFidelite.executeUpdate();
      
      con.commit();
      
      
    
    } catch (SQLException e ) {
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
                if (addFacture != null) { addFacture.close(); }
                if (addListProduit != null) { addListProduit.close(); }
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
        
        
    }

    public ProduitRepository getListProduit() {
        return listProduit;
    }

    public void setListProduit(ProduitRepository listProduit) {
        this.listProduit = listProduit;
    }
    
    /**
     * 
     * @param produit 
     */
    public void remove(Produit produit){
        this.listProduit.remove(produit);
        
    }/*
     * 
     */
    public void cleanData(){
        this.TableList = new Vector();
        fireTableChanged(null);
    }
    /**
     * 
     * @return Prix total
     */
    public float getPrixTotal() {
        return this.listProduit.getPrixTotal();
    }
    /**
     * 
     * @return toString
     */
    @Override
    public String toString() {
        return "Panier{" + "listProduit=" + listProduit.toString() + ",\n prixTotal=" + getPrixTotal() + '}';
    }

    @Override
    public String getColumnName(int i) {
        return headers[i];
    }
    
    @Override
    public int getRowCount() {
       return this.TableList.size();
    }

    @Override
    public int getColumnCount() {
        return this.headers.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return ((String[]) this.TableList.elementAt(row))[col];
    }
    
}