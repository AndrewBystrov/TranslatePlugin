package com.andrew.bystrov.translate.jsons;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class LangsJson
{
	@SerializedName("code")
	private int code;

	@SerializedName("message")
	private String message;

	@SerializedName("langs")
	private Map<String, String> langs;

	@SerializedName("dirs")
	private String[] dirs;

	public Map<String, String> getLangs()
	{
		return langs;
	}

	public String[] getDirs()
	{
		return dirs;
	}

	public int getCode()
	{
		return code;
	}

	public String getMessage()
	{
		return message;
	}
}
