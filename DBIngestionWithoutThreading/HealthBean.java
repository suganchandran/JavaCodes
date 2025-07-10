package jdbc.DBIngestionWithoutThreading;

public class HealthBean {

    private int Sno;
    private String Name;
    private int Age;
    private String Gender;
    private String Blood_Type;
    private String Medical_Condition;
    private String Date_Of_Admission;
    private String Doctor;
    private String Hospital;
    private String Insurance_Provider;
    private double Billing_Amount;
    private int Room_Number;
    private String Admission_Type;
    private String Discharge_Date;
    private String Medication;
    private String Test_Results;


    public int getSno() {
        return Sno;
    }

    public void setSno(int sno) {
        Sno = sno;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getBlood_Type() {
        return Blood_Type;
    }

    public void setBlood_Type(String blood_Type) {
        Blood_Type = blood_Type;
    }

    public String getMedical_Condition() {
        return Medical_Condition;
    }

    public void setMedical_Condition(String medical_Condition) {
        Medical_Condition = medical_Condition;
    }

    public String getDate_Of_Admission() {
        return Date_Of_Admission;
    }

    public void setDate_Of_Admission(String date_Of_Admission) {
        Date_Of_Admission = date_Of_Admission;
    }

    public String getDoctor() {
        return Doctor;
    }

    public void setDoctor(String doctor) {
        Doctor = doctor;
    }

    public String getHospital() {
        return Hospital;
    }

    public void setHospital(String hospital) {
        Hospital = hospital;
    }

    public String getInsurance_Provider() {
        return Insurance_Provider;
    }

    public void setInsurance_Provider(String insurance_Provider) {
        Insurance_Provider = insurance_Provider;
    }

    public double getBilling_Amount() {
        return Billing_Amount;
    }

    public void setBilling_Amount(double billing_Amount) {
        Billing_Amount = billing_Amount;
    }

    public int getRoom_Number() {
        return Room_Number;
    }

    public void setRoom_Number(int room_Number) {
        Room_Number = room_Number;
    }

    public String getAdmission_Type() {
        return Admission_Type;
    }

    public void setAdmission_Type(String admission_Type) {
        Admission_Type = admission_Type;
    }

    public String getDischarge_Date() {
        return Discharge_Date;
    }

    public void setDischarge_Date(String discharge_Date) {
        Discharge_Date = discharge_Date;
    }

    public String getMedication() {
        return Medication;
    }

    public void setMedication(String medication) {
        Medication = medication;
    }

    public String getTest_Results() {
        return Test_Results;
    }

    public void setTest_Results(String test_Results) {
        Test_Results = test_Results;
    }

    @Override
    public String toString() {
        return "HealthBean{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", Gender='" + Gender + '\'' +
                ", Blood_Type='" + Blood_Type + '\'' +
                ", Medical_Condition='" + Medical_Condition + '\'' +
                ", Date_Of_Admission=" + Date_Of_Admission +
                ", Doctor='" + Doctor + '\'' +
                ", Hospital='" + Hospital + '\'' +
                ", Insurance_Provider='" + Insurance_Provider + '\'' +
                ", Billing_Amount=" + Billing_Amount +
                ", Room_Number=" + Room_Number +
                ", Admission_Type='" + Admission_Type + '\'' +
                ", Discharge_Date=" + Discharge_Date +
                ", Medication='" + Medication + '\'' +
                ", Test_Results='" + Test_Results + '\'' +
                '}';
    }


}
