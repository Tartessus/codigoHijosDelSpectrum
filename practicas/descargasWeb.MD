Practica: Descargas Web
=======================

Supuesto
--------
La práctica trata sobre diseñar e implementar un prototipo basado en el supuesto de una aplicación de descarga de contenido desde un sitio web.

En nuestra aplicación se van a _**poder descargar ficheros de música y películas**_:
1. El contenido de estos ficheros tendrá una forma de identificarlos distinta del título, pues podría haber música o películas con el mismo título.
1. La música además tendrá un artista o intérprete y las películas un director y los actores principales.
3. Además los ficheros para descargar tendrán un tamaño en MB.

La aplicación permitirá ir añadiendo a una _**lista de descarga**_ el contenido que se desea descargar y cuando se quiera empezar la descarga la aplicación _**emitirá un informe**_ (usando la consola) con un listado de todas las descargas seleccionadas ordenadas por orden de su identificador (que es único), el tamaño total de todas las descargas y el tiempo estimado que tardará en descargarse (dividido en horas, minutos y segundos) dependiende de la velocidad de la conexión.

### Aspectos a tener en cuenta para el diseño
Se tiene previsto añadir descargas para software y libros usando una librería de software libre. El único requisito es que se use Java, pero el diseño que se haga en esta práctica debe permitir añadir esa librería fácilmente para que se use sin ningún cambio el código que proporciona la funcionalidad de ordenar el informe por `id`, sumar el tamaño de la descarga y calcular el tiempo.

También se podrá buscar contenido filtrando por alguno de sus datos como artista, director o actor. La interfaz de búsqueda podría tener controles tipo combobox para mostrar por ejemplo los artistas diponibles en nuestra base de datos.

Pruebas
-------
Para la prueba los datos serán cualquiera que cumpla con la información que se necesita (cualesquiera que sean las canciones y peliculas, al menos una de cada) y sirva para probar la funcionalidad indicada (distintas velocidades de conexión), más tarde se hará una migración de los datos verdaderos.

Tanto los datos de prueba como la selección de cuáles descargar estarán _'hard coded'_ en el método `main` porque todavía no hemos visto entrada y salida de datos, pero no se permite ningún otro _magic number_.

En esta práctica es necesario utilizar todo lo que hemos visto hasta ahora (en programación, pero también en ingeniería de requisitos y modelado de datos) para poder completarla cumpliendo todos los requisitos.

Organización de la práctica
---------------------------
Para la práctica se organizarán grupos de 4 a 5 personas que es lo normal en un equipo de desarrollo.

Entre todo el equipo, tras el estudio del supuesto, se acordará cuál es el mejor diseño y qué hace falta para implementarlo.

A la hora de construir se puede repartir la carga entre todos (para practicar cómo encaja el trabajo de varios programadores) o hacer varias versiones, pero programar mínimo en parejas.

**Lo importante es que los datos de prueba sean los mismos y se tengan claros los resultados esperados** cumpliendo con lo indicado para que las pruebas sean consistentes.
