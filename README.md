Perform the following steps to run the microservices with Docker Compose:

Step 1: Run the following command in product-service and payment-service microservices:
        mvn clean package -DskipTests  
Step 2: It will create jar file in their 'target' folders, e.g. product-service-0.0.1-SNAPSHOT
Step 3: Copy those jars and put them into the docker-compose project in the below location:
        docker-compose/product-service/product-service-0.0.1-SNAPSHOT
        docker-compose/payment-service/payment-service-0.0.1-SNAPSHOT
Step 4: Go to the respective folders and run the below command for each of them. It will create a Docker image. You can verify with the command 'docker images':
        docker build -t product-service
        docker build -t payment-service
Step 5: Now to the docker-compose run command 'docker-compose up' to run the docker-compose file. You can see that all the services mentioned in the docker-compose file are going up.
Step 6: Once all the services are up, you can run the project with endpoints. You can import the postman's JSON file to get the endpoints.
