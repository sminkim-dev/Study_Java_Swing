package chapter_14.practice;

import javax.swing.*;

public class MenuEx extends JFrame{
	public MenuEx() {
		super("make the Menu sample");
		createMenu();
		setSize(300,300);
		setVisible(true);
	}
	
	public void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu = new JMenu("Screen");
		
		// create insert menu item in the screen menu
		screenMenu.add(new JMenuItem("Load"));
		screenMenu.add(new JMenuItem("Hide"));
		screenMenu.add(new JMenuItem("ReShow"));
		screenMenu.addSeparator();
		screenMenu.add(new JMenuItem("Exit"));
		
		// insert menu on menubar
		mb.add(screenMenu);
		mb.add(new JMenu("Edit"));
		mb.add(new JMenu("Source"));
		mb.add(new JMenu("Project"));
		mb.add(new JMenu("Run"));
		
		setJMenuBar(mb);
	}
	public static void main(String[] args) {
		new MenuEx();
	}

}
