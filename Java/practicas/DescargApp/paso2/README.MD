Supuesto
--------

Continuando con la práctica y una vez implementado el diseño propuesto, nos hemos dado cuenta de un error de diseño que implica varios problemas:
1. `Libro` no tiene `getTitulo()`
2. Hemos implementado el método `toString()` de manera rápida utilizando el `id` y el `tamano` que es lo que nos hacía falta para pruebas. Podemos añadir el título pero no podrá usarse lo mismo para `Libro` por el punto 1
3. Si entendemos `Fichero` como el archivo donde se guarda el contenido, sería más apropiado que no tuviera `getTitulo()` y que tuviera `getNombreArchivo()` por ejemplo
4. Estamos tratando el contenido como `Fichero`s, pero en realidad sería mejor separar el contenido (que será lo que normalmente busquen los usuarios) de su soporte en archivo
5. Además un mismo contenido puede estar en varios ficheros (por ejemplo una cación puede estar en un single o formando parte de un album, una película puede formar parte de una saga, etc...). Sería bueno proponer alternativas de descarga que se ajusten más a lo que realmente quiere el usuario.

Con todos estos problemas identificados vamos a **rediseñar la aplicación y hacer los cambios necesarios reutilizando la mayor parte del código ya implementado**.

_NOTA: No hace falta añadir nuevas interfaces._
