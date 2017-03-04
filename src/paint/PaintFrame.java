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
	private JPanel controlPanel; // ø�Ϥu��
	private JPanel statusPanel; // ���A�u��
	private DrawPanel drawPanel; // �e��
	private JLabel statusLabelMouse; // �ƹ���m����
	private JLabel statusLabelTools; // �u�㪬�A����
	private JLabel statusLabelOthers; // ��L���A����
	private JLabel brushSizeLabel, toolLabel, alignLabel; // ���A����
	private JComboBox toolComboBox; // ø�Ϥu��U�Կ��
	private String toolName[] = { "����", "���u", "���", "�x��"}; // ø�Ϥu�㪺�W��
	private JRadioButton smallBrush, mediumBrush, bigBrush; // ����j�p
	private ButtonGroup brushSizeButtonGroup; // ����j�p
	private JCheckBox ChBox;//�O�_��
	private GridLayout grid;
	private BufferedImage image;
	private JButton newCanvasButton; // �]�w���e���s
	// TODO �N�Ҧ����ŧi����ø�Ϥ���H�ΰѼƸɤW
	
	public PaintFrame() {
		
		super("�p�e�a");
		
		GridLayout grid = new GridLayout(10,1);
		
	    controlPanel = new JPanel();
	    add(controlPanel,BorderLayout.WEST);
	    controlPanel.setLayout(grid);
		
		
		toolLabel = new JLabel("[ø�Ϥu��]");
		toolComboBox = new JComboBox( toolName );
		toolComboBox.addItemListener(new ToolTipHandler());
		controlPanel.add(toolLabel);
		controlPanel.add(toolComboBox);
		
		brushSizeLabel = new JLabel("[����j�p]");
		smallBrush = new JRadioButton( "�p", true );
		mediumBrush = new JRadioButton( "��", false );
		bigBrush = new JRadioButton( "�j", false );
	
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
		
		ChBox = new JCheckBox( "��" );
		ChBox.addActionListener(new CheckHandler());
		controlPanel.add( ChBox );
        
		newCanvasButton = new JButton( "�M���e��");
		newCanvasButton.addActionListener(new ButtonHandler());
		controlPanel.add( newCanvasButton );

		statusPanel = new JPanel();
        add(statusPanel,BorderLayout.SOUTH);
        
        alignLabel = new JLabel();
        GridLayout statusgrid= new GridLayout(1,3);
		
 
        statusLabelMouse = new JLabel("�o�̬O�ƹ���m�C",alignLabel.LEFT);
	    statusLabelTools = new JLabel("�o�̬O�u�㪬�A�C",alignLabel.CENTER);
	    statusLabelOthers = new JLabel("�o�̬O��L���A�C",alignLabel.RIGHT);
	    
	    statusPanel.setLayout(statusgrid);
	    statusPanel.add(statusLabelMouse);
	    statusPanel.add(statusLabelTools);
	    statusPanel.add(statusLabelOthers);
	   
	    
	    drawPanel = new DrawPanel();
	    add(drawPanel);
	    

	    
		/*TODO �b���ŧi�H�Ϊ�l�ƥH�U�d�ҥH�ΧA�{���һݪ����� EX:
		 * statusLabelMouse = new JLabel("�o�̬O�ƹ���m�C");
		 * statusLabelTools = new JLabel("�o�̬O�u�㪬�A�C");
		 * statusLabelOthers = new JLabel("�o�̬O��L���A�C");
		 *ø�Ϥu��
		 *����j�p
		 *�񺡪�checkbox
		 *�M�ū��s
		 *�O�o�ⱱ���[��controlPanel�̭�
		 * 
		 */
	}
	    
	/*
	 * �H�U�ݧiHandler��GUI�һݩҦ����ƥ�Handler
	 */
	//�M���e��Button Handler
	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
		   statusLabelOthers.setText("�M���e��");
		}
	}	
	
	// ø�Ϥu�� ComboBox handler
	private class ToolTipHandler implements ItemListener {
		public void itemStateChanged(ItemEvent event) {

		}
	}
	
	// ����j�p RadioButton handler
	private class RadioButtonHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent arg0) {

			}
	}
	//��@�O�_�񺡪�Check Handler
	private class CheckHandler implements ActionListener  {
		@Override
		public void actionPerformed(ActionEvent e) {
	
			// TODO Auto-generated method stub
					}
		
	}
	
	 class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {
		/*
		 * implement �e�����a��,�b������ƹ���m
		 * mouseClicked, Enter, Exited �٤��ݹ�@���e
		 */
		int sx, sy, ex, ey;

		DrawPanel() {
			addMouseMotionListener(this);
			addMouseListener(this);
			setBackground(Color.white);
		}
		//�`�N�I�@�~�@�ëD�Ҧ���k�������A��X�ݭn����k�åB��
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
			statusLabelOthers.setText("���U");
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			statusLabelOthers.setText("�u�}");
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			statusLabelOthers.setText("�즲");
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			statusLabelMouse.setText(String.format("��Ц�m:[%d,%d]",arg0.getX(),arg0.getY()));
		}
	 }
}
