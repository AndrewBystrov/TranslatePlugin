package com.andrew.bystrov.translate.idea;

import com.andrew.bystrov.translate.view.TranslatePane;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.structuralsearch.plugin.ui.Configuration;
import com.intellij.structuralsearch.plugin.ui.ConfigurationManager;
import org.jetbrains.annotations.NotNull;

public class MyToolWindow implements ToolWindowFactory
{
	@Override
	public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow)
	{
		toolWindow.getComponent().add(new TranslatePane());
	}
}