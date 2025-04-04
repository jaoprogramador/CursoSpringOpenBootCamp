# spring-api

# Arrancar Docker Desktop
# Arrancar el servidor de REDIS en nuestro pc con el terminarl dede donde estádocker-compose.yml:
# 		docker compose up
# en eclipse vamos a la classe CourseAopAndAnnotationsApplication de arranque y hacemos run as - java application

# instalar redis-cli 

# GET POSTMAN GET http://localhost:8080/v1/album


# POSTMAN POST http://localhost:8080/v1/album

{
  "name": "Thriller",
  "autor": "Michael Jackson",
  "price": 19.99,
  "recordCompany": {
    "tittle": "Universal Music"
  },
  "tracks": [
    {
      "name": "Wanna Be Startin' Somethin'",
      "lycris": "Too high to get over, too low to get under..."
    },
    {
      "name": "Baby Be Mine",
      "lycris": "I don't need no dreams when I'm by your side..."
    },
    {
      "name": "The Girl Is Mine",
      "lycris": "The doggone girl is mine..."
    },
    {
      "name": "Thriller",
      "lycris": "Cause this is thriller, thriller night..."
    },
    {
      "name": "Beat It",
      "lycris": "Just beat it, beat it..."
    },
    {
      "name": "Billie Jean",
      "lycris": "Billie Jean is not my lover..."
    },
    {
      "name": "Human Nature",
      "lycris": "Why, why, tell 'em that it's human nature..."
    },
    {
      "name": "P.Y.T. (Pretty Young Thing)",
      "lycris": "I wanna love you, P.Y.T..."
    },
    {
      "name": "The Lady in My Life",
      "lycris": "Lay your body close to mine..."
    }
  ]
}