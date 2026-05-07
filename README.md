# CRUD de películas en Android Studio
Autor: Mateo Recalde

La aplicación funciona como un CRUD de una API externa de películas cuya base de datos sigue el patrón maestro detalle, siendo la tabla de películas maestro y la tabla de actores la de detalle.
## Diagrama de la base de datos

<img width="794" height="352" alt="image" src="https://github.com/user-attachments/assets/1feaa991-c118-4700-9486-db28911c26bd" />

## Funcionamiento de la aplicación
### Películas
#### Leer todas las películas
La pantalla principal muestra todas las películas organizadas en tarjetas que se crearon utilizando la librería recycleview.

<img width="412" height="855" alt="image" src="https://github.com/user-attachments/assets/58e53245-be77-44d8-a8c1-f8ca205277d0" />

#### Crear una película
Para crear una nueva película, se da clic en el botón "+" que aparece en la parte inferior derecha de la pantalla. Una vez damos clic, aparecerá la siguiente pantalla con los campos necesarios.

<img width="414" height="855" alt="image" src="https://github.com/user-attachments/assets/202561e0-803b-4dde-83c6-b9efedcd51e3" />

Se llenan los campos.

<img width="403" height="845" alt="image" src="https://github.com/user-attachments/assets/a7fc8f11-d68a-44eb-a0b3-90cb93d7cc67" />

Al guardar aparece un mensaje Toast.

<img width="189" height="82" alt="image" src="https://github.com/user-attachments/assets/38be156f-8aca-4f2e-abb5-15252ff3ff35" />

Y podemos visualizar la nueva película creada en la parte inferior.

<img width="411" height="841" alt="image" src="https://github.com/user-attachments/assets/a381ba41-089f-48e7-94fc-f603a554204a" />

#### Leer una sola película

Al tocar en cualquiera de las películas, se desplegará la siguiente pantalla que contiene la información específica de esa película y sus actores.

<img width="403" height="847" alt="image" src="https://github.com/user-attachments/assets/a77a01ed-6e61-4e9d-b8e9-671bcbac0315" />

Ahora, veamos la pantalla de la película que acabamos de ingresar.

<img width="403" height="850" alt="image" src="https://github.com/user-attachments/assets/9bba0611-127a-4b59-a8a7-1c066bf064d6" />

#### Editar una película

Si tocamos el botón "Editar" de la vista individual de la película, se mostrará una pantalla similar a la de creación, pero en donde podemos ver toda la información de la película que se desea editar.

<img width="403" height="852" alt="image" src="https://github.com/user-attachments/assets/91e74519-0365-4fe7-8fd0-eee2dc884c30" />

Se modificará el campo genero a "Aventura".

<img width="359" height="404" alt="image" src="https://github.com/user-attachments/assets/3aa3f7d6-b9dd-4b82-ab52-8e636ebdb999" />

Guardamos, y regresaremos a la vista anterior con el nuevo campo ya modificado.

<img width="402" height="846" alt="image" src="https://github.com/user-attachments/assets/2900e172-6255-4eab-9e87-745ccb0359e5" />

#### Eliminar una película

En la misma vista individual de una película, tocamos el botón "Eliminar".

<img width="403" height="851" alt="image" src="https://github.com/user-attachments/assets/3abd6e45-353c-485c-83bd-1e3c4ae33514" />

Nos lanzará un aviso, si le damos a eliminar la película desaparecerá de la lista.

<img width="409" height="854" alt="image" src="https://github.com/user-attachments/assets/1fe824c6-4991-4ce5-a3d2-dc4a59c0c3fb" />

### Actores
### Leer los actores de una película

Al seleccionar una película individual, se nos mostrará todos los actores de dicha película.

<img width="407" height="854" alt="image" src="https://github.com/user-attachments/assets/d00bbdd1-6176-44dd-8b05-0a7cf4624215" />

### Crear un actor

Tocamos el botón "Añadir Actor" y se desplegará una pantalla con los campoz necesarios para añadir un actor.

<img width="403" height="394" alt="image" src="https://github.com/user-attachments/assets/7e1421c0-52b0-4100-b9b5-34cd74c55acb" />

Llenamos la información.

<img width="406" height="842" alt="image" src="https://github.com/user-attachments/assets/d5f0d268-176a-46b8-b68a-14ba11e5d221" />

Y guardamos el actor, lo cual nos regresará a la vista individual de la película ya con el nuevo actor añadido.

<img width="402" height="841" alt="image" src="https://github.com/user-attachments/assets/b4742feb-2264-4a2b-9ff6-3fc587092ea4" />

#### Editar un actor

Tocamos el icono de lápiz del actor que se desea editar. Y modificamos lo deseado.

<img width="407" height="359" alt="image" src="https://github.com/user-attachments/assets/074879a3-1ce3-46fe-9d7f-e9a35f8c5841" />

Guardamos, y podremos visualizar el cambio realizado.

<img width="419" height="854" alt="image" src="https://github.com/user-attachments/assets/9f354a3d-060a-4315-8b73-dda332b9a781" />

#### Eliminar un actor

Simplemente, tocamos el icono de eliminar en cualquiera de los actores.

<img width="414" height="856" alt="image" src="https://github.com/user-attachments/assets/f984ef2b-1dfc-4f6f-bc48-5108798dd217" />

Se nos avisará si deseamos eliminar el actor, si damos que si desaparecerá de la lista.

<img width="420" height="854" alt="image" src="https://github.com/user-attachments/assets/c70b0db4-8f2f-4b66-afc4-a8d4fa0f0d0f" />


