/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kassa.Entidad;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CESAR-TRN
 */
@Entity
@Table(name = "VW_CUMPLE", schema="TRN_SISTEMAS")
@XmlRootElement
@NamedNativeQueries({
    @NamedNativeQuery(name = "VwCumple.allCumples",query=" select * from TRN_SISTEMAS.vw_cumple",resultClass = VwCumple.class)
})
@NamedQueries({
    @NamedQuery(name = "VwCumple.findAll", query = "SELECT v FROM VwCumple v")
    , @NamedQuery(name = "VwCumple.findById", query = "SELECT v FROM VwCumple v WHERE v.id = :id")
    , @NamedQuery(name = "VwCumple.findByTitle", query = "SELECT v FROM VwCumple v WHERE v.title = :title")
    , @NamedQuery(name = "VwCumple.findByStart", query = "SELECT v FROM VwCumple v WHERE v.start = :start")
    , @NamedQuery(name = "VwCumple.findByDescription", query = "SELECT v FROM VwCumple v WHERE v.description = :description")})
public class VwCumple implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @Id
    private BigInteger id;
    @Size(max = 163)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 48)
    @Column(name = "START")
    private String start;
    @Size(max = 45)
    @Column(name = "DESCRIPTION")
    private String description;

    public VwCumple() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
