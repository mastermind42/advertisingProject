# iHeartMedia Advertising Project

Application creates API to do CRUD operations on a H2 database storing Advertiser's information.
The application uses mvn to run. [Install mvn](https://maven.apache.org/download.cgi) to run application from commandline.

### Creating Jar File
`mvn package` will create a .jar file at advertising\target\
To run jar file, run `java -jar [File Name]`


### Testing Application
`mvn test` will test application. The code coverage is above 90%.

### Swagger UI
To access swagger ui, go to http://localhost:8080/swagger-ui.html

### Actuator
To access the Actuator endpoints, go to http://localhost:8090/actuator/
