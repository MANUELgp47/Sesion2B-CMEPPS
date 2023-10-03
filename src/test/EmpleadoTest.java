package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {
	
	private TipoEmpleado tipo = TipoEmpleado.Vendedor ;
	private float mes = 1000;
	private float hora = 10;
	private int nominaBruta = 2400;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculoNominaBrutaVendedor() {
		float expected = 2400;
		float actual = Empleado.calculoNominaBruta(tipo, mes, hora);
		assertEquals(expected, actual);
	}
	@Test
	void testCalculoNominaBrutaEncargado() {
		float expected = 2900;
		tipo = TipoEmpleado.Encargado;
		float actual = Empleado.calculoNominaBruta(tipo, mes, hora);
		assertEquals(expected, actual);
	}
	@Test
	void testCalculoNominaBrutaOtro() {
		float expected = -1;
		tipo = TipoEmpleado.otro;
		float actual = Empleado.calculoNominaBruta(tipo, mes, hora);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaVentasNegativas() {
		mes=-8;
		float expected = -1;
		float actual = Empleado.calculoNominaBruta(tipo, mes, hora);
		assertEquals(expected, actual);
	}
	
	
	@Test
	void testCalculoNominaBrutaEntre1000y1500() {
		float expected = 2400;
		float actual = Empleado.calculoNominaBruta(tipo, mes, hora);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaEntre0y1000() {
		mes=999;
		float expected = 2300;
		float actual = Empleado.calculoNominaBruta(tipo, mes, hora);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaMayor1500() {
		mes=1501;
		float expected = 2500;
		float actual = Empleado.calculoNominaBruta(tipo, mes, hora);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaHorasBien() {
		mes=1501;
		float expected = 2500;
		float actual = Empleado.calculoNominaBruta(tipo, mes, hora);
		assertEquals(expected, actual);
	}
	@Test
	void testCalculoNominaBrutaHorasNegativas() {
		hora=-8;
		float expected = -1;
		float actual = Empleado.calculoNominaBruta(tipo, mes, hora);
		assertEquals(expected, actual);
	}
	
	
	
	
	
	
	
	
	/////Nomina neta
	

	@Test
	void testCalculaNominaNetaMenor2100() {
		nominaBruta=2090;
		float expected = 2090;
		float actual = Empleado.calculaNominaNeta(nominaBruta);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculaNominaNetaEntre2100y2500() {
		nominaBruta=2213;
		float expected =(float) 1881.05;
		float actual = Empleado.calculaNominaNeta(nominaBruta);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculaNominaNeta2500() {
		nominaBruta=2600;
		float expected =(float) 2132;
		float actual = Empleado.calculaNominaNeta(nominaBruta);
		assertEquals(expected, actual);
	}

}
