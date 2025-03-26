https://www.youtube.com/watch?v=uMn-kH0BjSo
ARQUITECTURA HEXAGONAL O DE PUERTOS Y ADAPTADORES
===================================================
===================================================
postman:
========
GET
	http://localhost:8080/users/1
	{
    "id": 1,
    "name": "jao",
    "email": "jao@mail.es",
    "activo": "A",
    "fechaAlta": "2025-03-25T13:37:28.516+00:00"
	}
POST
	http://localhost:8080/user
	{
    "id": 1,
    "name": "ale",
    "email": "alejandra@mail.es"
  GET 
    http://localhost:8080/users
    
}  
IDENTIFICAR EL SERVICIO ARRANCADO
netstat -ano | findstr :8080
MATAR EL PROCESO QUE ESTA EN EL PUERTO 8080
taskkill /PID 10387 /F
