package com.lianyu.tech.common.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bowen
 */
public class SystemConfigs {
    private static final SystemConfigs INSTANCE = new SystemConfigs();

    public static SystemConfigs getInstance() {
        return INSTANCE;
    }

    private List<SystemConfigGroup> groups;

    public List<SystemConfigGroup> getGroups() {
        return groups;
    }

    private SystemConfigs() {
        groups = new ArrayList<>();
        groups.add(introduce());
    }

    private SystemConfigGroup introduce() {
        String groupName = "introduce";
        SystemConfigGroup group = new SystemConfigGroup();
        group.setGroup(groupName);
        group.setName("简介");
        group.setKeys(new ArrayList<SystemConfigKey>());
        group.getKeys().add(new SystemConfigKey(groupName, "firstHead", "标题"));
        group.getKeys().add(new SystemConfigKey(groupName, "firstSubhead", "副标题"));
        group.getKeys().add(new SystemConfigKey(groupName, "secondHead", "第二标题"));
        group.getKeys().add(new SystemConfigKey(groupName, "secondSubhead", "第二副标题"));
        group.getKeys().add(new SystemConfigKey(groupName, "bottomHead", "底部标题"));
        return group;
    }
}
