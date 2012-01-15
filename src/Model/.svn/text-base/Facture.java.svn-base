package Model;

import java.io.FileNotFoundException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.File;


public class Facture {

    
  private String reference;
  private Date date;
  public ProduitRepository listProduit;
  private int remise = 0;
  
  
  
  private java.text.SimpleDateFormat DATE_FORMAT = new java.text.SimpleDateFormat("dd-MM-yyyy");
  private java.text.SimpleDateFormat F_DATE_FORMAT = new java.text.SimpleDateFormat("dd/MM/yyyy HH:MM");
  private java.text.SimpleDateFormat SQL_DATE_FORMAT = new java.text.SimpleDateFormat("yyy-MM-dd HH:mm:ss");
  private String DATA_TITLE ="Articles dans votre commande";

  
  
  
  /**
   * 
   * @param reference
   * @param date
   * @param listProduit 
   */
    public Facture(String reference, Date date, int remise ,ProduitRepository listProduit) {
        this.reference = reference;
        this.date = date;
        this.remise = remise;
        this.listProduit = listProduit;
    }
    /**
     * 
     * @param reference
     * @param date 
     */
    public Facture(String reference, Date date, int remise) {
        this.reference = reference;
        this.date = date;
        this.remise = remise;
    }
    
    /**
     * 
     * @param reference
     * @param date
     * @param dataSource 
     */
    public Facture(String reference, Date date, int remise,DataModel dataSource) {
        this.reference = reference;
        this.date = date;
        this.remise = remise;
        this.loadListProduit(dataSource);
        
        
    }
    /**
     * 
     */
    public void loadListProduit(DataModel dataSource){
        this.listProduit = new ProduitRepository(dataSource);
        this.listProduit.loadProduitFromFacture(this.reference);
    }
    
    /**
     * 
     * @param path 
     */
    public void generatePdf(String path){
        String filePath = path+ this.reference+"_" + this.DATE_FORMAT.format(date) +".pdf";
      
        try {
            
            try {
                Document document=new Document();
                
                PdfWriter.getInstance(document,new FileOutputStream(filePath));
                document.open();
               
                Paragraph datePara = new Paragraph(this.F_DATE_FORMAT.format(date));
                Paragraph title = new Paragraph(this.DATA_TITLE);
                LineSeparator line = new LineSeparator();
                line.setLineColor(BaseColor.LIGHT_GRAY);
                datePara.setAlignment(Element.ALIGN_RIGHT);
                
                document.add(datePara);
                document.add(Chunk.NEWLINE);
                 
                document.add(title);
                document.add(Chunk.NEWLINE);
                document.add(line);
              
                document.add(this.generateListProdTable());
                
                //line.setPercentage(80);
                //document.add(line);
                document.add(Chunk.NEWLINE); 
                document.add(generateTotalTable());
                
                
                
                document.close();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Facture.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (DocumentException ex) {
            Logger.getLogger(Facture.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.ShowPDF(filePath);
      
    }
    /**
     * 
     * @return 
     */
    public PdfPTable generateListProdTable(){
     PdfPTable table =new PdfPTable(4);
     table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
     table.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER);
     table.getDefaultCell().setBorderWidthTop(0);
     table.getDefaultCell().setBorderWidthLeft(0);
     table.getDefaultCell().setBorderWidthRight(0);
     table.getDefaultCell().setBorderColorBottom(BaseColor.LIGHT_GRAY);
     
     synchronized(this.listProduit.getMyList()){
     for(Object obj : this.listProduit.getMyList()){
         Produit p = (Produit)obj;
         table.addCell(p.getTitre());
         table.addCell(p.getPrix()+" €");
         table.addCell(p.getQuantiteAchete()+"");
         table.addCell(p.getPrix()*p.getQuantiteAchete()+" €");
     }
     }
     
     return table;
    
    }
    /**
     * 
     * @return 
     */
    private PdfPTable generateTotalTable(){
        PdfPTable table =new PdfPTable(2);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.getDefaultCell().setBorder(0);
        
        table.addCell("Sous-total");      
        table.addCell(this.listProduit.getPrixTotal()+" €");
        table.addCell("Remise");         
        table.addCell("-"+this.remise+" %");         
        table.addCell("Total de la commande");
        float prix = this.listProduit.getPrixTotal();
        prix = prix - ((prix*this.remise)/100);
        table.addCell(prix+" €");
        return table;
    }
    private void ShowPDF(String path){
         try {
 
		File pdfFile = new File(path);
		if (pdfFile.exists()) {
 
			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(pdfFile);
			} else {
				System.out.println("Awt Desktop is not supported!");
			}
 
		} else {
			System.out.println("File is not exists!");
		}
 
		System.out.println("Done");
 
	  } catch (Exception ex) {
		ex.printStackTrace();
	  }
 
	
    }

/**
     * 
     * @return Date
     */
    public Date getDate() {
        return date;
    }
    /**
     * 
     * @return List produit
     */
    public ProduitRepository getListProduit() {
        return listProduit;
    }
/**
     * 
     * @return Reference
     */
    public String getReference() {
        return reference;
    }
    
    /**
     * 
     * @return toString
     */
    @Override
    public String toString() {
        return "Facture{" + "reference=" + reference + ",\n date=" + date.toString() + ",\n listProduit=" + listProduit.toString() + '}';
    }
/**
     * 
     * @return 
     */
    public int getRemise() {
        return remise;
    }
/**
     * 
     * @param remise 
     */
    public void setRemise(int remise) {
        this.remise = remise;
    }
  
  

}