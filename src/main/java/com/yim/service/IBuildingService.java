package com.yim.service;

import java.util.List;

import com.yim.entity.Building;

public interface IBuildingService {
	Building findBuildingByNum(String buildingNum);
	
	List<Building> findAllBuildings();
	
	int addBuilding(Building building);
	
	int deleteBuilding(Building building);
	
	int updateBuilding(Building building);
}
