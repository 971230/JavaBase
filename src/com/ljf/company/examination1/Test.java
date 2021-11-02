package com.ljf.company.examination1;

public class Test {
    public static void main(String[] args) {
        Solider s1 = new Solider("王昊",1);
        Master m1 = new Master("士杰",4);
        //武器：大刀
        SoliderWord w1 = new SoliderWord();
        //武器：魔法球
        MgicalBall mb = new MgicalBall();

        //给对应的角色添加对应的武器
        s1.setSoliderWeapon(w1);
        m1.setMasterWeapon(mb);

        Team t = new Team(4);
        t.addRole(s1);
        t.addRole(m1);

        System.out.println("战士伤害值为" + s1.attack());
        System.out.println("法师伤害值为" + m1.attack());
        System.out.println("团队伤害值" + t.getHurt());
    }
}
