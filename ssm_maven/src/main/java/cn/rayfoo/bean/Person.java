package cn.rayfoo.bean;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by rayfoo@qq.com Luna on 2020/2/18 15:34
 */

/**
 * 这里可以使用lombok 鉴于可能有很多同学没有安装此插件，暂时不采用。
 */
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;    //编号
    private String pname;   //姓名
    private Integer age;    //年龄
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;  //出生日期
    private String sex;     //性别
    @NumberFormat
    private Double salary;


    public Person() {
    }

    public Person(Integer pid, String pname, Integer age, Date hiredate, String sex, Double salary) {
        this.pid = pid;
        this.pname = pname;
        this.age = age;
        this.hiredate = hiredate;
        this.sex = sex;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", age=" + age +
                ", hiredate=" + hiredate +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
