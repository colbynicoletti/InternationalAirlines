import com.toedter.calendar.JCalendar;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Ticket extends javax.swing.JInternalFrame {

  /**
   * Creates new form ticket
   */
  public Ticket() {
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
    textSource = new javax.swing.JComboBox<>();
    text_depart = new javax.swing.JComboBox<>();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jButton3 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jLabel3 = new javax.swing.JLabel();
    textTicketNumber = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    textCustomerId = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    textFirstName = new javax.swing.JLabel();
    textLastName = new javax.swing.JLabel();
    textPassport = new javax.swing.JLabel();
    jButton4 = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jLabel12 = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    jLabel15 = new javax.swing.JLabel();
    jLabel16 = new javax.swing.JLabel();
    jLabel17 = new javax.swing.JLabel();
    flightNumber = new javax.swing.JLabel();
    flightName = new javax.swing.JLabel();
    textDepart = new javax.swing.JLabel();
    txtclass = new javax.swing.JComboBox<>();
    textPrice = new javax.swing.JTextField();
    textSeats = new javax.swing.JSpinner();
    bookButton = new javax.swing.JButton();
    cancelButton = new javax.swing.JButton();
    textTotal = new javax.swing.JLabel();

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Country",
        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
        javax.swing.border.TitledBorder.DEFAULT_POSITION,
        new java.awt.Font("Tahoma", 1, 12))); // NOI18N

    textSource.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[]{"India", "Srilanka", "Uk", "Usa", "Canada", "Chinna"}));

    text_depart.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[]{"India\t", "Srilanka", "Uk", "Usa", "Canada", "Chinna"}));

    jLabel1.setText("Source");

    jLabel2.setText("Departure");

    jButton3.setText("Search");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitTicketToDBAction(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textSource, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64,
                    Short.MAX_VALUE)
                .addComponent(text_depart, javax.swing.GroupLayout.PREFERRED_SIZE, 111,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(87, 87, 87))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3)
                    .addGap(49, 49, 49))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textSource, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(text_depart, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28,
                    Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
    );

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][]{

        },
        new String[]{
            "Flight No", "Flight Name", "Source", "Departure", "Date", "DepTime", "ArrTime",
            "Charge"
        }
    ));
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        ticketTableClickedAction(evt);
      }
    });
    jScrollPane1.setViewportView(jTable1);

    jLabel3.setText("Ticket No");

    textTicketNumber.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    textTicketNumber.setForeground(new java.awt.Color(255, 0, 0));
    textTicketNumber.setText("Ticket NO");

    jLabel5.setText("Customer ID");

    jLabel6.setText("FirstName");

    jLabel7.setText("LastName");

    jLabel8.setText("Passportno");

    textFirstName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    textFirstName.setForeground(new java.awt.Color(255, 0, 0));
    textFirstName.setText("jLabel9");

    textLastName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    textLastName.setForeground(new java.awt.Color(255, 0, 0));
    textLastName.setText("jLabel10");

    textPassport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    textPassport.setForeground(new java.awt.Color(255, 0, 0));
    textPassport.setText("jLabel11");

    jButton4.setText("Search");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitPassportInfotoDBAction(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(34, 34, 34)
                            .addComponent(textCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE,
                                151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15,
                                Short.MAX_VALUE)
                            .addComponent(jButton4))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGap(56, 56, 56)
                            .addGroup(jPanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textPassport)
                                .addComponent(textLastName)
                                .addComponent(textFirstName))))
                .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(textCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4))
                .addGap(26, 26, 26)
                .addGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(textFirstName))
                .addGap(31, 31, 31)
                .addGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(textLastName))
                .addGap(36, 36, 36)
                .addGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(textPassport))
                .addContainerGap(37, Short.MAX_VALUE))
    );

    jLabel12.setText("Flight no");

    jLabel13.setText("Filght Name");

    jLabel14.setText("Depart Time");

    jLabel15.setText("Class");

    jLabel16.setText("Price");

    jLabel17.setText("Seats");

    flightNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    flightNumber.setForeground(new java.awt.Color(255, 0, 0));
    flightNumber.setText("jLabel18");

    flightName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    flightName.setForeground(new java.awt.Color(255, 0, 0));
    flightName.setText("jLabel19");

    textDepart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    textDepart.setForeground(new java.awt.Color(255, 0, 0));
    textDepart.setText("jLabel20");

    txtclass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Economy", "Business"}));

    textSeats.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        try {
          textSeatChangedAction(evt);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(35, 35, 35)))
                .addGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(flightName)
                                .addComponent(textDepart)
                                .addComponent(flightNumber)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                    false)
                                .addComponent(txtclass, 0, 116, Short.MAX_VALUE)
                                .addComponent(textPrice)
                                .addComponent(textSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                                    javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(151, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(flightNumber))
                .addGap(28, 28, 28)
                .addGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(flightName))
                .addGap(31, 31, 31)
                .addGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(textDepart))
                .addGap(23, 23, 23)
                .addGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txtclass, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(textPrice, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel17)
                        .addComponent(textSeats, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    bookButton.setText("Book");
    bookButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitButtonAction(evt);
      }
    });

    cancelButton.setText("Cancel");
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    textTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    textTotal.setForeground(new java.awt.Color(255, 0, 0));
    textTotal.setText("jLabel4");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textTicketNumber)))
                        .addGap(41, 41, 41)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                    534, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(207, 207, 207)
                                    .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(bookButton,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 138,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cancelButton,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 134,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(textTicketNumber))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bookButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                    41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                    41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    text_depart.setName("Depart");
    textSource.setName("Source");
    jButton3.setName("SearchFlight");
    jTable1.setName("Table");
    textCustomerId.setName("CustomerID");
    jButton4.setName("SearchCustomer");
    txtclass.setName("Class");
    textSeats.setName("Seats");
    cancelButton.setName("Cancel");
    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void submitTicketToDBAction(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    String source = textSource.getSelectedItem().toString().trim();
    String depart = text_depart.getSelectedItem().toString().trim();
    ArrayList<Vector> flights = getFlightsFromDB(source, depart);
    DefaultTableModel Df = (DefaultTableModel) jTable1.getModel();
    Df.setRowCount(0);
    flights.stream().forEach(i -> Df.addRow(i));

  }//GEN-LAST:event_jButton3ActionPerformed

  //gets list of flights from DB, based on source and departure locations
  public ArrayList<Vector> getFlightsFromDB(String source, String depart) {
    ArrayList<Vector> flights = new ArrayList<>();
    try {
      con = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/airline", "airlineManager", "123");
      pst = con.prepareStatement("SELECT * from flight WHERE source = ? and depart = ?");
      pst.setString(1, source);
      pst.setString(2, depart);
      ResultSet rs = pst.executeQuery();
//seems like useless code
//      ResultSetMetaData rsm = rs.getMetaData();
//      int c;
//      c = rsm.getColumnCount();

      while (rs.next()) {
        Vector v2 = new Vector();

//        for (int i = 1; i <= c; i++) {
        v2.add(rs.getString("id"));
        v2.add(rs.getString("flightname"));
        v2.add(rs.getString("source"));
        v2.add(rs.getString("depart"));
        v2.add(rs.getString("date"));
        v2.add(rs.getString("deptime"));
        v2.add(rs.getString("arrtime"));
        v2.add(rs.getString("flightcharge"));
//        }
        flights.add(v2);
      }
    } catch (SQLException ex) {
      Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
    }
    return flights;
  }

  public void autoID() {
    try {
      con = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/airline", "airlineManager", "123");
      Statement s = con.createStatement();
      ResultSet rs = s.executeQuery("select MAX(id) from ticket");
      rs.next();
      rs.getString("MAX(id)");
      if (rs.getString("MAX(id)") == null) {
        textTicketNumber.setText("TO001");
      } else {
        long id = Long
            .parseLong(rs.getString("MAX(id)").substring(2, rs.getString("MAX(id)").length()));
        id++;
        textTicketNumber.setText("TO" + String.format("%03d", id));
      }
    } catch (SQLException ex) {
      Logger.getLogger(CustomerAdder.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void submitPassportInfotoDBAction(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    String id = textCustomerId.getText();
    String[] customerInfo = getCustomerInfoFromDB(id);
    textFirstName.setText(customerInfo[0].trim());
    textLastName.setText(customerInfo[1].trim());
    textPassport.setText(customerInfo[2].trim());

  }//GEN-LAST:event_jButton4ActionPerformed

  //gets customer's firstname lastname and passport number from DB
  public String[] getCustomerInfoFromDB(String id) {
    try {
      con = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/airline", "airlineManager", "123");
      pst = con.prepareStatement("select * from customer where id = ?");
      pst.setString(1, id);
      ResultSet rs = pst.executeQuery();

      if (rs.next() == false) {
        JOptionPane.showMessageDialog(this, "Record not Found");
      } else {
        String[] customerInfo = {rs.getString("firstname"), rs.getString("lastname"),
            rs.getString("passport")};
        return customerInfo;
      }
    } catch (SQLException ex) {
      Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  private void ticketTableClickedAction(
      java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    DefaultTableModel Df = (DefaultTableModel) jTable1.getModel();

    int selectIndex = jTable1.getSelectedRow();

    flightNumber.setText(Df.getValueAt(selectIndex, 0).toString());
    flightName.setText(Df.getValueAt(selectIndex, 1).toString());
    textDepart.setText(Df.getValueAt(selectIndex, 5).toString());
    textPrice.setText(Df.getValueAt(selectIndex, 7).toString());
  }//GEN-LAST:event_jTable1MouseClicked

  private void textSeatChangedAction(
      javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtseatsStateChanged

    int price = Integer.parseInt(textPrice.getText());
    int qty = Integer.parseInt(textSeats.getValue().toString());
    try {
      textTotal.setText(String.valueOf(calculateCost(price, qty)));
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "<html><div color=red>Price or Seats Invalid", "Error",
          JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_txtseatsStateChanged

  //handling for textSeatChangedAction
  public int calculateCost(int price, int quantity) throws Exception {
    int total;
    if (price <= 0) {
      throw new Exception("PRICE <= 0 -> " + price);
    }
    if (quantity < 0) {
      throw new Exception("QUANTITY < 0 ->" + quantity);
    }
    total = price * quantity;
    return total;
  }

  public void submitButtonAction(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    String textId = textTicketNumber.getText();
    String flightId = flightNumber.getText();
    String customerId = textCustomerId.getText();
    String flightClass = txtclass.getSelectedItem().toString().trim();
    String price = textPrice.getText();
    String seats = textSeats.getValue().toString();
    JCalendar textDateOfBirth = new JCalendar();
    DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
    String date = da.format(textDateOfBirth.getDate());

    //Input handling
    boolean validInput = true;
    try {
      testInputForTickets(textId, flightId, customerId, flightClass, price, seats, date);
    } catch (Exception e) {
      validInput = false;
    }
    //if input valid, insert into DB
    if (validInput && addTicketToDB(textId, flightId, customerId, flightClass, price, seats,
        date)) {
      JOptionPane.showMessageDialog(null, "Ticket Booked.........");
    } else {
      JOptionPane.showMessageDialog(null, "<html><div color=red>Invalid Inputs", "Error",
          JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_jButton1ActionPerformed

  //handling for submitting a purchased ticket to DB
  public void testInputForTickets(String textId, String flightId, String customerId,
      String flightClass, String price, String seats, String date) throws Exception {
    String textIdPattern = "([T][O][0-9]*)";
    String flightIdPattern = "([F][O][0-9]*)";
    String customerIdPattern = "(([C][S][0-9]*))";
    String datePattern = "(^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$)";

    if (!textId.matches(textIdPattern)) {
      throw new Exception("BAD TICKET ID ->" + textId);
    }
    if (!flightId.matches(flightIdPattern)) {
      throw new Exception("BAD FLIGHT ID ->" + flightId);
    }
    if (!customerId.matches(customerIdPattern)) {
      throw new Exception("BAD CUSTOMER ID ->" + customerId);
    }
    if (!(flightClass.equals("Economy") || flightClass.equals("Business"))) {
      throw new Exception("BAD FLIGHT CLASS ->" + flightClass);
    }
    if (Integer.parseInt(price) <= 0) {
      throw new Exception("BAD PRICE ->" + price);
    }
    if (Integer.parseInt(seats) <= 0) {
      throw new Exception("BAD SEATS ->" + seats);
    }
    if (!date.matches(datePattern)) {
      throw new Exception("BAD DATE ->" + date);
    }
  }

  //adds purchased ticket to DB
  public boolean addTicketToDB(String textId, String flightId, String customerId,
      String flightClass, String price, String seats, String date) {
    try {
      con = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/airline", "airlineManager", "123");
      pst = con.prepareStatement(
          "insert into ticket(id,flightid,custid,class,price,seats,date)values(?,?,?,?,?,?,?)");
      pst.setString(1, textId);
      pst.setString(2, flightId);
      pst.setString(3, customerId);
      pst.setString(4, flightClass);
      pst.setString(5, price);
      pst.setString(6, seats);
      pst.setString(7, date);
      pst.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(FlightAdder.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
    return true;
  }

  private void jButton2ActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    this.hide();
  }//GEN-LAST:event_jButton2ActionPerformed

  //<editor-fold desc="SWING Variables Declarations">
  private javax.swing.JLabel flightName;
  private javax.swing.JLabel flightNumber;
  private javax.swing.JButton bookButton;
  private javax.swing.JButton cancelButton;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel17;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JComboBox<String> txtclass;
  private javax.swing.JTextField textCustomerId;
  private javax.swing.JComboBox<String> text_depart;
  private javax.swing.JLabel textDepart;
  private javax.swing.JLabel textFirstName;
  private javax.swing.JLabel textLastName;
  private javax.swing.JLabel textPassport;
  private javax.swing.JTextField textPrice;
  private javax.swing.JSpinner textSeats;
  private javax.swing.JComboBox<String> textSource;
  private javax.swing.JLabel textTicketNumber;
  private javax.swing.JLabel textTotal;
  //</editor-fold>

  public void setTextTicketNumber(String textTicketNumber) {
    this.textTicketNumber.setText(textTicketNumber);
  }

  public void setTxtclass(String txtclass) {
    this.txtclass.setSelectedItem(txtclass);
  }

  public void setTextCustomerId(String textCustomerId) {
    this.textCustomerId.setText(textCustomerId);
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber.setText(flightNumber);
  }

  public void setTextPrice(String textPrice) {
    this.textPrice.setText(textPrice);
  }

  public void setTextSeats(String textSeats) {
    this.textSeats.setValue(Integer.parseInt(textSeats));
  }
}