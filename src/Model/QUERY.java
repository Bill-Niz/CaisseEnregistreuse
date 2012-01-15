/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author kmeleon
 */
final public class QUERY {
    final static String LIST_FACTURE_PRODUIT = "SELECT listeproduitfacture.produit_idproduit,produit.titre,listeproduitfacture.quantite,listeproduitfacture.prix FROM caisse.listeproduitfacture INNER JOIN facture on listeproduitfacture.facture_idfacture = facture.idfacture INNER JOIN produit on listeproduitfacture.produit_idproduit = produit.idproduit WHERE facture_idfacture = ";
    
    final static String FACTURE_FROM_USER = "SELECT facture.idfacture as Reference,facture.remise,facture.date FROM caisse.`facture` WHERE `user_iduser` = ";
    
    final static String LIST_PRODUIT = "SELECT produit.*,marque.nom AS marque FROM caisse.`produit` INNER JOIN marque ON produit.marque_idmarque = marque.idmarque";
    
    final static String PREPARED_STATEMENT_ADD_FACTURE = "INSERT INTO facture (idfacture ,user_iduser ,remise,date)VALUES (NULL ,?,?,NOW())";
    
    
    final static String PREPARED_STATEMENT_ADD_LIST = "INSERT INTO  `caisse`.`listeproduitfacture` ("+
								"`idlisteproduitfacture` ,"+
								"`produit_idproduit` ,"+
								"`facture_idfacture` ,"+
								"`facture_user_iduser` ,"+
								"`quantite` ,"+
								"`prix` ,"+
								"`tva`)"+
                                                                "VALUES (NULL ,"+
                                                                "?,"+
                                                                "?,"+
                                                                "?,"+
                                                                "?,"+
                                                                "?,"+
                                                                "21)";
    
    final static String LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";
    
    final static String STOCK_FROM_PRODUIT = "SELECT * FROM caisse.`produit` WHERE `idproduit` = ";
    
    final static String UPDATE_STOCK_FROM_PRODUIT = "UPDATE  `caisse`.`produit` SET  `stock` = ? WHERE  `produit`.`idproduit` = ?";
    
    
    
    final static String FIDELITE_FROM_USER = "SELECT * FROM caisse.`user` WHERE `iduser` = ";
    final static String UPDATE_FIDELITE_FROM_USER = "UPDATE  `caisse`.`user` SET  `fidelite` = ? WHERE  `user`.`iduser` = ?";

    
    final static String ADD_CLIENT = "INSERT INTO  `caisse`.`user` (`iduser` ,`sexe` ,`nom` ,`prenom` ,`fidelite`)"+
                                                           "VALUES (NULL ,"+
                                                                    "?,"+
                                                                    "?,"+
                                                                    "?,"+
                                                                    "0)";

    
    final static String UPDATE_PRODUIT_BY_ID = "UPDATE  `caisse`.`produit` "
            + "SET  `titre` =  ?,"
            + "`description` = ?,"
            + "`prix` = ?, "
            + "`stock` = ? "
            + "WHERE `produit`.`idproduit` = ?";
    
    
    
    
}
