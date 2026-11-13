package chapter_14.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuActionEventEx extends JFrame{
	private JLabel imgLabel = new JLabel();
	public MenuActionEventEx() {
		super("make the sample of Action Listenr on Menu");
		createMenu();
		getContentPane().add(imgLabel, BorderLayout.CENTER);
		setSize(300,300);
		setVisible(true);
	}
	public void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenuItem [] menuItem = new JMenuItem[4];
		String [] itemTitle = {"Load", "Hide", "ReShow", "Exit"};
		JMenu screenMenu = new JMenu("Screen");
		
		// insert screen menu on four menu item.
		MenuActionListener listener = new MenuActionListener();
		for(int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(listener);
			screenMenu.add(menuItem[i]);
		}
		mb.add(screenMenu);
		setJMenuBar(mb);
		
	}
	class MenuActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); // 사용자가 선택한 메뉴 아이템의 문자열 리턴 
			switch(cmd) {
			case "Load":
				if(imgLabel.getIcon() != null) {
					return;
				}
				imgLabel.setIcon(new ImageIcon(getClass().getResource("/image/buddy1.jpeg")));
				break;
			case "Hide":
				imgLabel.setVisible(false);
				break;
			case "ReShow":
				imgLabel.setVisible(true);
				break;
			case "Exit":
				System.exit(0);
				break;
			}
		}
	}
	public static void main(String[] args) {
		new MenuActionEventEx();
	}

}
