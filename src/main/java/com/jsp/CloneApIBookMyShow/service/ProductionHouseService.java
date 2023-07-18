package com.jsp.CloneApIBookMyShow.service;

import javax.print.DocFlavor.STRING;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApIBookMyShow.dao.OwnerDao;
import com.jsp.CloneApIBookMyShow.dao.ProductionHouseDao;
import com.jsp.CloneApIBookMyShow.dto.ProductionHouseDto;
import com.jsp.CloneApIBookMyShow.entity.Owner;
import com.jsp.CloneApIBookMyShow.entity.ProductionHouse;
import com.jsp.CloneApIBookMyShow.exception.OwnerIdNotFoundException;
import com.jsp.CloneApIBookMyShow.exception.ProductionHouseIdNotFoundException;
import com.jsp.CloneApIBookMyShow.util.ResponseStructure;
import java.util.List;
import java.util.ArrayList;
@Service
public class ProductionHouseService 

{

	
	
		@Autowired
		private ModelMapper modelMapper;
		@Autowired
		private ProductionHouseDao houseDao;
		@Autowired
		private OwnerDao ownerDao;
		public ResponseEntity<ResponseStructure<ProductionHouse>> saveProductionHouse(long ownerId, ProductionHouseDto houseDto)
		{
		Owner dbOwner= ownerDao.findOwnerById(ownerId);
		if(dbOwner!=null)
		{
			ProductionHouse house=this.modelMapper.map(houseDto , ProductionHouse.class);
			house.setOwner(dbOwner);
//			ProductionHouse dbProductionHouse=houseDao.saveProductionHouse(house);
			if(dbOwner.getHouses().isEmpty())
			{
				List<ProductionHouse>  list= new ArrayList<ProductionHouse>();
				list.add(house);
				dbOwner.setHouses(list);
			}else {
				List<ProductionHouse> list=dbOwner.getHouses();
				list.add(house);
				dbOwner.setHouses(list);
			}
			house.setOwner(dbOwner);
			 ProductionHouse dbProductionHouse= houseDao.saveProductionHouse(house);
			ResponseStructure<ProductionHouse> structure= new ResponseStructure<ProductionHouse>();
			structure.setMessage("Production House saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dbProductionHouse);
			return new ResponseEntity<ResponseStructure<ProductionHouse>>(structure,HttpStatus.CREATED);
		}else {
			throw new OwnerIdNotFoundException("Sorry failed to add production House");
	}

		}
		public ResponseEntity<ResponseStructure<ProductionHouse>> updateProductionHouse(long houseId,
				ProductionHouseDto houseDto) {
			ProductionHouse house=this.modelMapper.map(houseDto, ProductionHouse.class);

			ProductionHouse dbHouse=houseDao.updateProductionHouse(houseId,house);
			if(dbHouse!=null) {
				ResponseStructure<ProductionHouse> structure=new ResponseStructure<ProductionHouse>();
				structure.setMessage("ProductionHouse Update successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dbHouse);
				return new ResponseEntity<ResponseStructure<ProductionHouse>>(structure,HttpStatus.OK);
			}else {
				throw new  ProductionHouseIdNotFoundException("Sorry failed to update ProductionHouse");
			}
			
		}
		public ResponseEntity<ResponseStructure<ProductionHouse>> getProductionHouseById(long houseId) {
		
			
			ProductionHouse dbHouse=houseDao.getProductionHouseById(houseId);
			if(dbHouse!=null)
			{
				
				
					ResponseStructure<ProductionHouse> structure=new ResponseStructure<ProductionHouse>();
					structure.setMessage("ProductionHouse fetched successfully");
					structure.setStatus(HttpStatus.FOUND.value());
					structure.setData(dbHouse);
					return new ResponseEntity<ResponseStructure<ProductionHouse>>(structure,HttpStatus.FOUND);
				}else {
					throw new  ProductionHouseIdNotFoundException("Sorry failed to FETCH ProductionHouse");
				}
		}
		public ResponseEntity<ResponseStructure<ProductionHouse>> deleteProductionHouseById(long houseId) {
	ProductionHouse dbHouse=	houseDao.deleteProductionHouseById(houseId);
		if(dbHouse!=null)
		{
			
			ResponseStructure<ProductionHouse> structure=new ResponseStructure<ProductionHouse>();
			structure.setMessage("ProductionHouse deleted successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbHouse);
			return new ResponseEntity<ResponseStructure<ProductionHouse>>(structure,HttpStatus.FOUND);
		}else {
			throw new  ProductionHouseIdNotFoundException("Sorry failed to delete ProductionHouse");
			
		}
		
		}
		
		
		
}
