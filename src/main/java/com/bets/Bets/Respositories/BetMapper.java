package com.bets.Bets.Respositories;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bets.Bets.Models.BetModel;   
import org.springframework.jdbc.core.RowMapper;
public class BetMapper implements RowMapper<BetModel>{
    public BetModel mapRow(final ResultSet rs, final int row) throws SQLException {
        BetModel Bet = new BetModel();
        Bet.setId(rs.getLong("id"));
        Bet.setName(rs.getString("name"));
        Bet.setStatus(rs.getString("Status"));
        return Bet;
    }
}
