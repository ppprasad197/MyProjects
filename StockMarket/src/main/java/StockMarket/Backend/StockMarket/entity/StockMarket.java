package StockMarket.Backend.StockMarket.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class StockMarket {
	private int id;
	private String stockname;
	private Date pricedate;
	private BigDecimal price;
	private int quantity;
	private long volume;

	public StockMarket() {
		super();
	}

	public StockMarket(int id, String stockname, Date pricedate, BigDecimal price, int quantity, long volume) {
		super();
		this.id = id;
		this.stockname = stockname;
		this.pricedate = pricedate;
		this.price = price;
		this.quantity = quantity;
		this.volume = volume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStockname() {
		return stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
	}

	public Date getPricedate() {
		return pricedate;
	}

	public void setPricedate(Date pricedate) {
		this.pricedate = pricedate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	
	// Getters and Setters

}
