package com.andrew.bystrov.translate;

public class Translater
{
	private String originText;
	private String lang;

	public static String translate(String originText, String sourceLang, String destLang)
	{
		Translater translater = new Translater(originText, sourceLang, destLang);
		String response = new Sender().translateText(translater.originText, translater.lang);
		return translater.parseResponse(response);
	}

	private Translater(String originText, String sourceLang, String destLang)
	{
		this.originText = originText;
		this.lang = sourceLang + "-" + destLang;
	}

	private String parseResponse(String response)
	{

		return response;
	}
}
