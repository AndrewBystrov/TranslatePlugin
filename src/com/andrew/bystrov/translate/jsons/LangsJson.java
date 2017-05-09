package com.andrew.bystrov.translate.jsons;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class LangsJson
{
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
}
