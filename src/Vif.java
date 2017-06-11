
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;






public class Vif extends javax.swing.JFrame 
{
    
    //Initializing Windows......
    Fixit fx = new Fixit();
    Xplore xpl = new Xplore();
    
    
    Appearance looks = new Appearance();
    
    
    //Creating Settings Files and assigning default values.....
    
    public static String dir = System.getProperty("user.home", "Desktop") + "\\Desktop\\";
    public static String path = dir.substring(0, dir.length()-8) + "Vifarnet\\";
    //Create folder
    File file = new File(path);
    
     public Properties prop = new Properties();
     public Properties def = new Properties();
     {
       def.setProperty("username", System.getProperty("user.name"));
       def.setProperty("wallpaper", "err");
      
     }
     
     public String value;    
     public String username = System.getProperty("user.name");
     public String imagepath = "err";
     public boolean apeartemp  = false;
    //Getter & Setter methods start here bitches!
   
  //Setting the wallpaper function 
   public void setWallpaper()
   {
      
       if(imagepath.equals("err"))
       {
           back.setIcon(null);   
           SaveSet("wallpaper","err");
       }
       else
       {           
       
       try
            {
             back.setIcon(new javax.swing.ImageIcon(imagepath));                 
              SaveSet("wallpaper",imagepath);
             
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Something went awry while setting your wallpaper\n\nError at function \"setWallpaper()\" :\n"+ e.toString());   
                SaveSet("wallpaper","err");
            }
       
       }
       this.refresh();
       
   }
   
   public int size = 0;
    
    
    int delay = 0;
    ActionListener closetime = new ActionListener() 
    {

        @Override
        public void actionPerformed(ActionEvent evt) 
        {
          if(size>=-15)
          {
          menu.setBounds(0, 0, size, 550);
          man=false;
          size -= 15;
          }
         else
          {
              close.stop();
          }
        }

    };
          
   
    ActionListener opentime = new ActionListener() 
    {

        @Override
        public void actionPerformed(ActionEvent evt) 
        {
          if(size<=200)
          {
          menu.setBounds(0, 0, size, 550);
          man=true;
          size += 15;
          }
         else
          {
              open.stop();
          }
        }

    };  
    
    
   public int l1 = 0; 
   public int l2 = 0; 
   public int l3 = 0; 
   public int l4 = 0; 
   public int l5 = 0;
   public int l6 = 0; 
   
   public int p1 = 0;
   public int p2 = 0;
   public int p3 = 0;
   public int p4 = 0;
   public int p5 = 0;
   
   /*
   public int l1 = 0; 
   public int l2 = 10; 
   public int l3 = 150; 
   public int l4 = 290; 
   public int l5 = 430;
   public int l6 = 570; 
   */
   
   
   ActionListener profentry = new ActionListener() 
    {

        @Override
        public void actionPerformed(ActionEvent evt) 
        {
          
              
          
            if(p1<=150)
          {
          n.setLocation(p1, 230);
          p1 += 2;
          }   
            
            
          if(p2<=380)
          {
          nm.setLocation(p2, 230);
          p2 += 2;
          }   
          
          
          if(p3<=150)
          {
          p.setLocation(p3, 280);
          p3 += 2;
          }   
          
          if(p4<=380)
          {
          key.setLocation(p4, 280);
          p4 +=2;
          }   
            else
          {
              
              
              prof_entry.stop();
              nm.requestFocus();
          }
          
          if(p5<=320)
          {
          save.setLocation(p5, 340);
          p5 += 3;
          }   
                    
            
        }

    };
   
   
   
   
   
   public void delay(int t)
   {
                try
               {
                   
                   Thread.sleep(t);       
                          
                  
               } catch(InterruptedException ex) 
              {
                Thread.currentThread().interrupt(); 
              }
        
            
                 
   }
     ActionListener appentry = new ActionListener() 
    {

        @Override
        public void actionPerformed(ActionEvent evt) 
        {
            
            if(l6<=710)
          {
          f.setLocation(l6, 110);
          l6 += 7;
          }      
            else
            {
                entry.stop();
            }
            
            
            
                       
          if(l5<=570)
          {
          e.setLocation(l5, 110);
          l5 += 6;
          }
          
           if(l4<=430)
          {
          d.setLocation(l4, 110);
          l4 += 5;
          }
           
           if(l3<=290)
          {
          c.setLocation(l3, 110);
          l3 += 4;
          }
           
             if(l2<=150)
          {
          b.setLocation(l2, 110);
          l2 +=3;
          }
           
           if(l1<=10)
          {
          a.setLocation(l1, 110);
          l1 += 2;
          }
           
           
           
        }
        
        

    };  
    
  
    Timer close = new Timer(delay,closetime);
    Timer open = new Timer(delay,opentime);
    Timer entry = new Timer(9/10,appentry);
    Timer prof_entry = new Timer(1/2,profentry);
    
    
    public Vif() 
    {
        initComponents();  
        
         if(!file.exists())
     {
         file.mkdir();
     }
        
        apps_animate();     
        prof_disappear();
        abt_disappear();
        
        //Load and assign username
        
        
        String temp = LoadSet("username");
        
        if(temp.equals("err"))
        {
             username = System.getProperty("user.name");
             tit.setText("Welcome, "+username);
             nm.setText(username);
             SaveSet("username",username);
        }
        else
        {
            username = temp;
             tit.setText("Welcome, "+username);
             nm.setText(username);
             SaveSet("username",username);
        }
      
      
    
      try
      {
        imagepath = LoadSet("wallpaper");
         setWallpaper();     
          
      }catch(Exception e)
      {
          imagepath = "err";
          setWallpaper();         
          
      }
      
      
     this.requestFocus();
    
     
    }

  public void abt_disappear()
  {
      save1.setVisible(false);
      save2.setVisible(false);
  }
  
  public void abt_appear()
  {
     
      save1.setVisible(true);
       save2.setVisible(true);
       
  }
  public boolean man = false;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wall = new javax.swing.JPanel();
        a1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ico = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        prof = new javax.swing.JLabel();
        down = new javax.swing.JPanel();
        abt = new javax.swing.JLabel();
        name6 = new javax.swing.JLabel();
        name4 = new javax.swing.JLabel();
        name5 = new javax.swing.JLabel();
        prof1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tit = new javax.swing.JLabel();
        save2 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        b = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        c = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        e = new javax.swing.JLabel();
        f = new javax.swing.JLabel();
        save1 = new javax.swing.JLabel();
        save = new javax.swing.JLabel();
        n = new javax.swing.JLabel();
        nm = new javax.swing.JTextField();
        p = new javax.swing.JLabel();
        key = new javax.swing.JTextField();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeme(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wall.setBackground(java.awt.Color.white);
        wall.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        a1.setBackground(java.awt.Color.white);
        a1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        a1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Untitled.png"))); // NOI18N
        a1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        a1.setIconTextGap(0);
        a1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        wall.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 60, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(198, 227, 251));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Thinking the impossible  ");
        wall.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 190, 30));

        ico.setBackground(new java.awt.Color(155, 207, 251));
        ico.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        ico.setForeground(new java.awt.Color(187, 222, 251));
        ico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1415356471_ic_menu_48px-32.png"))); // NOI18N
        ico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ico.setOpaque(true);
        ico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icoMouseClicked(evt);
            }
        });
        wall.add(ico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        menu.setBackground(new java.awt.Color(155, 207, 251));
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                menuFocusLost(evt);
            }
        });
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
        });
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setBackground(new java.awt.Color(155, 207, 251));
        name.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        name.setText("Home");
        name.setToolTipText("");
        name.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        name.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        name.setOpaque(true);
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
        });
        menu.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 140, 60));

        prof.setBackground(new java.awt.Color(155, 207, 251));
        prof.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        prof.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        prof.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1415371605_ic_account_circle_48px-32.png"))); // NOI18N
        prof.setText(" My Profile");
        prof.setToolTipText("");
        prof.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prof.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        prof.setOpaque(true);
        prof.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                profMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                profMouseReleased(evt);
            }
        });
        menu.add(prof, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 200, 50));

        down.setBackground(new java.awt.Color(155, 207, 251));
        down.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        abt.setBackground(new java.awt.Color(155, 207, 251));
        abt.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        abt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        abt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1415371857_ic_info_48px-32.png"))); // NOI18N
        abt.setText(" About");
        abt.setToolTipText("");
        abt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        abt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        abt.setOpaque(true);
        abt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abtMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                abtMousePressed(evt);
            }
        });
        down.add(abt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, 50));

        name6.setBackground(new java.awt.Color(155, 207, 251));
        name6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        name6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        name6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1416997718_ic_help_48px-32.png"))); // NOI18N
        name6.setText(" Help");
        name6.setToolTipText("");
        name6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        name6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        name6.setOpaque(true);
        name6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                name6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                name6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                name6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                name6MousePressed(evt);
            }
        });
        down.add(name6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 50));

        name4.setBackground(new java.awt.Color(155, 207, 251));
        name4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        name4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        name4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1415369835_ic_settings_48px-32.png"))); // NOI18N
        name4.setText(" Settings");
        name4.setToolTipText("");
        name4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        name4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        name4.setOpaque(true);
        name4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                name4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                name4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                name4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                name4MousePressed(evt);
            }
        });
        down.add(name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 200, 50));

        name5.setBackground(new java.awt.Color(155, 207, 251));
        name5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        name5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        name5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1415374796_ic_swap_vert_circle_48px-32.png"))); // NOI18N
        name5.setText(" Updates");
        name5.setToolTipText("");
        name5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        name5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        name5.setOpaque(true);
        name5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                name5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                name5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                name5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                name5MousePressed(evt);
            }
        });
        down.add(name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        menu.add(down, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 220));

        prof1.setBackground(new java.awt.Color(155, 207, 251));
        prof1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        prof1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        prof1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1415371604_ic_palette_48px-32.png"))); // NOI18N
        prof1.setText(" Appearance");
        prof1.setToolTipText("");
        prof1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prof1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        prof1.setOpaque(true);
        prof1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prof1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                prof1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                prof1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                prof1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                prof1MouseReleased(evt);
            }
        });
        menu.add(prof1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 200, 50));

        jLabel2.setBackground(new java.awt.Color(115, 188, 251));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Change wallpaper");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 40));

        jLabel3.setBackground(new java.awt.Color(115, 188, 251));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Change theme");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        menu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, 40));

        wall.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        tit.setBackground(new java.awt.Color(155, 207, 251));
        tit.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit.setText("Welcome");
        tit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit.setOpaque(true);
        wall.add(tit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 840, 34));

        save2.setBackground(java.awt.Color.white);
        save2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        save2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save2.setText("<html><center><b>Vifarnet Colors 4.0</b><br><br>\n\n© 2014 Aravind Balaji<br>\n<i>Thinking the impossible</i></center></html>");
        save2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, new java.awt.Color(63, 81, 181), new java.awt.Color(63, 81, 181)));
        save2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        save2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save2.setOpaque(true);
        save2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                save2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                save2MouseExited(evt);
            }
        });
        wall.add(save2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 430, 150));

        title.setBackground(new java.awt.Color(63, 81, 181));
        title.setFont(new java.awt.Font("Segoe Print", 1, 27)); // NOI18N
        title.setForeground(new java.awt.Color(198, 227, 251));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("    Vifarnet");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        title.setOpaque(true);
        wall.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 60));

        b.setBackground(new java.awt.Color(129, 212, 250));
        b.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        b.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1415375752_advancedsettings.png"))); // NOI18N
        b.setText("Fix It");
        b.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b.setIconTextGap(6);
        b.setInheritsPopupMenu(false);
        b.setOpaque(true);
        b.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bMouseClicked(evt);
            }
        });
        wall.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 120, 110));

        a.setBackground(new java.awt.Color(255, 216, 99));
        a.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1415375126_play_music.png"))); // NOI18N
        a.setText("Music");
        a.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        a.setIconTextGap(0);
        a.setOpaque(true);
        a.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        wall.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, 110));

        c.setBackground(new java.awt.Color(239, 179, 179));
        c.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        c.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/active-search-2-64.png"))); // NOI18N
        c.setText("Xplore");
        c.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        c.setOpaque(true);
        c.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cMouseClicked(evt);
            }
        });
        wall.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 120, 110));

        d.setBackground(new java.awt.Color(159, 168, 218));
        d.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        d.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tasks-64.png"))); // NOI18N
        d.setText("MyTasks");
        d.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        d.setIconTextGap(0);
        d.setOpaque(true);
        d.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dMouseClicked(evt);
            }
        });
        wall.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 120, 110));

        e.setBackground(new java.awt.Color(178, 223, 219));
        e.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        e.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        e.setIcon(new javax.swing.ImageIcon(getClass().getResource("/email.png"))); // NOI18N
        e.setText("DeskMail");
        e.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        e.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        e.setIconTextGap(0);
        e.setOpaque(true);
        e.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        wall.add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 120, 110));

        f.setBackground(new java.awt.Color(174, 213, 129));
        f.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        f.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1415377606_Globe-Download.png"))); // NOI18N
        f.setText("Downloader");
        f.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        f.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        f.setIconTextGap(0);
        f.setOpaque(true);
        f.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        wall.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 120, 110));

        save1.setBackground(new java.awt.Color(63, 81, 181));
        save1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        save1.setForeground(java.awt.Color.white);
        save1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save1.setText("Wow! Awesome");
        save1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save1.setOpaque(true);
        save1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                save1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                save1MouseExited(evt);
            }
        });
        wall.add(save1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 210, 40));

        save.setBackground(new java.awt.Color(63, 81, 181));
        save.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        save.setForeground(java.awt.Color.white);
        save.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save.setText("Save & Continue");
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save.setOpaque(true);
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveMouseExited(evt);
            }
        });
        wall.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 500, 220, 50));

        n.setBackground(new java.awt.Color(174, 213, 129));
        n.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        n.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n.setText("Name");
        n.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        n.setOpaque(true);
        wall.add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 220, 40));

        nm.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        nm.setToolTipText("");
        nm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(174, 213, 129), new java.awt.Color(174, 213, 129)));
        wall.add(nm, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 310, 40));

        p.setBackground(new java.awt.Color(129, 212, 250));
        p.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        p.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p.setText("Product key");
        p.setEnabled(false);
        p.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        p.setOpaque(true);
        wall.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 220, 40));

        key.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        key.setToolTipText("");
        key.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(129, 212, 250), new java.awt.Color(129, 212, 250)));
        key.setEnabled(false);
        wall.add(key, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, 310, 40));

        back.setBackground(java.awt.Color.white);
        back.setForeground(java.awt.Color.white);
        back.setOpaque(true);
        wall.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 850, 460));

        getContentPane().add(wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void apps_animate()
    {
        
         l1 = 0; 
         l2 = 0; 
         l3 = 0; 
         l4 = 0; 
         l5 = 0;
         l6 = 0; 
         entry.restart();
         
    }
    
    public void prof_animate()
    {
       
        
        p1 = 20; 
         p2 = 20; 
         p3 = -80; 
         p4 = -80; 
         p5 = -150;         
         
         prof_entry.restart();
         
    }
    
    
    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
    
 
        
    }//GEN-LAST:event_menuMouseClicked

   
     
    private void SaveSet(String key, String value) {

        try {

            File Sett = new File(path + "Vifarnet.properties");
            FileWriter writer = new FileWriter(Sett);

            prop.setProperty(key, value);

            prop.store(writer, "Vifarnet User Settings (Warning :DO NOT MODIFY/DELETE !!!)\n\n\nThese are the user settings saved in Vifarnet. Modifying these values may crash your computer and burn your house!!\n\n");
            writer.close();

        } catch (Exception e) {
            LoadDefSet();
           
        }
    }
    
    
   
     public void LoadDefSet() {

        try {

            File Sett = new File(path + "Vifarnet.properties");
            
            FileWriter writer = new FileWriter(Sett);

            username = System.getProperty("user.name");
            imagepath = "err";
            def.setProperty("username",username);
            def.setProperty("wallpaper", "err");

            def.store(writer, "Vifarnet User Settings (Warning :DO NOT MODIFY/DELETE !!!)\n\n\nThese are the user settings saved in Vifarnet. Modifying these values may crash your computer and burn your house!!\n\n");
            writer.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Unable to load Default User Settings\nError in function: LoadDefSet()\n\n"+ e.getMessage());
        }
    }
    
     public String LoadSet(String key) 
    {

        try {

            File Sett = new File(path + "Vifarnet.properties");
            FileReader reader = new FileReader(Sett);

            prop.load(reader);

            value = prop.getProperty(key);

            reader.close();
             return value;
        
            
        } catch (Exception e) {
            value = "err";
            return value;

        }

    }
     
     
     
    private void icoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icoMouseClicked
        
         //checkScreen();
         if(name.getText().equals("Home"))
         {
             toggleMenu();
             
         }
         
         else if(name.getText().equals("Back"))
         {
             ico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1415356471_ic_menu_48px-32.png")));
             
             tit.setText("Welcome, "+username);
             checkScreen();
             
         }
         
    }//GEN-LAST:event_icoMouseClicked

    
    public void checkScreen()
    {
        
        
        if(tit.getText().equals("Welcome, "+username))
        {
            name.setText("Home");
            tit.setBackground(new java.awt.Color(155,207,251));
            ico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1415356471_ic_menu_48px-32.png")));
            apps_appear();
            apps_animate();
            prof_disappear();
        }
        else if(tit.getText().equals("My Profile"))
        {
           tit.setBackground(new java.awt.Color(174,213,129)); 
           name.setText("Back");
           ico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1415550640_ic_arrow_back_48px-32.png")));
                      
        }
        
        
        
    }
    public void toggleMenu()
    {
       if(man==false) 
       {
           size=1;
           close.stop();
          open.restart();
         
          
       }
       else if(man==true) 
       {
           
           size=200;
           open.stop();
          close.restart();
           
       }  
       
      
    }
    
    
    private void abtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abtMouseClicked
            
     
    close.restart();
    apps_disappear(); 
    tit.setBackground(new java.awt.Color(255,167,38));
    tit.setText("About Vifarnet");
    
    abt_appear();   
    
    }//GEN-LAST:event_abtMouseClicked
   
    private void profMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profMouseClicked
       abt_disappear();
        close.restart();
        apps_disappear();
        tit.setText("My Profile"); 
        checkScreen();
        prof_appear();
    }//GEN-LAST:event_profMouseClicked

    private void name4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_name4MouseClicked

    private void name5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_name5MouseClicked

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked
       toggleMenu();
    }//GEN-LAST:event_nameMouseClicked

    private void menuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_menuFocusLost
   
    }//GEN-LAST:event_menuFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
      

    }//GEN-LAST:event_formWindowOpened

    private void name6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_name6MouseClicked

    private void profMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profMouseEntered
        prof.setBackground(new java.awt.Color(210,232,251));
    }//GEN-LAST:event_profMouseEntered

    private void profMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profMouseExited
        prof.setBackground(new java.awt.Color(155,207,251));
        
    }//GEN-LAST:event_profMouseExited

    private void profMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profMousePressed

       prof.setBackground(new java.awt.Color(100,181,246));
        
    }//GEN-LAST:event_profMousePressed

    private void profMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profMouseReleased
     
    }//GEN-LAST:event_profMouseReleased

    private void saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseEntered
        
       save.setBackground(new java.awt.Color(92,107,192));
    }//GEN-LAST:event_saveMouseEntered

    private void saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseExited
       save.setBackground(new java.awt.Color(63,81,181));
    }//GEN-LAST:event_saveMouseExited

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
       //Saving......
        username = nm.getText();       
        SaveSet("username",username);
       
        goBack();
        
    }//GEN-LAST:event_saveMouseClicked

    private void save1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save1MouseClicked
          goBack();
        

    }//GEN-LAST:event_save1MouseClicked

    public void goBack()
    {
        
         tit.setText("Welcome, "+username);
        
        abt_disappear();
         checkScreen();
    }
    private void save1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save1MouseEntered

        save1.setBackground(new java.awt.Color(92,107,192));
    }//GEN-LAST:event_save1MouseEntered

    private void save1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save1MouseExited
        save1.setBackground(new java.awt.Color(63,81,181));
    }//GEN-LAST:event_save1MouseExited

    private void save2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_save2MouseClicked

    private void save2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_save2MouseEntered

    private void save2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_save2MouseExited

    private void abtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abtMouseEntered
        abt.setBackground(new java.awt.Color(210,232,251));
        
    }//GEN-LAST:event_abtMouseEntered

    private void abtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abtMouseExited
       abt.setBackground(new java.awt.Color(155,207,251));
    }//GEN-LAST:event_abtMouseExited

    private void abtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abtMousePressed
        abt.setBackground(new java.awt.Color(100,181,246));
    }//GEN-LAST:event_abtMousePressed

    private void bMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMouseClicked
        
        fx.setVisible(true);
    }//GEN-LAST:event_bMouseClicked

    private void dMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dMouseClicked
     
       
    }//GEN-LAST:event_dMouseClicked

public void toggleAppear()
{
    if(apeartemp==false)
        {
         down.setLocation(0, 240);
         apeartemp = true;
        }
        else if(apeartemp==true)
        {
           down.setLocation(0, 160);
           apeartemp = false; 
        }
}

    private void prof1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prof1MouseClicked
      
        toggleAppear();
       
    }//GEN-LAST:event_prof1MouseClicked

    private void prof1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prof1MouseEntered
       prof1.setBackground(new java.awt.Color(210,232,251));
    }//GEN-LAST:event_prof1MouseEntered

    private void prof1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prof1MouseExited
       prof1.setBackground(new java.awt.Color(155,207,251));
    }//GEN-LAST:event_prof1MouseExited

    private void prof1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prof1MousePressed
       prof1.setBackground(new java.awt.Color(100,181,246));
    }//GEN-LAST:event_prof1MousePressed

    private void prof1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prof1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_prof1MouseReleased

    private void closeme(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeme
        
        
         this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
         apps_disappear();
         abt_disappear();
         prof_disappear();
         tit.setText("Wrapping things up...");
       
         tit.setBackground(new java.awt.Color(239,117,117));
         Object[] op = {"Yeah, I'll have to leave","Nope, I'll stay"};
       
      	if (JOptionPane.showOptionDialog(null, "Leaving so soon "+username+ "? :\\", "", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE,null,op ,op[0])== JOptionPane.YES_OPTION)
	    {
	    	  this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		 System.exit(1);
	    }
     else
       {
         
         tit.setText("Welcome, "+username);
         checkScreen();
       }
        
        
        
      	
        
    }//GEN-LAST:event_closeme

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        
                
        try
      {
          
      
        JFileChooser chooser = new JFileChooser();
        
    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");    
    chooser.setFileFilter(filter);    
    chooser.showDialog(this, "Set wallpaper");
    File file = chooser.getSelectedFile();  
    String temp = file.getAbsolutePath();
    if(temp!=null)
    {
       imagepath = temp;    
       setWallpaper();
    }
    else
    {
        imagepath = "err";
    }
    
    
    }
      catch(NullPointerException ef)
      {
                    
      }
      
      catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, "Something went awry while setting your wallpaper\n\nError at function \"aMouseClicked()\" :\n"+e.toString());
    }
       
       
           
        

        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void name5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name5MouseEntered
          name5.setBackground(new java.awt.Color(210,232,251));
    }//GEN-LAST:event_name5MouseEntered

    private void name4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name4MouseEntered
         name4.setBackground(new java.awt.Color(210,232,251));
    }//GEN-LAST:event_name4MouseEntered

    private void name6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name6MouseEntered
         name6.setBackground(new java.awt.Color(210,232,251));
    }//GEN-LAST:event_name6MouseEntered

    private void name5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name5MouseExited
       name5.setBackground(new java.awt.Color(155,207,251));
    }//GEN-LAST:event_name5MouseExited

    private void name4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name4MouseExited
        name4.setBackground(new java.awt.Color(155,207,251));
    }//GEN-LAST:event_name4MouseExited

    private void name6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name6MouseExited
         name6.setBackground(new java.awt.Color(155,207,251));
    }//GEN-LAST:event_name6MouseExited

    private void name5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name5MousePressed
        name5.setBackground(new java.awt.Color(100,181,246));
    }//GEN-LAST:event_name5MousePressed

    private void name4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name4MousePressed
          name4.setBackground(new java.awt.Color(100,181,246));
    }//GEN-LAST:event_name4MousePressed

    private void name6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name6MousePressed
         name6.setBackground(new java.awt.Color(100,181,246));
    }//GEN-LAST:event_name6MousePressed

    private void cMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cMouseClicked
     xpl.setVisible(true);
        
        
    }//GEN-LAST:event_cMouseClicked

    public void  apps_disappear()           
    {
        
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        e.setVisible(false);
        f.setVisible(false);
    }
    
    public void  apps_appear()            
    {
        a.setVisible(true);
        b.setVisible(true);
        c.setVisible(true);
        d.setVisible(true);
        e.setVisible(true);
        f.setVisible(true);
    }
    
    public void prof_appear()
    {
       
        n.setVisible(true);
        p.setVisible(true);
        key.setVisible(true);
        nm.setVisible(true);
        save.setVisible(true);
        prof_animate();
    }
     public void prof_disappear()
    {   
         prof_entry.stop();
        n.setVisible(false);
        p.setVisible(false);
        key.setVisible(false);
        nm.setVisible(false);
        save.setVisible(false);
    }
    
  public void refresh()
  {
      close.stop();
        open.stop();
        apps_animate();
        
  }
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
            java.util.logging.Logger.getLogger(Vif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() {
                new Vif().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel abt;
    private javax.swing.JLabel b;
    private javax.swing.JLabel back;
    private javax.swing.JLabel c;
    private javax.swing.JLabel d;
    private javax.swing.JPanel down;
    private javax.swing.JLabel e;
    private javax.swing.JLabel f;
    private javax.swing.JLabel ico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField key;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel n;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel name5;
    private javax.swing.JLabel name6;
    private javax.swing.JTextField nm;
    private javax.swing.JLabel p;
    private javax.swing.JLabel prof;
    private javax.swing.JLabel prof1;
    private javax.swing.JLabel save;
    private javax.swing.JLabel save1;
    private javax.swing.JLabel save2;
    public javax.swing.JLabel tit;
    private javax.swing.JLabel title;
    private javax.swing.JPanel wall;
    // End of variables declaration//GEN-END:variables
}
