# API REST

## Users

URL | Metodo | Datos | Respuesta
----|--------|------|----------
`/users/`| GET | - | Todos los usuarios
`/users/$id`| GET | - | Busca usuario con id
`/users/username/$username`| GET | - | Busca usuario con username
`/users/`| POST | JSON usuario | Crea el usuario
`/users/$id`| PUT | JSON usuario | Cambia usuario con id
`/users/$id`| DELETE | - | Borra usuario con id

## Tags

URL | Metodo | Datos | Respuesta
----|--------|------|----------
`/tags/`| GET | - | Todos las etiquetas
`/tags/$id`| GET | - | Busca etiqueta con id
`/tags/`| POST | JSON usuario | Crea la etiqueta
`/tags/$id`| PUT | JSON usuario | Cambia etiqueta con id
`/tags/$id`| DELETE | - | Borra etiqueta con id

## Offers

URL | Metodo | Datos | Respuesta
----|--------|------|----------
`/offers/`| GET | - | Todas las ofertas
`/offers/$id`| GET | - | Busca oferta con id
`/offers/tag/$title`| GET | - | Busca oferta por el nombre de la etiqueta
`/offers/`| POST | JSON usuario | Crea la oferta
`/offers/$id`| PUT | JSON usuario | Cambia oferta con id
`/offers/$id`| DELETE | - | Borra oferta con id

## Demands

URL | Metodo | Datos | Respuesta
----|--------|------|----------
`/demands/`| GET | - | Todas las demandas
`/demands/$id`| GET | - | Busca demanda con id
`/demands/`| POST | JSON usuario | Crea la demanda
`/demands/$id`| PUT | JSON usuario | Cambia demanda con id
`/demands/$id`| DELETE | - | Borra demanda con id

## Scores

URL | Metodo | Datos | Respuesta
----|--------|------|----------
`/scores/`| GET | - | Todas las calificaciones
`/scores/$id`| GET | - | Busca calificacion con id
`/scores/`| POST | JSON usuario | Crea la calificacion
`/scores/$id`| PUT | JSON usuario | Cambia calificacion con id
`/scores/$id`| DELETE | - | Borra calificacion con id