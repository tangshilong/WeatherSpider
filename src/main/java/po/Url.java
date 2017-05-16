package po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by tangshilong on 2017/5/15.
 */
@Entity
@Table(name = "url")
public class Url implements Serializable {

    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue()
    private Integer id;
    private String url;
    private Integer flag;

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", flag=" + flag +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Url() {
    }

    public Url(String url, Integer flag) {
        this.url = url;
        this.flag = flag;
    }

    public Url(Integer id, String url, Integer flag) {
        this.id = id;
        this.url = url;
        this.flag = flag;
    }
}
