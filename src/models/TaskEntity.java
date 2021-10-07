package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "getAllTasks",
        query = "SELECT m FROM TaskEntity AS m ORDER BY m.id DESC"
    )
})
@Table(name = "tasks")

public class TaskEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "createDate", nullable = false)
    private Timestamp createDate;

    @Column(name = "updateDate", nullable = false)
    private Timestamp updateDate;

    @Column(name = "content", length = 255, nullable = false)
    private String content;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreateDate(){
        return createDate;
    }
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate(){
        return updateDate;
    }
    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

}
