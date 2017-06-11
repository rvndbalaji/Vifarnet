import java.io.*;
import java.util.*;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
public class Xplore extends javax.swing.JFrame {

   

   
    public Xplore() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        srch = new javax.swing.JTextField();
        tit = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        list = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Xplore");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(201, 57, 5));
        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 27)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Xplore");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 60));

        srch.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        srch.setToolTipText("");
        srch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(244, 67, 54), new java.awt.Color(244, 67, 54), java.awt.Color.white, java.awt.Color.white));
        srch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                srchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                srchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                srchKeyTyped(evt);
            }
        });
        jPanel1.add(srch, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 830, 40));

        tit.setBackground(new java.awt.Color(229, 115, 115));
        tit.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit.setText("Ready when you are!");
        tit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit.setOpaque(true);
        jPanel1.add(tit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1370, 40));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 410, 40));

        list.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        list.setSelectionBackground(new java.awt.Color(229, 115, 115));
        list.setSelectionForeground(java.awt.Color.black);
        jScrollPane2.setViewportView(list);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 830, 450));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void srchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srchKeyTyped
    
      //StartSearch();
    }//GEN-LAST:event_srchKeyTyped

    private void srchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srchKeyPressed
      
        
    }//GEN-LAST:event_srchKeyPressed

    private void srchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srchKeyReleased
        
  
    }//GEN-LAST:event_srchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        tit.setText("Searching for your file...");
        StartSearch();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public void StartSearch()
    {
        if(srch.getText().isEmpty())
        {    
          //res.setText(null);
            list.removeAll();
          srch.requestFocus();
        }
        else    
        {
           // res.setText(null);
            list.removeAll();
           findFile(srch.getText(),new File("D:\\"));
           /*
           findFile(srch.getText(),new File("C:\\"));
         findFile(srch.getText(),new File("E:\\"));
          findFile(srch.getText(),new File("F:\\"));
           findFile(srch.getText(),new File("G:\\"));
            findFile(srch.getText(),new File("H:\\"));
             findFile(srch.getText(),new File("I:\\"));
              findFile(srch.getText(),new File("J:\\"));
               findFile(srch.getText(),new File("K:\\"));
           */
        }
      
  
  
        
       
    }
    @SuppressWarnings("unchecked")
    public void findFile(String name,File file)
    {
        
        DefaultListModel listModel = new DefaultListModel();
       try
       {
           
       
       File[] fileNames = file.listFiles();
            
       int len = fileNames.length;
       
   
       String pees;
       for(int i =0 ; i<len ; i++)
       {
           pees = Arrays.asList(fileNames).get(i).toString();
           
         
           if(pees.contains(name))
           {
               //res.append(pees);
               //res.append("\n");
               
               listModel.addElement(pees);
               list.setModel(listModel);
               
           }
               
                      
         
           
          
       }
        
   } catch(Exception e) {}
        
     finally
       {
           tit.setText("Here are the stuff we found...");
       }
    }
  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Fixit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fixit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fixit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fixit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fixit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList list;
    private javax.swing.JTextField srch;
    public javax.swing.JLabel tit;
    // End of variables declaration//GEN-END:variables
}
