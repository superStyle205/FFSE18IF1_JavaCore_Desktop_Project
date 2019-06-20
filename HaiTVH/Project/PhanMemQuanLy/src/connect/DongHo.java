package connect;




import java.util.Calendar;
 
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DongHo extends JFrame {

	 
	    private JLabel labelClock;
	 
	    public DongHo() {
	        setTitle("Đồng hồ trong Java Swing");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        labelClock = new JLabel();
	        labelClock.setBounds(20, 20, 80, 20);
	        add(labelClock);
	        setSize(400, 200);
	        setLayout(null);
	        setVisible(true);
	        
	        
	        try {
	            while (true) {
	                Calendar calendar = Calendar.getInstance();
	                String hour = (calendar.getTime().getHours() > 9) ? 
	                        "" + calendar.getTime().getHours() + ""
	                        : "0" + calendar.getTime().getHours();
	                String minute = (calendar.getTime().getMinutes() > 9) ? 
	                        "" + calendar.getTime().getMinutes() + ""
	                        : "0" + calendar.getTime().getMinutes();
	                String second = (calendar.getTime().getSeconds() > 9) ? 
	                        "" + calendar.getTime().getSeconds() + ""
	                        : "0" + calendar.getTime().getSeconds();
	                labelClock.setText(hour + ":" + minute + ":" + second);
	                Thread.sleep(1000);
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	      
	       new DongHo();
	       
	    }
	
}
