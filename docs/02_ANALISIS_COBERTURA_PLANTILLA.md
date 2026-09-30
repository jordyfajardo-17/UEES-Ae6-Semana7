# Análisis de cobertura Ae6

## Medición previa y mejora

La primera ampliación ejecutó 15 pruebas sin fallos: 14 casos de negocio y la prueba inicial. En `ReservaService`, JaCoCo registró 20/21 líneas (95,24 %), 11/12 ramas (91,67 %) y 69/74 instrucciones (93,24 %). La evidencia está en `evidencias/01_ejecucion_previa.txt` y `02_cobertura_previa.csv`.

La rama verdadera de `reserva == null` en `confirmar` no estaba cubierta. Se añadió CP-11 para comprobar `IllegalArgumentException`, el mensaje y la ausencia de consultas, persistencia y notificación. Protege el rechazo temprano de una entrada inválida.

## Resultado final

La ejecución limpia final contiene 16 pruebas, cero fallos, cero errores y cero omitidas. `ReservaService` cubre 21/21 líneas, 12/12 ramas, 74/74 instrucciones y 4/4 métodos: 100 % en esas métricas. Todos sus métodos tienen cobertura completa. Consultar `evidencias/03_ejecucion_final.txt` y `04_cobertura_final.csv`, y regenerar el HTML con `mvn clean test`.

## Huecos y límites

El resultado del servicio no equivale al del proyecto. `Reserva` conserva huecos en los identificadores inválidos, el tipo nulo, los getters y `cancelar`; el detalle final se registra en el CSV. La suite se concentra en los tres comportamientos de Ae6 y no añade pruebas del dominio solo para subir el porcentaje.

Aunque todas las ramas del servicio se ejecutan, no se prueban fallos reales del repositorio o del notificador, concurrencia, transacciones ni integraciones externas. Si `guardar` falla, el objeto ya fue confirmado: el contrato de recuperación requiere una decisión de diseño y pruebas específicas. Tampoco se define una política monetaria para NaN, infinito, redondeo, tipo desconocido o nulo.

Una implementación que aplique 20 % de descuento VIP podría cubrir las mismas líneas y ramas. La aserción que exige 85 para una base de 100 detecta ese error; el porcentaje por sí solo no lo detecta. La prueba de reserva nula mejora una rama y el contrato de interacciones, mientras que las pruebas de frontera protegen errores como cambiar `>= 2` por `> 2`.
