CORBA-java-idl-simple-calc
==========================

Este proyecto implementa una aplicación de calculadora distribuida utilizando la arquitectura de objetos distribuidos Common Object Request Broker Architecture (CORBA). La aplicación permite realizar operaciones aritméticas básicas entre dos números de punto flotante, así como entre dos fracciones. La aplicación también maneja el caso especial de la división por cero, lo que resulta en una excepción.

***Requisitos***

Para ejecutar esta aplicación, se necesitan los siguientes requisitos:

Java 8 o superior.
Un servidor CORBA que soporte el lenguaje de programación Java.
Configuración del servidor
Para configurar el servidor, siga estos pasos:

Ejecute el servidor de nombres de CORBA utilizando el comando tnameserv de su servidor de aplicaciones.
Compile los archivos de código fuente utilizando un compilador Java.
Inicie el servidor utilizando el siguiente comando:
```
java CalcServer -ORBInitialPort <puerto> -ORBInitialHost <dirección IP>
```
Asegúrese de reemplazar <puerto> y <dirección IP> con los valores apropiados.

Uso de la aplicación
Una vez iniciado el servidor, puede utilizar la aplicación a través de un cliente CORBA. Para utilizar el cliente, siga estos pasos:

Compile los archivos de código fuente utilizando un compilador Java.
Inicie el cliente utilizando el siguiente comando:
```
java CalcClient -ORBInitialPort <puerto> -ORBInitialHost <dirección IP>
```
Asegúrese de reemplazar <puerto> y <dirección IP> con los valores apropiados.
3. Seleccione una de las operaciones disponibles en la aplicación: suma, resta, multiplicación, división, suma de fracciones, resta de fracciones, multiplicación de fracciones, división de fracciones.

Proporcione los operandos necesarios para la operación seleccionada.
La aplicación mostrará el resultado de la operación en la salida estándar.
¡Gracias por utilizar CalcApp! Si tiene alguna pregunta o problema, no dude en abrir un problema en el repositorio de GitHub.
