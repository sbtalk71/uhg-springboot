# uhg-springboot
For Any query You may contact me at sbtalk@gmail.com
HOW TO RUN The applications
1. Install mongoDB 4.0 and populate the database using the script provided in 'support-files' folder.

2. Install MySQL DB with:
username: root
password: root
database: springdb;
populate the database using the script file provided in 'support-files' folder.


Now you can test the applications.

Run microservices in the following order
1. emp-eureka-server
2. emp-data-service (3 instances)
3. hr-service
4. Zuul-proxy
5. hystrix-dashboard

