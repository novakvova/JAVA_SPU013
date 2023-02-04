package models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_roles")
public class Role {
    @Id  //Первиний ключ Primary key
    @GeneratedValue(strategy=GenerationType.IDENTITY) //авто інкремень по ключу, коли додається новий запис
    private int id;
    @Column(length = 255, nullable = false)
    private String name;

}
