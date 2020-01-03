package GUI;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Data.UserDatabase;
import User.Account;

public class LoginWindow extends JFrame implements ActionListener
{
	
		JPasswordField passF = new JPasswordField("",50);
		JTextField accountNoT = new JTextField("",50);
		JButton loginB = new JButton("Login"), signUpB= new JButton("Create a new Account");
		UserDatabase db = UserDatabase.getInstance();
		JPanel jp = new JPanel();
		JPanel jp2= new JPanel();
		JLabel imgLabel;
		
		public LoginWindow()
		{	
			this.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we)
				{
					db.saveData();
					System.exit(0);
				}
			});
			
			db.printAccounts();
		    this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
			this.setSize(580, 520);
		    this.setVisible(true);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setTitle("Bank Management System");
		    jp.setBackground(new Color(0, 139, 139));
		    
		    this.add(jp);
		    
		    imgLabel = new JLabel(new ImageIcon("D:\\Fall2k19\\CSE215L\\Demo\\resources\\download.png"));
		    imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		    imgLabel.setBounds(0,0,10,10);
		    jp.add(imgLabel);
		    
		    
		    jp.setLayout(new GridLayout(2, 1));
		    jp2.setBackground(new Color(0, 139, 139));
		    
		    BoxLayout boxlayout= new BoxLayout(jp2,BoxLayout.Y_AXIS);
		    jp2.setLayout(boxlayout);
		    jp2.setBorder(new EmptyBorder(new Insets(5, 120, 50, 160)));
		    jp.add(jp2);
		   
		    
		    jp2.add(new JLabel("Account No: "));
		    jp2.add(accountNoT);
		    jp2.add(new JLabel("Password "));
		    jp2.add(passF);
		    loginB.setForeground(Color.LIGHT_GRAY);
		    loginB.setBackground(Color.DARK_GRAY);
		    
		    loginB.addActionListener(this);
		    loginB.setBounds(600,800,40,40);
		    jp2.add(loginB);
		    jp2.add(new JLabel("Don't have an account?"));
		    signUpB.setBackground(Color.DARK_GRAY);
		    signUpB.setForeground(Color.LIGHT_GRAY);
		    signUpB.addActionListener(this);
		    jp2.add(signUpB);
		    this.revalidate();
		   
		}
		
		public static void main(String args[])
		{
			
			UserDatabase.getInstance().loadData();
			new LoginWindow();
		}

		
		
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("Login"))
			{
				Account ac;
				if((ac=db.getAccount(accountNoT.getText(), passF.getText()))!=null)
				{
					this.dispose();
					new AccountWindow(ac);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Account number & Password didn't Match!","Login Failed",JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(e.getActionCommand().equals("Create a new Account"))
			{
				this.dispose();
				new SignUpWindow();
			}
		}
	}

