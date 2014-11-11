package net.java.dev.common.util;

import java.util.Map;

public abstract interface SysConfigManager {
    public abstract void addNewProperty(String paramString1, String paramString2);

    public abstract void removeProperty(String paramString);

    public abstract String getProperty(String paramString);

    public abstract void setProperty(String paramString1, String paramString2);

    public abstract void saveChange();

    public abstract Map<String, String> getProperties();
}

