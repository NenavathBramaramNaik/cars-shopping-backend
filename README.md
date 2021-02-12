# cars-shopping-backend

# Full Stack coding challenge - Cognizant
		
#Technology stack:
		Java 11, Spring Boot, Swagger,  MAVEN, Junit, mockito, 	Springtoolsuite.exe
	
#Implementation
	The application is developed as a classic microservice structure by following "Separation of concern" 	pattern which is more flexible with clean design and architecture.
	
	I tried to not add any any big external `dependencies/frameworks` and just keep it simple.
	
	The also integrated with swagger ui to visualize and interact with API resources which 	makes it easy 	for backend implementation and client side consumption If any.
	
#Application Setup
I have given the code as a zip file,

	Either we can use maven plugin to run the application using mvn spring-boot:run OR
	
	Open Springtoolsuite.exe IDE, File -> 
						  import ->
						  general ->
						  existing projects into workspace -> 
						  select archive file ->
						  select the zip file -> finish
						  Run as -> maven install
						  Run as -> Spring boot app
	Once, the server is started.
	Please access the URL http://localhost:8080/ for the swagger-ui which provides the access to rest api 	endpoints.
	
For this test, I am not aware of user access and other details, hence I didnt add any authentication and authorization.
But, I can add Spring Security for authentication and OAuth 2.0 for API authorization.

For production grade application, I can definitely add more high level configurations and other key blocks like Authentication and Authorization, Orchestration, CICD pipeline , gateways, fault tolerance, disaster recovery, monitoring, and documentation.
