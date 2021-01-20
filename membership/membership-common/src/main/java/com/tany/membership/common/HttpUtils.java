package com.tany.membership.common;

import com.tany.membership.common.http.HttpsClientRequestFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.commons.httpclient.methods.GetMethod;
//import org.apache.commons.httpclient.methods.PostMethod;

public class HttpUtils {
	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    private HttpUtils() {}
    
 // 默认时间五秒，不重试。
    private final static int CONNEC_TIMEOUT = 5000;
    private final static int READ_TIMEOUT   = 5000;

    
    public static String httpGet(String url,Object... uriVariables) {
        RestTemplate restTemplate = simpeClient(url, CONNEC_TIMEOUT, READ_TIMEOUT);
        String result = null; // 返回值类型;
        result = restTemplate.getForObject(url, String.class,uriVariables);
        return result;
    }
    public static String httpPost(String url, String params) {
        RestTemplate restTemplate = simpeClient(url, CONNEC_TIMEOUT, READ_TIMEOUT);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //requestHeaders.setAll(headersMap);
        HttpEntity<String> requestEntity = new HttpEntity<String>(params, headers); // josn utf-8 格式
        return restTemplate.postForObject(url, requestEntity, String.class);
    }
    
    public static String httpPostEncryption(String url, MultiValueMap<String, Object> postParameters, Map<String,String> headersMap) {
        RestTemplate restTemplate = simpeClient(url, CONNEC_TIMEOUT, READ_TIMEOUT);
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAll(headersMap);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(postParameters, requestHeaders);
        return restTemplate.postForObject(url, requestEntity, String.class);
        
    }
    
    private static RestTemplate simpeClient(String url, int connecTimeout, int readTimeout) {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connecTimeout);
        requestFactory.setReadTimeout(readTimeout);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8)); // 设置编码集
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler()); //error处理
        if (url.startsWith("https")){
            restTemplate.setRequestFactory(new HttpsClientRequestFactory()); // 绕过https
        }
        return restTemplate;
    }
    private static class DefaultResponseErrorHandler implements ResponseErrorHandler {

        /**
         * 对response进行判断，如果是异常情况，返回true
         */
        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            return response.getStatusCode().value() != 200;
        }

        /**
         * 异常情况时的处理方法
         */
        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getBody()));
            StringBuilder sb = new StringBuilder();
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            try {
                //throw new Exception(sb.toString());
            	logger.warn(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    


    /*public static final String get(String url) {
        String result = "";
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        try {
            client.executeMethod(method);
            result = method.getResponseBodyAsString();
        } catch (Exception e) {
            logger.error("", e);
        } finally {
            method.releaseConnection();
        }
        return result;
    }

    public static final String post(String url, List<NameValuePair> list) {
        String result = "";
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(url);
        try {
            NameValuePair[] params = new NameValuePair[list.size()];
            for (int i = 0; i < list.size(); i++) {
                params[i] = list.get(i);
            }
            method.addParameters(params);
            client.executeMethod(method);
            result = method.getResponseBodyAsString();
        } catch (Exception e) {
            logger.error("", e);
        } finally {
            method.releaseConnection();
        }
        return result;
    }*/
}