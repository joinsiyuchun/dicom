// 
// Decompiled by Procyon v0.5.36
// 

package com.yck12.dicom;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@Component
public class HttpHolder
{
    private static final Logger log;
    private final RestTemplate restTemplate;
    
    @Autowired
    public HttpHolder(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public <T> T get(final String url, final Class<T> responseType) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "application/json");
        HttpHolder.log.info("get >>> url:{}", (Object)url);
        return (T)this.restTemplate.exchange(url, HttpMethod.GET, new HttpEntity((MultiValueMap)headers), (Class)responseType, new Object[0]).getBody();
    }
    
    public <T> T get(final String url, final Map<String, String> headerMap, final Class<T> responseType) {
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headerMap.forEach(headers::add);
        HttpHolder.log.info("get >>> url:{}, headers:{}", (Object)url, (Object)JSON.toJSONString((Object)headerMap));
        final ResponseEntity<String> response = (ResponseEntity<String>)this.restTemplate.exchange(url, HttpMethod.GET, new HttpEntity((MultiValueMap)headers), (Class)String.class, new Object[0]);
        final int code = response.getStatusCodeValue();
        final String body = (String)response.getBody();
        HttpHolder.log.info("response[{}] >>> {}", (Object)code, (Object)body);
        if (HttpStatus.OK.value() == code) {
            return (T)JSON.parseObject(body, (Class)responseType);
        }
        return null;
    }
    
    public void post(final String url, final String jsonParams) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpHolder.log.info("post >>> url:{}, body:{}", (Object)url, (Object)jsonParams);
        final ResponseEntity<String> result = (ResponseEntity<String>)this.restTemplate.postForEntity(url, (Object)new HttpEntity((Object)jsonParams, (MultiValueMap)headers), (Class)String.class, new Object[0]);
        final int code = result.getStatusCodeValue();
        final String body = Optional.ofNullable(result.getBody()).orElse("");
        if (code == HttpStatus.OK.value()) {
            HttpHolder.log.info("post >>> response body:{}", (Object)body);
        }
        else {
            HttpHolder.log.error("post >>> failure!!! code:{}, body:{}", (Object)result.getStatusCodeValue(), (Object)body);
        }
    }
    
    public <T> T post(final String url, final String jsonParams, final Class<T> responseType) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpHolder.log.info("post >>> url:{}, body:{}", (Object)url, (Object)jsonParams);
        return (T)this.restTemplate.postForObject(url, (Object)new HttpEntity((Object)jsonParams, (MultiValueMap)headers), (Class)responseType, new Object[0]);
    }
    
    static {
        log = LoggerFactory.getLogger((Class)HttpHolder.class);
    }
}
