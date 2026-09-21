# BookGestion REST API

## Rutas de los controllers

Todas las rutas usan el prefijo indicado en la columna **Ruta base**. La ruta
completa se obtiene concatenando la ruta base con la ruta del endpoint.

### `AutorController`

Ruta base: `/api/v1/autor`

| Método HTTP | Ruta completa | Operación |
| --- | --- | --- |
| `GET` | `/api/v1/autor/findById/{id}` | Buscar un autor por ID |
| `POST` | `/api/v1/autor/saveAutor` | Crear un autor |
| `PUT` | `/api/v1/autor/updateAutor/{id}` | Actualizar un autor |
| `DELETE` | `/api/v1/autor/deleteAutor/{id}` | Eliminar un autor |

### `CategoriaController`

Ruta base: `/api/v1/categoria`

| Método HTTP | Ruta completa | Operación |
| --- | --- | --- |
| `GET` | `/api/v1/categoria/findAllCategorias` | Listar todas las categorías |
| `GET` | `/api/v1/categoria/findById/{id}` | Buscar una categoría por ID |
| `POST` | `/api/v1/categoria/saveCategoria` | Crear una categoría |
| `PUT` | `/api/v1/categoria/updateCategoria/{id}` | Actualizar una categoría |
| `DELETE` | `/api/v1/categoria/deleteCategoria/{id}` | Eliminar una categoría |

### `LibroController`

Ruta base: `/api/v1/libro`

| Método HTTP | Ruta completa | Operación |
| --- | --- | --- |
| `GET` | `/api/v1/libro/findAllLibros` | Listar todos los libros |
| `GET` | `/api/v1/libro/findById/{id}` | Buscar un libro por ID |
| `POST` | `/api/v1/libro/saveLibro` | Crear un libro |
| `PUT` | `/api/v1/libro/updateLibro/{id}` | Actualizar un libro |
| `DELETE` | `/api/v1/libro/deleteLibro/{id}` | Eliminar un libro |


### `PlanController`

Ruta base: `/api/v1/plan`

| Método HTTP | Ruta completa | Operación |
| --- | --- | --- |
| `GET` | `/api/v1/plan/findById/{id}` | Buscar un plan por ID |
| `GET` | `/api/v1/plan/findAllPlan` | Listar todos los planes |
| `POST` | `/api/v1/plan/savePlans` | Crear un plan |
| `PUT` | `/api/v1/plan/updatePlan/{id}` | Actualizar un plan |
| `DELETE` | `/api/v1/plan/deletePlan/{id}` | Eliminar un plan |

### `UsuarioController`

Ruta base: `/api/v1/usuario`

| Método HTTP | Ruta completa | Operación |
| --- | --- | --- |
| `GET` | `/api/v1/usuario/findById/{id}` | Buscar un usuario por ID |
| `GET` | `/api/v1/usuario/findAllUsuario` | Listar todos los usuarios |
| `POST` | `/api/v1/usuario/saveUsuario` | Crear un usuario |
| `PUT` | `/api/v1/usuario/updateUsuario/{id}` | Actualizar un usuario |
| `DELETE` | `/api/v1/usuario/deleteUsuario/{id}` | Eliminar un usuario |
 