package com.yim.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yim.entity.Building;
import com.yim.mapper.BuildingMapper;
import com.yim.service.IBuildingService;

@Service
public class BuildingService implements IBuildingService {

	@Autowired
	private BuildingMapper buildingMapper;
	
	@Override
	public Building findBuildingByNum(String buildingNum) {
		// TODO Auto-generated method stub
		return buildingMapper.selectBuildingByNum(buildingNum);
	}

	@Override
	public List<Building> findAllBuildings() {
		// TODO Auto-generated method stub
		return buildingMapper.selectAllBuildings();
	}

	@Override
	public int addBuilding(Building building) {
		// TODO Auto-generated method stub
		return buildingMapper.insertBuilding(building);
	}

	@Override
	public int deleteBuilding(Building building) {
		// TODO Auto-generated method stub
		return buildingMapper.deleteBuilding(building);
	}

	@Override
	public int updateBuilding(Building building) {
		// TODO Auto-generated method stub
		return updateBuilding(building);
	}

}
