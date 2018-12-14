Supuesto
--------

Vamos a refactorizar nuestro código para poder utilizarlo facilmente en proyectos futuros. Nos interesa convertir la interfaz `Identificable` en una interfaz genérica que nos permita que un elemento tengo como `id` cualquier tipo. Ejemplos serían:
1. `Libro` podría ser identificado por su ISBN
2. Una persona podría ser identificada por su _ID Card_
3. Un `Coche` podría ser identificado por su matrícula, pero incluso siendo matrícula del tipo `Matricula` y no sólo un `String`
4. Los `Nombrables` podrían implementarse para identificarse por su `nombre` en caso de no tener `Id`, o usar su `Id` como nombre.
5. Cualquier otro motivo que se os ocurra :)

Se pide:
1. Hacer los cambios necesarios para que `Identificable` sea genérico y proporcione un comparador para su tipo variable `T`.
2. Que `Nombrable` extienda `Identificable` para implementar el punto 4 anterior.
