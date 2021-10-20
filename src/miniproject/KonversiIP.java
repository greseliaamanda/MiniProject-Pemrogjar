/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Aspire
 */
public class KonversiIP extends javax.swing.JFrame {

    /**
     * Creates new form KonversiIP
     */
    public KonversiIP() {
        initComponents();
        //membuat layout tampil di tengah pada saat di tampilkan
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
                (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }

    public boolean isValidIPAddress(String ip) {
        try {
            if (ip == null || ip.isEmpty()) {
                return false;
            }

            String[] parts = ip.split("\\.");
            if (parts.length != 4) {
                return false;
            }

            for (String s : parts) {
                int i = Integer.parseInt(s);
                if ((i < 0) || (i > 255)) {
                    return false;
                }
            }
            if (ip.endsWith(".")) {
                return false;
            }

            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public int hostID(int cidr) {
        int totalhostID = 32 - cidr;
        return (int) Math.pow(2, totalhostID);
    }

    public void findIP(String ip, int cidr) {

        boolean cekString = false;
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) >= '0' && ip.charAt(i) <= '9') {
                cekString = true;
            } else {
                cekString = false;
            }
        }
        if (cekString == true) {
            int index = ip.indexOf('.');

            String ipsub = ip.substring(0, index);
            int ipadd = Integer.parseInt(ipsub);

            if (isValidIPAddress(ip) == false) {
                JOptionPane.showMessageDialog(null, "Format alamat IP tidak sesuai", "Informasi Kelas IP", JOptionPane.ERROR_MESSAGE);
            } else {
                String split_ip[] = ip.split("\\.");
                String split_bip[] = new String[4];
                String bip = "";
                for (int i = 0; i < 4; i++) {
                    split_bip[i] = appendZeros(Integer.toBinaryString(Integer.parseInt(split_ip[i])));
                    bip += split_bip[i];
                }

                txtHasil.append("Segmen: " + cidr + "\n");
                txtHasil.append("Host ID: " + hostID(cidr) + "\n" + "\n");

                int bits = 32 - cidr;

                int fbip[] = new int[32];
                for (int i = 0; i < 32; i++) {
                    fbip[i] = (int) bip.charAt(i) - 48;
                }
                for (int i = 31; i > (31 - bits); i--) {
                    fbip[i] &= 0;
                }
                String fip[] = {"", "", "", ""};
                for (int i = 0; i < 32; i++) {
                    fip[i / 8] = new String(fip[i / 8] + fbip[i]);
                }

                int ipAwal[] = new int[4];
                for (int i = 0; i < 4; i++) {
                    ipAwal[i] = Integer.parseInt(fip[i], 2);
                }
                txtHasil.append("IP Awal: " + ipAwal[0] + "." + ipAwal[1] + "." + ipAwal[2] + "." + ipAwal[3] + "\n");

                int lbip[] = new int[32];
                for (int i = 0; i < 32; i++) {
                    lbip[i] = (int) bip.charAt(i) - 48;
                }
                for (int i = 31; i > 31 - bits; i--) {
                    lbip[i] |= 1;
                }
                String lip[] = {"", "", "", ""};
                for (int i = 0; i < 32; i++) {
                    lip[i / 8] = new String(lip[i / 8] + lbip[i]);
                }

                int ipAkhir[] = new int[4];
                for (int i = 0; i < 4; i++) {
                    ipAkhir[i] = Integer.parseInt(lip[i], 2);
                }

                txtHasil.append("IP Akhir: " + ipAkhir[0] + "." + ipAkhir[1] + "." + ipAkhir[2] + "." + ipAkhir[3] + "\n");
                String init = (ipAkhir[0] + "." + ipAkhir[1] + "." + ipAkhir[2] + ".");

                txtHasil.append("Range IP: " + "\n");

                int j = ipAwal[3];
                int k = ipAkhir[3];
                for (int z = j + 1; z < k; z++) {
                    txtHasil.append(init + z + "\n");
                }

                int subnet;
                switch (cidr) {
                    case 25:
                        subnet = 128;
                        break;
                    case 26:
                        subnet = 192;
                        break;
                    case 27:
                        subnet = 224;
                        break;
                    case 28:
                        subnet = 240;
                        break;
                    case 29:
                        subnet = 248;
                        break;
                    case 30:
                        subnet = 252;
                        break;
                    default:
                        subnet = 0;
                }

                txtHasil.append("Subnet: " + subnet);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Format alamat IP tidak sesuai", "Informasi Kelas IP", JOptionPane.ERROR_MESSAGE);
        }

    }

    static String appendZeros(String s) {
        String temp = new String("00000000");
        return temp.substring(s.length()) + s;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCDN = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtIP = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHasil = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Konversi IP");

        btnBack.setText("Kembali");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jLabel1))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel2.setText("Alamat IP");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("/");

        jScrollPane2.setViewportView(txtCDN);

        jButton1.setText("Proses");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnClear.setText("Bersihkan");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(txtIP);

        txtHasil.setColumns(20);
        txtHasil.setRows(5);
        jScrollPane1.setViewportView(txtHasil);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addComponent(btnClear))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtIP.setText("");
        txtCDN.setText("");
        txtHasil.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(txtIP.getText().equals("") || txtCDN.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Kolom ip address dan cidr wajib diisi!", "Informasi Kelas IP", JOptionPane.ERROR_MESSAGE);
        } else {
            String ipaddress = txtIP.getText();
            int cidrValue = Integer.parseInt(txtCDN.getText());
            findIP(ipaddress, cidrValue);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(KonversiIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KonversiIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KonversiIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KonversiIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KonversiIP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane txtCDN;
    private javax.swing.JTextArea txtHasil;
    private javax.swing.JTextPane txtIP;
    // End of variables declaration//GEN-END:variables
}
