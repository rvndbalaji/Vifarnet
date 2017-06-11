
import java.awt.Color;



public class Appearance extends javax.swing.JFrame 

{
    private static final long serialVersionUID = 1L;

         
    public Appearance() 
    {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tit = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        cancel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(java.awt.Color.gray);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("It's all about the looks  ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 170, 30));

        tit.setBackground(java.awt.Color.black);
        tit.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tit.setForeground(java.awt.Color.white);
        tit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit.setText("Appearance");
        tit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit.setOpaque(true);
        jPanel1.add(tit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 50));

        a.setBackground(java.awt.Color.lightGray);
        a.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Paint-48.png"))); // NOI18N
        a.setText("Change wallpaper");
        a.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        a.setIconTextGap(0);
        a.setOpaque(true);
        a.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aMouseExited(evt);
            }
        });
        jPanel1.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, 130));

        cancel.setBackground(java.awt.Color.black);
        cancel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cancel.setForeground(java.awt.Color.white);
        cancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png"))); // NOI18N
        cancel.setText("Finish with the makeup");
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cancel.setOpaque(true);
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelMouseExited(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 650, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aMouseEntered
        a.setBackground(Color.WHITE);
    }//GEN-LAST:event_aMouseEntered

    private void aMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aMouseExited
       a.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_aMouseExited
     
    private void aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aMouseClicked
       
     
    }//GEN-LAST:event_aMouseClicked

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        cancel.setBackground(Color.BLACK);
    }//GEN-LAST:event_cancelMouseExited

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
        cancel.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
  
        this.dispose();
    }//GEN-LAST:event_cancelMouseClicked

    
    public static void main(String args[]) 
    {
       
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Appearance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Appearance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Appearance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Appearance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Appearance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a;
    private javax.swing.JLabel cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel tit;
    // End of variables declaration//GEN-END:variables
}
