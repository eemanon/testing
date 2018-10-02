package main.fr.ut2j.m1ice.ootesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.Random;

public class TestMyPoint {

	MyPoint simplePoint;
	MyPoint customPoint;
	MyPoint pointforOperationTests;
	
	@Before
	public void setUp() throws Exception {
		pointforOperationTests = new MyPoint();
	}
	
	
	/**
	 * Test Constructor 1 (without parameters)
	 */
	@Test
	public void testMyPoint() {
		simplePoint = new MyPoint();
		assertEquals (0d, simplePoint.getX(), 0.0001);
		assertEquals (0d, simplePoint.getY(), 0.0001);
	}
	/**
	 * Test Constructor 2 (with parameters x and y as doubles).
	 * Uses random doubles to check output.
	 */
	@Test
	public void testMyPointDoubleDouble() {
		Random rand = new Random();
		double  x = rand.nextDouble();
		double  y = rand.nextDouble();
		
		customPoint = new MyPoint(x, y);
		assertEquals (x, customPoint.getX(), 0.0001);
		assertEquals (y, customPoint.getY(), 0.0001);		
	}
	/**
	 * Test setX (with random double).
	 */
	@Test
	public void testsetX() {
		Random rand = new Random();
		double  x = rand.nextDouble();
		pointforOperationTests.setX(x);
		assertEquals (x, pointforOperationTests.getX(), 0.0001);		
	}	
	
	/**
	 * Test setY (with random double).
	 */
	@Test
	public void testsetY() {
		Random rand = new Random();
		double  y = rand.nextDouble();
		pointforOperationTests.setY(y);
		assertEquals (y, pointforOperationTests.getY(), 0.0001);		
	}	

}