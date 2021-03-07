package InternationalAirlines.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Main extends javax.swing.JFrame {

  /**
   * Creates new form Main
   */
  public Main() {
    initComponents();
    startSQL();
  }

  public static void startSQL() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/airline", "airlineManager", "123");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(("select * from customer;"));
      while (rs.next()) {
        System.out.println(rs.getString(1));
      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jDesktopPane1 = new javax.swing.JDesktopPane();
    customerMenuBar = new javax.swing.JMenuBar();
    customerMenu = new javax.swing.JMenu();
    addCustomerItem = new javax.swing.JMenuItem();
    searchCustomerMenu = new javax.swing.JMenuItem();
    ticketsMenu = new javax.swing.JMenu();
    bookTicketItem = new javax.swing.JMenuItem();
    ticketReportItem = new javax.swing.JMenuItem();
    flightMenu = new javax.swing.JMenu();
    addFlightMenu = new javax.swing.JMenuItem();
    userMenu = new javax.swing.JMenu();
    userCreationMenu = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setPreferredSize(new java.awt.Dimension(1366, 768));

    javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
    jDesktopPane1.setLayout(jDesktopPane1Layout);
    jDesktopPane1Layout.setHorizontalGroup(
        jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
    );
    jDesktopPane1Layout.setVerticalGroup(
        jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
    );

    customerMenu.setText("Customer");

    addCustomerItem.setText("Add Customer");
    addCustomerItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addCustomerAction(evt);
      }
    });
    customerMenu.add(addCustomerItem);

    searchCustomerMenu.setText("Search Customer");
    searchCustomerMenu.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        searchCustomerAction(evt);
      }
    });
    customerMenu.add(searchCustomerMenu);

    customerMenuBar.add(customerMenu);

    ticketsMenu.setText("Tickets");

    bookTicketItem.setText("Book Ticket");
    bookTicketItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ticketAction(evt);
      }
    });
    ticketsMenu.add(bookTicketItem);

    ticketReportItem.setText("Ticket Report");
    ticketReportItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ticketReportAction(evt);
      }
    });
    ticketsMenu.add(ticketReportItem);

    customerMenuBar.add(ticketsMenu);

    flightMenu.setText("Flight");

    addFlightMenu.setText("Add Flight");
    addFlightMenu.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addFlightAction(evt);
      }
    });
    flightMenu.add(addFlightMenu);

    customerMenuBar.add(flightMenu);

    userMenu.setText("User");

    userCreationMenu.setText("UserCreation");
    userCreationMenu.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        userCreationAction(evt);
      }
    });
    userMenu.add(userCreationMenu);

    customerMenuBar.add(userMenu);

    setJMenuBar(customerMenuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void addCustomerAction(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    // TODO add your handling code here:

    CustomerAdder cus = new CustomerAdder();
    jDesktopPane1.add(cus);
    cus.setVisible(true);

  }//GEN-LAST:event_jMenuItem1ActionPerformed

  private void searchCustomerAction(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    // TODO add your handling code here:

    CustomerSearch scus = new CustomerSearch();
    jDesktopPane1.add(scus);
    scus.setVisible(true);


  }//GEN-LAST:event_jMenuItem2ActionPerformed

  private void addFlightAction(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    // TODO add your handling code here:
    FlightAdder f = new FlightAdder();
    jDesktopPane1.add(f);
    f.setVisible(true);

  }//GEN-LAST:event_jMenuItem4ActionPerformed

  private void ticketAction(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    // TODO add your handling code here:
    Ticket t = new Ticket();
    jDesktopPane1.add(t);
    t.setVisible(true);

  }//GEN-LAST:event_jMenuItem3ActionPerformed

  private void ticketReportAction(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    // TODO add your handling code here:

    TicketReport ti = new TicketReport();
    jDesktopPane1.add(ti);
    ti.setVisible(true);


  }//GEN-LAST:event_jMenuItem6ActionPerformed

  private void userCreationAction(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    // TODO add your handling code here:

    UserCreator u = new UserCreator();
    jDesktopPane1.add(u);
    u.setVisible(true);


  }//GEN-LAST:event_jMenuItem5ActionPerformed

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
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
          .getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Main().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JDesktopPane jDesktopPane1;
  private javax.swing.JMenu customerMenu;
  private javax.swing.JMenu ticketsMenu;
  private javax.swing.JMenu flightMenu;
  private javax.swing.JMenu userMenu;
  private javax.swing.JMenuBar customerMenuBar;
  private javax.swing.JMenuItem addCustomerItem;
  private javax.swing.JMenuItem searchCustomerMenu;
  private javax.swing.JMenuItem bookTicketItem;
  private javax.swing.JMenuItem addFlightMenu;
  private javax.swing.JMenuItem userCreationMenu;
  private javax.swing.JMenuItem ticketReportItem;
  // End of variables declaration//GEN-END:variables
}
