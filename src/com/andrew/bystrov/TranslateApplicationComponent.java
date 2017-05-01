package com.andrew.bystrov;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.PersistentStateComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
