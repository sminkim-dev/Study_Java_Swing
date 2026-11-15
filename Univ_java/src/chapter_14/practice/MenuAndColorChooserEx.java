package chapter_14.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuAndColorChooserEx extends JFrame{
	private JLabel label = new JLabel("Hello");
			
	public MenuAndColorChooserEx() {
		super("example JColorChooser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Ravie", Font.ITALIC, 30));
		c.add(label, BorderLayout.CENTER);
		createMenu();
		setSize(250,200);
		setVisible(true);
	}
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenuItem colorMenuItem = new JMenuItem("Color");
		JMenu fileMenu =  new JMenu("Text");
		
		//color menuItem에 action listenr 등록 
		colorMenuItem.addActionListener(e->{
			String cmd = e.getActionCommand();
			if(cmd.equals("Color")) {
				// color 메뉴 아이템의 경우
				// 컬러 다이얼로그를 출력하고 사용자가 선택한 색을 알아온다.
				Color selectedColor = JColorChooser.showDialog(null, "Color", Color.YELLOW);
				
				// 취소 버튼을 누르거나 그냥 다이얼로그를 닫는 경우 selectedColor은 null이다.
				if(selectedColor != null) {
					label.setForeground(selectedColor);
				}
			}
		});
		
		fileMenu.add(colorMenuItem);
		mb.add(fileMenu);
		this.setJMenuBar(mb);
	}

	public static void main(String[] args) {	
		new MenuAndColorChooserEx();
	}

}
