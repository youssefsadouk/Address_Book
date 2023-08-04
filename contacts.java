
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class contacts extends javax.swing.JFrame {
    String filename = null;
    byte[] photo_contact = null;
    public contacts() {
        initComponents();
        afficher_contacts();
    }

    public ArrayList<Contact> contact_list(){
    ArrayList<Contact> contacts_list = new ArrayList<>();
    try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/carnetadresses","root","");
             String query = "Select * from contacts";
             java.sql.Statement st = con.createStatement();
             ResultSet  rs = st.executeQuery(query);
             Contact contact;
             while (rs.next()){
                contact = new Contact(rs.getInt("id"), rs.getString("telephone"), rs.getString("nom"), rs.getString("prenom"),rs.getString("mail"),rs.getString("adresse"), rs.getBytes("photo"));
                contacts_list.add(contact);
             }
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e );
         } 
    return contacts_list;
    }
    
    public void afficher_contacts(){
        ArrayList<Contact> contacts = contact_list();
        DefaultTableModel model = (DefaultTableModel)jTable1_afficher_contacts.getModel();
        Object[] row = new Object[6];
        
        for (int i=0; i<contacts.size(); i++){
            row[0] = contacts.get(i).getId();
            row[1] = contacts.get(i).getNom();
            row[2] = contacts.get(i).getPrenom();
            row[3] = contacts.get(i).getTel();
            row[4] = contacts.get(i).getMail();
            row[5] = contacts.get(i).getAdresse();
            model.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        prenom = new javax.swing.JTextField();
        telephone = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        adresse = new javax.swing.JTextField();
        EnregistrerBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_afficher_contacts = new javax.swing.JTable();
        modifierBtn = new javax.swing.JButton();
        SupprimerBtn = new javax.swing.JButton();
        lbl_photo = new javax.swing.JLabel();
        photo_upload_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nom");

        jLabel2.setText("Prenom");

        jLabel3.setText("Telephone");

        jLabel4.setText("Mail");

        jLabel5.setText("Adresse");

        prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomActionPerformed(evt);
            }
        });

        telephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneActionPerformed(evt);
            }
        });

        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });

        adresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adresseActionPerformed(evt);
            }
        });

        EnregistrerBtn.setText("Enregistrer");
        EnregistrerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnregistrerBtnActionPerformed(evt);
            }
        });

        jTable1_afficher_contacts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nom", "prenom", "telephone", "mail", "adresse"
            }
        ));
        jTable1_afficher_contacts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_afficher_contactsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_afficher_contacts);

        modifierBtn.setText("Modifier");
        modifierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierBtnActionPerformed(evt);
            }
        });

        SupprimerBtn.setText("Supprimer");
        SupprimerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerBtnActionPerformed(evt);
            }
        });

        photo_upload_btn.setText("Choisir une photo");
        photo_upload_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photo_upload_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mail)
                            .addComponent(adresse, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(prenom)
                            .addComponent(telephone)
                            .addComponent(nom))
                        .addGap(70, 70, 70))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(EnregistrerBtn)
                        .addGap(32, 32, 32)
                        .addComponent(modifierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(SupprimerBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(lbl_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(photo_upload_btn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(EnregistrerBtn)
                                    .addComponent(modifierBtn)
                                    .addComponent(SupprimerBtn))
                                .addGap(50, 50, 50))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(29, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(photo_upload_btn)
                        .addGap(97, 97, 97))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomActionPerformed

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailActionPerformed

    private void adresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adresseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adresseActionPerformed

    private void telephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneActionPerformed

    private void EnregistrerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnregistrerBtnActionPerformed
        try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/carnetadresses","root","");
             PreparedStatement pre_statement = con.prepareStatement("insert into contacts(nom, prenom, telephone, mail, adresse, photo) values(?,?,?,?,?,?)");
             pre_statement.setString(1, nom.getText());
             pre_statement.setString(2, prenom.getText());
             pre_statement.setString(3, telephone.getText());
             pre_statement.setString(4, mail.getText());
             pre_statement.setString(5, adresse.getText());
             pre_statement.setBytes(6, photo_contact);
             
             pre_statement.executeUpdate();
             
             JOptionPane.showMessageDialog(null,"Le contact a été enregistré avec succés" );
             
             nom.setText("");
             prenom.setText("");
             telephone.setText("");
             mail.setText("");
             adresse.setText("");
             
             DefaultTableModel model = (DefaultTableModel)jTable1_afficher_contacts.getModel();
             model.setRowCount(0);
             afficher_contacts();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e );
         }          
    }//GEN-LAST:event_EnregistrerBtnActionPerformed

    private void jTable1_afficher_contactsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_afficher_contactsMouseClicked
        int idx = jTable1_afficher_contacts.getSelectedRow();
        TableModel model = jTable1_afficher_contacts.getModel();
        nom.setText(model.getValueAt(idx, 1).toString());
        prenom.setText(model.getValueAt(idx, 2).toString());
        telephone.setText(model.getValueAt(idx, 3).toString());
        mail.setText(model.getValueAt(idx, 4).toString());
        adresse.setText(model.getValueAt(idx, 5).toString());
        
        byte[] img = contact_list().get(idx).getPhoto();
        ImageIcon image = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lbl_photo.getWidth(), lbl_photo.getHeight(), Image.SCALE_SMOOTH));
        lbl_photo.setIcon(image);

    }//GEN-LAST:event_jTable1_afficher_contactsMouseClicked

    private void modifierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierBtnActionPerformed
        try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/carnetadresses","root","");
             int row = jTable1_afficher_contacts.getSelectedRow();
             String id = jTable1_afficher_contacts.getModel().getValueAt(row, 0).toString();
             PreparedStatement pst = con.prepareStatement("update contacts set nom = ?, prenom = ?, telephone = ?, mail = ?, adresse = ? where id ="+ id);
             
             pst.setString(1, nom.getText());
             pst.setString(2, prenom.getText());
             pst.setString(3, telephone.getText());
             pst.setString(4, mail.getText());
             pst.setString(5, adresse.getText());
             
             pst.executeUpdate();
             
             JOptionPane.showMessageDialog(null,"Le contact est modifié avec succés" );
             
             nom.setText("");
             prenom.setText("");
             telephone.setText("");
             mail.setText("");
             adresse.setText("");
             
             DefaultTableModel model = (DefaultTableModel)jTable1_afficher_contacts.getModel();
             model.setRowCount(0);
             afficher_contacts();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e );
         } 
    }//GEN-LAST:event_modifierBtnActionPerformed

    private void SupprimerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerBtnActionPerformed
        try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/carnetadresses","root","");
             int row = jTable1_afficher_contacts.getSelectedRow();
             String id = jTable1_afficher_contacts.getModel().getValueAt(row, 0).toString();
             PreparedStatement pst = con.prepareStatement("delete from contacts where id ="+ id);
             pst.executeUpdate();
             
             
             
             nom.setText("");
             prenom.setText("");
             telephone.setText("");
             mail.setText("");
             adresse.setText("");
             
             DefaultTableModel model = (DefaultTableModel)jTable1_afficher_contacts.getModel();
             model.setRowCount(0);
             afficher_contacts();
             
             JOptionPane.showMessageDialog(null,"Le contact est supprimé avec succés" );
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e );
         } 
    }//GEN-LAST:event_SupprimerBtnActionPerformed

    private void photo_upload_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photo_upload_btnActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File fichier = chooser.getSelectedFile();
        filename = fichier.getAbsolutePath();
        ImageIcon image = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lbl_photo.getWidth(), lbl_photo.getHeight(), Image.SCALE_SMOOTH));
        lbl_photo.setIcon(image);
        try{
            File photo = new File(filename);
            FileInputStream fis = new FileInputStream(photo);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024*10];
            for(int readNum;(readNum=fis.read(buf))!=-1;){
                bos.write(buf, 0, readNum);
            }
            photo_contact = bos.toByteArray();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e );
         }
    }//GEN-LAST:event_photo_upload_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(contacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(contacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(contacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(contacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new contacts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EnregistrerBtn;
    private javax.swing.JButton SupprimerBtn;
    private javax.swing.JTextField adresse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_afficher_contacts;
    private javax.swing.JLabel lbl_photo;
    private javax.swing.JTextField mail;
    private javax.swing.JButton modifierBtn;
    private javax.swing.JTextField nom;
    private javax.swing.JButton photo_upload_btn;
    private javax.swing.JTextField prenom;
    private javax.swing.JTextField telephone;
    // End of variables declaration//GEN-END:variables
}
