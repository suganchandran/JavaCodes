package jdbc.DBIngestionWithoutThreading;

import jdbc.DBUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InsertMedicalDetailsIntoDatabase {

    static ArrayList<HealthBean> list = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("start :" + LocalDateTime.now());
        Path cwd = Path.of("").toAbsolutePath();

        FileReader fr = new FileReader(cwd + "/data/csv/healthcare_dataset1.csv");
        BufferedReader bf = new BufferedReader(fr);

        String line;
        String[] lines;
        int lineNo = 1;
        try {

            while ((line = bf.readLine()) != null) {

                if (lineNo == 1) {
                    lineNo++;
                    continue;
                }
                lines = line.split(",");

                HealthBean o = new HealthBean();
                o.setSno(Integer.parseInt(lines[0]));
                o.setName(lines[1]);
                o.setAge(Integer.parseInt(lines[2]));
                o.setGender(lines[3]);
                o.setBlood_Type(lines[4]);
                o.setMedical_Condition(lines[5]);
                o.setDate_Of_Admission(lines[6]);
                o.setDoctor(lines[7]);
                o.setHospital(lines[8]);
                o.setInsurance_Provider(lines[9]);
                o.setBilling_Amount(Double.parseDouble(lines[10]));
                o.setRoom_Number(Integer.parseInt(lines[11]));
                o.setAdmission_Type(lines[12]);
                o.setDischarge_Date((lines[13]));
                o.setMedication(lines[14]);
                o.setTest_Results(lines[15]);

                list.add(o);


            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("end" + LocalDateTime.now());


        System.out.println("start ing" + LocalDateTime.now());
        InsertMedicalDetailsIntoDatabase v = new InsertMedicalDetailsIntoDatabase();
        v.insertToUsertable();
    }

    public void insertToUsertable() {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int totalSize = list.size();
        int chunkSize = (int) (Math.ceil((double) totalSize / 8));

        for (int i = 0; i < 8; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, totalSize);

            if (start < totalSize) {
                List<HealthBean> subList = list.subList(start, end);
                executorService.submit(new DataProcess(subList));

            }
        }
        executorService.shutdown();

    }

    class DataProcess implements Runnable {
        List<HealthBean> partData;

        DataProcess(List<HealthBean> partData) {
            this.partData = partData;
        }


        @Override
        public void run() {

            LocalDateTime st = LocalDateTime.now();
            String threadName = Thread.currentThread().getName();

            System.out.println("Task is running on thread: " + threadName + "start time " + st);

            String insertQuery = "INSERT INTO insurance(Sno,Nam,Age,Gender,BloodType,MedicalCondition,DateofAdmission,Doctor," +
                    "Hospital,InsuranceProvider,BillingAmount," +
                    "RoomNumber,AdmissionType,DischargeDate,Medication,TestResults)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            Connection c = null;
            PreparedStatement p = null;

            try {
                c = DBUtil.getConnection();
                p = c.prepareStatement(insertQuery);
                int a = 1;

                for (HealthBean h : partData) {
                    p.setInt(1, h.getSno());
                    p.setString(2, h.getName());
                    p.setInt(3, h.getAge());
                    p.setString(4, h.getGender());
                    p.setString(5, h.getBlood_Type());
                    p.setString(6, h.getMedical_Condition());
                    p.setString(7, h.getDate_Of_Admission());
                    p.setString(8, h.getDoctor());
                    p.setString(9, h.getHospital());
                    p.setString(10, h.getInsurance_Provider());
                    p.setDouble(11, h.getBilling_Amount());
                    p.setInt(12, h.getRoom_Number());
                    p.setString(13, h.getAdmission_Type());
                    p.setString(14, h.getDischarge_Date());
                    p.setString(15, h.getMedication());
                    p.setString(16, h.getTest_Results());
                    p.executeUpdate();
                    a++;

                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    c.close();
                    p.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Task is ended on thread: " + threadName + "    end time " + LocalDateTime.now());
            }
        }
    }
}
