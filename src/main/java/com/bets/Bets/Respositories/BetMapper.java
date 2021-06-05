package com.bets.Bets.Respositories;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bets.Bets.Models.BetModel;   
import org.springframework.jdbc.core.RowMapper;
public class BetMapper implements RowMapper<BetModel>{
    public BetModel mapRow(final ResultSet rs, final int row) throws SQLException {
        BetModel Bet = new BetModel();
        Bet.setId(rs.getLong("id"));
        Bet.setNumbergain(rs.getInt("numbergain"));
        Bet.setStatus(rs.getString("Status"));
        Bet.setCreated_at(rs.getString("created_at"));
        Bet.setUpdated_at(rs.getString("updated_at"));
        
        return Bet;
    }
}
