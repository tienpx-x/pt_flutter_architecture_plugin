package com.tienpx.setting;

import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;

import javax.swing.*;

public class AppSettingsComponent {

    private final JPanel myMainPanel;
    private final JBTextField filePath = new JBTextField();
    private final JBTextField className = new JBTextField();
    private final JBCheckBox namedWithParent = new JBCheckBox("Named with parent");

    public AppSettingsComponent() {
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Enter generated file path: "), filePath, 1, false)
                .addLabeledComponent(new JBLabel("Enter generated class name: "), className, 1, false)
                .addComponent(namedWithParent, 1)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return myMainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return filePath;
    }

    public String getFilePath() {
        return filePath.getText();
    }

    public void setFilePath(String text) {
        filePath.setText(text);
    }

    public String getClassName() {
        return className.getText();
    }

    public void setClassName(String text) {
        className.setText(text);
    }

    public boolean getNamedWithParent() {
        return namedWithParent.isSelected();
    }

    public void setNamedWithParent(boolean newStatus) {
        namedWithParent.setSelected(newStatus);
    }

}
