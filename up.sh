#!/bin/bash

# Update ALL Dockerfiles with working image
for service in discovery-server api-gateway inventory-service order-service payment-service user-service frontend-service; do
    cat > $service/Dockerfile << EOF
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EOF
    echo "Updated $service/Dockerfile"
done

# Add specific ports (optional but good practice)
echo "EXPOSE 8761" >> discovery-server/Dockerfile
echo "EXPOSE 8080" >> api-gateway/Dockerfile
echo "EXPOSE 8081" >> inventory-service/Dockerfile
echo "EXPOSE 8082" >> order-service/Dockerfile
echo "EXPOSE 8083" >> payment-service/Dockerfile
echo "EXPOSE 8084" >> user-service/Dockerfile
echo "EXPOSE 8090" >> frontend-service/Dockerfile
