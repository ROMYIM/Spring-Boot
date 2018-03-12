package building;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.yim.Application;
import com.yim.entity.Building;
import com.yim.service.impl.BuildingService;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class BuildingServiceTest {
	@Autowired
	private BuildingService buildingService;
	
	int count = 0;
	
	@Test
	public void addBuilding() {
		System.out.println("test add building");
		Building building = new Building();
		building.setBuildingNum("1");
		System.out.println(building.toString());
		count = buildingService.addBuilding(building);
		Building building2 = buildingService.findBuildingByNum("1");
		if (count > 0) {
			System.out.println(building2.toString());
		}
	}
	
	@Test
	public void selectBuilding() {
		System.out.println("test select Building");
		List<Building> buildings = buildingService.findAllBuildings();
		System.out.println(buildings.size());
	}
	
}
