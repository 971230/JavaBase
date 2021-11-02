package com.ljf.company.examination1;

/**
 * 角色类
 */
abstract class Role {
    private String name;
    private int level;

    public Role(String name, int leverl) {
        this.name = name;
        this.level = leverl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }

    /**攻击抽象类*/
    abstract int attack();
}
