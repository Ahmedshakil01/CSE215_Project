package GUI;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Data.UserDatabase;
import User.Account;

public class AccountWindow extends JFrame implements ActionListener {
	UserDatabase db = UserDatabase.getInstance();
		Account ac;
		
		JLabel welcomeText = new JLabel();
		
		JTextField accountNoT = new JTextField("",20);
		JTextField amountT = new JTextField("",10);
		
		JPasswordField oldP= new JPasswordField("",20);
		JPasswordField newP= new JPasswordField("",20);
		JPasswordField reNewP= new JPasswordField("",20);
		
		JButton transferB= new JButton("Transfer Money");
		JButton withdrawB= new JButton("Withdraw Money");
		JButton depositB= new JButton("Deposit Money");
		JButton balanceB= new JButton("Balance Check");
		JButton payBillB= new JButton("Pay Bill");
		JButton userDetailB= new JButton("User Detail");
		JButton changePinB= new JButton("Change PIN");
		JButton saveB = new JButton("Save");
		JButton logoutB = new JButton("Log Out");
		
		JButton transferSB = new JButton("Transfer");
		JButton withdrawalSB = new JButton("Withdraw");
		JButton depositSB = new JButton("Deposit");
		JButton payBillSB = new JButton("Pay");
		JButton PinB = new JButton("Submit");
		
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();
		JPanel center = new JPanel();
		
		
		public AccountWindow(Account ac)
		{
			this.ac=ac;
			this.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we)
				{
					db.saveData();
					System.exit(0);
				}
			});
			this.setTitle("Bank Management System");
			this.setSize(700, 400);
		    this.setVisible(true);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		    
		    transferSB.addActionListener(this);
		    withdrawalSB.addActionListener(this);
		    payBillSB.addActionListener(this);
		    depositSB.addActionListener(this);
		    saveB.addActionListener(this);
		    PinB.addActionListener(this);
		    left.setBackground(new Color(95, 158, 160));
		    
		    getContentPane().add(left,BorderLayout.WEST);
		    right.setBackground(new Color(95, 158, 160));
		    getContentPane().add(right,BorderLayout.EAST);
		    top.setBackground(new Color(95, 158, 160));
		    getContentPane().add(top,BorderLayout.NORTH);
		    bottom.setBackground(new Color(95, 158, 160));
		    getContentPane().add(bottom,BorderLayout.SOUTH);
		    center.setBackground(SystemColor.activeCaption);
		    getContentPane().add(center,BorderLayout.CENTER);
		    
		    
		    top.setBorder(new EmptyBorder(10, 0, 10, 0));
		    welcomeText.setFont(new Font("Cambria", Font.BOLD, 18));
		    welcomeText.setText("Welcome, " + ac.user.getFirstName() + " " + ac.user.getLastName());
		    top.add(welcomeText);
		    
		    
		    left.setLayout(new GridLayout(7, 1,5,10));
		    transferB.setForeground(Color.LIGHT_GRAY);
		    transferB.setBackground(Color.DARK_GRAY);
		    transferB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    transferB.addActionListener(this);
		    left.add(transferB);
		    withdrawB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    withdrawB.setForeground(Color.LIGHT_GRAY);
		    withdrawB.setBackground(Color.DARK_GRAY);
		    withdrawB.addActionListener(this);
		    left.add(withdrawB);
		    depositB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    depositB.setForeground(Color.LIGHT_GRAY);
		    depositB.setBackground(Color.DARK_GRAY);
		    depositB.addActionListener(this);
		    left.add(depositB);
		    balanceB.setForeground(Color.LIGHT_GRAY);
		    balanceB.setBackground(Color.DARK_GRAY);
		    balanceB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    balanceB.addActionListener(this);
		    left.add(balanceB);
		    payBillB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    payBillB.setForeground(Color.LIGHT_GRAY);
		    payBillB.setBackground(Color.DARK_GRAY);
		    payBillB.addActionListener(this);
		    left.add(payBillB);
		    
		    right.setLayout(new GridLayout(7, 1,5,10));
		    userDetailB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    userDetailB.setForeground(Color.LIGHT_GRAY);
		    userDetailB.setBackground(Color.DARK_GRAY);
		    userDetailB.addActionListener(this);
		    right.add(userDetailB);
		    changePinB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    changePinB.setForeground(Color.LIGHT_GRAY);
		    changePinB.setBackground(Color.DARK_GRAY);
		    changePinB.addActionListener(this);
		    right.add(changePinB);
		    logoutB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		    logoutB.setForeground(Color.LIGHT_GRAY);
		    logoutB.setBackground(Color.DARK_GRAY);
		   
		    
		    logoutB.addActionListener(this);
		    bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		    bottom.add(logoutB);
		    
		}

		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("Transfer Money"))
			{
				generateTransferPanel();
			}
			else if(e.getActionCommand().equals("Withdraw Money"))
			{
				generateWithdrawalPanel();
			}
			else if(e.getActionCommand().equals("Deposit Money"))
			{
				generateDepositPanel();
			}
			else if(e.getActionCommand().equals("Balance Check"))
			{
				generateBalancePanel();
			}
			else if(e.getActionCommand().equals("Pay Bill"))
			{
				generatePayBillPanel();
			}
			else if(e.getActionCommand().equals("Transfer"))
			{
				transfer();
			}
			else if(e.getActionCommand().equals("Withdraw"))
			{
				withdraw();
			}
			else if(e.getActionCommand().equals("Deposit"))
			{
				deposit();
				
			}
			else if(e.getActionCommand().equals("Pay"))
			{
				payBill();
			}
			else if(e.getActionCommand().equals("User Detail"))
			{
				generateUserDetailPanel();
			}
			else if(e.getActionCommand().equals("Change PIN"))
			{
				generatePinPanel();
			}
			else if(e.getActionCommand().equals("Submit"))
			{
				changePIN();
			}
			else if(e.getActionCommand().equals("Log Out"))
			{
				this.dispose();
				new LoginWindow();
			}
			
		}
		
		void generateTransferPanel()
		{
			panelClear();
			center.add(new JLabel("Enter Account no: "));
			center.setFont(new Font("Tahoma", Font.PLAIN, 13));
			center.add(accountNoT);
			center.add(new JLabel("Enter Amount: "));
			center.add(amountT);
			center.add(new JLabel());
			center.add(transferSB);
			this.revalidate();
		}
		
		void generateWithdrawalPanel()
		{
			panelClear();
			center.add(new JLabel("Enter Amount: "));
			center.add(amountT);
			center.add(new JLabel());
			center.add(withdrawalSB);
			this.revalidate();
		}
		
		void generateDepositPanel()
		{
			panelClear();
			center.add(new JLabel("Enter Amount: "));
			center.add(amountT);
			center.add(new JLabel());
			center.add(depositSB);
			this.revalidate();
		}
		
		void generateBalancePanel()
		{
			panelClear();
			center.add(new JLabel("Current Balance: "));
			DecimalFormat df = new DecimalFormat("0.00");
			center.add(new JLabel(""+df.format(ac.getBalance())));
			center.add(new JLabel());
			center.add(new JLabel());
			this.revalidate();
		}
		
		void generatePayBillPanel()
		{
			panelClear();
			center.add(new JLabel("Enter ID/BillNo: "));
			center.add(accountNoT);
			center.add(new JLabel("Enter Amount: "));
			center.add(amountT);
			center.add(new JLabel());
			center.add(payBillSB);
			this.revalidate();
		}
		
		void generateUserDetailPanel()
		{
			panelClear();
			center.setBorder(new EmptyBorder(50, 50, 50,50));
			center.setLayout(new GridLayout(0, 2, 5, 10));
			center.add(new JLabel("Full Name:"));
			center.add(new JLabel(ac.user.getFirstName() + " " + ac.user.getLastName()));
			center.add(new JLabel("Sex:"));
			center.add(new JLabel(ac.user.getSex()));
			center.add(new JLabel("Date of Birth:"));
			center.add(new JLabel(ac.user.getBirthdate().getDate()+"/"+ac.user.getBirthdate().getMonth()+"/"+ac.user.getBirthdate().getYear()));
			center.add(new JLabel("Email:"));
			center.add(new JLabel(ac.user.getEmail()));
			center.add(new JLabel("Phone No.:"));
			center.add(new JLabel(ac.user.getPhoneNo()));
			center.add(new JLabel("NID:"));
			center.add(new JLabel(ac.user.getNID()));
			center.add(new JLabel("Address:"));
			center.add(new JLabel(ac.user.getAddress()));
			center.add(new JLabel("Occupation:"));
			center.add(new JLabel(ac.user.getOccupation()));
			this.revalidate();
			
		}
		
		void generatePinPanel()
		{
			panelClear();
			center.setBorder(new EmptyBorder(80, 50, 70,50));
			center.setLayout(new GridLayout(4, 2, 5, 10));
			center.add(new JLabel("Old PIN:"));
			center.add(oldP);
			center.add(new JLabel("Enter New PIN:"));
			center.add(newP);
			center.add(new JLabel("Re-Enter New PIN:"));
			center.add(reNewP);
			center.add(new JLabel(" "));
			center.add(PinB);
			this.revalidate();
			
		}
		
		void panelClear()
		{
			center.removeAll();
			center.setBorder(new EmptyBorder(80, 50, 110,50));
			center.setLayout(new GridLayout(3, 2, 5, 10));
			accountNoT.setText("");
			amountT.setText("");
			oldP.setText("");
			newP.setText("");
			reNewP.setText("");
		}
		
		void payBill()
		{
			try
			{
				double amount=Double.parseDouble(amountT.getText());
				if(ac.payBill(amount))
				{
					JOptionPane.showMessageDialog(this,"Bill successfully Paid!","Success",JOptionPane.OK_OPTION);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"You don't have enough Balance","Failed",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(this,"Enter valid amount","Failed",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		void transfer()
		{
			try
			{
				double amount=Double.parseDouble(amountT.getText());
				
				Account otherAccount;
				if((otherAccount=db.getAccount(accountNoT.getText()))!=null)
				{
					if(ac.transferMoney(otherAccount, amount))
					{
						JOptionPane.showMessageDialog(this,"Successfully Transferred","Success",JOptionPane.OK_OPTION);
					}
					else
					{
						JOptionPane.showMessageDialog(this,"You don't have enough Balance","Failed",JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Sorry, Given Account not Found","Failed",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(this,"Enter valid amount","Failed",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		void withdraw()
		{
			try
			{
				double amount=Double.parseDouble(amountT.getText());
				int t=ac.withdrawMoney(amount);
				if(t==0)
					JOptionPane.showMessageDialog(this,"Successfully Withdrawn","Success",JOptionPane.OK_OPTION);
				else if(t==Account.INSUFFICIENT_BALANCE)
					JOptionPane.showMessageDialog(this,"You don't have enough Balance","Failed",JOptionPane.ERROR_MESSAGE);
				else if(t==Account.WITHDRAWAL_LIMIT_UNDER)
					JOptionPane.showMessageDialog(this,"Minimum withdrawal amount is: "+ ac.getMinWithdrawal(),"Failed",JOptionPane.ERROR_MESSAGE);
				else if(t==Account.WITHDRAWAL_LIMIT_OVER)
					JOptionPane.showMessageDialog(this,"Maximum Withdrawal amount is: " +ac.getMaxWithdrawal(),"Failed",JOptionPane.ERROR_MESSAGE);
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(this,"Enter valid amount","Failed",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		void deposit()
		{
			try
			{
				double amount=Double.parseDouble(amountT.getText());
				ac.depositMoney(amount);
				JOptionPane.showMessageDialog(this,"Successfully Deposited","Success",JOptionPane.OK_OPTION);
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(this,"Enter valid amount","Failed",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		@SuppressWarnings("deprecation")
		void changePIN()
		{
			if(oldP.getText().isEmpty() || newP.getText().isEmpty() || reNewP.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Please Fill all the Fields","Failed",JOptionPane.ERROR_MESSAGE);
			}
			else if(!oldP.getText().equals(ac.getPIN()))
			{
				JOptionPane.showMessageDialog(this,"Wrong PIN Entered","Failed",JOptionPane.ERROR_MESSAGE);
			}
			else if(!newP.getText().equals(reNewP.getText()))
			{
				JOptionPane.showMessageDialog(this,"New PINs doesn't Match","Failed",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				ac.setPIN(newP.getText());
				JOptionPane.showMessageDialog(this,"PIN successfully changed","Success",JOptionPane.OK_OPTION);
			}
		}
	}


