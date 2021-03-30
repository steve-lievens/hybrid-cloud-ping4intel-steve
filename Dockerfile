#FROM openjdk:13-oracle
#VOLUME /tmp
#EXPOSE 8000
#RUN mkdir -p /app/
#RUN mkdir -p /app/logs/
#ADD target/hybrid-cloud-ping4intel-0.0.1-SNAPSHOT.jar /app/app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]

FROM openjdk:8
EXPOSE 8000
COPY target/hybrid-cloud-ping4intel-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]