package com.dyneinfo.zazh.model;



import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class MainMenuItem
    implements Serializable
{

    public MainMenuItem()
    {
        isLeaf = true;
        childs = new Vector();
    }

    public MainMenuItem(String name)
    {
        this();
        this.name = name;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public MainMenuItem(String name, int level)
    {
        this(name);
        setLevel(level);
    }

    public MainMenuItem(String name, String action, int level)
    {
        this(name, action);
        setLevel(level);
    }

    public MainMenuItem(String name, String action)
    {
        this(name);
        this.action = action;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public void addChild(MainMenuItem item)
    {
        childs.add(item);
    }

    public MainMenuItem[] getChilds()
    {
    	MainMenuItem childMenuTemp[] = new MainMenuItem[childs.size()];
        childs.toArray(childMenuTemp);
        return childMenuTemp;
    }

    public boolean isLeaf()
    {
        return isLeaf;
    }

    public void setLeaf(boolean leaf)
    {
        isLeaf = leaf;
    }

    public void display(String pre)
    {
        String info = pre + "name = " + name;
        if(isLeaf)
        {
            info = info + " action = " + action;
            System.out.println(info);
        } else
        {
            System.out.println(info);
            for(Iterator list = childs.iterator(); list.hasNext(); ((MainMenuItem)list.next()).display(pre + "   "));
        }
    }

    private boolean isLeaf;
    private Collection childs;
    private String action;
    private String name;
    private int level;
}