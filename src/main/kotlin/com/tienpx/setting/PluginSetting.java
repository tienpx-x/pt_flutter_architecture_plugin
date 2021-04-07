package com.tienpx.setting;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "com.tienpx.setting.PluginSetting",
        storages = {@Storage("AssetsPluginSetting.xml")}
)
public class PluginSetting implements PersistentStateComponent<PluginSetting> {
    public String className = "Assets";
    public String filePath = "generated";
    public boolean namedWithParent = true;

    public static PluginSetting getInstance() {
        return ServiceManager.getService(PluginSetting.class);
    }

    @Nullable
    @Override
    public PluginSetting getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull PluginSetting state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}
