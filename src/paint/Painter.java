package paint;
import javax.swing.JFrame;


public class Painter {
	static public void main(String args[]) {
		PaintFrame frame=new PaintFrame();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame.setSize( 700,500 );
		frame.setVisible( true );
		/* TODO initialize frame in here 
		 * setAttribute(ex:Size...)
		 * */
	}
}
