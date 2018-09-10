package cn.bee.domain;

import java.io.Serializable;

/**
 * @author answer
 * 2018/2/5
 */
public class User implements Serializable {
    private static final long serialVersionUID = -7246691510818047305L;
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
