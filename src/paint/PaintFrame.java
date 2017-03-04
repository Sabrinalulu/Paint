package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PaintFrame extends JFrame {
	private JPanel controlPanel; // 繪圖工具
	private JPanel statusPanel; // 狀態工具
	private DrawPanel drawPanel; // 畫布
	private JLabel statusLabelMouse; // 滑鼠位置說明
	private JLabel statusLabelTools; // 工具狀態說明
	private JLabel statusLabelOthers; // 其他狀態說明
	private JLabel brushSizeLabel, toolLabel, alignLabel; // 狀態說明
	private JComboBox toolComboBox; // 繪圖工具下拉選單
	private String toolName[] = { "筆刷", "直線", "橢圓", "矩形"}; // 繪圖工具的名稱
	private JRadioButton smallBrush, mediumBrush, bigBrush; // 筆刷大小
	private ButtonGroup brushSizeButtonGroup; // 筆刷大小
	private JCheckBox ChBox;//是否填滿
	private GridLayout grid;
	private BufferedImage image;
	private JButton newCanvasButton; // 設定重畫按鈕
	// TODO 將所有未宣告完的繪圖元件以及參數補上
	
	public PaintFrame() {
		
		super("小畫家");
		
		GridLayout grid = new GridLayout(10,1);
		
	    controlPanel = new JPanel();
	    add(controlPanel,BorderLayout.WEST);
	    controlPanel.setLayout(grid);
		
		
		toolLabel = new JLabel("[繪圖工具]");
		toolComboBox = new JComboBox( toolName );
		toolComboBox.addItemListener(new ToolTipHandler());
		controlPanel.add(toolLabel);
		controlPanel.add(toolComboBox);
		
		brushSizeLabel = new JLabel("[筆刷大小]");
		smallBrush = new JRadioButton( "小", true );
		mediumBrush = new JRadioButton( "中", false );
		bigBrush = new JRadioButton( "大", false );
	
		brushSizeButtonGroup = new ButtonGroup();
		smallBrush.addItemListener(new RadioButtonHandler());
		brushSizeButtonGroup.add( smallBrush );
		mediumBrush.addItemListener(new RadioButtonHandler());
		brushSizeButtonGroup.add( mediumBrush );
		bigBrush.addItemListener(new RadioButtonHandler());
		brushSizeButtonGroup.add( bigBrush );
		
		controlPanel.add(brushSizeLabel);
		controlPanel.add(smallBrush);
		controlPanel.add(mediumBrush);
		controlPanel.add(bigBrush);
		
		ChBox = new JCheckBox( "填滿" );
		ChBox.addActionListener(new CheckHandler());
		controlPanel.add( ChBox );
        
		newCanvasButton = new JButton( "清除畫面");
		newCanvasButton.addActionListener(new ButtonHandler());
		controlPanel.add( newCanvasButton );

		statusPanel = new JPanel();
        add(statusPanel,BorderLayout.SOUTH);
        
        alignLabel = new JLabel();
        GridLayout statusgrid= new GridLayout(1,3);
		
 
        statusLabelMouse = new JLabel("這裡是滑鼠位置列",alignLabel.LEFT);
	    statusLabelTools = new JLabel("這裡是工具狀態列",alignLabel.CENTER);
	    statusLabelOthers = new JLabel("這裡是其他狀態列",alignLabel.RIGHT);
	    
	    statusPanel.setLayout(statusgrid);
	    statusPanel.add(statusLabelMouse);
	    statusPanel.add(statusLabelTools);
	    statusPanel.add(statusLabelOthers);
	   
	    
	    drawPanel = new DrawPanel();
	    add(drawPanel);
	    

	    
		/*TODO 在此宣告以及初始化以下範例以及你認為所需的元件 EX:
		 * statusLabelMouse = new JLabel("這裡是滑鼠位置列");
		 * statusLabelTools = new JLabel("這裡是工具狀態列");
		 * statusLabelOthers = new JLabel("這裡是其他狀態列");
		 *繪圖工具
		 *筆刷大小
		 *填滿的checkbox
		 *清空按鈕
		 *記得把控制元件加到controlPanel裡面
		 * 
		 */
	}
	    
	/*
	 * 以下需告Handler為GUI所需所有之事件Handler
	 */
	//清除畫面Button Handler
	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
		   statusLabelOthers.setText("清除畫面");
		}
	}	
	
	// 繪圖工具 ComboBox handler
	private class ToolTipHandler implements ItemListener {
		public void itemStateChanged(ItemEvent event) {

		}
	}
	
	// 筆刷大小 RadioButton handler
	private class RadioButtonHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent arg0) {

			}
	}
	//實作是否填滿的Check Handler
	private class CheckHandler implements ActionListener  {
		@Override
		public void actionPerformed(ActionEvent e) {
	
			// TODO Auto-generated method stub
					}
		
	}
	
	 class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {
		/*
		 * implement 畫布的地方,在此抓取滑鼠位置
		 * mouseClicked, Enter, Exited 還不需實作內容
		 */
		int sx, sy, ex, ey;

		DrawPanel() {
			addMouseMotionListener(this);
			addMouseListener(this);
			setBackground(Color.white);
		}
		//注意！作業一並非所有方法都須實踐，找出需要實踐的方法並且實踐它
		@Override
		public void mouseClicked(MouseEvent arg0) {
			/*statusLabelOthers.setText(String.format("Clicked at [%d,%d]",arg0.getX(),arg0.getY()));*/
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			/*statusLabelOthers.setText(String.format("Mouse entered at [%d,%d]",arg0.getX(),arg0.getY()));*/
			//this.setBackground(Color.PINK);
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			/*statusLabelOthers.setText("Mouse outside JPanel");*/
			//is.setBackground(Color.white);
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			statusLabelOthers.setText("按下");
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			statusLabelOthers.setText("彈開");
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			statusLabelOthers.setText("拖曳");
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			statusLabelMouse.setText(String.format("游標位置:[%d,%d]",arg0.getX(),arg0.getY()));
		}
	 }
}
