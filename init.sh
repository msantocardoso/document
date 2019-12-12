#!/usr/bin/env bash

set -e

ENVIRONMENT_NAME="${SPRING_PROFILES_ACTIVE:-"dev"}"
JVM_OPS="${JVM_OPS:-""}"
echo "ENVIRONMENT_NAME: ${ENVIRONMENT_NAME}"

COMMAND=${1:-"web"}
echo $COMMAND

case "$COMMAND" in
  migrate|web)
    exec java ${JVM_OPS} -Duser.Timezone=America/Sao_Paulo \
      -Dspring.profiles.active=${ENVIRONMENT_NAME} \
      -Dspring.data.mongodb.uri=${MONGODB_URI} \
      -jar $BINARY_DIR/document-*.jar \
      $COMMAND
    ;;
  *)
    exec sh -c "$*"
    ;;
esac