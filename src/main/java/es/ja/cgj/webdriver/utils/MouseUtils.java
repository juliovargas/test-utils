package es.ja.cgj.webdriver.utils;

import java.awt.AWTException;
import java.awt.Robot;

import org.apache.log4j.Logger;

public class MouseUtils {
	
	// Define a static logger variable
	static Logger log = Logger.getLogger(MouseUtils.class);
	
	public static void waitAndMoveMouse (int ms) {

		try {
			//Esperar ms milisegundos
			Thread.sleep(ms);
			
			Robot robot = new Robot();
			robot.mouseMove(100, 100);
			
		} catch (InterruptedException e1) {
			log.error("Error inesperado", e1);
		} catch (AWTException e2) {
			log.error("Error inesperado", e2);
		}
	}
	
	public static void waitAndMoveMouse (int ms, int ms2) {

		try {
			//Esperar ms milisegundos
			Thread.sleep(ms);
			
			Robot robot = new Robot();
			robot.mouseMove(100, 100);
			
			//Esperar ms milisegundos
			Thread.sleep(ms2);
			
			robot.mouseMove(150, 150);
			
		} catch (InterruptedException e1) {
			log.error("Error inesperado", e1);
		} catch (AWTException e2) {
			log.error("Error inesperado", e2);
		}
	}
	
	public static void mouseMouveAfter5Seconds (int i) {

		try {
			Thread.sleep(5000);
			
			Robot robot = new Robot();
			robot.mouseMove(10+i, 10+i);
			
		} catch (InterruptedException e1) {
			log.error("Error inesperado", e1);
		} catch (AWTException e2) {
			log.error("Error inesperado", e2);
		}
	}
	
	public static void mouseMouve (int i) {

		try {
					
			Robot robot = new Robot();
			robot.mouseMove(10+i, 10+i);
			
		} catch (AWTException e) {
			log.error("Error inesperado", e);
		}
	}
}
