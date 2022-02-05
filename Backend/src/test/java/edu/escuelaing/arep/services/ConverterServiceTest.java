package edu.escuelaing.arep.services;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterServiceTest extends TestCase {
    ConverterService converterService;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ConverterServiceTest( String testName ) {
        super( testName );
        this.converterService= new ConverterService();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( ConverterServiceTest.class );
    }

    public void testCelsiusToFahrenheitOne() {
        double res = this.converterService.celsiusToFahrenheit(10);

        assertEquals(res, 50.0);
    }

    public void testCelsiusToFahrenheitTwo() {
        double res = this.converterService.celsiusToFahrenheit(27.3);
        assertTrue(true);
        assertEquals(res, 81.14);
    }

    public void testCelsiusToFahrenheitThree() {
        double res = this.converterService.celsiusToFahrenheit(123456);
        assertEquals(res, 222252.8);
    }

    public void testCelsiusToFahrenheitFour() {
        double res = this.converterService.celsiusToFahrenheit(-67);
        assertEquals(res, -88.6);
    }

    public void testCelsiusToFahrenheitFive() {
        double res = this.converterService.celsiusToFahrenheit(0);
        assertEquals(res, 32.0);
    }

    public void testCelsiusToFahrenheitSix() {
        double res = this.converterService.celsiusToFahrenheit(96.685);
        assertEquals(res, 206.033);
    }

    public void testCelsiusToFahrenheitSeven() {
        double res = this.converterService.celsiusToFahrenheit(-0);
        assertEquals(res, 32.0);
    }

    public void testFahrenheitToCelsiusOne() {
        double res = this.converterService.fahrenheitToCelsius(0);
        assertEquals(res, -17.7778);
    }

    public void testFahrenheitToCelsiusTwo() {
        double res = this.converterService.fahrenheitToCelsius(-0);
        assertEquals(res, -17.7778);
    }

    public void testFahrenheitToCelsiusThree() {
        double res = this.converterService.fahrenheitToCelsius(25);
        assertEquals(res, -3.8889);
    }

    public void testFahrenheitToCelsiusFour() {
        double res = this.converterService.fahrenheitToCelsius(250);
        assertEquals(res, 121.1111);
    }

    public void testFahrenheitToCelsiusFive() {
        double res = this.converterService.fahrenheitToCelsius(14589);
        assertEquals(res, 8087.2222);
    }

    public void testFahrenheitToCelsiusSix() {
        double res = this.converterService.fahrenheitToCelsius(-789);
        assertEquals(res, -456.1111);
    }
}
