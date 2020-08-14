# transbank

Existe 2 proyectos, uno Spring y otro Android.

1. Abrir el proyecto Spring (recomiendo con IntelliJ). Al ejecutarlo nos permitira establecer conexion entre el proyecto Android y los servicios Rest que se exponen desde https://www.themoviedb.org/

2. Abrir el proyecto Android, con Android Studio. Y dentro de la interface 

https://github.com/ramonchop/transbank/blob/master/Android/Transbank/app/src/main/java/cl/transbank/transbank/api/MoviesTopRatedServicesApi.kt

Modificar la constante por la ip local y puerto con el cual se subio la aplicación spring (por defecto es el 8080)

const val URL_MOVIES_TOP_RATED = "http://192.168.1.86:8080" //Reemplazar por IP local.

3. Ejecutar proyecto Android que permite ver el listado de peliculas "TOP". Al seleccionar alguna de estas peliculas, se puede ver la imagen y el resumen correspondiente. Existe la opcion de volver y selecionar otra pelicula.
