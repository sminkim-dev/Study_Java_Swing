package chapter_13.practice;

import javax.swing.*;

public class MenuEx extends JFrame{
	public MenuEx() {
		setTitle("make manu sample");
		createMenu();
		
		setSize(300,200);
		setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu = new JMenu("screen");
		
		screenMenu.add(new JMenuItem("LOAD"));
		screenMenu.add(new JMenuItem("HIDE"));
		screenMenu.add(new JMenuItem("RESHOW"));
		screenMenu.addSeparator(); // 분리선 삽입 
		screenMenu.add(new JMenuItem("Exit"));
		
		mb.add(screenMenu);
		mb.add(new JMenu("Edit"));
		mb.add(new JMenu("Source"));
		mb.add(new JMenu("Project"));
		mb.add(new JMenu("Run"));
		
		setJMenuBar(mb);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuEx();
	}

}
