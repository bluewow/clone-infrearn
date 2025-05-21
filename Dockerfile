# 1. Build 단계
FROM amazoncorretto:24-alpine AS builder

# 작업 디렉토리 설정
WORKDIR /app

# Gradle 캐싱을 위한 빌드 스크립트 복사
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# 소스 코드 복사
COPY src ./src

# 개행문자 변경 CR LF -> LF
RUN sed -i 's/\r//' gradlew

# 프로젝트 빌드 (테스트 생략)
RUN chmod 777 ./gradlew
RUN ./gradlew bootJar -x test --no-daemon


# 2. Run 단계
FROM amazoncorretto:24-alpine

# 작업 디렉토리 설정
WORKDIR /app

# 빌드된 JAR 파일 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 타임존 설정
ENV TZ=Asia/Seoul
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]