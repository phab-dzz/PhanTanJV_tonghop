package dao;

import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.Record;
import entity.Category;
import util.AppUtils;

public class testcategory {
	 private Driver driver;

	public testcategory() {
		driver = AppUtils.getDriver();
	}
	public Category findOne(String id) {
		String q="MATCH (n:Category) where n.categoryID= $id RETURN n";
		Map<String, Object> pars=Map.of("id",id);
		try(Session session= driver.session()){
			return (Category) session.executeRead( tx -> {
				Result result=(Result) tx.run(q,pars);
				if(!((org.neo4j.driver.Result) result).hasNext())
						return null;
				
				Record record=(Record) ((org.neo4j.driver.Result) result).next();
				 Node node = record.get("n").asNode();
				Category c= AppUtils.nodeToPOJO(node, Category.class);
				
				return c;
				
			});
		}
	}
	 

}
