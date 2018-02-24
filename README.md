# Road Camera Service
The goal of the project is to develop a car registration service.

## Stack of technologies
1. Frameworks: **Spring Boot, Spring Data JPA, REST**.
2. Build automation tool: **Maven**.
4. Database: **H2** in-memory.
5. Testing: **JUnit, Hamcrest, RestTemplate**.
6. Logging: **Log4j**.
9. Misc.: **Lombock, JSON**.

## Required environment
1. JDK 1.8
3. Maven 3.3
4. Tomcat 8
5. Git Bash
6. Postman or other

## Deploying project
### Download project
```
git clone https://github.com/amilosh/RoadCamera.git
```
### Build project
```
{project classpath}> mvn clean install
```
### Run Tomcat
```
{tomcat classpath}\bin> startup
```
### Deploy application
Copy **RoadCamera.war** from
```
{project classpath}\target\RoadCamera.war
```
to
```
{tomcat classpath}\webapps
```
## Web-service testing
Open H2 database:
```
http://localhost:8080/RoadCamera/console
```
```
JDBC URL: jdbc:h2:mem:RoadCamera
User Name: sa
Password:
```
Http Requests:
```
POST http://localhost:8080/RoadCamera/registrations
JSON:
{
	"carNumber": "1234 AA-7"
}
```
```
GET http://localhost:8080/RoadCamera/registrations
```
```
GET http://localhost:8080/RoadCamera/registrations/1234 AA-7
```
```
GET http://localhost:8080/RoadCamera/registrations/stats/count
```