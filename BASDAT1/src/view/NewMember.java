/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import aksesdata.AksesDataMember;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelMember;

/**
 *
 * @author Alexander Pratama
 */
public class NewMember extends javax.swing.JFrame {

    private final int idKasir;
    private final AksesDataMember aksesDataMember;

    /**
     * Creates new form NewMember
     */
    public NewMember(int idKasir) throws SQLException {
        initComponents();
        this.idKasir = idKasir;
        this.aksesDataMember = new AksesDataMember();
        this.setTextIdMember();
        this.tabelMember.setModel(this.viewTabel());
        this.setVisible(true);
    }

    private void setTextIdMember() throws SQLException {
        this.textidmem.setEditable(false);
        this.textidmem.setEnabled(false);
        int idMemberOtomatis = this.aksesDataMember.getSequenceIdMember();
        this.textidmem.setText(String.valueOf(idMemberOtomatis));
    }

    private boolean cekSemuaTextKosong() {
        return this.textidmem.getText().isEmpty() 
                || this.textnamamem.getText().isEmpty()
                || this.textnotelpmem.getText().isEmpty();
    }

    public DefaultTableModel viewTabel() throws SQLException {
        DefaultTableModel dtmMember = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtmMember.addColumn("ID Member");
        dtmMember.addColumn("Nama Member");
        dtmMember.addColumn("No Telp Member");

        ArrayList<ModelMember> daftarDataMember = this.aksesDataMember.read();
        for (int i = 0; i < daftarDataMember.size(); i++) {
            Object[] temp = new Object[3];
            temp[0] = daftarDataMember.get(i).getIdMember();
            temp[1] = daftarDataMember.get(i).getNamaMember();
            temp[2] = daftarDataMember.get(i).getNoTelpMember();
            dtmMember.addRow(temp);
        }

        return dtmMember;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labeljudulmem = new javax.swing.JLabel();
        labelidmem = new javax.swing.JLabel();
        labelnamamem = new javax.swing.JLabel();
        labelnotelpmem = new javax.swing.JLabel();
        textidmem = new javax.swing.JTextField();
        textnamamem = new javax.swing.JTextField();
        textnotelpmem = new javax.swing.JTextField();
        buttoninsertmem = new javax.swing.JButton();
        buttonbackmem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMember = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labeljudulmem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labeljudulmem.setText("Registrasi Member");

        labelidmem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelidmem.setText("ID Member");

        labelnamamem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnamamem.setText("Nama Member");

        labelnotelpmem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnotelpmem.setText("No Telp Member");

        buttoninsertmem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttoninsertmem.setText("Insert");
        buttoninsertmem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttoninsertmemActionPerformed(evt);
            }
        });

        buttonbackmem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonbackmem.setText("Back");
        buttonbackmem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonbackmemActionPerformed(evt);
            }
        });

        tabelMember.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelMember);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(labeljudulmem, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelidmem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelnamamem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(labelnotelpmem)
                            .addComponent(buttoninsertmem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textnamamem, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                .addComponent(textidmem)
                                .addComponent(textnotelpmem))
                            .addComponent(buttonbackmem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labeljudulmem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelidmem)
                            .addComponent(textidmem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelnamamem)
                            .addComponent(textnamamem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelnotelpmem)
                            .addComponent(textnotelpmem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttoninsertmem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonbackmem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonbackmemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonbackmemActionPerformed
        Menu menu = new Menu(this.idKasir);
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buttonbackmemActionPerformed

    private void buttoninsertmemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttoninsertmemActionPerformed
        if (cekSemuaTextKosong()) {
            JOptionPane.showMessageDialog(null, "Isi semua data terlebih dahulu");
        } else {
            try {
                String namaMember = this.textnamamem.getText();
                int noTelpMember = Integer.parseInt(this.textnotelpmem.getText());

                this.aksesDataMember.create(namaMember, noTelpMember);
                this.setTextIdMember();
                this.tabelMember.setModel(this.viewTabel());
                JOptionPane.showMessageDialog(null, "Data berhasil diinsert");
            } catch (SQLException ex) {
                Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttoninsertmemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonbackmem;
    private javax.swing.JButton buttoninsertmem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelidmem;
    private javax.swing.JLabel labeljudulmem;
    private javax.swing.JLabel labelnamamem;
    private javax.swing.JLabel labelnotelpmem;
    private javax.swing.JTable tabelMember;
    private javax.swing.JTextField textidmem;
    private javax.swing.JTextField textnamamem;
    private javax.swing.JTextField textnotelpmem;
    // End of variables declaration//GEN-END:variables
}