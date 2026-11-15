package chapter_14.practice;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;

public class MenuAndFileDialogEx extends JFrame{

	private JLabel imageLabel = new JLabel();
	
	public MenuAndFileDialogEx() {
		super("using example the Menu and JFileChooser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(imageLabel);
		createMenu();
		setSize(350,200);
		setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		
		// open 메뉴 아이템에 action listener 등록 
		//openItem.addActionListener(new OpenActionListener());
		JFileChooser chooser = new JFileChooser();
		openItem.addActionListener(e->{
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF, JPEG", "jpg", "gif", "jpeg");
			chooser.setFileFilter(filter);
			
			int ret = chooser.showOpenDialog(this);
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(this, "파일을 선택하지 않음 ", "경고 ", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String filePath = chooser.getSelectedFile().getPath();
			imageLabel.setIcon(new ImageIcon(filePath));
			pack();
		});
		fileMenu.add(openItem);
		mb.add(fileMenu);
		setJMenuBar(mb);
	}
	
//	class OpenActionListener implements ActionListener{
//		private JFileChooser chooser;
//		
//		public OpenActionListener() {
//			chooser = new JFileChooser();
//		}
//		public void actionPerformed(ActionEvent e) {
//			FileNameExtensionFilter filter = new FileNameExtensionFilter(
//					"JPG , GIF , jpeg Images", // 파일 이름란에 출력될 문자열  
//					"jpg", "gif", "jpeg"); // 파일 필터로 사용되는 확장자. *.jpg, *.gif만 나열됨 
//			chooser.setFileFilter(filter);
//			
//			int ret = chooser.showOpenDialog(MenuAndFileDialogEx.this); // show file dialog 
//			if(ret != JFileChooser.APPROVE_OPTION) {
//				// 사용자가 창을 강제로 닫았거나 취소 버튼을 누른 경우 
//				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다 ", "경고 ", JOptionPane.WARNING_MESSAGE);
//				return;
//			}
//			// 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우 
//			String filePath = chooser.getSelectedFile().getPath(); // file 경로만 리턴 
//			imageLabel.setIcon(new ImageIcon(filePath)); // image 출력 
//			pack(); // image의 크기에 맞추어 프레임 크기 조절 
//		}
//	}
	public static void main(String[] args) {
		new MenuAndFileDialogEx();
	}

}
