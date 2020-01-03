package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Data.UserDatabase;
import User.Account;
import User.CurrentAccount;
import User.SavingsAccount;
import User.UserInformation;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class SignUpWindow extends JFrame implements ActionListener
{
		
	    UserDatabase db = UserDatabase.getInstance();
		
		JTextField firstNameT = new JTextField("",20);
		JTextField lastNameT = new JTextField("",20);
		JTextField email = new JTextField("",20);
		JTextField phoneNo = new JTextField("",20);
		JTextField NID = new JTextField("",20);
		JTextField address = new JTextField("",20);
		JTextField occupation = new JTextField("",20);

		JRadioButton maleB  = new JRadioButton("Male");
		JRadioButton femaleB  = new JRadioButton("Female");
		ButtonGroup bg = new ButtonGroup();
		
		JComboBox<String> accountType = new JComboBox<String>();
		JComboBox<Integer> day = new JComboBox<Integer>();
		JComboBox<Integer> month = new JComboBox<Integer>();
		JComboBox<Integer> year = new JComboBox<Integer>();
		
		JPanel jp = new JPanel();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		JPanel jp7 = new JPanel();
		JPanel jp8 = new JPanel();
		JPanel jp9 = new JPanel();
		JPanel jp10 = new JPanel();
		
		JButton backB= new JButton("Back");
		JButton signUpB = new JButton("Create Account");
		
		public SignUpWindow()
		{   
			setTitle("Bank Management System");
			setForeground(new Color(0, 139, 139));
			setBackground(new Color(0, 128, 128));
			this.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we)
				{
					db.saveData();
					System.exit(0);
				}
			});
			this.setSize(600, 550);
		    this.setVisible(true);
		    this.setResizable(true);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    jp.setBackground(new Color(0, 139, 139));
		    getContentPane().setLayout(new GridLayout(1, 2, 10,0));
		    getContentPane().add(jp);
		    
		    jp.setLayout(new GridLayout(0, 1,10,20));
		    JLabel lblUserAccountSign = new JLabel("Sign Up", JLabel.CENTER);
		    lblUserAccountSign.setForeground(Color.WHITE);
		    lblUserAccountSign.setFont(new Font("Cambria", Font.BOLD, 18));
		    jp.add(lblUserAccountSign);
		    accountType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    accountType.setBackground(Color.WHITE);
		    
		    accountType.addItem("Savings Account");
		    accountType.addItem("Current Account");
		    jp.add(accountType);
		    jp1.setBackground(new Color(0, 139, 139));
		    
		    jp.add(jp1);
		    jp1.setLayout(new GridLayout(0, 2,5,0));
		    JLabel label_1 = new JLabel("First name", JLabel.CENTER);
		    label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    label_1.setForeground(Color.WHITE);
		    jp1.add(label_1);
		    jp1.add(firstNameT);
		    jp9.setBackground(new Color(0, 139, 139));
		    jp.add(jp9);
		    jp9.setLayout(new GridLayout(0, 2,5,0));
		    JLabel label_2 = new JLabel("Last name", JLabel.CENTER);
		    label_2.setForeground(Color.WHITE);
		    label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    jp9.add(label_2);
		    jp9.add(lastNameT);
		    jp2.setBackground(new Color(0, 139, 139));
		    
		    
		    jp.add(jp2);
		    JLabel label_3 = new JLabel("Gender", JLabel.LEFT);
		    label_3.setForeground(Color.WHITE);
		    label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    jp2.add(label_3);
		    bg.add(maleB);
		    bg.add(femaleB);
		    maleB.setForeground(Color.WHITE);
		    maleB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    maleB.setBackground(new Color(0, 139, 139));
		    jp2.add(maleB);
		    femaleB.setForeground(Color.WHITE);
		    femaleB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    femaleB.setBackground(new Color(0, 139, 139));
		    jp2.add(femaleB);
		    jp3.setForeground(Color.WHITE);
		    jp3.setBackground(new Color(0, 139, 139));
		    
		    jp.add(jp3);
		    generateDate();
		    JLabel label_4 = new JLabel("Birth Date: ");
		    label_4.setForeground(Color.WHITE);
		    label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    jp3.add(label_4);
		    day.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    day.setBackground(Color.WHITE);
		    jp3.add(day);
		    month.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    month.setBackground(Color.WHITE);
		    jp3.add(month);
		    year.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    year.setBackground(Color.WHITE);
		    jp3.add(year);
		    jp4.setBackground(new Color(0, 139, 139));

		    jp.add(jp4);
		    jp4.setLayout(new GridLayout(0, 2,5,0));
		    JLabel label = new JLabel("E-Mail: ", JLabel.CENTER);
		    label.setForeground(Color.WHITE);
		    label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    label.setBackground(new Color(143, 188, 143));
		    jp4.add(label);
		    email.setHorizontalAlignment(SwingConstants.CENTER);
		    jp4.add(email);
		    jp5.setBackground(new Color(0, 139, 139));
		    
		    jp.add(jp5);
		    jp5.setLayout(new GridLayout(0, 2,5,0));
		    JLabel label_5 = new JLabel("Phone No: ", JLabel.CENTER);
		    label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    label_5.setForeground(Color.WHITE);
		    jp5.add(label_5);
		    jp5.add(phoneNo);
		    jp6.setBackground(new Color(0, 139, 139));
		    
		    jp.add(jp6);
		    jp6.setLayout(new GridLayout(0, 2,5,0));
		    JLabel label_6 = new JLabel("NID No: ", JLabel.CENTER);
		    label_6.setForeground(Color.WHITE);
		    label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    jp6.add(label_6);
		    jp6.add(NID);
		    jp7.setBackground(new Color(0, 139, 139));
		    
		    jp.add(jp7);
		    jp7.setLayout(new GridLayout(0, 2,5,0));
		    JLabel label_7 = new JLabel("Occupation: ", JLabel.CENTER);
		    label_7.setForeground(Color.WHITE);
		    label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    jp7.add(label_7);
		    jp7.add(occupation);
		    
		    jp.add(jp8);
		    jp8.setLayout(new GridLayout(0, 2,5,0));
		    jp8.setBackground(new Color(0, 139, 139));
		    JLabel lblAddress = new JLabel("Address", JLabel.CENTER);
		    lblAddress.setForeground(Color.WHITE);
		    lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    jp8.add(lblAddress);
		    jp8.add(address);
		    jp10.setBackground(new Color(0, 139, 139));
		    
		    jp.add(jp10);
		    jp10.setLayout(new GridLayout(0, 2, 5,0));
		    backB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    backB.setForeground(Color.LIGHT_GRAY);
		    backB.setBackground(Color.DARK_GRAY);
		    backB.addActionListener(this);
		    jp10.add(backB);
		    signUpB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    signUpB.setForeground(Color.LIGHT_GRAY);
		    signUpB.setBackground(Color.DARK_GRAY);
		    signUpB.addActionListener(this);
		    jp10.add(signUpB);
		}

		void generateDate()
		{
			for(int i=1;i<=31;i++)
			{
				day.addItem(i);
			}
			for(int i=1;i<=12;i++)
			{
				month.addItem(i);
			}
			for(int i=1990;i<=2019;i++)
			{
				year.addItem(i);
			}
		}
		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("Back"))
			{
				this.dispose();
				new LoginWindow();
			}
			else if(e.getActionCommand().equals("Create Account"))
			{
				if(isFormFilled())
				{
					createNewAccount();
					this.dispose();
					new LoginWindow();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please fill up all the fields","Failed", JOptionPane.ERROR_MESSAGE );
				}
			}
		}
		
		boolean isFormFilled()
		{
			if(firstNameT.getText().isEmpty() || lastNameT.getText().isEmpty() 
					|| email.getText().isEmpty() || phoneNo.getText().isEmpty()
					|| NID.getText().isEmpty() || address.getText().isEmpty() || occupation.getText().isEmpty())
			{
				return false;
			}
			if(!maleB.isSelected() && !femaleB.isSelected())
			{
				return false;
			}
			return true;
		}
		
		@SuppressWarnings("deprecation")
		void createNewAccount()
		{
			String sex;
			Date d;
			Account ac;
			
			if(maleB.isSelected())
				sex="male";
			else
				sex="female";
			
			d=new Date((int)year.getSelectedItem(),(int)month.getSelectedItem(),(int)day.getSelectedItem());
			
			UserInformation u= new UserInformation(firstNameT.getText(), lastNameT.getText(), email.getText(),
					phoneNo.getText(), NID.getText(), address.getText(), occupation.getText(), 
					sex, d);
			
			if(accountType.getSelectedItem().equals("Savings Account"))
			{
				ac= new SavingsAccount(u);
				db.addNewAccount(ac);
			}
			else
			{
				ac = new CurrentAccount(u);
				db.addNewAccount(ac);
			}

			JOptionPane.showMessageDialog(null,"Account No:"+ac.getAccuntNo()+"\nPIN:"+ac.getPIN(),"Success", JOptionPane.INFORMATION_MESSAGE );
			
			
			
		}
	}


