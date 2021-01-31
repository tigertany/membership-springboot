package com.tany.membership.vo;

import javax.swing.*;
import java.util.List;

public class Menu {
    private Integer id;
    private Integer parentId;
    private String menuName;
    private Integer type;
    private String url;
    private String icon;
    private Integer idx;
    private List<Menu> subMenus;
    private List<PageElement> elements;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }

    public List<PageElement> getElements() {
        return elements;
    }

    public void setElements(List<PageElement> elements) {
        this.elements = elements;
    }
}
