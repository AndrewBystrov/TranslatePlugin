package com.andrew.bystrov.translate;

import com.andrew.bystrov.translate.jsons.LangsJson;
import com.google.gson.Gson;
import com.intellij.openapi.ui.ComboBox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LangsCommon
{
	private List<Lang> langs;

	private static LangsCommon ourInstance = new LangsCommon();

	public static LangsCommon getInstance()
	{
		return ourInstance;
	}

	public void addAllLangs(ComboBox<Lang> comboBox)
	{
		getLangs().forEach(comboBox::addItem);
	}

	public List<Lang> getLangs()
	{
		if (this.langs == null)
		{
			Sender sender = new Sender();
			String response = sender.getLangs();
			this.langs = parseResponse(response);
		}
		return this.langs;
	}

	private List<Lang> parseResponse(String response)
	{
		System.out.println("Get langs response : " + response);
		LangsJson langsJson = new Gson().fromJson(response, LangsJson.class);
		return langsJson.getLangs().entrySet()
				.stream()
				.map(e -> new Lang(e.getValue(), e.getKey()))
				.collect(Collectors.toList());
	}
}
