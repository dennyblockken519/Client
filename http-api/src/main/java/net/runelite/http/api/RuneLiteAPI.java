/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.http.api;

import com.google.gson.Gson;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RuneLiteAPI
{
	private static final Logger logger = LoggerFactory.getLogger(RuneLiteAPI.class);

	public static final String RUNELITE_AUTH = "RUNELITE-AUTH";

	public static final OkHttpClient CLIENT;
	public static final Gson GSON = new Gson();
	public static String userAgent;
	
	private static final String INFERNO_BASE = "http://3.84.251.214:8080";
	
	private static final String BASE = "https://api.runelite.net";
	private static final String WSBASE = "https://api.runelite.net/ws";
	private static final String STATICBASE = "https://static.runelite.net";
	private static final Properties properties = new Properties();
	private static String version;
	private static int rsVersion;

	static
	{
		try
		{
			InputStream in = RuneLiteAPI.class.getResourceAsStream("/runelite.properties");
			properties.load(in);

//			version = properties.getProperty("runelite.version");
			version = getVersion();
			rsVersion = Integer.parseInt(properties.getProperty("rs.version"));
			String commit = properties.getProperty("runelite.commit");
			boolean dirty = Boolean.parseBoolean(properties.getProperty("runelite.dirty"));
			
			userAgent = "Api";
		}
		catch (NumberFormatException e)
		{
			throw new RuntimeException("Version string has not been substituted; Re-run maven");
		}
		catch (IOException ex)
		{
			logger.error(null, ex);
		}

		CLIENT = new OkHttpClient.Builder()
			.pingInterval(30, TimeUnit.SECONDS)
			.addNetworkInterceptor(new Interceptor()
			{

				@Override
				public Response intercept(Chain chain) throws IOException
				{
					Request userAgentRequest = chain.request()
						.newBuilder()
							.addHeader("Authorization", "Bearer eZ02dvQi-JwZ7-s3o7-rxIw-9TLNqtjR2Yuj")
						.addHeader("User-Agent", userAgent)
						.build();
					return chain.proceed(userAgentRequest);
				}
			})
			.build();
	}

	public static HttpUrl getApiRoot()
	{
		return HttpUrl.parse(BASE);
	}

	public static HttpUrl getApiBase() {
//		return HttpUrl.parse(BASE + "/runelite-" + getVersion());
		return HttpUrl.parse(BASE + "/runelite-" + version);
	}
	
	public static HttpUrl getInfernoApi() {
		return HttpUrl.parse(INFERNO_BASE + "/");
	}

	public static HttpUrl getStaticBase()
	{
		return HttpUrl.parse(STATICBASE);
	}

	public static HttpUrl getWsEndpoint()
	{
		return HttpUrl.parse(WSBASE);
	}

	public static String getVersion() {
		String version = "1.5.22";
		/*try {
			Document document = Jsoup.connect("https://raw.githubusercontent.com/runelite/runelite/master/http-api/pom.xml").get();
			version = document.select("parent").select("version").text();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return version;
	}

	public static void setVersion(String version)
	{
		RuneLiteAPI.version = version;
	}

	public static int getRsVersion()
	{
		return rsVersion;
	}

}
