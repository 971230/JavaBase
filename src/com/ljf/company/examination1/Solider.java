package com.ljf.company.examination1;

/**
 * @author 1
 */
public class Solider extends Role {
    /**TODO 武器属性*/
    private SoliderWeapon soliderWeapon;

    public void setSoliderWeapon(SoliderWeapon soliderWeapon){
        this.soliderWeapon = soliderWeapon;
    }

    /**调用父类的构造方法。*/
    public Solider(String name,int leverl){
        super(name,leverl);
    }

    @Override
    int attack() {
        return  soliderWeapon.kill()*getLevel();
    }
}
