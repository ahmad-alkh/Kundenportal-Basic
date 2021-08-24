/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.kundenportal.service.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import de.intellinet.commons.rest.logging.RequestResponseLoggerInterceptor;
import de.intellinet.services.rating.client.controller.RatingControllerClient;
import de.intellinet.services.rating.client.controller.auth.BasicAuthorizationInterceptor;
import de.intellinet.services.rating.client.controller.eh.ErrorHandler;
import de.intellinet.services.rating.client.model.ServiceAuthorization;

/**
 * @author AHmad
 *
 * @since 25.01.2018
 *
 */
@Component
public class RatingServiceClientConfig {

    @Value("${rating-service.connection.timeout:60000}")
    private Integer connectionTimeout = 60000;
    @Value("${rating-service.connection.read.timeout:60000}")
    private Integer connectionReadTimeout = 60000;

    @Value("${rating-service.basic.auth}")
    private String basicAuth;

    @Value("${rating-service.base.url}")
    private String url;

    public RatingServiceClientConfig() {
        this.url = "https://www.demobank.info/rating-service/api/v1";
        this.basicAuth = "Basic SU5URUxMSU5FVDpUaWdMWGJlV1pXQmJWbjhaeVdGN25Fdk51SERiV0tyZg==";

    }

    public RestTemplate restTemplate() {

        SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
        httpRequestFactory.setConnectTimeout(connectionTimeout);
        httpRequestFactory.setReadTimeout(connectionReadTimeout);

        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(httpRequestFactory));

        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        interceptors.add(new BasicAuthorizationInterceptor(new ServiceAuthorization(basicAuth)));
        interceptors.add(new RequestResponseLoggerInterceptor());
        restTemplate.setErrorHandler(new ErrorHandler());
        return restTemplate;
    }

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public Integer getConnectionReadTimeout() {
        return connectionReadTimeout;
    }

    public String getBasicAuth() {
        return basicAuth;
    }

    public String getUrl() {
        return url;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setConnectionReadTimeout(Integer connectionReadTimeout) {
        this.connectionReadTimeout = connectionReadTimeout;
    }

    public void setBasicAuth(String basicAuth) {
        this.basicAuth = basicAuth;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public RatingControllerClient getClient() {
        return new RatingControllerClient(restTemplate(), getUrl());
    }

}
