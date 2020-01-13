# spring-boot-root-1
this project contains several microservices with spring boot implementation
  > product-service - simple microservice to check for if a product exists
  > ordver-service - another MS which will place the order by checking/talking to product-service 
  > discovery-service - another MS which enable the above services to locate them on a network
  > edge-service - acta as a gateway to order and product service
  > secure-api - spring-security - enable spring security using basic authentication of user
  > spring-admin - where you can view all the actions that is going on wit all the services
