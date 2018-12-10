package com.reptile.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource({"classpath:webUser.properties"})
public class HeaderConstant {
	
	@Value("#{'${UserAgentValue}'.split('#;#').length}")
	public static int userAgentRan;
	
	@Value("#{'${UserAgentValue}'.split('#;#')}")
	public static List<String> userAgent;
	
	@Value("${UserAgent}")
	public static String userAgentKey;
	
	@Value("#{'${cookie}'.split('#;#').length}")
	public static int cookieRan;
	
	@Value("#{'${cookie}'.split('#;#')}")
	public static List<String> cookie;
	
	@Value("${AcceptEncoding}")
	public static String AcceptEncodingKey;
	
	@Value("${AcceptEncodingValue}")
	public static String AcceptEncoding;
	
	
	
	
	
	@Value("${AcceptLanguageValue}")
	public static String AcceptLanguage;
	@Value("${AcceptLanguage}")
	public static String AcceptLanguageKey;
	
	
	
	
	@Value("${ConnectionValue}")
	public static String Connection;
	@Value("${Connection}")
	public static String ConnectionKey;
	
	
	
	@Value("${UpgradeInsecureRequestsValueValue}")
	public static String UpgradeInsecureRequestsValue;
	@Value("${UpgradeInsecureRequestsValue}")
	public static String UpgradeInsecureRequestsValueKey;
	
	
	
	@Value("${Referer}")
	public static String RefererKey;
	
	
	
	@Value("${webUrl}")
	public static String webUrl;
	
	
	
}
