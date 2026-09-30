# Matriz de casos
| ID | Regla | Escenario | Entrada | Esperado | Tipo | Riesgo |
|---|---|---|---|---|---|---|
| CP-01 | puedeCancelar | Anticipación habitual | 5 horas | true | Normal | Verificar que una reserva con suficiente anticipación pueda cancelarse. |
| CP-02 | puedeCancelar | Límite exacto permitido | 2 horas | true | Límite | Detectar un posible error de frontera si se implementa `> 2` en lugar de `>= 2`. |
| CP-03 | puedeCancelar | Debajo del límite | 1 hora | false | Límite | Evitar que se permita cancelar cuando no se cumplen las 2 horas mínimas. |
| CP-04 | calcularTotal | Cliente NORMAL | NORMAL, 100 | 100.0 | Normal | Comprobar que no se aplique descuento a una reserva normal. |
| CP-05 | calcularTotal | Cliente VIP | VIP, 100 | 85.0 | Alternativo | Comprobar la aplicación correcta del 15 % de descuento VIP. |
| CP-06 | calcularTotal | Cliente ESTUDIANTE | ESTUDIANTE, 100 | 90.0 | Alternativo | Comprobar la aplicación correcta del 10 % de descuento de estudiante. |
| CP-07 | calcularTotal | Total base igual a cero | VIP, 0 | 0.0 | Límite | Verificar que el valor mínimo no negativo sea procesado correctamente. |
| CP-08 | calcularTotal | Total base negativo | NORMAL, -1 | IllegalArgumentException: "Total base inválido" | Inválido / Excepción | Evitar procesar valores monetarios negativos. |
| CP-09 | confirmar | Reserva con disponibilidad | Reserva R-001 + disponibilidad true | Estado CONFIRMADA, se guarda y se notifica | Normal | Verificar que el flujo exitoso actualice el estado y ejecute las colaboraciones requeridas. |
| CP-10 | confirmar | Reserva sin disponibilidad | Reserva R-002 + disponibilidad false | IllegalStateException: "Horario no disponible"; no guardar ni notificar | Alternativo / Excepción | Evitar persistir o notificar una reserva que no puede confirmarse. |
| CP-11 | confirmar | Reserva nula | null | IllegalArgumentException: "Reserva obligatoria"; no consultar dependencias | Inválido / Excepción | Verificar que una entrada inválida detenga el flujo antes de interactuar con colaboradores externos. |
