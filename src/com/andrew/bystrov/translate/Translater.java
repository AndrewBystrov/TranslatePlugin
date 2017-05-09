package com.andrew.bystrov.translate;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Translater
{
	public static final String URL = "https://translate.yandex.net/api/v1.5/tr.json/";
	public static final String TRANSLATE = "translate";
	public static final String LANGS = "getLangs";
	public static final String KEY = "key";
	public static final String KEY_VALUE = "";

	private String originText;
	private String lang;

	private String translatedText;

	public static String translate(String originText, String sourceLang, String destLang)
	{
		Translater translater = new Translater(originText, sourceLang, destLang);
		HttpResponse send = translater.send();
		String data = translater.readData(send);
		System.out.println("Readed data : " + data);
		return translater.convertData(data);
	}

	private Translater(String originText, String sourceLang, String destLang)
	{
		this.originText = originText;
		this.lang = sourceLang + "-" + destLang;

		this.translatedText = this.originText;
	}

	private HttpResponse send()
	{
		try
		{
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(URL + TRANSLATE);
			post.setHeader("User-Agent", "Mozilla/5.0");
			System.out.println("text : " + this.originText);
			System.out.println("lang : " + this.lang);
			List<NameValuePair> list = new ArrayList<>();
			list.add(new BasicNameValuePair(KEY, KEY_VALUE));
			list.add(new BasicNameValuePair("text", this.originText));
			list.add(new BasicNameValuePair("lang", this.lang));
			list.add(new BasicNameValuePair("format", "plain"));
			list.add(new BasicNameValuePair("options", "1"));

			post.setEntity(new UrlEncodedFormEntity(list));
			return client.execute(post);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private String readData(HttpResponse response)
	{
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent())))
		{
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null)
			{
				sb.append(line);
			}
			return sb.toString();
		}
		catch (Exception e)
		{

		}
		return null;
	}

	private String convertData(String jsonString)
	{
		return "";
	}


}
