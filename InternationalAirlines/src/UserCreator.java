package InternationalAirlines.src;

import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class UserCreator extends javax.swing.JInternalFrame {

  /**
   * Creates new form userCreation
   */
  public UserCreator() {
    initComponents();
    autoID();
  }

  Connection con;
  PreparedStatement pst;

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    textUserId = new javax.swing.JLabel();
    textFirstName = new javax.swing.JTextField();
    textLastName = new javax.swing.JTextField();
    textUsername = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    textPassword = new javax.swing.JPasswordField();

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("User Creation"));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel1.setText("User ID");

    jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel2.setText("FirstName");

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel3.setText("LastName");

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel4.setText("User Name");

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel5.setText("Password");

    textUserId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    textUserId.setForeground(new java.awt.Color(255, 0, 0));
    textUserId.setText("jLabel6");

    jButton1.setText("Add");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        try {
          jButton1ActionPerformed(evt);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

    jButton2.setText("Cancel");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textUserId)
                    .addComponent(textFirstName)
                    .addComponent(textLastName)
                    .addComponent(textUsername)
                    .addComponent(textPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 140,
                        Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel1Layout.createSequentialGroup()
                    .addContainerGap(208, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(textUserId))
                                    .addGap(37, 37, 37)
                                    .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(textFirstName,
                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(44, 44, 44)
                                    .addComponent(jLabel3))
                                .addComponent(textLastName, javax.swing.GroupLayout.PREFERRED_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(49, 49, 49)
                            .addComponent(jLabel4))
                        .addComponent(textUsername, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26,
                    Short.MAX_VALUE)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  public void jButton1ActionPerformed(
      java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:

    String id = textUserId.getText();
    String firstname = textFirstName.getText();
    String lastname = textLastName.getText();
    String username = textUsername.getText();
    String password = textPassword.getText();

    String firstNamePattern = "[A-Z][a-z]*";
    String lastNamePattern = "[A-Z]+([A-Za-z'\\s\\-])*";
    String usernamePattern = "^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$";
    String passwordPattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";

    if (!firstname.matches(firstNamePattern)) {
      throw new Exception("BAD FIRSTNAME ->" + firstname);
    }

    if (!lastname.matches(lastNamePattern)) {
      throw new Exception("BAD LASTNAME ->" + lastname);
    }

    if (!username.matches(usernamePattern)) {
      throw new Exception("BAD USERNAME ->" + username);
    }

    if (!password.matches(passwordPattern)) {
      throw new Exception("BAD PASSWORD ->" + password);
    }

    try {
      con = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/airline", "airlineManager", "123");
      pst = con.prepareStatement(
          "insert into user(id,firstname,lastname,username,password)values(?,?,?,?,?)");

      pst.setString(1, id);
      pst.setString(2, firstname);
      pst.setString(3, lastname);
      pst.setString(4, username);
      pst.setString(5, password);
      pst.executeUpdate();

      JOptionPane.showMessageDialog(null, "User Created.........");
    } catch (SQLException ex) {
      Logger.getLogger(FlightAdder.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:
    this.hide();
  }//GEN-LAST:event_jButton2ActionPerformed

  public void autoID() {
    try {
      con = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/airline", "airlineManager", "123");
      Statement s = con.createStatement();
      ResultSet rs = s.executeQuery("select MAX(id) from user");
      rs.next();
      rs.getString("MAX(id)");
      if (rs.getString("MAX(id)") == null) {
        textUserId.setText("UO001");
      } else {
        long id = Long
            .parseLong(rs.getString("MAX(id)").substring(2, rs.getString("MAX(id)").length()));
        id++;
        textUserId.setText("UO" + String.format("%03d", id));
      }
    } catch (SQLException ex) {
      Logger.getLogger(CustomerAdder.class.getName()).log(Level.SEVERE, null, ex);
    }
  }


  //<editor-fold desc="SWING Variables Declarations">
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField textFirstName;
  private javax.swing.JTextField textLastName;
  private javax.swing.JPasswordField textPassword;
  private javax.swing.JLabel textUserId;
  private javax.swing.JTextField textUsername;
  //</editor-fold>

  /* These are the setters for the test suite used in UserCreatorTest. */
  public void setTextFirstName(JTextField textFirstName) {
    this.textFirstName = textFirstName;
  }

  public void setTextLastName(JTextField textLastName) {
    this.textLastName = textLastName;
  }

  public void setTextUsername(JTextField textUsername) {
    this.textUsername = textUsername;
  }

  public void setTextPassword(JPasswordField textPassword) {
    this.textPassword = textPassword;
  }
}
