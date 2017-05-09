package com.andrew.bystrov.translate;

import com.intellij.openapi.diagnostic.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sender
{
	public static final String MAIN_URL = "https://translate.yandex.net/api/v1.5/tr.json/";
	public static final String TRANSLATE = "translate";
	public static final String LANGS = "getLangs";
	public static final String API_KEY = "key";

	public static final String API_KEY_VALUE = "";

	public Sender()
	{

	}

	public String translateText(String originText, String lang)
	{
		try
		{
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(MAIN_URL + TRANSLATE);
			post.setHeader("User-Agent", "Mozilla/5.0");

			List<NameValuePair> list = new ArrayList<>();
			list.add(new BasicNameValuePair(API_KEY, API_KEY_VALUE));
			list.add(new BasicNameValuePair("text", originText));
			list.add(new BasicNameValuePair("lang", lang));
			list.add(new BasicNameValuePair("format", "plain"));
			list.add(new BasicNameValuePair("options", "1"));
			post.setEntity(new UrlEncodedFormEntity(list));
			HttpResponse response = client.execute(post);

			return parseResponse(response);

		}
		catch (Exception e)
		{
			Logger.getInstance(Sender.class).error(e.getMessage(), e);
			return e.getMessage();
		}
	}

	public String getLangs()
	{
		try
		{
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(MAIN_URL + LANGS);
			post.setHeader("User-Agent", "Mozilla/5.0");

			List<NameValuePair> list = new ArrayList<>();
			list.add(new BasicNameValuePair(API_KEY, API_KEY_VALUE));
			list.add(new BasicNameValuePair("ui", "en"));
			post.setEntity(new UrlEncodedFormEntity(list));
			HttpResponse response = client.execute(post);

			return parseResponse(response);
		}
		catch (Exception e)
		{
			Logger.getInstance(Sender.class).error(e.getMessage(), e);
			return e.getMessage();
		}
	}

	private String parseResponse(HttpResponse response) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent())))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				sb.append(line);
			}
		}
		return sb.toString();
	}
}
