#  Recommendation Service

## Stakeholders

* H&M

## Purpose
Recommendation service that suggests an outfit based on a given event, user preferences, and available inventory.

## Description
This service facilitates outfit recommendation based on event type and user preferences.
This service will internally filter available inventory based on the input.
These APIs will return set of outfit recommendations.
Finally, the recommendation service will return the set of outfit recommendations.

### API Documentation

| Environment    | URL                                      |
| -------------- |------------------------------------------|
| localhost      | http://localhost:8090/api/recommendation |


## Development quick start

Always use the [Gradle wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html). This increases the
reliability of the build and will ensure that everyone are using the same Gradle version.

1. Install Java 17
2. Open project in IDE
3. Build: `./gradlew build`
4. Test: `./gradlew test`
5. Code Coverage: `./gradlew test jacocoTestReport`
6. Run: `./gradlew bootRun`

Note: Code Coverage will be available under build folder ./build/reports/jacoco/index.html

* In IDE Settings:

1. Import project select from gradle
2. Select java 17 as SDK
3. Run

After running the application the endpoints are accessible on http://localhost:8090/api/recommendations

**Example Curl**:

curl --location --request POST 'http://localhost:8090/api/recommendations' \
--header 'Content-Type: application/json' \
--data-raw '{
"eventType": "CHRISTMAS",
"userPreferences": {
"budget": 100,
"stylePreferences": ["Casual", "Formal"]

}
}'


