package com.andrew.bystrov.translate;

import com.intellij.openapi.ui.ComboBox;

import java.util.ArrayList;
import java.util.List;

public class Langs
{
	public static void addAllLangs(ComboBox<String> comboBox)
	{
		getLangs().forEach(comboBox::addItem);
	}

	public static List<String> getLangs()
	{
		Sender sender = new Sender();
		String response = sender.getLangs();
		return parseResponse(response);
	}

	private static List<String> parseResponse(String response)
	{
		System.out.println("Get langs response : " + response);
		return new ArrayList<>();
	}
}
