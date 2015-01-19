package namelessgame;

public class Main 
{
	public static void main(String[] args)
	{
		new Thread(new Runnable(){public void run(){new Game().start();}}).start();
	}
}
