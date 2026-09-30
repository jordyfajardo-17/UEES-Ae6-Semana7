# Pull Request Ae6

## Objetivo
Proteger las reglas de cancelación, descuentos y confirmación del módulo de reservas y entregar evidencia reproducible de Ae6.

## Cambios realizados
- 15 casos de negocio con JUnit 5; se conserva la prueba inicial.
- Disponibilidad controlada como stub y persistencia/notificación verificadas como mocks.
- Matriz, métricas antes y después, logs de Maven, análisis y autorrevisión.

## Casos de prueba
- Cancelación: 5, 2, 1, 0 y -1 horas.
- Totales: NORMAL, VIP, ESTUDIANTE, cero, negativo y tipos en minúsculas.
- Confirmación: disponible, no disponible y reserva nula; estado, excepción e interacciones.

## Cómo verificar
```bash
mvn clean test
```

## Cobertura
`ReservaService`: de 20/21 líneas y 11/12 ramas a 21/21 y 12/12 (100 %), añadiendo la prueba de reserva nula tras revisar JaCoCo. Ejecución final: 16 pruebas, 0 fallos, 0 errores, 0 omitidas. Java 21 y Maven 3.9.16. Ver `docs/evidencias`.

## Limitaciones
Sin pruebas de integración, transacciones, concurrencia ni recuperación ante fallos de persistencia/notificación. El dominio `Reserva` conserva métodos y ramas sin cubrir. Cobertura completa del servicio no garantiza corrección para todas las entradas monetarias. No se modificó producción.

## Autorrevisión
- [x] Compila con Java 21
- [x] Pruebas en verde
- [x] `target/` ignorado; evidencia seleccionada explícitamente
- [x] Commits descriptivos
- [x] Documentación y matriz actualizadas

## Uso de IA
OpenAI Codex asistió en diseño de casos, implementación JUnit/Mockito, ejecución de Maven, lectura de JaCoCo, documentación y preparación de Git/PR. Las afirmaciones de ejecución se respaldan con logs y CSV. La revisión asistida no sustituye la revisión académica del estudiante.
