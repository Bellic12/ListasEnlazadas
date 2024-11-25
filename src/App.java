import Listas.*;
import Interfaces.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

public class App {
    // Función para medir el tiempo de ejecución de las funciones de las listas
    public static <T> void measureExecutionTime(int n, String listType, String functionName, Consumer<IListasEnlazadas<T>> function, IListasEnlazadas<T> lista) {
        long startTime = System.currentTimeMillis();
        function.accept(lista);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        try (FileWriter writer = new FileWriter("execution_times.csv", true)) {
            writer.append(n + "," + listType + "," + functionName + "," + duration + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        int[] ns = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 20000000, 30000000, 40000000, 50000000,
            60000000, 70000000, 80000000, 90000000, 100000000}; // Valores de n que aumentan

        for (int n : ns) {
            System.out.println("n = " + n);
            // Probar con SencillaSinCola
            SencillaSinCola<Integer> lista1 = new SencillaSinCola<>();
            System.out.println("SencillaSinCola");
            for (int i = n; i > 0; i--) {
                lista1.pushFront(i);
            }
            measureExecutionTime(n, "SencillaSinCola", "pushFront", l -> l.pushFront(-1000), lista1);
            measureExecutionTime(n, "SencillaSinCola", "pushBack", l -> l.pushBack(-2000), lista1);
            measureExecutionTime(n, "SencillaSinCola", "popFront", l -> l.popFront(), lista1);
            measureExecutionTime(n, "SencillaSinCola", "popBack", l -> l.popBack(), lista1);
            measureExecutionTime(n, "SencillaSinCola", "find", l -> l.find(n-5), lista1);
            lista1.pushBack(-3000); // Agregar un nodo específico para la prueba
            INodo<Integer> nodoPrueba = lista1.find(-3000);
            measureExecutionTime(n, "SencillaSinCola", "addBefore", l -> l.addBefore(nodoPrueba, -4000), lista1);
            measureExecutionTime(n, "SencillaSinCola", "addAfter", l -> l.addAfter(nodoPrueba, -5000), lista1);
            measureExecutionTime(n, "SencillaSinCola", "erase", l -> l.erase(-3000), lista1);
            measureExecutionTime(n, "SencillaSinCola", "empty", l -> l.empty(), lista1);
            measureExecutionTime(n, "SencillaSinCola", "topFront", l -> l.topFront(), lista1);
            measureExecutionTime(n, "SencillaSinCola", "topBack", l -> l.topBack(), lista1);

            // Probar con SencillaConCola
            System.out.println("SencillaConCola");
            SencillaConCola<Integer> lista2 = new SencillaConCola<>();
            for (int i = n; i > 0; i--) {
                lista2.pushFront(i);
            }
            measureExecutionTime(n, "SencillaConCola", "pushFront", l -> l.pushFront(-1000), lista2);
            measureExecutionTime(n, "SencillaConCola", "pushBack", l -> l.pushBack(-2000), lista2);
            measureExecutionTime(n, "SencillaConCola", "popFront", l -> l.popFront(), lista2);
            measureExecutionTime(n, "SencillaConCola", "popBack", l -> l.popBack(), lista2);
            measureExecutionTime(n, "SencillaConCola", "find", l -> l.find(n-5), lista2);
            lista2.pushBack(-3000); // Agregar un nodo específico para la prueba
            INodo<Integer> nodoPrueba2 = lista2.find(-3000);
            measureExecutionTime(n, "SencillaConCola", "addBefore", l -> l.addBefore(nodoPrueba2, -4000), lista2);
            measureExecutionTime(n, "SencillaConCola", "addAfter", l -> l.addAfter(nodoPrueba2, -5000), lista2);
            measureExecutionTime(n, "SencillaConCola", "erase", l -> l.erase(-3000), lista2);
            measureExecutionTime(n, "SencillaConCola", "empty", l -> l.empty(), lista2);
            measureExecutionTime(n, "SencillaConCola", "topFront", l -> l.topFront(), lista2);
            measureExecutionTime(n, "SencillaConCola", "topBack", l -> l.topBack(), lista2);

            // Probar con DobleConCola
            DobleConCola<Integer> lista3 = new DobleConCola<>();
            System.out.println("DobleConCola");
            for (int i = n; i > 0; i--) {
                lista3.pushBack(i);
            }
            measureExecutionTime(n, "DobleConCola", "pushFront", l -> l.pushFront(-1000), lista3);
            measureExecutionTime(n, "DobleConCola", "pushBack", l -> l.pushBack(-2000), lista3);
            measureExecutionTime(n, "DobleConCola", "popFront", l -> l.popFront(), lista3);
            measureExecutionTime(n, "DobleConCola", "popBack", l -> l.popBack(), lista3);
            measureExecutionTime(n, "DobleConCola", "find", l -> l.find(n-5), lista3);
            lista3.pushBack(-3000); // Agregar un nodo específico para la prueba
            INodo<Integer> nodoPrueba3 = lista3.find(-3000);
            measureExecutionTime(n, "DobleConCola", "addBefore", l -> l.addBefore(nodoPrueba3, -4000), lista3);
            measureExecutionTime(n, "DobleConCola", "addAfter", l -> l.addAfter(nodoPrueba3, -5000), lista3);
            measureExecutionTime(n, "DobleConCola", "erase", l -> l.erase(-3000), lista3);
            measureExecutionTime(n, "DobleConCola", "empty", l -> l.empty(), lista3);
            measureExecutionTime(n, "DobleConCola", "topFront", l -> l.topFront(), lista3);
            measureExecutionTime(n, "DobleConCola", "topBack", l -> l.topBack(), lista3);
        }
    }
}