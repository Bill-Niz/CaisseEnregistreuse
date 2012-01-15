/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CaisseFrame.java
 *
 * Created on 21 nov. 2011, 09:04:02
 */
package View;

import Controller.CallBackEvent;
import Controller.DataChangeEvent;
import Controller.DataChangeListener;
import Model.Client;
import Model.ClientRepository;
import Model.DataModel;
import Model.Facture;
import Model.FactureRepository;
import Model.KeyValue;
import Model.Panier;
import Model.Produit;
import Model.ProduitRepository;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author kmeleon
 */
public class CaisseFrame extends javax.swing.JFrame implements CallBackEvent{

    /** Creates new form CaisseFrame */
    public CaisseFrame() {
        this.dataModel = new DataModel();
        this.iniData();
        initComponents();
        
        this.factureRep.addMyEventListener(new DataChangeListener() {
            @Override
            public void dataChanged(DataChangeEvent evt) {
                facturDataChanged(evt);
            }

            @Override
            public void dataChanged(DataChangeEvent evt, Object data) {
                facturDataChanged(evt,data);
            }
        });
        this.changeEnable(false);
        this.setVisible(true);
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneCaisse = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePanier = new javax.swing.JTable();
        buttonValider = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelSousTotal = new javax.swing.JLabel();
        labelRemise = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        buttonAnnuler = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableFacture = new javax.swing.JTable();
        panelProduit = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        comboBoxProduit = new javax.swing.JComboBox();
        spinnerQuantite = new javax.swing.JSpinner();
        buttonAjouter = new javax.swing.JButton();
        labelPrix = new javax.swing.JLabel();
        labelPrixUni = new javax.swing.JLabel();
        panelClient = new javax.swing.JTabbedPane();
        cliPanel = new javax.swing.JPanel();
        comboBoxUser = new javax.swing.JComboBox();
        buttonChoisir = new javax.swing.JButton();
        buttonAjouterClient = new javax.swing.JButton();
        panelUserInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelFid = new javax.swing.JLabel();
        labelUserName = new javax.swing.JLabel();
        labelUserPrenom = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        paneCaisse.setEnabled(false);
        paneCaisse.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                paneCaisseStateChanged(evt);
            }
        });

        tablePanier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Articles", "Quantité", "Prix", "Total"
            }
        ));
        jScrollPane1.setViewportView(tablePanier);

        buttonValider.setText("Valider");
        buttonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValiderActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 13));
        jLabel3.setText("Sous-Total :");

        jLabel4.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 13));
        jLabel4.setText("Remise :");

        labelSousTotal.setFont(new java.awt.Font("OCR A Std", 1, 13));
        labelSousTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSousTotal.setText("0.0 €");

        labelRemise.setFont(new java.awt.Font("OCR A Std", 1, 13));
        labelRemise.setForeground(new java.awt.Color(0, 153, 0));
        labelRemise.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelRemise.setText("- 0 %");

        jLabel7.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 13));
        jLabel7.setText("Total:");

        labelTotal.setBackground(java.awt.Color.lightGray);
        labelTotal.setFont(new java.awt.Font("OCR A Std", 1, 14));
        labelTotal.setForeground(java.awt.Color.red);
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotal.setText("0.0 €");

        buttonAnnuler.setText("Annuler");
        buttonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnnulerActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(546, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7))
                .add(79, 79, 79)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(labelSousTotal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .add(labelRemise, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(labelTotal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(670, 670, 670)
                .add(buttonAnnuler)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(buttonValider))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 158, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelSousTotal)
                    .add(jLabel3))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelRemise)
                    .add(jLabel4))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelTotal)
                    .add(jLabel7))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(buttonValider)
                    .add(buttonAnnuler))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        paneCaisse.addTab("Panier", jPanel1);

        tableFacture.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableFacture);

        paneCaisse.addTab("Factures", jScrollPane2);

        panelProduit.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(239, 239, 239));

        comboBoxProduit.setModel(this.produitRep);
        comboBoxProduit.setSelectedIndex(-1);
        comboBoxProduit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxProduitItemStateChanged(evt);
            }
        });

        spinnerQuantite.setBorder(new javax.swing.border.MatteBorder(null));
        spinnerQuantite.setValue(1);
        spinnerQuantite.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerQuantiteStateChanged(evt);
            }
        });

        buttonAjouter.setText("Ajouter");
        buttonAjouter.setEnabled(false);
        buttonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAjouterActionPerformed(evt);
            }
        });

        labelPrix.setBackground(new java.awt.Color(255, 51, 51));
        labelPrix.setFont(new java.awt.Font("OCR A Std", 1, 13));
        labelPrix.setForeground(new java.awt.Color(51, 51, 255));
        labelPrix.setText("0.0 €");

        labelPrixUni.setFont(new java.awt.Font("OCR A Std", 1, 13));
        labelPrixUni.setText("0.0 €");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(comboBoxProduit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 248, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(37, 37, 37)
                .add(labelPrixUni, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .add(119, 119, 119)
                .add(spinnerQuantite, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(41, 41, 41)
                .add(labelPrix, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(27, 27, 27)
                .add(buttonAjouter)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(spinnerQuantite, 0, 0, Short.MAX_VALUE)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(comboBoxProduit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(labelPrixUni))
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(buttonAjouter)
                        .add(labelPrix, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        panelProduit.addTab("Produits", jPanel2);

        comboBoxUser.setModel(this.clientRep);
        comboBoxUser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxUserItemStateChanged(evt);
            }
        });

        buttonChoisir.setText("Choisir");
        buttonChoisir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChoisirActionPerformed(evt);
            }
        });

        buttonAjouterClient.setText("+");
        buttonAjouterClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAjouterClientActionPerformed(evt);
            }
        });

        panelUserInfo.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14));
        jLabel1.setText("Nom :");

        jLabel2.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14));
        jLabel2.setText("Prénom :");

        jLabel5.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14));
        jLabel5.setText("Fidélité");

        labelFid.setFont(new java.awt.Font("OCR A Std", 1, 24));
        labelFid.setForeground(new java.awt.Color(255, 0, 0));
        labelFid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFid.setText("0");

        org.jdesktop.layout.GroupLayout panelUserInfoLayout = new org.jdesktop.layout.GroupLayout(panelUserInfo);
        panelUserInfo.setLayout(panelUserInfoLayout);
        panelUserInfoLayout.setHorizontalGroup(
            panelUserInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelUserInfoLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelUserInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelUserInfoLayout.createSequentialGroup()
                        .add(panelUserInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(panelUserInfoLayout.createSequentialGroup()
                                .add(jLabel2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(panelUserInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(labelUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(labelUserPrenom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 153, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(labelFid, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, panelUserInfoLayout.createSequentialGroup()
                        .add(jLabel5)
                        .add(99, 99, 99))))
        );
        panelUserInfoLayout.setVerticalGroup(
            panelUserInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelUserInfoLayout.createSequentialGroup()
                .add(jLabel5)
                .add(3, 3, 3)
                .add(panelUserInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, labelFid, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, panelUserInfoLayout.createSequentialGroup()
                        .add(panelUserInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(labelUserName))
                        .add(18, 18, 18)
                        .add(panelUserInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(labelUserPrenom))))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout cliPanelLayout = new org.jdesktop.layout.GroupLayout(cliPanel);
        cliPanel.setLayout(cliPanelLayout);
        cliPanelLayout.setHorizontalGroup(
            cliPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cliPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(cliPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(buttonChoisir)
                    .add(comboBoxUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 238, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(buttonAjouterClient)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 14, Short.MAX_VALUE)
                .add(panelUserInfo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        cliPanelLayout.setVerticalGroup(
            cliPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cliPanelLayout.createSequentialGroup()
                .add(cliPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(cliPanelLayout.createSequentialGroup()
                        .add(41, 41, 41)
                        .add(cliPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(comboBoxUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(buttonAjouterClient))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buttonChoisir))
                    .add(panelUserInfo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelClient.addTab("Clients", cliPanel);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, paneCaisse, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, panelProduit, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                    .add(panelClient, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(panelClient, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(panelProduit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(2, 2, 2)
                .add(paneCaisse, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .add(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxProduitItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxProduitItemStateChanged
        
        JComboBox cb = (JComboBox)evt.getSource();

        // Get the affected item
        Object item = evt.getItem();

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String value = ((KeyValue) cb.getSelectedItem()).getValue();
            Produit p = this.produitRep.getProduitById(value);
            this.labelPrixUni.setText(p.getPrix()+" €");
            SpinnerModel sm = new SpinnerNumberModel(1, 1, p.getStock(), 1);
            
            updatePrix();
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            // Item is no longer selected
        }
    }//GEN-LAST:event_comboBoxProduitItemStateChanged

    private void comboBoxUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxUserItemStateChanged
        
        JComboBox cb = (JComboBox)evt.getSource();

        // Get the affected item
        Object item = evt.getItem();

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String value = ((KeyValue) cb.getSelectedItem()).getValue();
            System.out.println(value);
            Client c = this.clientRep.getClientById(value);
            this.labelUserName.setText(c.getNom());
            this.labelUserPrenom.setText(c.getPrenom());
            this.labelFid.setText(c.getFidelite()+"");
            
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            // Item is no longer selected
        }
    }//GEN-LAST:event_comboBoxUserItemStateChanged

    private void spinnerQuantiteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerQuantiteStateChanged
        
        this.updatePrix();
    }//GEN-LAST:event_spinnerQuantiteStateChanged
/**
     * 
     * @param evt 
     */
    private void buttonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAjouterActionPerformed
        if(this.comboBoxProduit.getSelectedItem() != null){
        String value = ((KeyValue) this.comboBoxProduit.getSelectedItem()).getValue();
        Produit p = this.produitRep.getProduitById(value);
        int quantite = Integer.valueOf(this.spinnerQuantite.getModel().getValue().toString());
        p.setQuantiteAchete(quantite);
        
        this.client.getPanier().add(this.produitRep.getProduitById(value));
        this.labelSousTotal.setText(client.getPanier().getPrixTotal()+" €");
        float prixtt = client.getPanier().getPrixTotal();
        if(this.client.getFidelite() != 0 && this.client.getFidelite()%10 == 0){
            prixtt = prixtt - ((prixtt*10)/100);
        }
        this.labelTotal.setText(prixtt + " €");
        }
        if(!this.buttonValider.isEnabled()){this.buttonValider.setEnabled(true);
        }
    }//GEN-LAST:event_buttonAjouterActionPerformed
/**
     * 
     * @param evt 
     */
    private void buttonChoisirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChoisirActionPerformed
        int index = this.comboBoxUser.getSelectedIndex();
        if(index>-1){
            String value = ((KeyValue) this.comboBoxUser.getSelectedItem()).getValue();
            this.client = this.clientRep.getClientById(value);
            this.changeEnable(true);
            this.changeClientEnable(false);
            this.tablePanier.setModel(this.client.getPanier());
            if(this.client.getFidelite() !=0 && this.client.getFidelite()%10 == 0){this.labelRemise.setText("-"+10+" %");
            }
        }
    }//GEN-LAST:event_buttonChoisirActionPerformed
    /**
     * 
     * @param evt 
     */
    private void buttonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValiderActionPerformed
       if(this.client.getPanier().getListProduit().getPrixTotal() != 0){
           this.changeEnable(false);
           this.changeClientEnable(true);
           this.validerPanier();
       }
       
    }//GEN-LAST:event_buttonValiderActionPerformed
    /**
     * 
     * @param evt 
     */
    private void paneCaisseStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_paneCaisseStateChanged
        JTabbedPane pane = (JTabbedPane) evt.getSource();
        switch(pane.getSelectedIndex()){
            case 0 :
                break;
                
            case 1 : loadFacture();
                break;
            default:
        }

    }//GEN-LAST:event_paneCaisseStateChanged
    /**
     * 
     * @param evt 
     */
    private void buttonAjouterClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAjouterClientActionPerformed
        new AddClientFrame(this);
        
    }//GEN-LAST:event_buttonAjouterClientActionPerformed

    private void buttonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnnulerActionPerformed
        this.changeEnable(false);
        this.changeClientEnable(true);
        this.clearPanierPane();
        this.client.getPanier().cleanData();
        this.client = null;
        this.produitRep = null;
        this.clientRep = null;
        this.factureRep = null;
        this.tablePanier.clearSelection();  
        
        
        this.iniData();
    }//GEN-LAST:event_buttonAnnulerActionPerformed
    /**
     * 
     */
    private void updatePrix(){
        int quantite = Integer.valueOf(this.spinnerQuantite.getModel().getValue().toString());
        float prixUn = Float.valueOf(this.labelPrixUni.getText().substring(0, this.labelPrixUni.getText().length()-2));
        float prixtt = quantite * prixUn;
        
        this.labelPrix.setText(prixtt+" €");
    
    }
    /**
     * 
     * @param bool 
     */
    private void changeClientEnable(boolean bool){
        for( Component c : this.cliPanel.getComponents()){
            c.setEnabled(bool);
        }
        this.cliPanel.setEnabled(bool);
    }
    /**
     * 
     * @param bool 
     */
    private void changeEnable(boolean bool){
        for( Component c : this.jPanel2.getComponents()){
            c.setEnabled(bool);
        }
        for( Component c : this.jPanel1.getComponents()){
            c.setEnabled(bool);
        }
        this.paneCaisse.setEnabled(bool);
        this.panelProduit.setEnabled(bool);
    }
    /**
     * 
     */
    public void validerPanier(){
       /** Panier panier = this.client.getPanier();
        String reference = "";
        Facture fact = new Facture(reference, new Date(), 0  ,panier.getListProduit());
        this.factureRep.add(fact);
        this.client.getListFacture().add(fact);*/
        int fid = 0;
        
        if(this.client.getFidelite()%10 == 0){fid=10;}
        
        this.client.getPanier().validerPanier(this.factureRep,this.client.getID(), fid);
        /*this.factureRep.loadData();
        this.clientRep.loadData();
        this.comboBoxUser.repaint();*/
        
        
        this.clearPanierPane();
        this.client.getPanier().cleanData();
        this.client = null;
        this.produitRep = null;
        this.clientRep = null;
        this.factureRep = null;
        this.tablePanier.clearSelection();  
        
        
        this.iniData();
        
    }
    /**
     * 
     */
    private void clearPanierPane(){
        this.labelPrixUni.setText("O.O €");
        this.labelPrix.setText("O.O €");
        this.labelSousTotal.setText("O.O €");
        this.labelTotal.setText("O.O €");
        this.comboBoxProduit.setSelectedIndex(-1);
        //spinnerQuantite.setValue(1);
        
    }
    /**
     * 
     */
    @SuppressWarnings("UseOfObsoleteCollectionType")
    private void loadFacture() {
        this.tableFacture.clearSelection();
        this.tableFacture.setModel(this.client.getListFacture());
    }
    /**
     * 
     * @param evt 
     */
     private void facturDataChanged(DataChangeEvent evt) {
               /** System.out.println("Changed!!!");
                FactureRepository f = (FactureRepository) evt.getSource();
                System.out.println(f.toString());*/
                
            }
     /**
      * 
      * @param evt
      * @param data 
      */
     private void facturDataChanged(DataChangeEvent evt, Object data) {
         Facture f = (Facture)data;
         System.out.println(f.toString());
         Vector v = this.client.getListFacture().getTableList();
         String[] record = new String[v.size()];
         
     }
     /**
      * 
      */
     private void iniData(){
       
        
        this.clientRep = new ClientRepository(this.dataModel);
        this.produitRep = new ProduitRepository(this.dataModel);
        this.factureRep = new FactureRepository(this.dataModel);
        this.produitRep.loadData();
        this.factureRep.loadData();
        
        
     }
    /**
     * 
     */
    private ClientRepository clientRep;
    private ProduitRepository produitRep;
    private FactureRepository factureRep;
    private DataModel dataModel;
    private Client client;
   
    
    //My Custom attributs
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAjouter;
    private javax.swing.JButton buttonAjouterClient;
    private javax.swing.JButton buttonAnnuler;
    private javax.swing.JButton buttonChoisir;
    private javax.swing.JButton buttonValider;
    private javax.swing.JPanel cliPanel;
    private javax.swing.JComboBox comboBoxProduit;
    private javax.swing.JComboBox comboBoxUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelFid;
    private javax.swing.JLabel labelPrix;
    private javax.swing.JLabel labelPrixUni;
    private javax.swing.JLabel labelRemise;
    private javax.swing.JLabel labelSousTotal;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JLabel labelUserPrenom;
    private javax.swing.JTabbedPane paneCaisse;
    private javax.swing.JTabbedPane panelClient;
    private javax.swing.JTabbedPane panelProduit;
    private javax.swing.JPanel panelUserInfo;
    private javax.swing.JSpinner spinnerQuantite;
    private javax.swing.JTable tableFacture;
    private javax.swing.JTable tablePanier;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dataAddedToDb() {
        this.clientRep = null;
        this.clientRep = new ClientRepository(this.dataModel);
        this.iniData();
    }

    
}
