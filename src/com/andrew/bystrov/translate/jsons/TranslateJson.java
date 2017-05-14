package com.andrew.bystrov.translate.jsons;

import com.google.gson.annotations.SerializedName;

public class TranslateJson
{

	@SerializedName("code")
	private int code;

	@SerializedName("lang")
	private String lang;

	@SerializedName("text")
	private String text;

	@SerializedName("message")
	private String message;

	public TranslateJson()
	{
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getLang()
	{
		return lang;
	}

	public void setLang(String lang)
	{
		this.lang = lang;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getMessage()
	{
		return message;
	}

}
