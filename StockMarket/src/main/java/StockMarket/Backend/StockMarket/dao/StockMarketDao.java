package StockMarket.Backend.StockMarket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import StockMarket.Backend.StockMarket.entity.StockMarket;

@Repository
public class StockMarketDao {

	private final JdbcTemplate jdbcTemplate;

	public StockMarketDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(StockMarket stockMarket) {
		String sql = "INSERT INTO STOCKMARKET (stockname, pricedate, price, quantity, volume) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, stockMarket.getStockname(), stockMarket.getPricedate(), stockMarket.getPrice(),
				stockMarket.getQuantity(), stockMarket.getVolume());
	}

	public List<StockMarket> findAll() {
		String sql = "SELECT * FROM STOCKMARKET";
		return jdbcTemplate.query(sql, new StockMarketRowMapper());
	}

	public StockMarket findById(int id) {
		String sql = "SELECT * FROM STOCKMARKET WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new StockMarketRowMapper());
	}

	public void update(StockMarket stockMarket) {
		String sql = "UPDATE STOCKMARKET SET stockname = ?, pricedate = ?, price = ?, quantity = ?, volume = ? WHERE id = ?";
		jdbcTemplate.update(sql, stockMarket.getStockname(), stockMarket.getPricedate(), stockMarket.getPrice(),
				stockMarket.getQuantity(), stockMarket.getVolume(), stockMarket.getId());
	}

	public void deleteById(int id) {
		String sql = "DELETE FROM STOCKMARKET WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	private static class StockMarketRowMapper implements RowMapper<StockMarket> {
		@Override
		public StockMarket mapRow(ResultSet rs, int rowNum) throws SQLException {
			StockMarket stockMarket = new StockMarket();
			stockMarket.setId(rs.getInt("id"));
			stockMarket.setStockname(rs.getString("stockname"));
			stockMarket.setPricedate(rs.getDate("pricedate"));
			stockMarket.setPrice(rs.getBigDecimal("price"));
			stockMarket.setQuantity(rs.getInt("quantity"));
			stockMarket.setVolume(rs.getLong("volume"));
			return stockMarket;
		}
	}
}
