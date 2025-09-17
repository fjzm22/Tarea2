import java.util.Scanner;

public class Alumno {
    private final String nombre;
    private final int[] calificaciones; // arreglo de 5 calificaciones

    // Constructor
    public Alumno(String nombre, int[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    // Método para calcular el promedio
    public double calcularPromedio() {
        int suma = 0;
        for (int cal : calificaciones) {
            suma += cal;
        }
        return (double) suma / calificaciones.length;
    }

    // Método para obtener la calificación en letra
    public char obtenerCalificacion(double promedio) {
        if (promedio <= 50) {
            return 'F';
        } else if (promedio <= 60) {
            return 'E';
        } else if (promedio <= 70) {
            return 'D';
        } else if (promedio <= 80) {
            return 'C';
        } else if (promedio <= 90) {
            return 'B';
        } else {
            return 'A';
        }
    }

    // Método para imprimir resultados
    public void imprimirResultados() {
        double promedio = calcularPromedio();
        char califLetra = obtenerCalificacion(promedio);

        System.out.println("\n--- Resultados ---");
        System.out.println("Nombre del estudiante: " + nombre);
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Calificación " + (i + 1) + ": " + calificaciones[i]);
        }
        System.out.println("Promedio: " + promedio);
        System.out.println("Calificación: " + califLetra);
    }

    // Método main con varios alumnos
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Preguntar cuántos alumnos
        System.out.print("¿Cuántos alumnos deseas registrar? ");
        int numAlumnos = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        Alumno[] alumnos = new Alumno[numAlumnos];

        // Captura de datos
        for (int a = 0; a < numAlumnos; a++) {
            System.out.println("\n--- Alumno " + (a + 1) + " ---");

            // Pedir nombre
            System.out.print("Ingresa el nombre del estudiante: ");
            String nombre = sc.nextLine();

            // Pedir calificaciones con validación
            int[] calificaciones = new int[5];
            for (int i = 0; i < calificaciones.length; i++) {
                int nota;
                while (true) {
                    System.out.print("Ingresa la calificación " + (i + 1));
                    nota = sc.nextInt();
                    if (nota >= 0 && nota <= 100) {
                        break; // válido
                    } else {
                        System.out.println("❌ Error: la calificación debe estar entre 0 y 100. Intenta de nuevo.");
                    }
                }
                calificaciones[i] = nota;
            }
            sc.nextLine(); // limpiar buffer

            // Crear objeto y guardarlo en el arreglo
            alumnos[a] = new Alumno(nombre, calificaciones);
        }

        // Mostrar resultados de todos los alumnos
        System.out.println("\n========== Reporte Final ==========");
        for (Alumno alumno : alumnos) {
            alumno.imprimirResultados();
        }

        sc.close();
    }
}