# PRE-REQUISITOS

Antes de instalar Grails verifica que tienes la ultima versión de [JAVA](https://www.oracle.com/technetwork/es/java/javase/downloads/index.html)
  - [JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html?ssSourceSiteId=otnes)
  - [JRE](https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html?ssSourceSiteId=otnes)

Gestor de Bases De Datos [MySQL](https://www.mysql.com/downloads/)
  Para agilizar la instalación del gestor se puede usar [XAMMP](https://www.apachefriends.org/download.html), [WAMP](http://www.wampserver.com/en/), [LAMP](https://bitnami.com/stack/lamp/installer) o cualquier otra herramienta que nos permita acelerar el proceso

# INSTALANDO [GRAILS](https://grails.org/)

Para instalar Grails sólo se deben ejecutar los siguientes comandos en una terminal:

    curl -s https://get.sdkman.io | bash
    
    source "$HOME/.sdkman/bin/sdkman-init.sh"
    
    sdk install grails
    
 Si desea verificar la versión de Grails digite en la terminal:
 ``   
    grails -version
 ``
    
[Ver más versiones de Grails](https://grails.org/download.html)

# Crear API Con Grails

Sólo ejecute el comando 
`` 
  grails create-app nombre-proyecto --profile=rest-api
``   
 Grails permite crear diferentes proyectos con [perfiles](http://grails.org/profiles.html) según se requiera.
 
 # Correr API
 
Para correr la aplicación debe ejecutar el comando
`` 
  grails run-app
`` 

Si desea cambiar el puerto que viene por defecto (8080) sólo debe agregar -port= y el puerto que escuchará la aplicación
`` 
  grails run-app -port=8090
`` 

Si es la primera vez que corre una aplicación de Grails, debe esperar a que se culmine la descarga que se inicia automáticamente y luego dirigirse a la dirección que se asigna, localhost:8080.

# Crear Dominio

Para generar los dominios en Grails solamente ejecute el comando
`` 
  grails create-domain-class nombre-dominio
 `` 
  
Si desea crear tablas desde Grails sólo cree los atributos y [reglas](https://docs.grails.org/latest/ref/Constraints/Usage.html) que va a tener

```JAVA
class NombreClase {
    int atributo1
    string atributo2
    
    //Aquí deben estipularse las reglas que tendrán los atributos
    static constraints = {
        atributo1 size: 5..15, blank: false, unique: true
        atributo2 min: 18
    }
}
```
Si ya tiene creada una base de datos con sus respectivas tablas y desea mapearlas esto es lo que necesita

```JAVA
package nombrePaquete

import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class NombreClase {

    int atributo1
    string atributo2

    static constraints = {
    }
    
    //El nombre de la columna almacenada en la base de datos debe ser la misma que la que se referencia en 'atributo1'
    static mapping = {
        table 'nombreTablaBD'
        atributo1 column:'atributo1'
        atributo2 column:'atributo2'
    }
}
```
# Generar Vistas, Controladores, Servicios y Test

Si no desea generar cada uno de estos sólo ejecute:
`` 
  grails generate-all nombre
  `` 

Para conocer que más funciones tiene grails ingrese [aquí](https://grails-profiles.github.io/rest-api/latest/guide/index.html)

# Construir El Proyecto

Dirijase al archivo build.gradle y verifique que estan las dependecias de tomcat y mysql, de lo contrario digite lo siguiente:
```
    runtime "org.apache.tomcat:tomcat-jdbc"
    runtime "mysql:mysql-connector-java:5.1.40"
```
    
 Ahora en el archivo de configuración llamado application.yml se debe configurar el entorno de producción
 
 ```
 dataSource:
    pooled: true
    jmxExport: true
    driverClassName: com.mysql.jdbc.Driver
    dialect : org.hibernate.dialect.MySQL5InnoDBDialect
    username: "root"
    password: ""

environments:
    development:
        dataSource:
            dbCreate: create-drop
            url: jdbc:mysql://localhost:3306/tubasededatos
    production:
        dataSource:
            dbCreate: update
            url: jdbc:mysql://localhost:3306/tubasededatos
```

Para construir el proyecto solamente digite:
`` 
  grails war
  `` 
  
# Despliegue De Aplicación

Para dejar la aplicación en un servidor, es necesario instalar Tomcat y alojar allí el archivo .war que se genera con el paso anterior
 
