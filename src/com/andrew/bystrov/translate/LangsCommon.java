package com.andrew.bystrov.translate;

import com.andrew.bystrov.translate.jsons.LangsJson;
import com.google.gson.Gson;
import com.intellij.openapi.ui.ComboBox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LangsCommon
{
	public static void addAllLangs(ComboBox<Lang> comboBox)
	{
		getLangs().forEach(comboBox::addItem);
	}

	public static List<Lang> getLangs()
	{
		Sender sender = new Sender();
		String response = sender.getLangs();
		return parseResponse(response);
	}

	private static List<Lang> parseResponse(String response)
	{
		System.out.println("Get langs response : " + response);
		LangsJson langsJson = new Gson().fromJson(response, LangsJson.class);
		return langsJson.getLangs().entrySet()
				.stream()
				.map(e -> new Lang(e.getValue(), e.getKey()))
				.collect(Collectors.toList());
	}
}
