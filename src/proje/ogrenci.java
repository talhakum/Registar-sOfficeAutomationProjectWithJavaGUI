/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author talha
 */
public class ogrenci extends javax.swing.JFrame {
static int i=0;
    /**
     * Creates new form ornek
     */
    public ogrenci() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
        @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text1 = new javax.swing.JTextField();
        text2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buton1 = new javax.swing.JButton();
        buton2 = new javax.swing.JButton();
        buton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list1 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Öğrenci ");

        jLabel1.setText("Öğrenci Adı");

        jLabel2.setText("Öğrenci Numarası");

        buton1.setText("ÖĞRENCİ EKLE");
        buton1.setToolTipText("");
        buton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton1ActionPerformed(evt);
            }
        });

        buton2.setText("ÖĞRENCİ SİL");
        buton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton2ActionPerformed(evt);
            }
        });

        buton3.setText("ÖĞRENCİ GÜNCELLE");
        buton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton3ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(list1);

        jLabel3.setText("Öğrenci Ad");

        jLabel4.setText("Öğrenci Numara");

        jLabel5.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buton2)
                            .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buton3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buton1)
                    .addComponent(buton2)
                    .addComponent(buton3))
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
   static public String[] goster() {
    String dizi[]=new String[50];
    try {
    Class.forName("com.mysql.jdbc.Driver");
    
    Connection bag=DriverManager.getConnection("jdbc:mysql://localhost:3306/calisandb","root", "");
    String sql="SELECT * FROM ogrenci ";

    PreparedStatement p1=bag.prepareStatement(sql);

            
            ResultSet sonuc=p1.executeQuery();
             i=0;
            while(sonuc.next()) {
                dizi[i]=sonuc.getString(1);
                
                dizi[i]+="      "+sonuc.getString(2);
                dizi[i]+="      "+sonuc.getString(3);
                
                        
                        i++;
            }

            list1.setListData(dizi);
                      

            p1.close();
            bag.close();
            
            
    
}
catch(Exception e) {
    System.out.println(e.getMessage());
}
    return dizi;
}
    
    
    
    private void buton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton1ActionPerformed
  Connection bag=null;
  PreparedStatement p1=null;
        try {
            if(text2.getText().length()!=10) {
                JOptionPane.showMessageDialog(null, "GİRECEĞİNİZ NUMARA 10 HANELİ OLMALIDIR. ÖRN:1306140000");
                throw new Exception();
            }
            
            Class.forName("com.mysql.jdbc.Driver");

                 bag=DriverManager.getConnection("jdbc:mysql://localhost:3306/calisandb","root", "");


            String sql="INSERT INTO ogrenci(ID,ogrAd,ogrNo) VALUES(?,?,?)";

            p1=bag.prepareStatement(sql);
            p1.setString(1, String.valueOf(i+1));
            p1.setString(2, text1.getText());
            p1.setString(3, text2.getText());
                        p1.executeUpdate();

            p1.close();
            bag.close();
            
                goster();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
         finally  {
              
            try {
            p1.close();
            bag.close();
            }catch(Exception e){}
        }
    }//GEN-LAST:event_buton1ActionPerformed

    private void buton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton2ActionPerformed
        Connection bag=null;
        PreparedStatement p1=null;
        try {
    Class.forName("com.mysql.jdbc.Driver");

     bag=DriverManager.getConnection("jdbc:mysql://localhost:3306/calisandb","root", "");

    String sql="update ogrenci set ograd=\"\",ogrno=\" \" where ogrno=?";

     p1=bag.prepareStatement(sql);
        
        p1.setString(1,text2.getText() );
        
        int sonuc=p1.executeUpdate();
        if(sonuc==1) 
                System.out.println("Kayıt eklendi.");
        else
                System.out.println("Kayıt eklenemedi.");
        goster();

}
catch(Exception e) {
    System.out.println(e.getMessage());
}
        finally  {
              
            try {
            p1.close();
            bag.close();
            }catch(Exception e){}
        }
    }//GEN-LAST:event_buton2ActionPerformed

    private void buton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton3ActionPerformed
 try {
      if(text2.getText().length()!=10) {
                JOptionPane.showMessageDialog(null, "GİRECEĞİNİZ NUMARA 10 HANELİ OLMALIDIR. ÖRN:1306140000");
                throw new Exception();
            }
    Class.forName("com.mysql.jdbc.Driver");

    Connection bag=DriverManager.getConnection("jdbc:mysql://localhost:3306/calisandb","root", "");

    String sql="UPDATE ogrenci SET ogrAd=?, ogrNo=? WHERE ogrAd=?";

    PreparedStatement p1=bag.prepareStatement(sql);

            p1.setString(1,text1.getText() );
            p1.setString(2,text2.getText());
            p1.setString(3,JOptionPane.showInputDialog("Güncellemek istediğiniz öğrencinin adını giriniz: "));
            
            int sonuc=p1.executeUpdate();
            if(sonuc==1) 
                System.out.println("Kayıt eklendi.");
            else
                System.out.println("Kayıt eklenemedi.");
            
            
            p1.close();
            bag.close();
            
            
    goster();
}
catch(Exception e) {
    System.out.println(e.getMessage());
}
 
    }//GEN-LAST:event_buton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ogrenci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ogrenci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ogrenci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ogrenci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ogrenci().setVisible(true);
            }
        });
              goster();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buton1;
    private javax.swing.JButton buton2;
    private javax.swing.JButton buton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JList<String> list1;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text2;
    // End of variables declaration//GEN-END:variables
}
