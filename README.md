Caching in Spring Boot improves performance by storing frequently accessed data in memory. The main annotations are:

1. @EnableCaching – Enables caching globally in the Spring Boot application.

2. @Cacheable – Caches the result of a method; subsequent calls return cached data.

3. @CacheEvict – Clears cache entries when data changes to prevent stale data.

4. @CachePut – Updates the cache without interfering with method execution, ensuring the cache stays current.
