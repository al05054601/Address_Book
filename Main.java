import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        book.load();

        while (true) {
            System.out.println("\n--- Menú de Agenda Telefónica ---");
            System.out.println("1. Listar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Guardar y salir");
            System.out.print("Seleccione una opción: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    book.list();
                    break;
                case "2":
                    System.out.print("Ingrese número: ");
                    String number = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String name = scanner.nextLine();
                    book.create(number, name);
                    break;
                case "3":
                    System.out.print("Ingrese número a eliminar: ");
                    String toDelete = scanner.nextLine();
                    book.delete(toDelete);
                    break;
                case "4":
                    book.save();
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}