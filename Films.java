/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r.mavenproject2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kleopatra
 */
@Entity
@Table(name = "films", catalog = "guepard", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Films.findAll", query = "SELECT f FROM Films f"),
    @NamedQuery(name = "Films.findByIdF", query = "SELECT f FROM Films f WHERE f.idF = :idF"),
    @NamedQuery(name = "Films.findByName", query = "SELECT f FROM Films f WHERE f.name = :name"),
    @NamedQuery(name = "Films.findByGenre", query = "SELECT f FROM Films f WHERE f.genre = :genre"),
    @NamedQuery(name = "Films.findByAge", query = "SELECT f FROM Films f WHERE f.age = :age"),
    @NamedQuery(name = "Films.findByAbout", query = "SELECT f FROM Films f WHERE f.about = :about"),
    @NamedQuery(name = "Films.findByYear", query = "SELECT f FROM Films f WHERE f.year = :year"),
    @NamedQuery(name = "Films.findByCountry", query = "SELECT f FROM Films f WHERE f.country = :country"),
    @NamedQuery(name = "Films.findByLike", query = "SELECT f FROM Films f WHERE f.like = :like"),
    @NamedQuery(name = "Films.findByDislike", query = "SELECT f FROM Films f WHERE f.dislike = :dislike")})
public class Films implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_f")
    private Integer idF;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "genre")
    private String genre;
    @Column(name = "age")
    private Integer age;
    @Size(max = 50)
    @Column(name = "about")
    private String about;
    @Column(name = "year")
    private Integer year;
    @Size(max = 50)
    @Column(name = "country")
    private String country;
    @Column(name = "like")
    private Integer like;
    @Column(name = "dislike")
    private Integer dislike;

    public Films() {
    }

    public Films(Integer idF) {
        this.idF = idF;
    }

    public Integer getIdF() {
        return idF;
    }

    public void setIdF(Integer idF) {
        this.idF = idF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idF != null ? idF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Films)) {
            return false;
        }
        Films other = (Films) object;
        if ((this.idF == null && other.idF != null) || (this.idF != null && !this.idF.equals(other.idF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "r.mavenproject2.Films[ idF=" + idF + " ]";
    }
    
}
