/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Vaccine {

    String vId;
    String vName;

    public Vaccine() {
        vId = "";
        vName = "";
    }

    public Vaccine(String vId, String vName) {
        this.vId = vId;
        this.vName = vName;
    }

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public void outputVaccine() {
        System.out.println("ID:" + vId + ", " + "Vaccine:" + vName);
    }

    @Override
    public String toString() {
        return "Vaccine{" + "vId=" + vId + ", vName=" + vName + '}';
    }

}
