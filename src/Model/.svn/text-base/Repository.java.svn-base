package Model;

import Controller.DataChangeEvent;
import Controller.DataChangeListener;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

public  class Repository extends AbstractTableModel implements ComboBoxModel {
   protected Vector myList;
   protected Vector TableList;
   protected String[] headers;
   protected Object selection = null;
   protected int colCount;
   protected javax.swing.event.EventListenerList listenerList;
   protected DataModel dataSource = new DataModel();

   /*
    * 
    */
   
    public Repository() {
        this.myList = new Vector();
        this.listenerList = new javax.swing.event.EventListenerList();
        this.TableList = new Vector();
        
        
    }
    
   /**
    * 
    * @param listener 
    */
    public void addMyEventListener(DataChangeListener listener) {
        listenerList.add(DataChangeListener.class, listener);
    }

    /**
     * 
     * @param listener 
     */
    public void removeMyEventListener(DataChangeListener listener) {
        listenerList.remove(DataChangeListener.class, listener);
    }
    
    /**
     * 
     * @param evt 
     */
    void notifyChangeEvent(DataChangeEvent evt, Object data) {
        Object[] listeners = listenerList.getListenerList();
        
        for (int i=0; i<listeners.length; i+=2) {
            if (listeners[i]==DataChangeListener.class) {
                ((DataChangeListener)listeners[i+1]).dataChanged(evt,data);
            }
        }
    }
    /**
     * 
     * @return My List
     */
    public Vector getMyList(){
        return this .myList;
    }
    /**
     * 
     * @param obj 
     */
    public void add(Object obj){
        this.myList.add(obj);
        this.notifyChangeEvent(new DataChangeEvent(this),obj);
    }

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }
    
    /**
     * 
     * @param obj 
     */
    public void remove(Object obj){
        this.myList.remove(obj);
         this.notifyChangeEvent(new DataChangeEvent(this),obj);
    }

    public Vector getTableList() {
        return TableList;
    }

    public void setTableList(Vector TableList) {
        this.TableList = TableList;
    }
    
    /**
     * 
     * @return Number of elements in the repository
     */
    public int getCount(){
        return this.myList.size();
    }

    public DataModel getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataModel dataSource) {
        this.dataSource = dataSource;
    }
    
    /**
     * 
     *  IMPLEMENTATION FOR TABLE MODEL
     * 
     * 
     */
    
    
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
        return this.colCount;
    }

    @Override
    public Object getValueAt(int row, int col) {
       return ((String[]) this.TableList.elementAt(row))[col];
        
    }
    
    
    
    
    public Produit getProduitAt(int index) {
       return (Produit) this.TableList.get(index);
        
    }
    
    

    /**
     * 
     *  IMPLEMENTATION FOR COMBOBOX MODEL
     * 
     * 
     */
    
    /**
     * 
     * @param o 
     */
    @Override
    public void setSelectedItem(Object o) {
       selection =  o;
    }

    @Override
    public Object getSelectedItem() {
       return selection;
    }

    @Override
    public int getSize() {
        return this.TableList.size();
    }

    @Override
    public Object getElementAt(int i) {
        return new KeyValue(((String[]) this.TableList.elementAt(i))[1],((String[]) this.TableList.elementAt(i))[0]);
    }

    @Override
    public void addListDataListener(ListDataListener ll) {
         listenerList.add(ListDataListener.class, ll);
    }

    @Override
    public void removeListDataListener(ListDataListener ll) {
        listenerList.remove(ListDataListener.class, ll);
    }
    
    
}