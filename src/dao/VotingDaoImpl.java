package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;
import pojos.Voter;
import static utils.DBUtils.*;

public class VotingDaoImpl implements IVotingDao {

	private Connection connection;
	private PreparedStatement pst1,pst2,pst3,pst4;
	
	
	public VotingDaoImpl() throws ClassNotFoundException, SQLException {
		
		this.connection = fetchConnection();
		this.pst1 = connection.prepareStatement("SELECT *FROM voters WHERE email=? and password=?");
		this.pst2 = connection.prepareStatement("SELECT *FROM candidates");
		this.pst3 = connection.prepareStatement("UPDATE voters SET status='YES' WHERE id=?");
		this.pst4 = connection.prepareStatement("UPDATE candidates SET votes=votes+1 WHERE id=?");
	}

	@Override
	public Voter authenticateVoter(String em, String pass) throws Exception {
		pst1.setString(1, em);
		pst1.setString(2, pass);
		try(ResultSet rst=pst1.executeQuery()){
			if(rst.next())
				return new Voter(rst.getInt(1),rst.getString("email"),rst.getString(3),rst.getString(4));
		}
		return null;
	}

	@Override
	public List<Candidate> getCandidateList() throws Exception {
		List<Candidate>candidateList=new ArrayList<>();
		try(ResultSet rst=pst2.executeQuery()){			
			while(rst.next())
				candidateList.add(new Candidate(rst.getInt(1),rst.getString("name"),rst.getString(3),rst.getInt(4)));
			return candidateList;
		}
	}

	@Override
	public String incVotesUpdateStatus(int candidateId, int voterId) throws Exception {
		pst3.setInt(1, voterId);
		pst4.setInt(1, candidateId);
		int i=pst3.executeUpdate();
		int j=pst4.executeUpdate();
			if(i>0 && j>0)
				return "Success";
		
		return "Fail";
	}

}
