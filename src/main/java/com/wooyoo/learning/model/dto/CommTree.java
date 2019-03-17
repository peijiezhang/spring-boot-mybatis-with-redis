package com.wooyoo.learning.model.dto;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CommTree {


    /**
     * 树节点id
     */
    private String id;

    /**
     * 树节点父id
     */
    private String pid;

    /**
     * 树节点展示内容
     */
    private String text;

    /**
     * 是否是叶子节点
     */
    private boolean leaf;

    /**
     * 当前树的深度
     */
    private int depth;


    /**
     * 叶子节点的内容
     */
    private String data;


    private List<? extends CommTree> children = new CopyOnWriteArrayList<>();

    public List<? extends CommTree> getChildren() {
        return children;
    }

    public void setChildren(List<? extends CommTree> children) {
        this.children = children;
    }

    public CommTree(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
