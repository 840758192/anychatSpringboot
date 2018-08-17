package com.anychat.core.http;

import org.apache.http.ssl.TrustStrategy;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author lijian
 * @version V1.0 创建时间：2018/8/17 0017
 * Copyright 2018 by landray & STIC
 */
public class TrustStrategyAll implements TrustStrategy {
    public TrustStrategyAll() {
    }

    public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        return true;
    }
}
