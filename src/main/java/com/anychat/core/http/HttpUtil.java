package com.anychat.core.http;



import com.anychat.core.log.ILog;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class HttpUtil {
    public static SSLConnectionSocketFactory sslSocketFactory;
    public static String ENCODE;
    private static ILog log;
    private static String CONTENT_TYPE_JSON = "application/json";
    public static final String GET = "get";
    public static final String PUT = "put";
    public static final String DELETE = "delete";
    public static final String HEAD = "head";
    public static final String POST = "post";
    public static final String PATCH = "patch";

    public HttpUtil() {
    }

    public static void init(String encode, ILog log) throws Exception {
        ENCODE = encode;
        log = log;
        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(new TrustStrategyAll()).build();
        sslSocketFactory = new SSLConnectionSocketFactory(sslContext);
    }

    public static byte[] send(String data, String url, Map<String, String> headMap, String type) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;

        HttpEntity responseEntity;
        try {
            Object http;
            try {
                if (url.startsWith("https")) {
                    httpClient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();
                } else {
                    httpClient = HttpClients.createDefault();
                }

                HttpEntity entity = null;
                http = null;
                byte var9 = -1;
                switch(type.hashCode()) {
                    case -1335458389:
                        if (type.equals("delete")) {
                            var9 = 3;
                        }
                        break;
                    case 102230:
                        if (type.equals("get")) {
                            var9 = 0;
                        }
                        break;
                    case 111375:
                        if (type.equals("put")) {
                            var9 = 1;
                        }
                        break;
                    case 3198432:
                        if (type.equals("head")) {
                            var9 = 4;
                        }
                        break;
                    case 3446944:
                        if (type.equals("post")) {
                            var9 = 5;
                        }
                        break;
                    case 106438728:
                        if (type.equals("patch")) {
                            var9 = 2;
                        }
                }

                switch(var9) {
                    case 0:
                        http = new HttpGet(url);
                        break;
                    case 1:
                        http = new HttpPut(url);
                        if (data != null && !data.equals("")) {
                            entity = new ByteArrayEntity(data.getBytes(ENCODE), ContentType.create(CONTENT_TYPE_JSON, ENCODE));
                            ((HttpEntityEnclosingRequestBase)http).setEntity(entity);
                        }
                        break;
                    case 2:
                        http = new HttpPatch(url);
                        if (data != null && !data.equals("")) {
                            entity = new ByteArrayEntity(data.getBytes(ENCODE), ContentType.create(CONTENT_TYPE_JSON, ENCODE));
                            ((HttpEntityEnclosingRequestBase)http).setEntity(entity);
                        }
                        break;
                    case 3:
                        http = new HttpDelete(url);
                        break;
                    case 4:
                        http = new HttpHead(url);
                        break;
                    case 5:
                        http = new HttpPost(url);
                        if (data != null && !data.equals("")) {
                            entity = new ByteArrayEntity(data.getBytes(ENCODE), ContentType.create(CONTENT_TYPE_JSON, ENCODE));
                            ((HttpEntityEnclosingRequestBase)http).setEntity(entity);
                        }
                }

                String key;
                if (headMap != null) {
                    Object[] keyArray = headMap.keySet().toArray();

                    for(int i = 0; i < keyArray.length; ++i) {
                        key = String.valueOf(keyArray[i]);
                        String value = (String)headMap.get(key);
                        ((HttpRequestBase)http).addHeader(key, value);
                    }
                }

                httpResponse = httpClient.execute((HttpUriRequest)http);
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    responseEntity = httpResponse.getEntity();
                    if (responseEntity != null) {
                        byte[] result = EntityUtils.toByteArray(responseEntity);
                        byte[] var33 = result;
                        return var33;
                    }

                    if (log != null) {
                        log.warn("responseEntity为空");
                    }

                    key = null;

                    return key.getBytes();
                }

                if (log != null) {
                    log.warn("http返回码为：" + statusCode + "请注意");
                }

                responseEntity = null;
            } catch (Exception var29) {
                if (log != null) {
                    log.error("http请求异常", var29);
                }

                http = null;
                return (byte[])http;
            }
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException var28) {
                if (log != null) {
                    log.error("关闭httpClient异常", var28);
                }
            }

            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
            } catch (IOException var27) {
                if (log != null) {
                    log.error("关闭httpResponse异常", var27);
                }
            }

        }

        return null;
    }

    public static byte[] sendFile(File file, String url, Map<String, String> headMap, String type) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;

        Object[] keyArray;
        try {
            try {
                if (url.startsWith("https")) {
                    httpClient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();
                } else {
                    httpClient = HttpClients.createDefault();
                }

                HttpRequestBase http = null;
                byte var8 = -1;
                switch(type.hashCode()) {
                    case 111375:
                        if (type.equals("put")) {
                            var8 = 0;
                        }
                        break;
                    case 3446944:
                        if (type.equals("post")) {
                            var8 = 2;
                        }
                        break;
                    case 106438728:
                        if (type.equals("patch")) {
                            var8 = 1;
                        }
                }

                switch(var8) {
                    case 0:
                        http = new HttpPut(url);
                        break;
                    case 1:
                        http = new HttpPatch(url);
                        break;
                    case 2:
                        http = new HttpPost(url);
                }

                int statusCode;
                String key;
                String value;
                if (headMap != null) {
                    keyArray = headMap.keySet().toArray();

                    for(statusCode = 0; statusCode < keyArray.length; ++statusCode) {
                        key = String.valueOf(keyArray[statusCode]);
                        value = (String)headMap.get(key);
                        ((HttpRequestBase)http).addHeader(key, value);
                    }
                }

                MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                builder.addPart("file", new FileBody(file));
                ((HttpEntityEnclosingRequestBase)http).setEntity(builder.build());
                httpResponse = httpClient.execute((HttpUriRequest)http);
                statusCode = httpResponse.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    if (log != null) {
                        log.warn("http返回码为：" + statusCode + "请注意");
                    }

                    key = null;
                    return key.getBytes();
                }

                HttpEntity responseEntity = httpResponse.getEntity();
                if (responseEntity == null) {
                    if (log != null) {
                        log.warn("responseEntity为空");
                    }

                    value = null;
                    return value.getBytes();
                }

                byte[] result = EntityUtils.toByteArray(responseEntity);
                byte[] var11 = result;
                return var11;
            } catch (Exception var29) {
                if (log != null) {
                    log.error("http请求异常", var29);
                }
            }

            keyArray = null;
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException var28) {
                if (log != null) {
                    log.error("关闭httpClient异常", var28);
                }
            }

            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
            } catch (IOException var27) {
                if (log != null) {
                    log.error("关闭httpResponse异常", var27);
                }
            }

        }
        return null;
    }
}
