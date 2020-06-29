package view;

import aksesdata.AksesDataKasir;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ModelKasir;

public class Login extends javax.swing.JFrame {

    private final AksesDataKasir aksesDataKasir;

    public Login() {
        initComponents();
        this.setVisible(true);
        this.aksesDataKasir = new AksesDataKasir();
    }

    private boolean cekSemuaTextKosong() {
        return this.textusername.getText().isEmpty() || this.textpassword.getText().isEmpty();
    }

    private boolean validasiDataLogin() throws SQLException {
        boolean loginValid = false;
        ArrayList<ModelKasir> daftarDataKasir = this.aksesDataKasir.getSemuaDataKasir();
        for (int i = 0; i < daftarDataKasir.size(); i++) {
            if (this.textusername.getText().equals(daftarDataKasir.get(i).getNamaKasir()) && this.textpassword.getText().equals(
                            daftarDataKasir.get(i).getPasswordKasir())) {
                loginValid = true;
            }
        }
        return loginValid;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textusername = new javax.swing.JTextField();
        labelusername = new javax.swing.JLabel();
        labelpassword = new javax.swing.JLabel();
        labeljudul = new javax.swing.JLabel();
        buttonlogin = new javax.swing.JButton();
        textpassword = new javax.swing.JPasswordField();
        buttonreset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelusername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelusername.setText("Username");

        labelpassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelpassword.setText("Password");

        labeljudul.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labeljudul.setText("LOGIN KASIR");

        buttonlogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonlogin.setText("Login");
        buttonlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonloginActionPerformed(evt);
            }
        });

        buttonreset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonreset.setText("Reset");
        buttonreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonresetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelusername, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(labelpassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonlogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(buttonreset))
                    .addComponent(textusername)
                    .addComponent(textpassword))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(labeljudul)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labeljudul, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelusername))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelpassword)
                    .addComponent(textpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonlogin)
                    .addComponent(buttonreset))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonloginActionPerformed
        if (cekSemuaTextKosong()) {
            JOptionPane.showMessageDialog(null, "Isi semua data terlebih dahulu");
        } else {
            try {
                if (this.validasiDataLogin()) {
                    int idKasir = this.aksesDataKasir.cariIdKasir(this.textusername.getText());
                    Menu menu = new Menu(idKasir);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Nama atau password salah, silahkan masukkan lagi");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonloginActionPerformed

    private void buttonresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonresetActionPerformed
        textusername.setText(null);
        textpassword.setText(null);
    }//GEN-LAST:event_buttonresetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonlogin;
    private javax.swing.JButton buttonreset;
    private javax.swing.JLabel labeljudul;
    private javax.swing.JLabel labelpassword;
    private javax.swing.JLabel labelusername;
    private javax.swing.JPasswordField textpassword;
    private javax.swing.JTextField textusername;
    // End of variables declaration//GEN-END:variables
}
