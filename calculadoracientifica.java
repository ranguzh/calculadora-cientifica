// CalculadoraCientifica.java
import java.util.Scanner;

public class calculadoracientifica {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.iniciar();
        scanner.close();
    }
}

// Menu.java
class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final OperacionesGeometricas operacionesGeometricas = new OperacionesGeometricas();

    public void iniciar() {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = obtenerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 2);
    }

    private void mostrarMenuPrincipal() {
        System.out.println("\n=== Calculadora de Área y Perímetro ===");
        System.out.println("1. Cálculos Geométricos");
        System.out.println("2. Salir");
    }

    private int obtenerOpcion() {
        System.out.print("Seleccione una opción: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> operacionesGeometricas.mostrarMenu();
            case 2 -> System.out.println("¡Gracias por usar la calculadora científica!");
            default -> System.out.println("Opción no válida");
        }
    }
}

// OperacionesGeometricas.java
class OperacionesGeometricas {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n=== Cálculos Geométricos ===");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");

        int figura = obtenerOpcion("Seleccione una figura: ");
        int operacion = obtenerOpcion("¿Qué desea calcular? (1: Área, 2: Perímetro): ");

        calcular(figura, operacion);
    }

    private int obtenerOpcion(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void calcular(int figura, int operacion) {
        switch (figura) {
            case 1 -> calcularCirculo(operacion);
            case 2 -> calcularCuadrado(operacion);
            case 3 -> calcularTriangulo(operacion);
            case 4 -> calcularRectangulo(operacion);
            case 5 -> calcularPentagono(operacion);
            default -> System.out.println("Figura no válida");
        }
    }

    private void calcularCirculo(int operacion) {
        System.out.print("Ingrese el radio: ");
        double radio = scanner.nextDouble();
        if (operacion == 1) {
            System.out.println("Área del círculo: " + (Math.PI * radio * radio));
        } else {
            System.out.println("Perímetro del círculo: " + (2 * Math.PI * radio));
        }
    }

    private void calcularCuadrado(int operacion) {
        System.out.print("Ingrese el lado: ");
        double lado = scanner.nextDouble();
        if (operacion == 1) {
            System.out.println("Área del cuadrado: " + (lado * lado));
        } else {
            System.out.println("Perímetro del cuadrado: " + (4 * lado));
        }
    }

    private void calcularTriangulo(int operacion) {
        if (operacion == 1) {
            System.out.print("Ingrese la base: ");
            double base = scanner.nextDouble();
            System.out.print("Ingrese la altura: ");
            double altura = scanner.nextDouble();
            System.out.println("Área del triángulo: " + (base * altura / 2));
        } else {
            System.out.print("Ingrese el primer lado: ");
            double lado1 = scanner.nextDouble();
            System.out.print("Ingrese el segundo lado: ");
            double lado2 = scanner.nextDouble();
            System.out.print("Ingrese el tercer lado: ");
            double lado3 = scanner.nextDouble();
            System.out.println("Perímetro del triángulo: " + (lado1 + lado2 + lado3));
        }
    }

    private void calcularRectangulo(int operacion) {
        System.out.print("Ingrese la base: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura: ");
        double altura = scanner.nextDouble();
        if (operacion == 1) {
            System.out.println("Área del rectángulo: " + (base * altura));
        } else {
            System.out.println("Perímetro del rectángulo: " + (2 * (base + altura)));
        }
    }

    private void calcularPentagono(int operacion) {
        System.out.print("Ingrese el lado: ");
        double lado = scanner.nextDouble();
        if (operacion == 1) {
            System.out.print("Ingrese el apotema: ");
            double apotema = scanner.nextDouble();
            System.out.println("Área del pentágono: " + (5 * lado * apotema / 2));
        } else {
            System.out.println("Perímetro del pentágono: " + (5 * lado));
        }
    }
}
