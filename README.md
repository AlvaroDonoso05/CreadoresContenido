# Aplicación de Gestión de Creadores

## Descripción

La aplicación tiene como objetivo gestionar toda la información relacionada con los creadores de contenido en diferentes plataformas, tales como YouTube, Instagram y Twitch. La aplicación permitirá a los creadores analizar y optimizar su contenido, su interacción con los seguidores y gestionar colaboraciones con otros creadores.

### Funcionalidades de la Aplicación

La aplicación debe ser capaz de realizar las siguientes tareas:

---

### 1. **Lectura y visualización de datos**
   - **Objetivo**: Leer y mostrar los datos de los creadores, plataformas y colaboraciones.
   - **Acción**:
     - Leer los datos de los archivos `creadores.json` y `metricas_contenido.csv`.
     - Mostrar la información de todos los creadores, plataformas y colaboraciones.

---

### 2. **Análisis de métricas de rendimiento**
   - **Objetivo**: Calcular el rendimiento de cada creador en cada plataforma.
   - **Acción**:
     - Calcular el promedio de vistas y "me gusta" en las publicaciones de cada creador en sus plataformas.
     - Identificar el tipo de contenido con mayor rendimiento en cada plataforma.

---

### 3. **Inserción de una nueva colaboración**
   - **Objetivo**: Añadir una nueva colaboración entre dos creadores existentes.
   - **Acción**:
     - Permitir la adición de colaboraciones entre dos creadores.
     - Actualizar las métricas de impacto en las plataformas correspondientes.

---

### 4. **Exportación de colaboraciones a CSV**
   - **Objetivo**: Guardar todas las colaboraciones en un archivo CSV.
   - **Acción**:
     - Extraer todas las colaboraciones y exportarlas a un archivo CSV (`colaboraciones.csv`), incluyendo la fecha, los creadores involucrados, y el impacto en seguidores y visualizaciones.

---

### 5. **Modificación y eliminación de publicaciones**
   - **Objetivo**: Modificar o eliminar publicaciones basadas en el rendimiento.
   - **Acción**:
     - Modificar los datos de una publicación en el archivo CSV (p. ej., actualizar el número de "me gusta" o comentarios).
     - Eliminar una publicación que no haya alcanzado un mínimo de vistas, como las que tienen menos de 10,000 vistas.

---

### 6. **Creación de un informe JSON**
   - **Objetivo**: Generar un archivo JSON que resuma:
     - El total de seguidores de cada creador en todas sus plataformas.
     - La plataforma con mayor interacción promedio para cada creador.

---

### 7. **Análisis de Seguidores y Crecimiento**
   - **Objetivo**: Calcular la tasa de crecimiento de seguidores de cada creador en sus plataformas durante el primer trimestre de 2023.
   - **Instrucciones**:
     - Utilizar el JSON para extraer los datos del historial de cada plataforma y calcular el crecimiento mensual.

---

### 8. **Reporte de Colaboraciones**
   - **Objetivo**: Generar un reporte en CSV con todas las colaboraciones.
   - **Instrucciones**:
     - Extraer todas las colaboraciones del JSON, incluyendo la fecha, la plataforma y el colaborador.

---

### 9. **Análisis Comparativo de Rendimiento**
   - **Objetivo**: Comparar el rendimiento promedio de cada tipo de contenido (video, imagen, stream) en cada plataforma.
   - **Instrucciones**:
     - Utilizar el CSV para calcular el promedio de vistas y "me gusta" para cada tipo de contenido.

---

### 10. **Creación de un JSON de Resumen de Rendimiento**
   - **Instrucciones**:
     - Para cada creador, incluir un objeto con la plataforma que generó más vistas y la plataforma que generó más interacciones promedio en 2023.

---

### 11. **Gestión de Contenido**
   - **Objetivo**: Permitir agregar, modificar y eliminar publicaciones en el CSV.
   - **Instrucciones**:
     1. Añadir una publicación nueva a `metricas_contenido.csv`.
     2. Modificar el número de "me gusta" y comentarios de una publicación específica.
     3. Eliminar una publicación que no haya alcanzado un mínimo de vistas.

---

### 12. **Conversión de Colaboraciones a JSON**
   - **Objetivo**: Convertir todas las colaboraciones a un archivo JSON `colaboraciones.json`.
   - **Instrucciones**:
     - Extraer las colaboraciones y estructurarlas en un nuevo archivo JSON que contenga objetos con la fecha, el creador, el colaborador y los impactos de la colaboración.

---

## Requisitos del Sistema

La aplicación requiere que los siguientes archivos estén disponibles para su correcto funcionamiento:

### Archivos Necesarios
1. **Archivo JSON: `creadores.json`**
   - Contiene detalles de los creadores de contenido, plataformas en las que participan, y colaboraciones realizadas.
2. **Archivo CSV: `metricas_contenido.csv`**
   - Contiene métricas de rendimiento de cada publicación, incluyendo vistas, "me gusta", comentarios y compartidos en diversas plataformas.

### Requisitos Técnicos
1. **JDK 11 o superior**
2. **Librerías:**
   - **Jackson** para la manipulación de JSON (para leer y escribir archivos JSON).
   - **OpenCSV** para leer y escribir archivos CSV.
   - **JFreeChart** para la visualización gráfica de métricas y crecimiento.
   - **Swing** para la interfaz gráfica de usuario (GUI).
   
---

## Flujo de Trabajo

1. **Lectura de Archivos**: La aplicación cargará los datos desde los archivos `creadores.json` y `metricas_contenido.csv` al inicio. Utilizando Jackson, se procesará el archivo JSON para obtener la lista de creadores y plataformas. Luego, OpenCSV se encargará de la lectura de las métricas asociadas a cada publicación en el CSV.

2. **Interacción con el Usuario**:
   - La interfaz mostrará los creadores, plataformas y métricas de sus publicaciones.
   - Los usuarios podrán seleccionar creadores, plataformas y ver las estadísticas correspondientes de cada uno.
   - Podrán agregar, modificar o eliminar colaboraciones y publicaciones, con la opción de actualizar las métricas o eliminar las publicaciones con un rendimiento insuficiente.

3. **Análisis de Datos**: 
   - La aplicación calculará y mostrará métricas como las vistas promedio, "me gusta", comentarios y tasa de crecimiento de seguidores para cada creador.
   - El sistema también analizará el impacto de las colaboraciones en el crecimiento de seguidores y visualizaciones, y generará reportes de estos datos.

4. **Generación de Reportes**:
   - Los reportes se exportarán en formato JSON y CSV. Por ejemplo, el reporte de colaboraciones será exportado en un archivo CSV, mientras que el resumen de seguidores y plataformas con mayor interacción se exportará en un archivo JSON.

5. **Visualización Gráfica**: Se generarán gráficos de tipo circular para mostrar estadísticas de interacciones y de rendimiento, utilizando JFreeChart. Los gráficos se actualizarán de manera dinámica en la interfaz para mostrar los resultados en tiempo real.

---

## Beneficios de la Aplicación

- **Optimización de Contenido**: Los creadores pueden ver sus métricas y determinar qué tipo de contenido está teniendo mejor rendimiento.
- **Colaboraciones Eficientes**: La gestión y análisis de colaboraciones permite a los creadores optimizar sus esfuerzos en redes sociales, identificar a sus colaboradores más efectivos y medir el impacto en su crecimiento.
- **Automatización del Análisis de Datos**: Gracias a la integración con archivos JSON y CSV, la aplicación realiza un análisis detallado y permite la generación de reportes con un solo clic.
- **Interfaz Gráfica Atractiva y Funcional**: Con una interfaz sencilla basada en Swing y gráficos interactivos, los creadores pueden analizar su información de manera rápida y efectiva.

---

## Tecnologías Utilizadas

- **Java**: El lenguaje principal para la implementación de la lógica de la aplicación.
- **Jackson**: Para la manipulación de archivos JSON (lectura y escritura).
- **OpenCSV**: Para manejar los archivos CSV y realizar operaciones con los datos de las métricas.
- **JFreeChart**: Para crear gráficos interactivos para las métricas y análisis.
- **Swing**: Para la creación de la interfaz gráfica de usuario (GUI).
- **FlatLaf**: Para una interfaz moderna y ligera con soporte para temas oscuros y claros.
- **JCalendar**: Utilizado para implementar selectores de fechas en la interfaz de usuario.

---

## Capturas de Pantalla

(Agrega aquí capturas de pantalla de la aplicación en uso, por ejemplo, cómo se visualizan las métricas, las colaboraciones, o los gráficos.)

---

## Contribuir

Si deseas contribuir al desarrollo de esta aplicación, por favor sigue estos pasos:

1. **Fork** el repositorio.
2. Crea una rama para tu funcionalidad (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y asegúrate de que las pruebas pasen (`git commit -am 'Agregada nueva funcionalidad'`).
4. **Push** a tu rama (`git push origin feature/nueva-funcionalidad`).
5. Crea un **Pull Request** explicando tus cambios.

---

## Autores

- **Alvaro Donoso** – *Desarrollador*
- **Izan García** – *Desarrollador*

---

## Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE.md](LICENSE.md) para más detalles.
