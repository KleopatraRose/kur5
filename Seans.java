/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r.mavenproject2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kleopatra
 */
@Entity
@Table(name = "seans", catalog = "guepard", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seans.findAll", query = "SELECT s FROM Seans s"),
    @NamedQuery(name = "Seans.findByIdS", query = "SELECT s FROM Seans s WHERE s.idS = :idS"),
    @NamedQuery(name = "Seans.findByIdF", query = "SELECT s FROM Seans s WHERE s.idF = :idF"),
    @NamedQuery(name = "Seans.findByDate", query = "SELECT s FROM Seans s WHERE s.date = :date"),
    @NamedQuery(name = "Seans.findByTime", query = "SELECT s FROM Seans s WHERE s.time = :time"),
    @NamedQuery(name = "Seans.findByPrice", query = "SELECT s FROM Seans s WHERE s.price = :price"),
    @NamedQuery(name = "Seans.findByRow1", query = "SELECT s FROM Seans s WHERE s.row1 = :row1"),
    @NamedQuery(name = "Seans.findByRow2", query = "SELECT s FROM Seans s WHERE s.row2 = :row2"),
    @NamedQuery(name = "Seans.findByRow3", query = "SELECT s FROM Seans s WHERE s.row3 = :row3"),
    @NamedQuery(name = "Seans.findByRow4", query = "SELECT s FROM Seans s WHERE s.row4 = :row4"),
    @NamedQuery(name = "Seans.findByRow5", query = "SELECT s FROM Seans s WHERE s.row5 = :row5"),
    @NamedQuery(name = "Seans.findByRow6", query = "SELECT s FROM Seans s WHERE s.row6 = :row6")})
public class Seans implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_s")
    private Integer idS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_f")
    private int idF;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @Size(max = 50)
    @Column(name = "row1")
    private String row1;
    @Size(max = 50)
    @Column(name = "row2")
    private String row2;
    @Size(max = 50)
    @Column(name = "row3")
    private String row3;
    @Size(max = 50)
    @Column(name = "row4")
    private String row4;
    @Size(max = 50)
    @Column(name = "row5")
    private String row5;
    @Size(max = 50)
    @Column(name = "row6")
    private String row6;

    public Seans() {
    }

    public Seans(Integer idS) {
        this.idS = idS;
    }

    public Seans(Integer idS, int idF, Date date, Date time, int price) {
        this.idS = idS;
        this.idF = idF;
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public Integer getIdS() {
        return idS;
    }

    public void setIdS(Integer idS) {
        this.idS = idS;
    }

    public int getIdF() {
        return idF;
    }

    public void setIdF(int idF) {
        this.idF = idF;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRow1() {
        return row1;
    }

    public void setRow1(String row1) {
        this.row1 = row1;
    }

    public String getRow2() {
        return row2;
    }

    public void setRow2(String row2) {
        this.row2 = row2;
    }

    public String getRow3() {
        return row3;
    }

    public void setRow3(String row3) {
        this.row3 = row3;
    }

    public String getRow4() {
        return row4;
    }

    public void setRow4(String row4) {
        this.row4 = row4;
    }

    public String getRow5() {
        return row5;
    }

    public void setRow5(String row5) {
        this.row5 = row5;
    }

    public String getRow6() {
        return row6;
    }

    public void setRow6(String row6) {
        this.row6 = row6;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idS != null ? idS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seans)) {
            return false;
        }
        Seans other = (Seans) object;
        if ((this.idS == null && other.idS != null) || (this.idS != null && !this.idS.equals(other.idS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "r.mavenproject2.Seans[ idS=" + idS + " ]";
    }
    
}
