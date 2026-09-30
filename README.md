# UEES UCOM0310 — Semana 7 — Proyecto base Ae6

Proyecto base para las actividades individuales de Semana 7.

## Entrega Ae6

La rama `ae6/suite-pruebas` añade 15 casos de negocio y conserva la prueba inicial: 16 pruebas exitosas. Se cubren cancelación, descuentos y confirmación con JUnit 5 y Mockito. No se modificó código productivo.

- [Matriz y trazabilidad](docs/01_MATRIZ_CASOS_PLANTILLA.md)
- [Análisis de cobertura](docs/02_ANALISIS_COBERTURA_PLANTILLA.md)
- [Descripción del Pull Request](docs/03_PULL_REQUEST_PLANTILLA.md)
- [Autorrevisión](docs/04_AUTORREVISION.md)
- [Reporte técnico de cuatro páginas](docs/05_REPORTE_TECNICO_Ae6.pdf)
- [Pull Request 1](https://github.com/jordyfajardo-17/UEES-Ae6-Semana7/pull/1)
- [Evidencias de ejecución y métricas](docs/evidencias)

Usa Java 21 y comprueba `mvn -version` antes de ejecutar `mvn clean test`. En este equipo, Java 21 está incluido en la extensión Java de VS Code; el Java 26 predeterminado no es compatible con JaCoCo 0.8.12. La ruta local usada se registra en el reporte, pero no es un requisito portable.

`ReservaService` alcanza 100 % de líneas y ramas. El proyecto completo conserva huecos del dominio; consulta el análisis. El HTML se genera en `target/site/jacoco/index.html` y `target/` no se versiona.

Se utilizó OpenAI Codex para diseñar y escribir pruebas, ejecutar Maven, interpretar JaCoCo, redactar documentación y preparar Git/PR. La asistencia y sus limitaciones se declaran en el reporte técnico.

## Requisitos
- Java 21
- Maven 3.9+
- Git

## Verificación inicial
```bash
mvn clean test
```

## Cobertura
```bash
mvn clean test
```

Luego abrir:
`target/site/jacoco/index.html`

## Regla de trabajo
No modifiques el código productivo solo para hacer pasar una prueba sin justificar el cambio.
Primero diseña el caso, luego implementa la prueba y finalmente interpreta el resultado.
