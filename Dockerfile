FROM gradle:5.4.1-alpine as builder
MAINTAINER Murilo Cardoso
USER root

ENV SOURCE_DIR /var/source
WORKDIR $SOURCE_DIR

COPY . $SOURCE_DIR

RUN gradle build -x test

# -----------------------------------------------------------------------------

FROM openjdk:12-alpine3.9

RUN apk add --no-cache tini

ENV SOURCE_DIR /var/source
ENV BINARY_DIR /var/bin

WORKDIR $BINARY_DIR

COPY --from=builder $SOURCE_DIR/init.sh $BINARY_DIR
COPY --from=builder $SOURCE_DIR/build/libs/document-*.jar $BINARY_DIR

EXPOSE 8080

ENTRYPOINT ["tini", "-s", "--", "sh", "init.sh"]