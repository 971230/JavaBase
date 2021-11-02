package com.ljf.company.examination1;

/**
 * @author 项海涛
 */
public class Team {
    Role [] roles;

    public Team(int size){
        roles = new Role[size];
    }

    /**1.为团队添加角色*/
    int count = 0;
    public void addRole(Role role){
        if(count > roles.length){
            System.out.println("团队满了，别装了");
        }
        roles[count++] = role;
    }
    /**就算团队伤害值的方法*/
    public int getHurt(){
        int sum = 0;
        for (Role role : roles) {
            if (role != null) {
                sum += role.attack();
            }
        }
        return sum;
    }
}
