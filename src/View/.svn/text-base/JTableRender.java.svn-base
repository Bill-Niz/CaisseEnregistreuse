/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author kmeleon
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Définir l'affichage dans un JTable
 * @author Fobec 2010
 */
public class JTableRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        /**
         * Fixer la couleur de fond de la première colonne en jaune
         */
        
        
        if (column == 0) {
            Color clr = new Color(255, 255, 240);
            component.setBackground(clr);
        } else {
            Color clr = new Color(255, 255, 255);
            component.setBackground(clr);
        }
        /**
         * Colorier les cellules en orange si le montant est négatif
         */
        
        if(isSelected){component.setBackground(new Color(89,187,46));}
        
        Object oR = table.getValueAt(row, 6);
        String  p = (String)oR;
        if(Integer.valueOf(p) <5){
        component.setBackground(new Color(255,189,23));}
        if(Integer.valueOf(p) ==0){
        component.setBackground(new Color(255,0,0));}
        
        return component;
    }
}