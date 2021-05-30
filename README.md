# Spring Data JPA with Redis Caching

### Overview
This is a demo Springboot application, in which a caching mechanism has been implemented using Redis, to reduce database hits.

### Demo
1. Start an instance of Redis Server in Docker using the command:
    ```shell
    docker compose up -d
    ```

2. Start the Springboot application.
   - Make POST requests to the API endpoint `http://localhost:8080/employees/`
   - Make a GET request to the API endpoint `http://localhost:8080/employees/{id}`
      - The first request will hit the database.
      - After that, it will hit the cache and reduce database hits.
   - Make a DELETE or PUT request to the API endpoint `http://localhost:8080/employees/{id}`
   - Make a GET request again to the API endpoint `http://localhost:8080/employees/{id}`
      - It will hit the database again since PUT/DELETE actions trigger *Cache Eviction*