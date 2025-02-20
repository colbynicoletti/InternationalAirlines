import com.toedter.calendar.JCalendar;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class CustomerSearch extends javax.swing.JInternalFrame {

  /**
   * Creates new form addCustomer
   */
  public CustomerSearch() {
    initComponents();
  }

  Connection con;
  PreparedStatement pst;

  JFileChooser picchooser;
  String path = null;
  byte[] userimage = null;


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
    txtlastname = new javax.swing.JTextField();
    txtfirstname = new javax.swing.JTextField();
    txtnic = new javax.swing.JTextField();
    txtpassport = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    txtaddress = new javax.swing.JTextArea();
    jLabel6 = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    r1 = new javax.swing.JRadioButton();
    r2 = new javax.swing.JRadioButton();
    txtcontact = new javax.swing.JTextField();
    txtphoto = new javax.swing.JLabel();
    txtdob = new com.toedter.calendar.JDateChooser();
    browseButton = new javax.swing.JButton();
    updateButton = new javax.swing.JButton();
    cancelButton = new javax.swing.JButton();
    txtcustid = new javax.swing.JTextField();
    findButton = new javax.swing.JButton();

    jPanel1.setBackground(new java.awt.Color(51, 0, 255));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("FirstName");

    jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("LastName");

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Nic No");

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("Passport ID");

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 255, 255));
    jLabel5.setText("Address");

    txtlastname.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtlastnameActionPerformed(evt);
      }
    });

    txtpassport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtpassportActionPerformed(evt);
      }
    });

    txtaddress.setColumns(20);
    txtaddress.setRows(5);
    jScrollPane1.setViewportView(txtaddress);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                    false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(47, 47, 47)
                                    .addComponent(txtfirstname))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1)
                                        .addComponent(txtpassport)
                                        .addComponent(txtnic))))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(48, 48, 48)
                            .addComponent(txtlastname, javax.swing.GroupLayout.PREFERRED_SIZE, 166,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtfirstname, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtlastname, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtnic, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtpassport, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
    );

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel6.setText("Customer ID");

    jPanel2.setBackground(new java.awt.Color(51, 0, 255));

    jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("Date of Birth");

    jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setText("Gender");

    jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 255, 255));
    jLabel10.setText("Contact");

    r1.setText("Male");

    r2.setText("Female");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(txtdob, javax.swing.GroupLayout.DEFAULT_SIZE, 100,
                            Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10))
                            .addGap(43, 43, 43)
                            .addGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                    false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(r1)
                                    .addGap(18, 18, 18)
                                    .addComponent(r2))
                                .addComponent(txtcontact))))
                .addContainerGap(41, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel8)
                .addComponent(txtdob, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(r1)
                        .addComponent(r2))
                .addGap(18, 18, 18)
                .addGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtcontact, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
    );

    txtphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    browseButton.setText("Browse");
    browseButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        browseButtonClick(evt);
      }
    });

    updateButton.setText("Update");
    updateButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        try {
          updateButtonClick(evt);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

    cancelButton.setText("Cancel");
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelButtonClick(evt);
      }
    });

    findButton.setText("Find");
    findButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        findButtonClick(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLabel6)
                            .addGap(29, 29, 29)
                            .addComponent(txtcustid, javax.swing.GroupLayout.PREFERRED_SIZE, 147,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtphoto, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(337, 337, 337)
                                    .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                            javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
                            javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcustid, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findButton))
                .addGap(38, 38, 38)
                .addGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                    false)
                                .addComponent(txtphoto, javax.swing.GroupLayout.DEFAULT_SIZE, 250,
                                    Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                    javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49))
    );

    findButton.setName("FindButton");
    txtcustid.setName("CustomerIDTF");
    cancelButton.setName("Cancel");
    pack();
  }// </editor-fold>//GEN-END:initComponents


  private void txtlastnameActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlastnameActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txtlastnameActionPerformed

  private void txtpassportActionPerformed(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassportActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txtpassportActionPerformed

  public void browseButtonClick(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:

    picchooser = new JFileChooser();
    picchooser.showOpenDialog(null);
    File pic = picchooser.getSelectedFile();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "png", "jpg");
    picchooser.addChoosableFileFilter(filter);
    path = pic.getAbsolutePath();
    try {
      testPic(path);
    } catch (IOException | NullPointerException e) {
      JOptionPane.showMessageDialog(null, "<html><div color=red>Invalid Picture", "Error",
          JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_jButton1ActionPerformed

  public void testPic(String path) throws IOException {
      BufferedImage img;
      img = ImageIO.read(picchooser.getSelectedFile());
      ImageIcon imageIcon = new ImageIcon(new
          ImageIcon(img).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
      txtphoto.setIcon(imageIcon);

      File image = new File(path);
      FileInputStream fis = new FileInputStream(image);
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      byte[] buff = new byte[1024];
      for (int readNum; (readNum = fis.read(buff)) != -1; ) {
        baos.write(buff, 0, readNum);
      }
      userimage = baos.toByteArray();

  }

  public void updateButtonClick(
      java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:

    //REGEX Pattern - not finished
    String firstNamePattern = "[A-Z]+([A-Za-z'\\s\\-])*";
    String lastNamePattern = "[A-Z]+([A-Za-z'\\s\\-])*";
    String nicPattern = "[0-9]{8}";
    String passportPattern = "^[A-PR-WYa-pr-wy][1-9]\\d\\s?\\d{4}[1-9]$";
    String addressPattern = "(\\d+[ ](?:[A-Za-z0-9.-]+[ ]?)+(?:Avenue|Lane|Road|Boulevard|Drive|Street|Ave|Dr|Rd|Blvd|Ln|St)\\.?)";
    //String datePattern = "([12]\\d{3}\\/(0[1-9]|1[0-2])\\/(0[1-9]|[12]\\d|3[01]))";

    String id = txtcustid.getText();


    String firstname = txtfirstname.getText();
    if (!firstname.matches(firstNamePattern)) {
      throw new Exception("BAD FIRSTNAME ->" + firstname);
    }
    String lastname = txtlastname.getText();
    if (!lastname.matches(lastNamePattern)) {
      throw new Exception("BAD LASTNAME ->" + lastname);
    }
    String nic = txtnic.getText();
    if (!nic.matches(nicPattern)) {
      throw new Exception("BAD NIC ->" + nic);
    }
    String passport = txtpassport.getText();
    if (!passport.matches(passportPattern)) {
      throw new Exception("BAD PASSPORT ->" + passport);
    }
    String address = txtaddress.getText();
    if (!address.matches(addressPattern)) {
      throw new Exception("BAD ADDRESS ->" + address);
    }

    JCalendar txtdob = new JCalendar();
    DateFormat da = new SimpleDateFormat("yyyy-MM-dd");

    String date = da.format(txtdob.getDate());
    String Gender;



    //Exception Handles
    if (r1.isSelected()) {
      Gender = "Male";
    } else {
      Gender = "Female";
    }

    String contact = txtcontact.getText();

    try {
      con = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/airline", "airlineManager", "123");
      pst = con.prepareStatement(
          "update customer set firstname = ?,lastname = ?,nic = ?,passport = ?,address= ?,dob = ?,gender = ?,contact = ?,photo = ? where id = ?");

      pst.setString(1, firstname);
      pst.setString(2, lastname);
      pst.setString(3, nic);
      pst.setString(4, passport);
      pst.setString(5, address);
      pst.setString(6, date);
      pst.setString(7, Gender);
      pst.setString(8, contact);
      pst.setBytes(9, userimage);
      pst.setString(10, id);
      pst.executeUpdate();

      JOptionPane.showMessageDialog(null, "Registation Updateddddd.........");

//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(CustomerAdder.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(CustomerAdder.class.getName()).log(Level.SEVERE, null, ex);
    }


  }//GEN-LAST:event_jButton2ActionPerformed

  private void cancelButtonClick(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here:

    this.hide();
  }//GEN-LAST:event_jButton3ActionPerformed

  private void findButtonClick(
      java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    // TODO add your handling code here:

    String id = txtcustid.getText();

    try {
      con = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/airline", "airlineManager", "123");
      pst = con.prepareStatement("select * from customer where id = ?");
      pst.setString(1, id);
      ResultSet rs = pst.executeQuery();

      if (rs.next() == false) {
        JOptionPane.showMessageDialog(this, "Record not Found");
      } else {
        String fname = rs.getString("firstname");
        String lname = rs.getString("lastname");
        String nic = rs.getString("nic");
        String passport = rs.getString("passport");

        String address = rs.getString("address");
        String dob = rs.getString("dob");
        Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse(dob);
        String gender = rs.getString("gender");

        Blob blob = rs.getBlob("photo");
        byte[] _imagebytes = blob.getBytes(1, (int) blob.length());
        ImageIcon image = new ImageIcon(_imagebytes);
        Image im = image.getImage();
        Image myImg = im
            .getScaledInstance(txtphoto.getWidth(), txtphoto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);

        if (gender.equals("Female")) {
          r1.setSelected(false);
          r2.setSelected(true);

        } else {
          r1.setSelected(true);
          r2.setSelected(false);
        }
        String contact = rs.getString("contact");

        txtfirstname.setText(fname.trim());
        txtlastname.setText(lname.trim());
        txtnic.setText(nic.trim());
        txtpassport.setText(passport.trim());
        txtaddress.setText(address.trim());
        txtcontact.setText(contact.trim());
        txtdob.setDate(date1);
        txtphoto.setIcon(newImage);
      }
    } catch (SQLException ex) {
      Logger.getLogger(CustomerSearch.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
      Logger.getLogger(CustomerSearch.class.getName()).log(Level.SEVERE, null, ex);
    }


  }//GEN-LAST:event_jButton4ActionPerformed

  //<editor-fold desc="SWING Variables Declarations">
  private javax.swing.JButton browseButton;
  private javax.swing.JButton updateButton;
  private javax.swing.JButton cancelButton;
  private javax.swing.JButton findButton;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JRadioButton r1;
  private javax.swing.JRadioButton r2;
  private javax.swing.JTextArea txtaddress;
  private javax.swing.JTextField txtcontact;
  private javax.swing.JTextField txtcustid;
  private javax.swing.JTextField txtfirstname;
  private javax.swing.JTextField txtlastname;
  private javax.swing.JTextField txtnic;
  private javax.swing.JTextField txtpassport;
  private javax.swing.JLabel txtphoto;
  private com.toedter.calendar.JDateChooser txtdob;
  //</editor-fold>

  public void setTxtfirstName(JTextField txtfirstname) {
    this.txtfirstname = txtfirstname;
  }

  public void setTxtlastName(JTextField txtlastname) {
    this.txtlastname = txtlastname;
  }

  public void setTxtNic(JTextField txtnic) {
    this.txtnic = txtnic;
  }

  public void setTxtPassport(JTextField txtPassport) { this.txtpassport = txtpassport; }

  public void setTxtAddress(JTextField txtAddress) {
    this.txtaddress = txtaddress;
  }

}
