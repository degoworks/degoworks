package dacta;
import java.io.IOException;
import java.io.OutputStream;

/*
 * Created on May 6, 2005
 * @author Timo Dinnesen
 *
 * A thread used to send keep alive's to the DACTA box.
 * 
 */
public class DACTA70909KeepAliveThread extends Thread {
	OutputStream os;
	boolean closeFlag = false;
	
	public  DACTA70909KeepAliveThread(OutputStream os){
		this.os = os;
	}
	
	public void run(){
		while(!closeFlag){
			try {
				os.write((byte)0x02); // 0x02 is the keep alive message
			} catch (IOException e) {
				System.out.println("Hey what up " + e.getMessage());
				
			}
			try {
				//System.out.println("zzz...");
				sleep(2000);		// Send every two seconds
			} catch (InterruptedException e2) {
				// Do nothing.
			}
		}    
	}

	public void signalClose() {
		closeFlag = true;
	}
}
