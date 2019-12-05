FROM gradle:5.4.1-alpine as builder

USER root

ENV APP_DIR /app
WORKDIR $APP_DIR

COPY build.gradle.kts $APP_DIR/
COPY settings.gradle.kts $APP_DIR/

RUN apk add --no-cache curl

COPY . $APP_DIR

RUN gradle build -x test

# -----------------------------------------------------------------------------

FROM openjdk:12-alpine3.9

RUN apk add --no-cache tini

WORKDIR /app

COPY --from=builder /app/init.sh /app
COPY --from=builder /app/build/libs/document-*.jar /app/

EXPOSE 8080

ENTRYPOINT ["tini", "-s", "--", "sh", "init.sh"]