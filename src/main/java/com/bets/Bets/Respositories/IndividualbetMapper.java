package com.bets.Bets.Respositories;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bets.Bets.Models.IndivudualBetModel;
import org.springframework.jdbc.core.RowMapper; 
public class IndividualbetMapper implements RowMapper<IndivudualBetModel>{
    public IndivudualBetModel mapRow(final ResultSet rs, final int row) throws SQLException {
        IndivudualBetModel Bet = new IndivudualBetModel();
        Bet.setIdbet(rs.getLong("idbet"));
        Bet.setIduser(rs.getLong("iduser"));
        Bet.setCredit(rs.getLong("credit"));
        Bet.setGain(rs.getInt("gain"));
        Bet.setNumber(rs.getInt("number"));
        Bet.setStatus(rs.getString("status"));
        Bet.setName(rs.getString("name"));
        Bet.setColor(rs.getString("color"));
        Bet.setCreated_at(rs.getString("created_at"));
        
        return Bet;
    }
}
