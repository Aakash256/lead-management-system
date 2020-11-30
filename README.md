#spring-boot-skeleton 

##Functionalities implemented in this -
1. A Java multi module project with Maven 
2. A fully functional spring boot rest api project.
3. Fully functional repository module talking to MySQL database.
4. Swagger UI integrated
5. Fully functional security module with database tables.
6. Fully functional Exception handling with error table.


##Steps to Install -
1. Download project from git
2. Replace your google/facebook/github oAuth account details in application.yml
3. Replace MySQL database URL
4. Launch ServiceApplication.java
 
### To get bearer token from google account, use the following URL -
http://localhost:8090/oauth2/authorize/google?redirect_uri=http://localhost:3000/login/redirect 