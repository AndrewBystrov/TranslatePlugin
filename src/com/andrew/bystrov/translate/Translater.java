package com.andrew.bystrov.translate;

import com.andrew.bystrov.translate.jsons.JsonUtils;
import com.andrew.bystrov.translate.jsons.TranslateJson;
import com.google.gson.Gson;

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
		Gson gson = new Gson();
		TranslateJson json = gson.fromJson(response, TranslateJson.class);
		if (json.getCode() != 200)
		{
			return JsonUtils.createException(json.getCode(), json.getMessage()).getMessage();
		}
		return json.getText();
	}
}
