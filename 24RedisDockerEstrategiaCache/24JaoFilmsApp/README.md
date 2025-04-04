# Requisitoskeys definidas en cache
# ============
# Eclipse
# Java 17
# Docker desktop
# postman

# APLI que nos permite gestionar en H2 peliculas-actores-productoras y 
# aplicar una estrategia de carga en cache con REDIS para no saturar la BD

# Iniciar
# =========
# bajamos las dependencias con Maven - update proyect -force
# abrimos docker descktop
# listar los contenerores y puertos
# 		docker ds
# levantar app en contenedor
#  		docker compose up
# ejecutar servidor redis-cli para autenticarme y ver si tenemos 
#		docker exec -it myRedisPeliculas redis-cli
#		AUTH jaoprogramador1234
#		KEYS *

# Arrancamos la aplicacion desde JaoFilmsAppApplication con run as - java aplication
# Cargamos peliculas actores desde el endpoint con postmand del json /JaoFilmsApp/src/main/resources/static/data.json
# 		POST http://localhost:8080/v1/pelicula
# 
# Llamaos al end point listar peliculas para que se inicie la cache
# 		GET http://localhost:8080/v1/pelicula
# hacemos delete actor para refrescar la cache
# 		DELETE http://localhost:8080/v1/actor

# 