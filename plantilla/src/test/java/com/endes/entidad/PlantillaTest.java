package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Pruebas unitarias para la clase Plantilla.
 */
class PlantillaTest {
    private Plantilla plantilla;
    Empleado empleado1;
    Empleado empleado2;

    @BeforeEach
    @DisplayName("Inicialización de la plantilla de empleados")
    void setUp() {
        plantilla = new Plantilla();
        empleado2 = new Tecnico("87654321B", "Ismael", "Dorantes", 1500.00, 6);
        plantilla.contratarEmpleado(empleado2);
    }

    /**
     * Prueba que verifica que no se puedan contratar empleados con el mismo DNI.
     */
    @Disabled
    @Test
    @DisplayName("No permite contratar empleados con el mismo DNI")
    void testContratarEmpleado_Duplicado() {
        Empleado tecnico1 = new Tecnico("11111111H", "Alejandro", "Fernández", 1000.0, 1);
        Empleado tecnico2 = new Tecnico("11111111H", "Carlos", "Pérez", 1200.0, 2); // Mismo DNI que el primero

        // Se permite el primer contrato
        assertDoesNotThrow(() -> plantilla.contratarEmpleado(tecnico1));

        // Intentar contratar otro empleado con el mismo DNI debería lanzar una excepción
        Exception ex = assertThrows(IllegalArgumentException.class, () -> plantilla.contratarEmpleado(tecnico2));

        // Verificar el mensaje de la excepción
        assertEquals("El empleado con DNI 11111111H ya está contratado", ex.getMessage());
    }
    
    @Test
    @DisplayName("test para contratar un empleado")
    void testContratarEmpleado () {
    	Empleado empleado1 = null;
    	IllegalArgumentException exceptionNull = assertThrows(IllegalArgumentException.class, () -> plantilla.contratarEmpleado(empleado1));
    	String mensajeEsperado = "No se puede contratar un empleado nulo";
    	assertEquals(mensajeEsperado, exceptionNull.getMessage());
    	
    	Empleado empleado3 = new Tecnico("87654321B", "Juanmi", "Ruiz", 1500.00, 6);
    	IllegalArgumentException exceptionDNI = assertThrows(IllegalArgumentException.class, () -> plantilla.contratarEmpleado(empleado3));
    	String mensajeEsperadoDNI = "No se puede contratar un empleado duplicado";
    	assertEquals(mensajeEsperadoDNI, exceptionDNI.getMessage());
    	
    	Empleado empleado4 = new Tecnico("87654321B", "Ismael", "Dorantes", 1500.00, 6);
    	IllegalArgumentException exceptionDuplicado = assertThrows(IllegalArgumentException.class, () -> plantilla.contratarEmpleado(empleado1));
    	String mensajeDuplicadoEsperado = "No se puede contratar un empleado con DNI duplicado";
    	assertEquals(mensajeDuplicadoEsperado, exceptionDuplicado.getMessage());
    	
    	
    }
}