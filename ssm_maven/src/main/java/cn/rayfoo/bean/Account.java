package cn.rayfoo.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: rayfoo@qq.com
 * @Date: 2020/7/15 3:29 下午
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "account")
public class Account {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double money;
}
