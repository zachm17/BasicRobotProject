package bot.model;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;



public class EV3Bot
{
	private String botMessage;
	private MovePilot botPilot;
	private int xPosition;
	private int yPosition;
	private long waitTime;
	
	private EV3TouchSensor backTouch;
	private EV3UltrasonicSensor distanceSensor;
	private float [] ultrasonicSamples;
	private float [] touchSamples;
	
	
	
	public EV3Bot()
	{
		this.botMessage = "ZACH IS CODING BOT BOIII";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
		
		distanceSensor = new EV3UltrasonicSensor(LocalEV3.get().getPort("S1"));
		backTouch = new EV3TouchSensor(LocalEV3.get().getPort("S2"));
		
		setupPilot();
		displayMessage();
	}

	private void setupPilot()
	{
		
		
		Wheel leftWheel = WheeledChassis.modelWheel(Motor.A, 50.3).offset(-72);
		Wheel rightWheel = WheeledChassis.modelWheel(Motor.B,  50.3).offset(72);
		WheeledChassis chassis = new WheeledChassis(new Wheel[]{leftWheel, rightWheel}, WheeledChassis.TYPE_DIFFERENTIAL);
		botPilot = new MovePilot(chassis);
		
		
	}
	
	public void driveRoom()
	{
		ultrasonicSamples = new float [distanceSensor.sampleSize()];
		distanceSensor.fetchSample(ultrasonicSamples, 0);
		
		for(ultrasonicSamples[0] = 0; (ultrasonicSamples[0]) > (ultrasonicSamples[0] + 1); ultrasonicSamples[0]++);
		if(ultrasonicSamples[0] > 810 / 2)
		{
			
		//Long method
			botPilot.travel(3510.00);
			botPilot.rotateRight();
			
			botPilot.travel(5940.00);
			botPilot.rotateLeft();
		}
		else
		{
			
		//Short method
			botPilot.travel(254.00);
		}
			
			
		displayMessage("driveRoom");
		
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
