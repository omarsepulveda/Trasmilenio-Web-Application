# INSTALACIÓN MySQL Debian 9

**NOTA**: ejecutar comandos como usuario **no root**

## Correr estos comandos para actualizar dependencias
`sudo apt update`

`sudo apt upgrade`

## Descargar el archivo usando wget
`wget https://dev.mysql.com/get/mysql-apt-config_0.8.10-1_all.deb`

dpkg es usado para instalar, remover e inspeccionar el paquete .deb que descargamos. El **-i** indica que se instale.

`sudo dpkg -i mysql-apt-config*`

Actualizamos dependencias

`sudo apt update`

## Ahora si podemos instalar MySQL:
`sudo apt install mysql-server`

Durante la instalación puede salir un mensaje el al cual debemos dar **OK**

Ahora que esta instalado MySQL probamos systemctl para verificar su funcionamiento:

`sudo systemctl status mysql`

Comandos adicionales

`sudo systemctl [command] mysql`

`start`, `stop`, `status`, `restart`

Para conectarse a MySQL, verificar que el servicio este en funcionamiento

`sudo mysql`

Cambiamos contraseña del usuario root de MySQL

`SET password FOR root@localhost = password('root');`

Crear la base de datos;

`CREATE DATABASE db_test;`

Ver todos los usuarios del sistema

`SELECT user FROM mysql.user;`

Crear un usuario con su contraseña

`CREATE USER 'user_test'@'localhost' IDENTIFIED BY 'test';`

Ver todas las bases de datos

`SHOW DATABASES;`

Dar privilegios a un usuario

`GRANT SELECT, INSERT, DELETE ON db_test.* TO 'user_test'@'localhost';`

Información adicional

ALL PRIVILEGES – dat TODOS los privilegios a un usuario sobre MySQL
CREATE – Permite crear bases de datos y tablas
DROP   - Permite eliminar bases de datos y tablas
DELETE - Permite eliminar registros de una tabla en una base de datos en especifico
INSERT - Permite insertar registros de una tabla en una base de datos en especifico
SELECT – Permite leer registros en una base de datos
UPDATE - Permite actualizar registros de una tabla en una base de datos en especifico

**Tambien se pueden usar comodines como el * para referise a todas las tablas o a todas las bases de datos**

Conectar a usuario

`mysql -h localhost -u user_test -p`

# INSTRUCCIONES PARA CREAR BASE DE DATOS DEL PROYECTO

Ejecutar el script de creación de la base de datos

Creamos el usuario transmilenio

`CREATE USER 'transmilenio'@'localhost' IDENTIFIED BY 'transmilenio';`

`GRANT SELECT, INSERT, UPDATE, DELETE ON db_transmilenio.* TO 'transmilenio'@'localhost';`
