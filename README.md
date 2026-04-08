# PasswordManager - Secure Vault

Gestor de contrasenas desarrollado en Java, con persistencia en XML y seguridad mediante cifrado simetrico AES-128. Este proyecto permite almacenar credenciales de forma local, asegurando que los datos sensibles nunca se almacenen en texto plano.

## Caracteristicas

* **Persistencia Local:** Uso de Jakarta XML Binding (JAXB) para una gestion eficiente de bases de datos XML.
* **Seguridad:** Implementacion de cifrado AES para proteger URLs, nombres de usuario y contrasenas.
* **Interfaz Grafica (GUI):** Construida con la libreria Swing, con transiciones entre el panel de Login y el gestor principal.
* **Arquitectura:** Separacion de responsabilidades en paquetes core (logica), ui (interfaz) y model (datos).

## Stack Tecnologico

* **Lenguaje:** Java 17
* **Gestor de Dependencias:** Maven
* **Librerias Principales:**
    * jakarta.xml.bind-api: Serializacion de datos a XML.
    * jbcrypt: Soporte para hashing de contrasenas.
    * Java Crypto: Motor de cifrado y descifrado AES.

## Estructura del Proyecto

Directorio principal de fuentes:

* **core/manager/**: Logica de cifrado y persistencia XML.
* **core/model/**: Clases de datos (POJOs) y listas.
* **core/DatabaseChecker.java**: Verificacion y creacion de base de datos.
* **ui/**: Componentes de la interfaz de usuario (Swing).
* **Main.java**: Clase principal de arranque.

## Detalles de Seguridad

El sistema utiliza la clase CryptoManager para procesar la informacion antes de ser escrita en disco o mostrada en la interfaz.

* **Cifrado de Datos:** Se aplica un algoritmo simetrico AES a todos los campos del archivo database_vault.xml.
* **Validacion de Acceso:** El inicio de sesion requiere credenciales almacenadas de forma segura, evitando el acceso no autorizado a la base de datos de claves.

## Instalacion y Ejecucion

Para compilar y ejecutar este proyecto en sistemas Linux (como Parrot OS) o Windows, siga estos pasos:

1. **Clonar el repositorio:**
   git clone https://github.com/tu-usuario/PasswordManager.git
   cd PasswordManager

2. **Compilar y empaquetar con Maven:**
   mvn clean package

3. **Ejecutar el archivo JAR generado:**
   java -jar target/PasswordManager-1.0-SNAPSHOT.jar

## Notas Adicionales

Al ejecutarse por primera vez, la aplicacion genera automaticamente los archivos database_login.xml y database_vault.xml en la raiz del proyecto con las credenciales de administrador por defecto:

* **Usuario:** root
* **Clave:** root

Desarrollado por **Daniel de la Rosa**.
