package org.apache.ignite.springdata.repository.config;

public class IgniteSpringDataConfiguration {

    private String configPath;

    public IgniteSpringDataConfiguration() {
    }

    public IgniteSpringDataConfiguration(String configPath) {
        this.configPath = configPath;
    }

    public String getConfigPath() {
        return configPath;
    }

    public void setConfigPath(String configPath) {
        this.configPath = configPath;
    }
}
