package sithole.thobane;
     /**
     * @author Sithole Thobane
     */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import sithole.thobane.gymlibrary.Member;

public class GymMembershipFrame extends JFrame{
    
    //Panels
    private JPanel headingPnl;
    private JPanel clientPnl;
    private JPanel namePnl;
    private JPanel surnamePnl;
    private JPanel idNoPnl;
    private JPanel genderPnl;
    private JPanel contractsPnl;
    private JPanel personalTrainerOptionPnl;
    private JPanel membershipPnl;
    private JPanel commentsPnl;
    private JPanel headingClientsCombinedPnl;
    private JPanel membershipCommentsCombinedPnl;
    private JPanel mainPnl;
    
    //Labels
    private JLabel headingLbl;
    private JLabel nameLbl;
    private JLabel surnameLbl;
    private JLabel idNoLbl;
    private JLabel genderLbl;
    private JLabel personalTrainerLbl;
    private JLabel contractTypeLbl;
    
    //textfields
    private JTextField nameTxtFld;
    private JTextField surnameTxtFld;
    private JTextField idNoTxtFld;
    
    //comboBox
    private JComboBox genderComboBox;
    
    //radio buttons
    private JRadioButton monthToMonthRagBtn;
    private JRadioButton sixMonthsRadBtn;
    private JRadioButton annualRadBtn;
    
    //checkBox
    private JCheckBox personalTrainerChkBx;
    
    //buttonGroup
    private ButtonGroup btnGrp;
    
    //textArea
    private JTextArea commentsArea;
    
    //scroolPane
    private JScrollPane scrollableTxtArea;
    
    private JMenuBar menuBar;
    
    //menuItems
    private JMenuItem openFileMenuItem;
    private JMenuItem viewFileMenuItem;
    private JMenuItem clearMenuItem;
    private JMenuItem exitMenuItem;
    
    //menu
    private JMenu fileMenu;

    public GymMembershipFrame() {
        //set the frame
        
        setTitle("Gym membership");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        //menu bar
        menuBar = new JMenuBar();
        
        //menu
        fileMenu = new JMenu("File");
        
        //menu items
        openFileMenuItem = new JMenuItem("Register Member...");
        openFileMenuItem.addActionListener(new RegisterBtnListener());
        
        viewFileMenuItem = new JMenuItem("Display members...");
        viewFileMenuItem.addActionListener(new DisplayBtnListener());
        
        clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.addActionListener(new ClearBtnListener());
        
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ExitBtnListener());

        //add items to the file menu
        fileMenu.add(openFileMenuItem);
        fileMenu.add(viewFileMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(clearMenuItem);
        fileMenu.add(exitMenuItem);
        
        menuBar.add(fileMenu);
        
        //create panels
        headingPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        clientPnl = new JPanel(new GridLayout(4,1,1,1));
        clientPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1), "Client details"));
        
        namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnamePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idNoPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        contractsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        personalTrainerOptionPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        membershipPnl = new JPanel(new GridLayout(2,1,1,1));
        membershipPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1), "Contract option"));
        
        commentsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        headingClientsCombinedPnl = new JPanel(new BorderLayout());
        membershipCommentsCombinedPnl = new JPanel(new BorderLayout());
        mainPnl = new JPanel(new BorderLayout());
        
        //create labels
        headingLbl = new JLabel("Membership Form");
        headingLbl.setFont(new Font(Font.SANS_SERIF, Font.ITALIC + Font.BOLD, 20));
        headingLbl.setForeground(Color.BLUE);
        headingLbl.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        
        nameLbl = new JLabel("Name:         ");
        surnameLbl = new JLabel("Surname:   ");
        idNoLbl = new JLabel("ID no:            ");
        genderLbl = new JLabel("Gender:        ");
        contractTypeLbl = new JLabel("Type of contract: ");
        personalTrainerLbl = new JLabel("Select the checkbox if you need the personal trainer ");
        
        //create textfields
        nameTxtFld = new JTextField(10);
        surnameTxtFld = new JTextField(10);
        idNoTxtFld = new JTextField(10);
        
        //create combobox
        genderComboBox = new JComboBox();
        genderComboBox.addItem("Male");
        genderComboBox.addItem("Female");
        
        //create radio buttons
        monthToMonthRagBtn = new JRadioButton("Month-to-month");
        sixMonthsRadBtn = new JRadioButton("Six months");
        annualRadBtn = new JRadioButton("Annual");
        
        //create checkbox
        personalTrainerChkBx = new JCheckBox();
        
        //create buttongroup
        btnGrp = new ButtonGroup();
        btnGrp.add(monthToMonthRagBtn);
        btnGrp.add(sixMonthsRadBtn);
        btnGrp.add(annualRadBtn);
        
        //create textArea
        
        commentsArea = new JTextArea(15, 50);
        commentsArea.setEditable(false);
        commentsArea.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1), "Member(s) details"));
        
        scrollableTxtArea = new JScrollPane(commentsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //add components to panels
        headingPnl.add(headingLbl);
        
        namePnl.add(nameLbl);
        namePnl.add(nameTxtFld);
        
        surnamePnl.add(surnameLbl);
        surnamePnl.add(surnameTxtFld);
        
        idNoPnl.add(idNoLbl);
        idNoPnl.add(idNoTxtFld);
        
        genderPnl.add(genderLbl);
        genderPnl.add(genderComboBox);
        
        clientPnl.add(namePnl);
        clientPnl.add(surnamePnl);
        clientPnl.add(idNoPnl);
        clientPnl.add(genderPnl);
        
        headingClientsCombinedPnl.add(headingPnl, BorderLayout.NORTH);
        headingClientsCombinedPnl.add(clientPnl, BorderLayout.CENTER);
        
        contractsPnl.add(contractTypeLbl);
        contractsPnl.add(monthToMonthRagBtn);
        contractsPnl.add(sixMonthsRadBtn);
        contractsPnl.add(annualRadBtn);
        
        personalTrainerOptionPnl.add(personalTrainerLbl);
        personalTrainerOptionPnl.add(personalTrainerChkBx);
        
        membershipPnl.add(contractsPnl);
        membershipPnl.add(personalTrainerOptionPnl);
        
        commentsPnl.add(scrollableTxtArea);
        
        membershipCommentsCombinedPnl.add(membershipPnl, BorderLayout.NORTH);
        membershipCommentsCombinedPnl.add(commentsPnl, BorderLayout.CENTER);
        
        
        mainPnl.add(headingClientsCombinedPnl, BorderLayout.NORTH);
        mainPnl.add(membershipCommentsCombinedPnl, BorderLayout.CENTER);
        
        add(mainPnl);
        
        pack();
        
        setResizable(false);
        
        // set menu bar
        setJMenuBar(menuBar);
        
        setVisible(true);
    }
    
    //helper method for clearing fields
    private void clearFields(){
        // clear the fields
        nameTxtFld.setText("");
        surnameTxtFld.setText("");
        idNoTxtFld.setText("");
        personalTrainerChkBx.setSelected(false);
        btnGrp.clearSelection();
        commentsArea.setText("");
        
        //set focus back to the name text field
        nameTxtFld.setFocusable(true);
        
    }
    
    private class RegisterBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name, surname, idNo, gender, contractType;
            Boolean isPersonalTrainerSelected;
            Member member;
            JFileChooser fc;
            int val;
            File file;
            BufferedWriter bw;
            
            //read data from the fields
            name = nameTxtFld.getText();
            surname = surnameTxtFld.getText();
            idNo = idNoTxtFld.getText();
            //cast to String
            gender = (String)genderComboBox.getSelectedItem();
            isPersonalTrainerSelected = personalTrainerChkBx.isSelected();
            contractType = "Month-to-month";
            
            if(sixMonthsRadBtn.isSelected()){
                contractType = "Six months";
            }else{
                if(annualRadBtn.isSelected()){
                    contractType = "Annual";
                }
            }
            
            // create a member
            member = new Member(name, surname, idNo, gender, contractType, isPersonalTrainerSelected);
            
            fc = new JFileChooser();
            
            //open the save dialog
            val = fc.showSaveDialog(GymMembershipFrame.this);
            
            if(val == JFileChooser.APPROVE_OPTION){
                
                try{
                    // get the selected file
                    file = fc.getSelectedFile();
                    
                    //Write to the file
                    bw = new BufferedWriter(new FileWriter(file,true));
                    
                    //write the member to the file
                    bw.write(member.toString());
                    
                    //add a space after writing to the file
                    bw.newLine();
                    
                    //close the buffered writer after writing to the file
                    bw.close();
                    
                    //clear all fields to get new member
                    clearFields();
                    
                    //confirmation dialog
                    JOptionPane.showMessageDialog(GymMembershipFrame.this, "Member registered");
                    
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }else {
                JOptionPane.showMessageDialog(GymMembershipFrame.this, "If statement fails. The returned value is " + val);
            }
        }
        
    }
    
    private class DisplayBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            //declare local variables
            
            BufferedReader br;
            String data, record = "";
            JFileChooser fc;
            int val;
            File file;
            
            //create a file chooser
            fc = new JFileChooser();
            
            //open a file dialog
            val = fc.showOpenDialog(GymMembershipFrame.this);
            
            if(val == JFileChooser.APPROVE_OPTION){
                try{
                    //get the selected file
                    file = fc.getSelectedFile();
                    
                    //open reading stream
                    br = new BufferedReader(new FileReader(file));
                    
                    //read the file until the end of the file
                    while((data = br.readLine()) != null){
                        //concatenate the text from the file
                        record = record + data + "\n";
                    }
                    
                    //close the reading stream
                    br.close();
                    
                    //write the data to the text area
                    commentsArea.setText(record);
                    
                    
                    
                }catch(FileNotFoundException ex){
                    ex.printStackTrace();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    
    private class ClearBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            clearFields();
        }
        
    }
    
    private class ExitBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    }
}
