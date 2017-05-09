package com.andrew.bystrov.translate.idea;

import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

public class TranslateApplicationComponent implements ApplicationComponent
{
	public TranslateApplicationComponent()
	{

	}

	@Override
	@NotNull
	public String getComponentName()
	{
		return "TranslateApplicationComponent";
	}

	//region ApplicationComponent intefrace
	@Override
	public void initComponent()
	{
		// TODO: insert component initialization logic here
	}

	@Override
	public void disposeComponent()
	{
		// TODO: insert component disposal logic here
	}

	//endregion
}
