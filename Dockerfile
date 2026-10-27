# TP4 SmartCampus — image du JAR produit par Maven/Jenkins
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# curl pour healthcheck Compose ; utilisateur non-root
RUN apk add --no-cache curl \
    && addgroup -S smartcampus && adduser -S smartcampus -G smartcampus

COPY target/smartcampus-*.jar app.jar
RUN chown smartcampus:smartcampus app.jar

USER smartcampus

EXPOSE 8080

ENV SERVER_PORT=8080 \
    JAVA_OPTS="-XX:+UseContainerSupport"

ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar /app/app.jar"]