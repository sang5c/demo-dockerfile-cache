# 종속성을 다운로드하고 캐싱하기 위한 단계
FROM gradle:8.6-jdk21 AS dependencies

WORKDIR /app

COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle

RUN ./gradlew dependencies

# 실제 애플리케이션을 빌드하기 위한 단계
FROM gradle:8.6-jdk21 AS builder

WORKDIR /app

COPY --from=dependencies /app /app
COPY src /app/src

RUN ls -al
RUN ls -al ./.gradle

RUN ./gradlew build

# 최종 실행 이미지 생성
FROM eclipse-temurin:21-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
