FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY fiap_bff_travel.jar fiap_bff_travel.jar
ENTRYPOINT ["java","-jar","/fiap_bff_travel.jar"]