package com.andrew.bystrov.translate.view;

import com.andrew.bystrov.translate.Translater;
import com.intellij.openapi.ui.ComboBox;
import org.jdesktop.swingx.prompt.PromptSupport;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TranslatePane extends JPanel
{
	private JTextArea taText;
	private JTextArea taResult;

	private ComboBox<String> cbTranslateFrom;
	private ComboBox<String> cbTranslateTo;

	public TranslatePane()
	{
		this.taText = new JTextArea();
		PromptSupport.setPrompt("Use ctrl+enter to translate text", this.taText);
		this.taText.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					translateText();
				}
			}
		});

		this.taResult = new JTextArea();
		this.taResult.setEditable(false);

		this.cbTranslateFrom = new ComboBox<>();
		this.cbTranslateTo = new ComboBox<>();

		addItemsToComboBox(this.cbTranslateFrom);
		addItemsToComboBox(this.cbTranslateTo);

		this.setLayout(new GridLayout(1, 2, 8, 0));

		//region Left panel
		JPanel userEditorPanel = new JPanel();
		userEditorPanel.setLayout(new BoxLayout(userEditorPanel, BoxLayout.PAGE_AXIS));

		JPanel comboBoxesPanel = createComboBoxesPanel();

		userEditorPanel.add(comboBoxesPanel);
		userEditorPanel.add(Box.createRigidArea(new Dimension(0, 8)));
		userEditorPanel.add(this.taText);
		//endregion

		this.add(userEditorPanel);
		this.add(this.taResult);
	}

	private void translateText()
	{
		String result = Translater.translate(this.taText.getText(), (String) this.cbTranslateFrom.getSelectedItem(), (String) this.cbTranslateTo.getSelectedItem());
		this.taResult.setText(result);
	}

	public static void addItemsToComboBox(ComboBox<String> comboBox)
	{
		comboBox.addItem("English");
		comboBox.addItem("Russian");
	}

	@NotNull
	private JPanel createComboBoxesPanel()
	{
		JPanel comboBoxesPanel = new JPanel();
		comboBoxesPanel.setLayout(new GridBagLayout());

		GridBagConstraints c0 = new GridBagConstraints();
		c0.fill = GridBagConstraints.HORIZONTAL;
		c0.anchor = GridBagConstraints.LINE_START;
		c0.weightx = 0.4;

		GridBagConstraints c1 = new GridBagConstraints();
		c1.anchor = GridBagConstraints.CENTER;
		c1.weightx = 0.1;

		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.anchor = GridBagConstraints.LINE_END;
		c2.weightx = 0.4;

		GridBagConstraints c3 = new GridBagConstraints();
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.anchor = GridBagConstraints.LINE_END;
		c3.weightx = 0.1;

		comboBoxesPanel.add(this.cbTranslateFrom, c0);
		comboBoxesPanel.add(new Label("=>"), c1);
		comboBoxesPanel.add(this.cbTranslateTo, c2);
		JButton translate = new JButton("Translate");
		translate.addActionListener(e -> translateText());
		comboBoxesPanel.add(translate, c3);
		comboBoxesPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		return comboBoxesPanel;
	}
}
