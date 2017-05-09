package com.andrew.bystrov.translate.view;

import com.andrew.bystrov.translate.Lang;
import com.andrew.bystrov.translate.LangsCommon;
import com.andrew.bystrov.translate.Translater;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.HyperlinkLabel;
import com.intellij.util.ui.AbstractTableCellEditor;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TranslatePane extends JPanel
{
	private static final int MAX_TOP_WIDTH = 30;

	private JTextArea taText;
	private JTextArea taResult;

	private ComboBox<Lang> cbTranslateFrom;
	private ComboBox<Lang> cbTranslateTo;

	public TranslatePane()
	{
		this.taText = new JTextArea();
		this.taText.setLineWrap(true);
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
		this.taResult.setLineWrap(true);
		this.taResult.setEditable(false);

		this.cbTranslateFrom = new ComboBox<>();
		this.cbTranslateTo = new ComboBox<>();

		LangsCommon.addAllLangs(this.cbTranslateFrom);
		LangsCommon.addAllLangs(this.cbTranslateTo);

		this.setLayout(new GridLayout(1, 2, 8, 0));

		this.add(createLeftPanel());
		this.add(createRightPanel());
	}

	private JPanel createRightPanel()
	{
		JPanel panel = new JPanel();

		//region license panel
		JPanel licensePanel = new JPanel();
		licensePanel.setLayout(new BoxLayout(licensePanel, BoxLayout.PAGE_AXIS));
		licensePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, MAX_TOP_WIDTH));

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		Label lbl = new Label("Переведено сервисом «Яндекс.Переводчик»");
		lbl.setAlignment(Label.RIGHT);
		licensePanel.add(lbl);
		HyperlinkLabel hyperLink = new HyperlinkLabel.Croppable();
		hyperLink.setAlignmentX(-1.0f);
		licensePanel.add(hyperLink);
		hyperLink.setHtmlText("<a href=\"http://translate.yandex.ru/\">http://translate.yandex.ru/</a>");
		hyperLink.setHyperlinkTarget("http://translate.yandex.ru");
		//endregion

		panel.add(licensePanel);
		panel.add(this.taResult);
		return panel;
	}

	private JPanel createLeftPanel()
	{
		JPanel userEditorPanel = new JPanel();
		userEditorPanel.setLayout(new BoxLayout(userEditorPanel, BoxLayout.PAGE_AXIS));

		JPanel comboBoxesPanel = createComboBoxesPanel();

		userEditorPanel.add(comboBoxesPanel);
		userEditorPanel.add(Box.createRigidArea(new Dimension(0, 8)));
		userEditorPanel.add(this.taText);
		return userEditorPanel;
	}

	private void translateText()
	{
		String result = Translater.translate(this.taText.getText()
				, ((Lang) this.cbTranslateFrom.getSelectedItem()).getDirection()
				, ((Lang) this.cbTranslateTo.getSelectedItem()).getDirection()
		);
		System.out.println("result :" + result);
		this.taResult.setText(result);
	}

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
