package tester;

import java.sql.SQLException;

import dao.VotingDaoImpl;

public class TestMain {

	public static void main(String[] args) {
		try {
			VotingDaoImpl obj1 = new VotingDaoImpl();
			System.out.println(obj1.authenticateVoter("shubendu@gmail.com", "shu#123"));
			System.out.println(obj1.getCandidateList());
			System.out.println(obj1.incVotesUpdateStatus(1, 2).equals("Success")?"Voted successfully":"Voted unsuccessfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
