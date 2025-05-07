# Prices
API para consultar precios

🚀 Instrucciones para Correr y Probar el Proyecto

## Prerrequisitos

Antes de empezar, asegúrate de tener los siguientes programas instalados:

- **Docker**: Para crear y ejecutar contenedores de Docker
- **Java 17** (opcional): Si prefieres ejecutar el proyecto directamente sin Docker
-
## 1. Clona el repositorio

Clona el repositorio del proyecto a tu máquina local usando Git:

```bash
git clone https://github.com/amperezp14/Prices.git
cd Prices
```

## 2. Construir la imagen Docker
Para construir la imagen Docker de tu servicio, corre el siguiente comando en la raíz del proyecto (donde se encuentra el Dockerfile):

```bash
docker build -t my-prices-api .
Este comando construirá la imagen Docker a partir del Dockerfile y la etiquetará como my-prices-api.
```

## 3. Ejecutar el contenedor Docker
Una vez que la imagen esté construida, puedes correr el contenedor con el siguiente comando:

```bash
docker run -p 8070:8070 my-prices-api
Esto ejecutará el servicio en el puerto 8070. Ahora, podrás acceder a la API en http://localhost:8070.
```

## 4. Probar la API
Puedes probar la API utilizando herramientas como Postman o cURL.

Endpoint: Obtener precio
URL: GET http://localhost:8070/prices/getPrice

Parámetros:

```json
{
  "product_id": 35456,
  "brand_id": 1,
  "query_date": "2023-06-14 10:00:00"
}
```

Respuesta exitosa:
```json
{
  "product_id": 35456,
  "brand_id": 1,
  "price": 29.99,
  "currency": "USD"
}
```
Respuesta de error (si no se encuentra el precio):

```json
{
  "timestamp": "2023-06-14T10:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "No se encontró un precio para el producto y fecha indicados"
}
```

5. Probar en modo desarrollo (sin Docker)
   Para ejecutar el proyecto sin Docker:

Construir el JAR (en la raíz del proyecto):

```bash
mvn clean package -DskipTests
Ejecutar el JAR:
```

```bash
java -jar target/mi-proyecto.jar
```
El servidor se levantará en http://localhost:8070.
