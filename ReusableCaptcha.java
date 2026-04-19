package com.orb;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.annotation.processing.Generated;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ReusableCaptcha extends JFrame
{
    private JLabel captchaLabel;
    private JTextField captchaTextField;
    private JButton genButton;
    private String generatedcaptcha;
    
    public ReusableCaptcha()
    {
    	setTitle("Reusable Captcha Generator");
    	setSize(500, 200);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    	
    	captchaLabel = new JLabel();
    	captchaLabel.setFont(new Font("Arial",Font.BOLD,20));
    	captchaLabel.setForeground(Color.blue);
    	captchaTextField = new JTextField(10);
    	genButton = new JButton("Generate Captcha");
    	genButton.setForeground(Color.red);
    	genButton.setFont(new Font("Arial",Font.BOLD,20));
        
    	genButton.addActionListener(new ActionListener()
    	{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				generatedcaptcha = gencaptcha();
				captchaLabel.setText(generatedcaptcha);
			}	
		});
    	
    	JPanel panel = new JPanel();
    	panel.add(captchaLabel);
    	panel.add(captchaTextField);
    	panel.add(genButton);
    	
    	add(panel);
    }
    
    	private String gencaptcha() 
    	{
			String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			StringBuilder captcha = new StringBuilder();
			Random rd = new Random();
			
			for (int i = 0; i < 8; i++) 
			{
				char c = characters.charAt(rd.nextInt(characters.length()));
				captcha.append(c);
			}
			return captcha.toString();
		}
    	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			@Override
			public void run()
            {
	          new ReusableCaptcha().setVisible(true);			
			} 
		});

	}

}
