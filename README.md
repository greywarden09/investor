# Investor
Application needs database for work. There is docker-compose.yml file in deploy directory.
After executing following command:
```
docker-compose up -d
```
PostgreSQL database is brought up. After this, you can build project:
```
./gradlew build
```
And run:
```
./gradlew run
```
## API
Project uses Swagger. Console is available under http://<your-host>:8080/swagger-ui.html
Example request:
```json
{
  "funds": [
    {
      "id" : 1,
      "fundType": "Polskie",
      "name": "Fundusz Polski 1"
    },
    {
      "id" : 2,
      "fundType": "Polskie",
      "name": "Fundusz Polski 2"
    },
    {
      "id" : 3,
      "fundType": "Zagraniczne",
      "name": "Fundusz Zagraniczny 1"
    },
    {
      "id" : 4,
      "fundType": "Zagraniczne",
      "name": "Fundusz Zagraniczny 2"
    },
    {
      "id" : 5,
      "fundType": "Zagraniczne",
      "name": "Fundusz Zagraniczny 3"
    },
    {
      "id" : 6,
      "fundType": "Pieniężne",
      "name": "Fundusz Pieniężny 1"
    }
  ],
  "input": 10000,
  "wayOfInvest": "bezpieczny"
}
```
