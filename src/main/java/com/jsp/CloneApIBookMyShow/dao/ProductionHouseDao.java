package com.jsp.CloneApIBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneApIBookMyShow.entity.ProductionHouse;
import com.jsp.CloneApIBookMyShow.repository.ProductionHouseRepo;

@Repository
public class ProductionHouseDao {
	
	@Autowired
	private ProductionHouseRepo houseRepo;

	public ProductionHouse saveProductionHouse(ProductionHouse house) {
		
		return houseRepo.save(house);
	}

	public ProductionHouse updateProductionHouse(long houseId, ProductionHouse house) {
		Optional<ProductionHouse> optional=houseRepo.findById(houseId);
		if(optional.isPresent()) {
//			update the data
			house.setProductionId(houseId);
			house.setOwner(optional.get().getOwner());
			house.setMovies(optional.get().getMovies());
			houseRepo.save(house);
			return house;
		}

		return null;
	}

	public ProductionHouse getProductionHouseById(long houseId) {
		Optional<ProductionHouse> optional= houseRepo.findById(houseId);
		if(optional.isPresent())
		{
			return optional.get();
		}else {
			return null;
		}
		
	}

	public ProductionHouse deleteProductionHouseById(long houseId) {
		Optional<ProductionHouse> optional= houseRepo.findById(houseId);
		if(optional.isPresent())
		{
			ProductionHouse house= optional.get();
			house.setMovies(null);
			house.setOwner(null);
			houseRepo.delete(house);
			return optional.get();
		}else {
			return null;
		}
	}
	}



