# Respuestas a las preguntas

1. Diferencias al comparar entre usar los operadores `foo = bar`, `foo == bar` y el método `foo.equals(bar)`

   El operador `=` es el operador de asignación y no sirve para comparar.
   
   El operador **`==` sirve para comparar si los valores de los operandos tienen la misma referencia**. Devolverá `true` si es la misma (los operandos son el mismo objeto) y `false` en caso contrario.
   
   El método **`equals` depende de la implementación que contenga**:
     * Se usa para determinar si dos objetos deben tratarse como iguales, normalmente comparando el contenido relevante de `foo` vs `bar`.
     * Devolverá `true` o `false` al final de la evaluación de su implementación.
     * Su implementación debería cumplir las [propiedades descritas en su definición](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals-java.lang.Object-).
     * Pero nada nos impedirá implementarlo como `return false;` dando este resultado siempre. En este caso podríamos obtener resultados inesperados de otras clases que lo utilicen para su funcionamiento como clases que implementan las interfaces [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html) o [Set](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html)
     * Es importante decir que si `foo` es `null` producirá la excepción [`NullPointerException`](https://docs.oracle.com/javase/8/docs/api/java/lang/NullPointerException.html). Podemos evitarlo si usamos una llamada estática con `Objects.equals(foo, bar);`.
   
1. **Diferencias** entre una clase normal, una abstracta y una interfaz.

   |   |[class](https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html)|[abstract class](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)|[interface](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)|
   |---|---|---|---|
   |Finalidad|Permiten construir objetos de su tipo|Encapsulan código común para subtipos|Definen un **contrato/comportamiento para tipos sin relación** que las implementen|
   |Acceso a variables|Sin restricciones|Sin restricciones|Sólo `public static final`|
   |Métodos|Deben tener todos implementados|No están obligadas a implementar todos sus miembros|* Definen qué metodos son necesarios implementar para cumplir con su contrato.<br/>* Pueden tener una implementación por defecto usando `default`.<br/>* Todos son `public`.|
   |Herencia|Herencia simple con `extends`|Herencia simple con `extends`|Implementación de cualquier número de interfaces por un mismo tipo con `implements`, otorgando más posibilidades de reutilización al evitar las restricciones que conlleva la herencia simple de las clases|
   
1. ¿Qué **relación** tiene el concepto "erasure" con la definición de clase:
`class MiClase implements Comparable<String>, Comparable<Integer> {...}`? Explícalo.

   Al compilar [type erasure](https://docs.oracle.com/javase/tutorial/java/generics/erasure.html) va a eliminar los tipos variables por tipos concretos compatibles con el código, en este caso tendríamos implementada la misma interfaz por duplicado y no está permitido.
1. Explica si compilará la sentencia: `Object[] array = { "", 0, true, new Object() };`

   La sentencia es correcta pues está usando el "azucar sintáctico" correctamente a la hora de inicializar la variable y el valor asignado es correcto (todo su contenido está formado por tipos `Object` al convertirse los valores respectivos en sus respectivas clases wrapper)
1. Explica si es sintácticamente correcta la sentencia: `Collection<int> enteros = new ArrayList<>();`

   Es incorrecta pues `int` es un tipo primitivo y los tipos variables son tipos por referencia. Debería escribirse `Integer` en vez de `int`.
