package Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FactureRepository extends Repository {
    private String TABLE_FACTURE = "facture";

    public FactureRepository(DataModel dataSource) {
        super();
        this.setDataSource(dataSource);
    }
    
    /**
     * 
     * @param facture 
     */
    public void add(Facture facture){
       super.add(facture);
    }
    /**
     * 
     * @param ref
     * @return 
     */
    public Facture getFactureByReference(String ref){
        Facture fact = null;
        for(Object obj : this.myList){
            Facture f = (Facture)obj;
            if(f.getReference().equals(ref)){
                fact = f;
                break;
            }
        }
        return fact;
    }
    /**
     * 
     * @return toString
     */
    @Override
    public String toString() {
        return "FactureRepository{" + this.myList.toString() +'}';
    }
    /**
     * 
     */
    
   public  void loadData() {
        try {
            
            
            ResultSet  result = this.dataSource.getAllDataFromTable(this.TABLE_FACTURE);
            ResultSetMetaData resultMeta = result.getMetaData();
            
            colCount = resultMeta.getColumnCount();
            headers = new String[colCount];
            for (int h = 1; h <= colCount; h++) {
                headers[h - 1] = resultMeta.getColumnName(h).toUpperCase();
            }
            
            while(result.next()){
                   
                        String ref = result.getString("idfacture");
                        Date date = result.getDate("date");
                        int remise = result.getInt("remise");
                        Facture f = new Facture(ref,date,remise,this.dataSource);
                        add(f);
                        
                         // Ajout des données brutes
                        String[] record = new String[colCount];
                        for (int i = 0; i < colCount; i++) {
                            record[i] = result.getString(i + 1);
                        }
                        this.TableList.addElement(record);
                        
                   
                        
            }
            
            //this.dataSource.getConnection().close();
            //result.close();
            //result.getStatement().close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param idUSer 
     */
    public void loadFactureFromUser(String idUser){
        ResultSet result = null;
        String query = QUERY.FACTURE_FROM_USER + idUser;
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
                   
                        String ref = result.getString("Reference");
                        Date date = result.getDate("date");
                        int remise = result.getInt("remise");
                        Facture f = new Facture(ref,date,remise,this.dataSource);
                        add(f);
                        
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
            //this.dataSource.getConnection().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
  
}