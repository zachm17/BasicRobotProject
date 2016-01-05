package bot.model;

import lejos.hardware.lcd.LCD;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;

public class EV3Bot
{
	private String botMessage;
	private MovePilot botPilot;
	private int xPosition;
	private int yPosition;
	private long waitTime;
	
	
	public EV3Bot()
	{
		this.botMessage = "ZACH IS CODING BOT BOIII";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
		
		setupPilot();
		displayMessage();
	}

	private void setupPilot()
	{
		
	}
	
	public void driveRoom()
	{
		
	}
	
	private void displayMessage()
	{
		LCD.drawString(botMessage, xPosition, yPosition);
		Delay.msDelay(waitTime);
	}
	
	private void displayMessage(String message)
	{
		LCD.drawString(botMessage, xPosition, yPosition);
		Delay.msDelay(waitTime);
	}
	
	
}
