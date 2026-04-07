package core.manager;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.File;

public class XmlManager {

    private static final String DEFAULT_FILE = "database.xml";

    /**
     * Método Genérico para guardar cualquier objeto anotado con JAXB en un XML.
     * @param data El objeto a guardar (debe tener @XmlRootElement)
     * @param fileName El nombre del archivo (ej: "database.xml")
     */
    public static <T> void write(T data, String fileName) {
        try {
            // Creamos el contexto basado en la clase del objeto que le pasamos
            JAXBContext context = JAXBContext.newInstance(data.getClass());
            Marshaller marshaller = context.createMarshaller();

            // Configuración para que el XML sea legible
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Guardamos en el archivo
            marshaller.marshal(data, new File(fileName));

            System.out.println("Objeto " + data.getClass().getSimpleName() + " guardado en " + fileName);
        } catch (Exception e) {
            System.err.println("Error al marshallear el objeto: " + e.getMessage());
            e.printStackTrace();
        }
    }
}