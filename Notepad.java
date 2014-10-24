import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyListener;

class CyyFrame implements KeyListener, ActionListener{
	/**
	 *
	 */
	JFrame frame;
	JMenuItem itemCopy, itemCut, itemPaste, itemNew, itemOpen, itemSave, itemSaveAs, itemSetting, itemPrint, itemQuit;
	JTextArea textarea;
	
	public void initFrame() {
		frame = new JFrame("陈滢滢的简易记事本");
		frame.setBounds(250,250,500,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
		JMenuBar menubar = new JMenuBar();
		JMenu menuFile = new JMenu("文件(F)");
		menuFile.setMnemonic(KeyEvent.VK_F);
		JMenu menuEdit = new JMenu("编辑(E)");
		menuEdit.setMnemonic(KeyEvent.VK_E);
		JMenu menuFormat = new JMenu("格式(O)");
		menuFormat.setMnemonic(KeyEvent.VK_O);
		JMenu menuView = new JMenu("查看(V)");
		menuView.setMnemonic(KeyEvent.VK_V);
		JMenu menuHelp = new JMenu("帮助(H)");
		menuHelp.setMnemonic(KeyEvent.VK_H);
		
		itemNew = new JMenuItem("新建(N)");
		itemNew.setMnemonic(KeyEvent.VK_N);
		itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		itemOpen = new JMenuItem("打开(O)");
		itemOpen.setMnemonic(KeyEvent.VK_O);
		itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		itemSave = new JMenuItem("保存(S)");
		itemSave.setMnemonic(KeyEvent.VK_S);
		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		itemSaveAs = new JMenuItem("另存为(A)");
		itemSaveAs.setMnemonic(KeyEvent.VK_A);
		itemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		itemSetting = new JMenuItem("页面设置(U)");
		itemSetting.setMnemonic(KeyEvent.VK_U);
		itemSetting.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.CTRL_MASK));
		itemPrint = new JMenuItem("打印(P)");
		itemPrint.setMnemonic(KeyEvent.VK_P);
		itemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK));
		itemQuit = new JMenuItem("退出(Q)");
		itemQuit.setMnemonic(KeyEvent.VK_Q);
		itemQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,InputEvent.CTRL_MASK));

		itemCopy = new JMenuItem("复制(C)");
		itemCopy.setMnemonic(KeyEvent.VK_C);
		itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		itemCut = new JMenuItem("剪切(X)");
		itemCut.setMnemonic(KeyEvent.VK_X);
		itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
		itemPaste = new JMenuItem("粘贴(P)");
		itemPaste.setMnemonic(KeyEvent.VK_P);
		itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK));

		frame.setJMenuBar(menubar);
		menubar.add(menuFile);
		menubar.add(menuEdit);
		menubar.add(menuFormat);
		menubar.add(menuView);
		menubar.add(menuHelp);
		
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.add(itemSaveAs);
		menuFile.add(itemSetting);
		menuFile.add(itemPrint);
		menuFile.add(itemQuit);

		menuEdit.add(itemCopy);
		menuEdit.add(itemCut);
		menuEdit.add(itemPaste);

		textarea = new JTextArea();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,1));
		panel.add(new JScrollPane(textarea));

		itemCopy.addActionListener(this);
		itemCut.addActionListener(this);
		itemPaste.addActionListener(this);
		itemQuit.addActionListener(this);
		textarea.addKeyListener(this);

		frame.add(panel);
		frame.validate();

	}
	
	public void keyPressed(KeyEvent e)
	{
		JTextArea textarea = (JTextArea)e.getSource();
		if(e.getModifiers() == InputEvent.CTRL_MASK && e.getKeyCode() == KeyEvent.VK_X)
		{
			textarea.cut();
		}
		else if(e.getModifiers() == InputEvent.CTRL_MASK && e.getKeyCode() == KeyEvent.VK_C)
		{
			textarea.copy();
		}
		else if(e.getModifiers() == InputEvent.CTRL_MASK && e.getKeyCode() == KeyEvent.VK_V)
		{
			textarea.paste();
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == itemCopy)
		{
			textarea.copy();
		}
		else if(e.getSource() == itemCut)
		{
			textarea.cut();
		}
		else if(e.getSource() == itemPaste)
		{
			textarea.paste();
		}
		else if(e.getSource() == itemQuit)
		{
			frame.dispose();	
		}
	}
	
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	
}

public class Notepad {
	public static void main(String args[]) {
		CyyFrame frame = new CyyFrame();
		frame.initFrame();
	}
}
