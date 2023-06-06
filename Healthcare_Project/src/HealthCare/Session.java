/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCare;

/**
 *
 * @author HP
 */
public class Session {
    
    private static String Email;
    private static String Doctor_ID;
    private static String Doctor_name;
    private static String Specialist;
    private static String Patient_Name;
    private static String Patient_Birth;

    /**
     * @return the Patient_Name
     */
    public String getPatient_Name() {
        return Patient_Name;
    }

    /**
     * @param aPatient_Name the Patient_Name to set
     */
    public void setPatient_Name(String Patient_Name) {
        this.Patient_Name = Patient_Name;
    }

    /**
     * @return the Patient_Birth
     */
    public String getPatient_Birth() {
        return Patient_Birth;
    }

    /**
     * @param aPatient_Birth the Patient_Birth to set
     */
    public void setPatient_Birth(String Patient_Birth) {
        this.Patient_Birth = Patient_Birth;
    }

    /**
     * @return the Doctor_ID
     */

    public String getDoctor_ID() {
        return Doctor_ID;
    }

    /**
     * @param Doctor_ID the Doctor_ID to set
     */
    public void setDoctor_ID(String Doctor_ID) {
        this.Doctor_ID = Doctor_ID;
    }

    /**
     * @return the Doctor_name
     */
    public String getDoctor_name() {
        return Doctor_name;
    }

    /**
     * @param Doctor_name the Doctor_name to set
     */
    public void setDoctor_name(String Doctor_name) {
        this.Doctor_name = Doctor_name;
    }

    /**
     * @return the Specialist
     */
    public String getSpecialist() {
        return Specialist;
    }

    /**
     * @param Specialist the Specialist to set
     */
    public void setSpecialist(String Specialist) {
        this.Specialist = Specialist;
    }

    /**
     * @return the DoctorName
     */
   

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public void reset(){
        Doctor_ID = "";
        Doctor_name ="";
        Specialist ="";
        Email = "";
        Patient_Name ="";
        Patient_Birth ="";
    }
}
