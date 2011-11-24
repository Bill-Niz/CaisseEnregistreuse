package Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ClientRepository extends Repository {
    
    private String TABLE_CLIENT =  "user";
  /**
   * 
   */
    public ClientRepository(DataModel datamodel){
        super();
      if(datamodel != null){
            this.setDataSource(dataSource);
        }else{
            this.setDataSource(new DataModel());
        }
        
        this.loadData();
    }
    /**
     * 
     * @param client 
     */
    public void add(Client client) {
        super.add(client);
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "ClientRepository{" + this.myList.toString() + '}';
    }
    /**
     * 
     * @return Produit
     */
    public Client getClientById(String idClient){
        Client client = null;
        for(Object obj : this.myList){
            Client c = (Client)obj;
            if(c.getID().equals(idClient)){
               client = c;
                break;
            }
        }
        return client;
    }
    /**
     * 
     */
    public synchronized void loadData() {
        try {
            
            
            ResultSet  result = this.dataSource.getAllDataFromTable(this.TABLE_CLIENT);
            ResultSetMetaData resultMeta = result.getMetaData();
            
            colCount = resultMeta.getColumnCount();
            headers = new String[colCount];
            for (int h = 1; h <= colCount; h++) {
                headers[h - 1] = resultMeta.getColumnName(h).toUpperCase();
            }
            
            while(result.next()){
                   
                        String id = result.getString("iduser");
                        String nom = result.getString("nom");
                        String prenom = result.getString("prenom");
                        int fidelite = result.getInt("fidelite");
                        Client c = new Client(id,nom,prenom,fidelite,this.dataSource);
                        c.loadFacture(this.dataSource);
                        add(c);
                        
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
    @Override
    public Object getElementAt(int i) {
        return new KeyValue(((String[]) this.TableList.elementAt(i))[2]+ " " + ((String[]) this.TableList.elementAt(i))[3],((String[]) this.TableList.elementAt(i))[0]);
    }
    

    
}