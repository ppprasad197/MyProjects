package StockMarket.Backend.StockMarket.controller;

import org.springframework.web.bind.annotation.*;

import StockMarket.Backend.StockMarket.dao.StockMarketDao;
import StockMarket.Backend.StockMarket.entity.StockMarket;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
@RequestMapping("/stockmarket")
public class StockMarketController {

	private final StockMarketDao stockMarketDAO;

	public StockMarketController(StockMarketDao stockMarketDAO) {
		this.stockMarketDAO = stockMarketDAO;
	}

	@PostMapping("/create")
	@Transactional
	public void createStock(@RequestBody StockMarket stockMarket) {
		stockMarketDAO.save(stockMarket);
	}

	@GetMapping("/all")
	public List<StockMarket> getAllStocks() {
		return stockMarketDAO.findAll();
	}

	@PutMapping("/update")
	@Transactional
	public void updateStock(@RequestBody StockMarket stockMarket) {
		stockMarketDAO.update(stockMarket);
	}

	@DeleteMapping("/delete/{id}")
	@Transactional
	public void deleteStock(@PathVariable int id) {
		stockMarketDAO.deleteById(id);
	}
}
