import java.io.*;
import java.util.*;

public class AddressBook {
    private Map<String, String> contacts = new HashMap<>();
    private final String filePath = "contacts.csv";

    // Cargar contactos desde archivo CSV
    public void load() {
        contacts.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    contacts.put(parts[0], parts[1]);
                }
            }
            System.out.println("Contactos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo: " + e.getMessage());
        }
    }

    // Guardar contactos en archivo CSV
    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
            System.out.println("Contactos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo: " + e.getMessage());
        }
    }

    // Mostrar contactos
    public void list() {
        System.out.println("Contactos:");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Crear nuevo contacto
    public void create(String number, String name) {
        contacts.put(number, name);
        System.out.println("Contacto agregado.");
    }

    // Eliminar contacto
    public void delete(String number) {
        if (contacts.remove(number) != null) {
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("Número no encontrado.");
        }
    }
}
