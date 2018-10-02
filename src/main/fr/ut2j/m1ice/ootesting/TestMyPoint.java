package main.fr.ut2j.m1ice.ootesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.Random;

public class TestMyPoint {

	MyPoint simplePoint;
	MyPoint customPoint;
	MyPoint pointForOperations;
	MyPoint fromOtherPoint;
	MyPoint fromScale;
	MyPoint toScale;
	
	@Before
	public void setUp() throws Exception {
		pointForOperations = new MyPoint();
		toScale = new MyPoint();
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
		pointForOperations.setX(x);
		assertEquals (x, pointForOperations.getX(), 0.0001);		
	}	
	
	/**
	 * Test setY (with random double).
	 */
	@Test
	public void testsetY() {
		Random rand = new Random();
		double  y = rand.nextDouble();
		pointForOperations.setY(y);
		assertEquals (y, pointForOperations.getY(), 0.0001);		
	}
	/**
	 * Test setX (with Double.NAN).
	 */
	@Test
	public void testsetX2() {
		double x = Double.NaN;
		pointForOperations.setX(x);
		assert (!Double.isNaN(pointForOperations.getX()));
	}
	
	/**
	 * Test Constructor 3
	 * Creates a point from a IMyPoint.
	 * (0,0) will be used when the given pt is null.
	 * @param pt The IMyPoint, if null the default value (0,0) will be used.
	 */
	@Test
	public void testMyPoint3() {
		fromOtherPoint = new MyPoint(simplePoint);
		assert(fromOtherPoint.getX()==0.0 && fromOtherPoint.getY()==0.0);
				
	}

	/**
	 * Tests scale functionality with default constructor
	 */
	@Test
	public void testscale() {
		Random rand = new Random();
		double  sx = rand.nextDouble();
		fromScale = toScale.scale(sx);
		assert(fromScale.getX() == 0.0 && fromScale.getY() == 0.0);
	}

	/**
	 * Tests scale functionality with pointer = null
	 */
	@Test
	public void testscale2() {
		Random rand = new Random();
		double  sx = rand.nextDouble();
		toScale = null;
		fromScale = toScale.scale(sx);
		assert(fromScale.getX() == 0.0 && fromScale.getY() == 0.0);
	}
	
	
	/**
	 * Tests scale functionality with constructor 2
	 */
	@Test
	public void testscale3() {
		Random rand = new Random();
		double  sx = rand.nextDouble();
		double  x = rand.nextDouble();
		double  y = rand.nextDouble();
		toScale.setX(x);
		toScale.setY(y);
		fromScale = toScale.scale(sx);
		assertEquals (x*sx, fromScale.getX(), 0.0001);
		assertEquals (y*sx, fromScale.getY(), 0.0001);
	}	
	/**
	 * tests horizontally 
	 * @param origin The location of the horizontal axe.
	 * @return the computed point.
	 * @throws IllegalArgumentException When the given parameter is null.
	 */
	@Test
	public void testhorizontally() {
		
	}	

}
