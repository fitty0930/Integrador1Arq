# Integrador1Arq

Para la correcta ejecución del proyecto se requiere de una base de datos MySql con el nombre "integrador1" corriendo en el puerto 3306 sin contraseña

Main : En el archivo MainTables de crea un Factory y luego los factory's de cliente, factura
producto y facturaProducto

primero se crean las tablas si no estan creadas con user root y sin password
luego de crear las tablas generamos los arrayList de productos,clientes, facturas y facturaProducto
estos se generan en la clase CSVaMySql con metodos que retornan listas
una vez que pasamos los archivos csv a listas los cargamos a las tablas correspondientes con
el metodo insertarLista declarado en el main que itera la lista e inserta en el dao correspondiente

Luego se genera el producto con mas recaudacion y la lista de clientes que mas invirtieron y se imprimen todos en pantalla
