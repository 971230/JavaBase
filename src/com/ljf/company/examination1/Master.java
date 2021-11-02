package com.ljf.company.examination1;

/**
 * @author 1
 */
public class Master extends Role {
    // 武器属性
    private MasterWeapon  masterWeapon;

    public void setMasterWeapon(MasterWeapon masterWeapon) {
        this.masterWeapon = masterWeapon;
    }

    /** 调用父类的构造方法。*/
    public Master(String name,int leverl){
        super(name,leverl);
    }

    @Override
    int attack() {
        return  masterWeapon.kill() * getLevel();
    }
}
