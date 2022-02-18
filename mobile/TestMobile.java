package com.xworkz.mobile;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.mobile.dao.MobileDAO;
import com.xworkz.mobile.dto.MobileDetailsDTO;

public class TestMobile {
	
	public static void main(String[] args) {
		
		MobileDetailsDTO dto = new MobileDetailsDTO();
		dto.setName("redmi6");
		dto.setPrice(8500);
		dto.setColor("black");
		dto.setNoOfCamera((byte)3);
		dto.setStorage(64);
		
		MobileDetailsDTO dto1 = new MobileDetailsDTO();
		dto1.setName("vivoz1");
		dto1.setPrice(19000);
		dto1.setColor("blue");
		dto1.setNoOfCamera((byte)4);
		dto1.setStorage(128);
		
		MobileDetailsDTO dto2 = new MobileDetailsDTO();
		dto2.setName("realme8");
		dto2.setPrice(20000);
		dto2.setColor("infiniteBlack");
		dto2.setNoOfCamera((byte)4);
		dto2.setStorage(127);
		
		MobileDetailsDTO dto3 = new MobileDetailsDTO();
		dto3.setName("poco");
		dto3.setPrice(15000);
		dto3.setColor("violet");
		dto3.setNoOfCamera((byte)4);
		dto3.setStorage(128);
		
		MobileDAO dao  = new MobileDAO();
//		dao.save(dto);
//		dao.save(dto1);
//		dao.save(dto2);
//		dao.save(dto3);
		System.out.println();
		// dao.updatePriceByName();
	//	dao.deleteByName();
	//	dao.getMobileBrandAndPriceByTD("poco ");
		//dao.getCameraAndStorageByName("vivoz1 ");
		
		List<MobileDetailsDTO> list = new ArrayList<MobileDetailsDTO>();
		list.add(dto);
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		
		dao.insertMobiles(list);
	}

}
