FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY deploy/fiap_bff_travel-0.0.1-SNAPSHOT.jar fiap_bff_travel.jar
ENTRYPOINT ["java","-jar","/fiap_bff_travel.jar"]