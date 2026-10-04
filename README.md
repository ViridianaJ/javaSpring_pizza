# CRUD de Pizzas con Spring Boot

Desarrollado con **Spring Boot** para implementar una API REST con operaciones CRUD.

## Endpoints

* **`/api/v1/pizzas`**

* **`/api/v1/tamanos`**

* **`/api/v1/bebidas`**

* **`/api/v1/clientes`**


Los datos se almacenan temporalmente en memoria mediante `ArrayList`. 

## La aplicación se ejecuta en:

http://localhost:8080

## Ejemplos: 

## Obtener todas las pizzas GET

http://localhost:8080/api/v1/pizzas

## Obtener una pizza por ID GET

http://localhost:8080/api/v1/pizzas/1

## Actualizar una pizza PUT

http://localhost:8080/api/v1/pizzas/id

## Eliminar una pizza DELETE

http://localhost:8080/api/v1/pizzas/id

## Ejemplo con POST

http://localhost:8080/api/v1/pizzas
```
{
    "nombre": "Pizza Hawaiana",
    "ingredientes": "Queso, jamón y piña"
}
```

http://localhost:8080/api/v1/tamanos
```
{
    "nombre": "Mediana",
    "precio": 120.0
}
```

http://localhost:8080/api/v1/bebidas
```
{
    "nombre": "Coca Cola",
    "precio": 35.0
}
```

http://localhost:8080/api/v1/clientes
```
{
    "nombre": "Juan Perez",
    "telefono": "5551234567",
    "email": "juan@example.com"
}
```
## Ejemplo con PUT:

http://localhost:8080/api/v1/tamanos/1
```
{
    "nombre": "Mediana Especial",
    "precio": 200.0
}
```
