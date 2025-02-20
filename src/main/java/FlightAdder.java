import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class FlightAdder extends javax.swing.JInternalFrame {

  /**
   * Creates new form addflight
   */
  public FlightAdder() {
    initComponents();
    autoID();
  }

  Connection con;
  PreparedStatement pst;

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    flightIdLabel = new javax.swing.JLabel();
    textFlightId = new javax.swing.JLabel();
    flightNameLabel = new javax.swing.JLabel();
    sourceLabel = new javax.swing.JLabel();
    departureLabel = new javax.swing.JLabel();
    txtflightname = new javax.swing.JTextField();
    dateLabel = new javax.swing.JLabel();
    txtdate = new com.toedter.calendar.JDateChooser();
    departureTimeLabel = new javax.swing.JLabel();
    txtdtime = new javax.swing.JTextField();
    txtarrtime = new javax.swing.JTextField();
    arrivalTime = new javax.swing.JLabel();
    flightChargeLabel = new javax.swing.JLabel();
    txtflightcharge = new javax.swing.JTextField();
    addButton = new javax.swing.JButton();
    cancelButton = new javax.swing.JButton();
    textSource = new javax.swing.JComboBox<>();
    textDepart = new javax.swing.JComboBox<>();

    jPanel1.setBackground(new java.awt.Color(51, 51, 255));

    flightIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    flightIdLabel.setForeground(new java.awt.Color(255, 255, 255));
    flightIdLabel.setText("Flight ID");

    textFlightId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    textFlightId.setForeground(new java.awt.Color(255, 255, 0));
    textFlightId.setText("jLabel2");

    flightNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    flightNameLabel.setForeground(new java.awt.Color(255, 255, 255));
    flightNameLabel.setText("Flight Name");

    sourceLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    sourceLabel.setForeground(new java.awt.Color(255, 255, 255));
    sourceLabel.setText("Source");

    departureLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    departureLabel.setForeground(new java.awt.Color(255, 255, 255));
    departureLabel.setText("Departure");

    dateLabel.setForeground(new java.awt.Color(255, 255, 255));
    dateLabel.setText("Date");

    departureTimeLabel.setForeground(new java.awt.Color(255, 255, 255));
    departureTimeLabel.setText("Dep Time");

    arrivalTime.setForeground(new java.awt.Color(255, 255, 255));
    arrivalTime.setText("Arr Time");

    flightChargeLabel.setForeground(new java.awt.Color(255, 255, 255));
    flightChargeLabel.setText("Flight Charge");

    addButton.setText("Add");
    addButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        try {
          submitFlightButtonClick(evt);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

    cancelButton.setText("Cancel");
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    textSource.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[]{"India\t", "Srilanka", "Uk", "Usa", "Canada", "Chinna"}));

    textDepart.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[]{"India\t", "Srilanka", "Uk", "Usa", "Canada", "Chinna"}));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(flightIdLabel)
                            .addComponent(flightNameLabel))
                        .addGroup(jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(textFlightId))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(txtflightname, javax.swing.GroupLayout.PREFERRED_SIZE,
                                    136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sourceLabel)
                                .addComponent(departureLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                    false)
                                .addComponent(textSource, 0, 136, Short.MAX_VALUE)
                                .addComponent(textDepart, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                                    Short.MAX_VALUE))))
                .addGap(103, 103, 103)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dateLabel)
                                .addComponent(departureTimeLabel)
                                .addComponent(arrivalTime))
                            .addGap(62, 62, 62)
                            .addGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                    false)
                                .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, 174,
                                    Short.MAX_VALUE)
                                .addComponent(txtdtime)
                                .addComponent(txtarrtime)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(flightChargeLabel)
                            .addGap(52, 52, 52)
                            .addComponent(txtflightcharge, javax.swing.GroupLayout.PREFERRED_SIZE,
                                172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(flightIdLabel)
                            .addComponent(textFlightId)
                            .addComponent(dateLabel))
                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(flightNameLabel)
                        .addComponent(txtflightname, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(departureTimeLabel)
                        .addComponent(txtdtime, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sourceLabel)
                        .addComponent(txtarrtime, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(arrivalTime)
                        .addComponent(textSource, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(departureLabel)
                                .addComponent(textDepart, javax.swing.GroupLayout.PREFERRED_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(flightChargeLabel)
                                .addComponent(txtflightcharge,
                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93,
                    Short.MAX_VALUE)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
    );
    txtflightname.setName("FlightName");
    textSource.setName("Source");
    textDepart.setName("Depart");
    txtdtime.setName("DepTime");
    txtarrtime.setName("ArrTime");
    txtflightcharge.setName("Charge");
    cancelButton.setName("Cancel");
    pack();
  }// </editor-fold>//GEN-END:initComponents

  public void autoID() {
    try {
      con = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/airline", "airlineManager", "123");
      Statement s = con.createStatement();
      ResultSet rs = s.executeQuery("select MAX(id) from flight");
      rs.next();
      rs.getString("MAX(id)");
      if (rs.getString("MAX(id)") == null) {
        textFlightId.setText("FO001");
      } else {
        long id = Long
            .parseLong(rs.getString("MAX(id)").substring(2, rs.getString("MAX(id)").length()));
        id++;
        textFlightId.setText("FO" + String.format("%03d", id));
      }
    } catch (SQLException ex) {
      Logger.getLogger(CustomerAdder.class.getName()).log(Level.SEVERE, null, ex);
    }
  }


  public void submitFlightButtonClick(
      java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
    //REGEX Patterns - not finished
    String flightNamePattern = "[A-Z]+([A-Za-z'\\s\\-])*";
    String sourcePattern = "[A-Z]+([A-Za-z'\\s\\-])*";
    String departPattern = "[A-Z]+([A-Za-z'\\s\\-])*";
    String flightChargePattern = "/^\\$?[0-9]+(\\.[0-9][0-9])?$/";
    String departTimePattern = "^([01]\\d|2[0-3]):?([0-5]\\d)$";
    String arrivalTimePattern = "^([01]\\d|2[0-3]):?([0-5]\\d)$";

    String id = textFlightId.getText();

    String flightName = txtflightname.getText();
    if (!flightName.matches(flightNamePattern)) {
      throw new Exception("BAD FLIGHT NAME ->" + flightName);
    }
    String source = textSource.getSelectedItem().toString().trim();
    if (!source.matches(sourcePattern)) {
      throw new Exception("BAD SOURCE ->" + source);
    }
    String depart = textDepart.getSelectedItem().toString().trim();
    if (!depart.matches(departPattern)) {
      throw new Exception("BAD DEPART ->" + depart);
    }
    DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
    String date = da.format(txtdate.getDate());
    String departTime = txtdtime.getText();
    if (!departTime.matches(departTimePattern)) {
      throw new Exception("BAD DEPART TIME ->" + depart);
    }
    String arrivalTime = txtarrtime.getText();
    if (!arrivalTime.matches(arrivalTimePattern)) {
      throw new Exception("BAD ARRIVAL TIME ->" + arrivalTime);
    }
    String flightCharge = txtflightcharge.getText();
    if (!flightCharge.matches(flightChargePattern)) {
      throw new Exception("BAD FLIGHT CHARGE ->" + flightCharge);
    }

    try {
      con = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/airline", "airlineManager", "123");
      pst = con.prepareStatement(
          "insert into flight(id,flightname,source,depart,date,deptime,arrtime,flightcharge)values(?,?,?,?,?,?,?,?)");

      pst.setString(1, id);
      pst.setString(2, flightName);
      pst.setString(3, source);
      pst.setString(4, depart);
      pst.setString(5, date);
      pst.setString(6, departTime);
      pst.setString(7, arrivalTime);
      pst.setString(8, flightCharge);

      pst.executeUpdate();

      JOptionPane.showMessageDialog(null, "Flight Created.........");
    } catch (SQLException ex) {
      Logger.getLogger(FlightAdder.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:

    this.hide();
  }//GEN-LAST:event_jButton2ActionPerformed

  //<editor-fold desc="SWING Variables Declarations">
  private javax.swing.JButton addButton;
  private javax.swing.JButton cancelButton;
  private javax.swing.JLabel flightIdLabel;
  private javax.swing.JLabel flightNameLabel;
  private javax.swing.JLabel sourceLabel;
  private javax.swing.JLabel departureLabel;
  private javax.swing.JLabel dateLabel;
  private javax.swing.JLabel departureTimeLabel;
  private javax.swing.JLabel arrivalTime;
  private javax.swing.JLabel flightChargeLabel;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField txtarrtime;
  private com.toedter.calendar.JDateChooser txtdate;
  private javax.swing.JComboBox<String> textDepart;
  private javax.swing.JTextField txtdtime;
  private javax.swing.JTextField txtflightcharge;
  private javax.swing.JLabel textFlightId;
  private javax.swing.JTextField txtflightname;
  private javax.swing.JComboBox<String> textSource;
  //</editor-fold>

  public void setTxtflightname(JTextField txtflightname) {
    this.txtflightname = txtflightname;
  }

  public void setTxtflightcharge(JTextField txtflightcharge) {
    this.txtflightcharge = txtflightcharge;
  }

  public void setTextSource(JComboBox<String> textSource) {
    this.textSource = textSource;
  }

  public void setTxtDepart(JComboBox<String> txtDepart) { this.textDepart = textDepart; }

  public void setTxtdtime(JTextField txtdtime) {
    this.txtdtime = txtdtime;
  }

  public void setTxtarrtime(JTextField txtarrtime) { this.txtarrtime = txtarrtime;}

}
