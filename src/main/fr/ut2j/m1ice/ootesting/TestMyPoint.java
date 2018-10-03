package main.fr.ut2j.m1ice.ootesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Random;
import static org.mockito.Mockito.*;

public class TestMyPoint {

	MyPoint simplePoint;
	MyPoint customPoint;
	MyPoint pointForOperations;
	MyPoint fromOtherPoint;
	MyPoint fromScale;
	MyPoint toScale;
	
	
	@Mock
	private ITranslation itrans;

	
	@Before
	public void setUp() throws Exception {
		pointForOperations = new MyPoint();
		toScale = new MyPoint();
	}
	
	@After
	public void tearDown() {
		pointForOperations = null;
		toScale = null;
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
	 * Tests scale functionality with pointer = null
	 */
	@Test
	public void testscale2() {
		Random rand = new Random();
		double  sx = rand.nextDouble();
		fromScale = toScale.scale(sx);
		assertEquals(fromScale.getX(),0d,0.0001);
		assertEquals(fromScale.getY(),0d,0.0001);
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
		MyPoint zero = new MyPoint(3,3);
		MyPoint result = zero.horizontalSymmetry(pointForOperations);
		assertEquals (3d, result.getX(), 0.0001);
		assertEquals (-3d, result.getY(), 0.0001);
	}
	
	@Test
	public void testhorizontally2() {
		MyPoint zero = new MyPoint(3,3);
		MyPoint autrePoint = new MyPoint(5,5);
		MyPoint result = zero.horizontalSymmetry(autrePoint);
		assertEquals (3d, result.getX(), 0.0001);
		assertEquals (7d, result.getY(), 0.0001);
	}	
		
	@Test(expected=IllegalArgumentException.class)
	public void testhorizontallyException() {
		MyPoint result = pointForOperations.horizontalSymmetry(simplePoint);	
	}	
	
	
    @Test(expected=IllegalArgumentException.class)
    public void testCentralSymmetryNULL ( ) {
        new MyPoint ( 10 , 20 ).centralSymmetry ( null ) ;
    }
    
    @Test 
    public void testsetPointRandom() {
    	Random mockPoint = mock(Random.class);
    	when(mockPoint.nextInt()).thenReturn(3);
    	Random mockPoint2 = mock(Random.class);
    	when(mockPoint2.nextInt()).thenReturn(5);
    	MyPoint nonRandom= new MyPoint();
    	nonRandom.setPoint(mockPoint,mockPoint2);
    	assertEquals(3d,nonRandom.getX(), 0.0001);
    	assertEquals(5d,nonRandom.getY(), 0.0001);
    }
    
    @Test
    public void testITranslation() {
    	MyPoint p = new MyPoint();
    	itrans = mock(ITranslation.class);
    	when(itrans.getTx()).thenReturn(2);
    	when(itrans.getTy()).thenReturn(4);
    	p.translate(itrans);
    	assertEquals(2d,p.getX(), 0.0001);
    	assertEquals(4d,p.getY(), 0.0001); 	
    }
    
    @Test
    public void testgetMiddlePoint() {
    	pointForOperations = pointForOperations.getMiddlePoint(new MyPoint(2.0, 2.0));
    	assertEquals(1d,pointForOperations.getX(), 0.0001);
    	assertEquals(1,pointForOperations.getY(), 0.0001);
    }
    
    @Test
    public void testrotatePoint() {
    	MyPoint p = new MyPoint(3,3);
    	p = p.rotatePoint(pointForOperations, 5.3);
    	assertEquals(4.159925335209186,p.getX(), 0.0001);
    	assertEquals(-0.8336793181342212,p.getY(), 0.0001); 	
    	
    }    
    @Test
    public void testcomputeAngle() {
    	MyPoint p = new MyPoint(3,3);
    	double res = p.computeAngle(pointForOperations);
    	System.out.println(res);
    	assertEquals(3.9269908169872414,res, 0.0001);	
    	
    }    
    
}
