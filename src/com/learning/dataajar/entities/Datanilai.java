/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learning.dataajar.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hendri
 */
@Entity
@Table(name = "datanilai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datanilai.findAll", query = "SELECT d FROM Datanilai d"),
    @NamedQuery(name = "Datanilai.findByNama", query = "SELECT d FROM Datanilai d WHERE d.nama = :nama"),
    @NamedQuery(name = "Datanilai.findByNim", query = "SELECT d FROM Datanilai d WHERE d.nim = :nim"),
    @NamedQuery(name = "Datanilai.findByNilai1", query = "SELECT d FROM Datanilai d WHERE d.nilai1 = :nilai1"),
    @NamedQuery(name = "Datanilai.findByNilai2", query = "SELECT d FROM Datanilai d WHERE d.nilai2 = :nilai2"),
    @NamedQuery(name = "Datanilai.findByNilai3", query = "SELECT d FROM Datanilai d WHERE d.nilai3 = :nilai3"),
    @NamedQuery(name = "Datanilai.findByNilai4", query = "SELECT d FROM Datanilai d WHERE d.nilai4 = :nilai4"),
    @NamedQuery(name = "Datanilai.findByNilai5", query = "SELECT d FROM Datanilai d WHERE d.nilai5 = :nilai5"),
    @NamedQuery(name = "Datanilai.findByNilai6", query = "SELECT d FROM Datanilai d WHERE d.nilai6 = :nilai6"),
    @NamedQuery(name = "Datanilai.findByNilai7", query = "SELECT d FROM Datanilai d WHERE d.nilai7 = :nilai7"),
    @NamedQuery(name = "Datanilai.findByNilai8", query = "SELECT d FROM Datanilai d WHERE d.nilai8 = :nilai8"),
    @NamedQuery(name = "Datanilai.findByNilai9", query = "SELECT d FROM Datanilai d WHERE d.nilai9 = :nilai9"),
    @NamedQuery(name = "Datanilai.findByNilai10", query = "SELECT d FROM Datanilai d WHERE d.nilai10 = :nilai10"),
    @NamedQuery(name = "Datanilai.findByNilai11", query = "SELECT d FROM Datanilai d WHERE d.nilai11 = :nilai11"),
    @NamedQuery(name = "Datanilai.findByNilai12", query = "SELECT d FROM Datanilai d WHERE d.nilai12 = :nilai12"),
    @NamedQuery(name = "Datanilai.findByNilai13", query = "SELECT d FROM Datanilai d WHERE d.nilai13 = :nilai13"),
    @NamedQuery(name = "Datanilai.findByNilai14", query = "SELECT d FROM Datanilai d WHERE d.nilai14 = :nilai14"),
    @NamedQuery(name = "Datanilai.findByNilai15", query = "SELECT d FROM Datanilai d WHERE d.nilai15 = :nilai15"),
    @NamedQuery(name = "Datanilai.findByNilai16", query = "SELECT d FROM Datanilai d WHERE d.nilai16 = :nilai16"),
    @NamedQuery(name = "Datanilai.findByNilai17", query = "SELECT d FROM Datanilai d WHERE d.nilai17 = :nilai17"),
    @NamedQuery(name = "Datanilai.findByNilai18", query = "SELECT d FROM Datanilai d WHERE d.nilai18 = :nilai18"),
    @NamedQuery(name = "Datanilai.findByIsLulusTepatWaktu", query = "SELECT d FROM Datanilai d WHERE d.isLulusTepatWaktu = :isLulusTepatWaktu")})
public class Datanilai implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "NAMA")
    private String nama;
    @Id
    @Basic(optional = false)
    @Column(name = "NIM")
    private String nim;
    @Column(name = "NILAI_1")
    private String nilai1;
    @Column(name = "NILAI_2")
    private String nilai2;
    @Column(name = "NILAI_3")
    private String nilai3;
    @Column(name = "NILAI_4")
    private String nilai4;
    @Column(name = "NILAI_5")
    private String nilai5;
    @Column(name = "NILAI_6")
    private String nilai6;
    @Column(name = "NILAI_7")
    private String nilai7;
    @Column(name = "NILAI_8")
    private String nilai8;
    @Column(name = "NILAI_9")
    private String nilai9;
    @Column(name = "NILAI_10")
    private String nilai10;
    @Column(name = "NILAI_11")
    private String nilai11;
    @Column(name = "NILAI_12")
    private String nilai12;
    @Column(name = "NILAI_13")
    private String nilai13;
    @Column(name = "NILAI_14")
    private String nilai14;
    @Column(name = "NILAI_15")
    private String nilai15;
    @Column(name = "NILAI_16")
    private String nilai16;
    @Column(name = "NILAI_17")
    private String nilai17;
    @Column(name = "NILAI_18")
    private String nilai18;
    @Column(name = "IS_LULUS_TEPAT_WAKTU")
    private String isLulusTepatWaktu;

    public Datanilai() {
    }

    public Datanilai(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNilai1() {
        return nilai1;
    }

    public void setNilai1(String nilai1) {
        this.nilai1 = nilai1;
    }

    public String getNilai2() {
        return nilai2;
    }

    public void setNilai2(String nilai2) {
        this.nilai2 = nilai2;
    }

    public String getNilai3() {
        return nilai3;
    }

    public void setNilai3(String nilai3) {
        this.nilai3 = nilai3;
    }

    public String getNilai4() {
        return nilai4;
    }

    public void setNilai4(String nilai4) {
        this.nilai4 = nilai4;
    }

    public String getNilai5() {
        return nilai5;
    }

    public void setNilai5(String nilai5) {
        this.nilai5 = nilai5;
    }

    public String getNilai6() {
        return nilai6;
    }

    public void setNilai6(String nilai6) {
        this.nilai6 = nilai6;
    }

    public String getNilai7() {
        return nilai7;
    }

    public void setNilai7(String nilai7) {
        this.nilai7 = nilai7;
    }

    public String getNilai8() {
        return nilai8;
    }

    public void setNilai8(String nilai8) {
        this.nilai8 = nilai8;
    }

    public String getNilai9() {
        return nilai9;
    }

    public void setNilai9(String nilai9) {
        this.nilai9 = nilai9;
    }

    public String getNilai10() {
        return nilai10;
    }

    public void setNilai10(String nilai10) {
        this.nilai10 = nilai10;
    }

    public String getNilai11() {
        return nilai11;
    }

    public void setNilai11(String nilai11) {
        this.nilai11 = nilai11;
    }

    public String getNilai12() {
        return nilai12;
    }

    public void setNilai12(String nilai12) {
        this.nilai12 = nilai12;
    }

    public String getNilai13() {
        return nilai13;
    }

    public void setNilai13(String nilai13) {
        this.nilai13 = nilai13;
    }

    public String getNilai14() {
        return nilai14;
    }

    public void setNilai14(String nilai14) {
        this.nilai14 = nilai14;
    }

    public String getNilai15() {
        return nilai15;
    }

    public void setNilai15(String nilai15) {
        this.nilai15 = nilai15;
    }

    public String getNilai16() {
        return nilai16;
    }

    public void setNilai16(String nilai16) {
        this.nilai16 = nilai16;
    }

    public String getNilai17() {
        return nilai17;
    }

    public void setNilai17(String nilai17) {
        this.nilai17 = nilai17;
    }

    public String getNilai18() {
        return nilai18;
    }

    public void setNilai18(String nilai18) {
        this.nilai18 = nilai18;
    }

    public String getIsLulusTepatWaktu() {
        return isLulusTepatWaktu;
    }

    public void setIsLulusTepatWaktu(String isLulusTepatWaktu) {
        this.isLulusTepatWaktu = isLulusTepatWaktu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nim != null ? nim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datanilai)) {
            return false;
        }
        Datanilai other = (Datanilai) object;
        if ((this.nim == null && other.nim != null) || (this.nim != null && !this.nim.equals(other.nim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.learning.dataajar.entities.Datanilai[ nim=" + nim + " ]";
    }
    
}
