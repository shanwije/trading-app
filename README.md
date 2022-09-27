# Trading App - Price Formatter

* This project act as the backend service for the react-frontend implementation which can be found in ./trading-web-app directory.
* Built with Spring boot reactive with webflux.
* For the persistence of price values mongodb instance is invoked alongside with the jar file in netty using docker and docker-compose.


## Requirements

* Docker and Docker-compose
* Node v14.17.5, NPM 6.14.14
* Free port 8080, 27017 and 3000

### Good to have
* MongoDB compass to check current status of values.
* Postman : can test endpoints : ( please import the postman collection in ./ path.)

### Local Manual Testing

1. Open terminal, run `docker-compose build` then or `docker-compose` in ./trading-app directory. This will invoke spring boot application in `0.0.0.0:8080`
2. you may test the `/health` endpoint using `http://localhost:8080/trade-service/v1/actuator/health`.
3. Invoke `npm install` inside ./trading-web-app directory. then `npm start`.
4. This will open broser in `http://localhost:3000/` there you may interact with the UI.
