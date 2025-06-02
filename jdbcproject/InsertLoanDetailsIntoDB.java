package jdbc.jdbcproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InsertLoanDetailsIntoDB {

    static ArrayList<LoanBean>arrList=new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        Path cwd=Path.of("").toAbsolutePath();

        FileReader fr=new FileReader(cwd+"/data/csv/mahil_test_loan_dataset.csv");
        BufferedReader br=new BufferedReader(fr);

        String line;
        String[]lines;
        int firstLine=0;

        try {

            while ((line=br.readLine())!=null){

                if (firstLine==0){
                    firstLine++;
                    continue;
                }

                lines=line.split(",");

                LoanBean o=new LoanBean();

                o.setApplicationDate(Date.valueOf(lines[0]));
                o.setAge(Integer.parseInt(lines[1]));
                o.setAnnualIncome(Integer.parseInt(lines[2]));
                o.setCreditScore(Integer.parseInt(lines[3]));
                o.setEmploymentStatus(lines[4]);

                o.setEducationLevel(lines[5]);
                o.setExperience(Integer.parseInt(lines[6]));
                o.setLoanAmount(Integer.parseInt(lines[7]));
                o.setLoanDuration(Integer.parseInt(lines[8]));
                o.setMaritalStatus(lines[9]);

                o.setNumberOfDependents(Integer.parseInt(lines[10]));
                o.setHomeOwnershipStatus(lines[11]);
                o.setMonthlyDebtPayments(Integer.parseInt(lines[12]));
                o.setCreditCardUtilizationRate(Float.parseFloat(lines[13]));
                o.setNumberOfOpenCreditLines(Integer.parseInt(lines[14]));

                o.setNumberOfCreditInquiries(Integer.parseInt(lines[3]));
                o.setDebtToIncomeRatio(Float.parseFloat(lines[16]));
                o.setBankruptcyHistory(Integer.parseInt(lines[17]));
                o.setLoanPurpose(lines[18]);
                o.setPreviousLoanDefaults(Integer.parseInt(lines[19]));

                o.setPaymentHistory(Integer.parseInt(lines[20]));
                o.setLengthOfCreditHistory(Integer.parseInt(lines[21]));
                o.setSavingsAccountBalance(Integer.parseInt(lines[22]));
                o.setCheckingAccountBalance(Integer.parseInt(lines[23]));
                o.setTotalAssets(Integer.parseInt(lines[24]));

                o.setTotalLiabilities(Integer.parseInt(lines[25]));
                o.setMonthlyIncome(Double.parseDouble(lines[26]));
                o.setUtilityBillsPaymentHistory(Float.parseFloat(lines[27]));
                o.setJobTenure(Integer.parseInt(lines[28]));
                o.setNetWorth(Integer.parseInt(lines[29]));

                o.setBaseInterestRate(Float.parseFloat(lines[30]));
                o.setInterestRate(Float.parseFloat(lines[31]));
                o.setMonthlyLoanPayment(Double.parseDouble(lines[32]));
                o.setTotalDebtToIncomeRatio(Float.parseFloat(lines[33]));
                o.setLoanApproved(Integer.parseInt(lines[34]));
                o.setRiskScore(Float.parseFloat(lines[35]));

                arrList.add(o);

            }

            } catch (Exception e) {
            e.printStackTrace();
        }

        InsertLoanDetailsIntoDB i=new InsertLoanDetailsIntoDB();
        i.insertDetailsToDb();

    }

    public  void insertDetailsToDb(){

        int totalSize= arrList.size();

        int chunkSize=(int)Math.ceil((double)totalSize/4);

        ExecutorService executorService= Executors.newFixedThreadPool(2);

        for (int i=0;i<4;i++){

            int start=i*chunkSize;
            int end=Math.min(start+chunkSize,totalSize);

            List<LoanBean>partList=arrList.subList(start,end);
            executorService.submit(new Thread1(partList));

        }
        executorService.shutdown();

    }

    class Thread1 extends  Thread{

        List<LoanBean>partList;

        Thread1(List<LoanBean>partList){
            this.partList=partList;
        }

        @Override
        public void run() {

            LocalDateTime startTime=LocalDateTime.now();
            Connection connection= null;
            PreparedStatement preparedStatement=null;

            try {
                connection=ConnectionQuick.getConnection();

                String query="Insert into LoanDetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                preparedStatement= connection.prepareStatement(query);

                for (LoanBean x:partList){


                    preparedStatement.setDate(1,x.getApplicationDate());
                    preparedStatement.setInt(2,x.getAge());
                    preparedStatement.setInt(3,x.getAnnualIncome());
                    preparedStatement.setInt(4,x.getCreditScore());
                    preparedStatement.setString(5,x.getEmploymentStatus());


                    preparedStatement.setString(6,x.getEducationLevel());
                    preparedStatement.setInt(7,x.getExperience());
                    preparedStatement.setInt(8,x.getLoanAmount());
                    preparedStatement.setInt(9,x.getLoanDuration());
                    preparedStatement.setString(10,x.getMaritalStatus());


                    preparedStatement.setInt(11,x.getNumberOfDependents());
                    preparedStatement.setString(12,x.getHomeOwnershipStatus());
                    preparedStatement.setInt(13,x.getMonthlyDebtPayments());
                    preparedStatement.setFloat(14,x.getCreditCardUtilizationRate());
                    preparedStatement.setInt(15,x.getNumberOfOpenCreditLines());


                    preparedStatement.setInt(16,x.getNumberOfCreditInquiries());
                    preparedStatement.setFloat(17,x.getDebtToIncomeRatio());
                    preparedStatement.setInt(18,x.getBankruptcyHistory());
                    preparedStatement.setString(19,x.getLoanPurpose());
                    preparedStatement.setInt(20,x.getPreviousLoanDefaults());

                    preparedStatement.setInt(21,x.getPaymentHistory());
                    preparedStatement.setInt(22,x.getLengthOfCreditHistory());
                    preparedStatement.setInt(23,x.getSavingsAccountBalance());
                    preparedStatement.setInt(24,x.getCheckingAccountBalance());
                    preparedStatement.setInt(25,x.getTotalAssets());

                    preparedStatement.setInt(26,x.getTotalLiabilities());
                    preparedStatement.setDouble(27,x.getMonthlyIncome());
                    preparedStatement.setFloat(28,x.getUtilityBillsPaymentHistory());
                    preparedStatement.setInt(29,x.getJobTenure());
                    preparedStatement.setInt(30,x.getNetWorth());

                    preparedStatement.setFloat(31,x.getBaseInterestRate());
                    preparedStatement.setFloat(32,x.getInterestRate());
                    preparedStatement.setDouble(33,x.getMonthlyLoanPayment());
                    preparedStatement.setFloat(34,x.getTotalDebtToIncomeRatio());
                    preparedStatement.setInt(35,x.getLoanApproved());
                    preparedStatement.setFloat(36,x.getRiskScore());

                    preparedStatement.executeUpdate();

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            finally {
                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }

            LocalDateTime endTime=LocalDateTime.now();
            String name=Thread.currentThread().getName();

            System.out.println("Time taken by "+name+" -" + Duration.between(startTime,endTime) +" size of the data - "+partList.size());
        }
    }
}
