package co.escuelaing.edu.arep;

public class ReflexCalculator {
    private static class helper {
        private static final ReflexCalculator INSTANCE = new ReflexCalculator();
    }
    public static ReflexCalculator getInstance() {
        return helper.INSTANCE;
    }
    /**
     * Calcula el coseno de un numero
     *
     * param num Numero a procesar
     * return el valor de la tangente del numero
     */
    public final Operations cos = (Double num) -> {
        return Math.cos(num);
    };
    /**
     * Calcula el seno de un numero
     *
     * param num Numero a procesar
     * return el valor de la tangente del numero
     */
    public final Operations sin = (Double num) -> {
        return Math.sin(num);
    };
    /**
     * Calcula la tangente de un numero
     *
     * param num Numero a procesar
     * return el valor de la tangente del numero
     */
    public final Operations tan = (Double num) -> {
        return Math.tan(num);
    };
    /**
     * Interfaz funcional de las operaciones
     */
    interface Operations {
        Double operation(Double num);
    }
    /**
     *
     * @param num numero con el cual se va a realizar la operación
     * @param op operacion la cual se quiere realizar
     * @return Double resultado de la operación
     */
    public Double operate(Double num, Operations op) {
        return op.operation(num);
    }
}

