package com.endes.entidad;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComercialTest {

	Comercial comercial;
	
	@BeforeEach
	void setUp() throws Exception {
		comercial = new Comercial("12345678A", "Javier", "Martinez Becket", 2000.50, 10.00); 
	}

	@Test
	@DisplayName("Deberia obtener las ventas del comercial")
	void testObtenerVentas() {
		double ventaEsperada = 10.00;
		assertEquals(ventaEsperada, comercial.getVentas());
	}
	
	@Test
	@DisplayName("Debe lanzar una excepción si el valor es negativo")
	void testSetventaNegativo() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->comercial.setVentas(-5.00));
		String mensajeEsperado = "Las ventas no pueden ser negativas";
		
		assertEquals(mensajeEsperado, exception.getMessage());
	}
	
	@Test
	@DisplayName("Calcular extra")
	void testCalcularExtra() {
		double valorEsperado = 1;
		
		assertEquals(valorEsperado, comercial.calcularExtra());
	}
	
	@Test
	@DisplayName("Debe comprobarse con diferentes valores de ventas")
	void testGetSueldo() {
		Double valorEsperado = 2001.50;
		assertEquals(valorEsperado, comercial.getSueldo());
	}

}
