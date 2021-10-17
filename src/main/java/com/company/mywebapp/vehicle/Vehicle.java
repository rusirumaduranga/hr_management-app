package com.company.mywebapp.vehicle;

import javax.persistence.*;

@Entity
@Table(name = "vehicales")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true,length = 45)
    private String vehicleno;

    @Column(length = 45, nullable = false, name = "first_name")
    private String owner;

    @Column(length = 45, nullable = false, name = "last_name")
    private String parkingno;

    private boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getParkingno() {
        return parkingno;
    }

    public void setParkingno(String parkingno) {
        this.parkingno = parkingno;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleno='" + vehicleno + '\'' +
                ", owner='" + owner + '\'' +
                ", parkingno='" + parkingno + '\'' +
                '}';
    }

}
