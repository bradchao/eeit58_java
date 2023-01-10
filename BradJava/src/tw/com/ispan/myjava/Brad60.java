package tw.com.ispan.myjava;

import java.util.Timer;
import java.util.TimerTask;

public class Brad60 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(), 1*1000, 1*1000);
		timer.schedule(new StopTask(timer), 10*1000);
		System.out.println("Main");
	}
}

class MyTask extends TimerTask {
	int i;
	@Override
	public void run() {
		System.out.println(i++);
	}
}
class StopTask extends TimerTask {
	private Timer timer;
	public StopTask(Timer timer) {
		this.timer = timer;
	}
	@Override
	public void run() {
		timer.cancel();
		timer.purge();
		timer = null;
	}
}
