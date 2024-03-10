
package com.ecommerce.interceptor;

import com.github.bucket4j.Bandwidth;
import com.github.bucket4j.Bucket;
import com.github.bucket4j.Bucket4j;
import com.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;

@Component
public class RateLimitingInterceptor implements HandlerInterceptor {

    @Value("${ecommerce.api.rateLimit}")
    private int rateLimit;

    @Value("${ecommerce.api.refillRate}")
    private int refillRate;

    private final Bucket bucket;

    public RateLimitingInterceptor() {
        Bandwidth limit = Bandwidth.classic(rateLimit, Refill.intervally(refillRate, Duration.ofMinutes(1)));
        this.bucket = Bucket4j.builder().addLimit(limit).build();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (bucket.tryConsume(1)) {
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_TOO_MANY_REQUESTS);
            return false;
        }
    }
}
