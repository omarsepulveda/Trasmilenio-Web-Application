# TransMilenioApp
Este proyecto fue generado con [Angular CLI](https://github.com/angular/angular-cli) version 7.3.6.

# Requisitos
node js con su gestor de paquetes npm.

type-script

# Pasos antes de la instalación
Instalar la última versión de angular

`npm install @angular/cli –g`

Si se quiere utilizar la misma de este proyecto

`npm install @angular/cli@7.3.6`

Si se quiere verificar la versión de angular

`ng v`

Para crear el proyecto en angular

`ng new nombre_de_mi_app`

## Servidor de desarrollo

Correr `ng serve` para montar un servidor de desarrollo. Navegar a `http://localhost:4200/`. La aplicación se volverá a cargar automáticamente si cambia alguno de los archivos de origen.

## Estructura de código

Correr `ng generate component component-name` para generar un nuevo componente. También puedes usar `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Construir

Correr `ng build` para construir el proyecto. Los artefactos de compilación serán almacenados en el directorio `dist/`. Utilizar `--prod` bandera para una construcción en producción.

## Correr Pruebas unitarias

Correr `ng test` para ejecutar las pruebas unitarias via [Karma](https://karma-runner.github.io).

## Correr pruebas de extremo a extremo

Correr `ng e2e` para ejecutar las pruebas de extremo a extremo via [Protractor](http://www.protractortest.org/).

## Ayuda adicional

Para obtener más ayuda sobre el uso del CLI de angular `ng help` o ve a ver [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

## Crear estructura de un servicio en angular

Correr `ng generate service [nombre servicio]`
Con esto generamos un archivo con la estructura de servicio en angular, esta clase se utiliza para realizar operaciones POST, GET, PUT, DELETE, etc.

Importamos HttpClientModule en app.module.ts
```TypeScript
imports: [HttpClientModule]
```

Configuramos las variables iniciales del servicio

```TypeScript
  url: string;
  httpHeaders: HttpHeaders;
  
  constructor(private http: HttpClient) {
    this.url = '';
    this.httpHeaders = new HttpHeaders({
          'Content-Type': 'application/json',
        }
    );
  }
```

Después llamamos nuestro servicio en app.module.ts

```TypeScript
providers: [
        TipoVehiculoService
]
```
## Validaciones con Angular

Importamos FormsModule en app.module.ts
```TypeScript
imports: [FormsModule]
```

En la vista que queramos realizar el formulario colocamos lo siguiente
```HTML
<form name="form" ngForm (ngSubmit)="f.form.valid && onSubmit()" #f="ngForm">
    <div class="md-form">
        <i class="fas fa-envelope prefix grey-text"></i>
        <input type="email" id="correo" class="form-control"
               name="correo" [(ngModel)]="usuario.correo"
               [ngClass]="{ 'is-invalid': f.submitted && correo.invalid }"
               #correo="ngModel" required
               mdbInput>
        <label for="correo">correo</label>
        <div *ngIf="f.submitted && correo.invalid" class="invalid-feedback">
            <div *ngIf="correo.errors.required">El correo es requerido</div>
        </div>
    </div>
    
    <div class="md-form">
        <i class="fas fa-key prefix grey-text"></i>
        <input type="password" id="contrasena" class="form-control"
               name="contrasena" [(ngModel)]="usuario.contrasena"
               [ngClass]="{ 'is-invalid': f.submitted && contrasena.invalid }"
               #contrasena="ngModel" required
               mdbInput>
        <label for="contrasena">contraseña</label>
        <div *ngIf="f.submitted && contrasena.invalid" class="invalid-feedback">
            <div *ngIf="contrasena.errors.required">Contraseña requerida</div>
        </div>
    </div>
    <div class="text-center mt-3">
        <button mdbBtn color="indigo" mdbWavesEffect>Enviar</button>
    </div>
</form>
```


```HTML
(ngSubmit)="f.form.valid && onSubmit()"
```

Es el evento que va a verificar los campos cuando se haga submit en el formulario por medio del botón

```HTML
#f="ngForm"
```

Es el identificador que se utiliza para llamar en (ngSubmit)

```HTML
[ngClass]="{ 'is-invalid': f.submitted && correo.invalid }"
#correo="ngModel" required
```

Esto permite que cuando #correo sea invalido, es decir no tenga algo muestre error el cual es el div que se encuentra abajo

```HTML
<div *ngIf="f.submitted && correo.invalid" class="invalid-feedback">
    <div *ngIf="correo.errors.required">El correo es requerido</div>
</div>
```
Este verifica que cuando hagan submit al formulario y la variable correo es decir #correo sea invalida mande error

**vista**
```TypeScript
[(ngModel)]="usuario.contrasena"
```

**archivo ts**
```TypeScript
usuario: any;
```

**[(ngModel)]** permite enlazar la variable que se encuentra en el archivo ts con lo que se escriba en el input

```TypeScript
console.log(JSON.stringify(this.usuario));
```
Se puede colocar en el botón una acción que ejecute un método con esta instrucción para probar el [(ngModel)]


## Login con LocalStorage

Para almacenar datos en sesión utilizamos la siguiente instrucción  
```TypeScript
localStorage.setItem('correo', this.usuario.correo);
```
Utilizamos el setItem el cual recibe dos parámetros, ([nombre_variable], [valor])
para el ejemplo almacenamos un correo con el valor que tiene la variable que utilizamos anteriormente

```TypeScript
localStorage.getItem('correo');
```

getItem se utiliza para traer el valor almacenado desde cualquier sitio

```TypeScript
localStorage.clear();
```

clear(); es otra instrucción importante ya que nos va a servir para borrar todos los datos de la sesión sin tener que recargar la página
