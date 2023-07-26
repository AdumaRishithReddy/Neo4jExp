import org.neo4j.driver.AuthTokens;
	import org.neo4j.driver.Driver;
	import org.neo4j.driver.GraphDatabase;
	import org.neo4j.driver.Query;
import org.neo4j.driver.Session;

import static org.neo4j.driver.Values.parameters;
public class Neoj4trial implements AutoCloseable{
	public final String uri="bolt://localhost:7687";
	public  String user="neo4j";
    public  String password="rishi@neo";
	    private final Driver driver;
	    
	    public Neoj4trial() {
	    	
	        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
	        System.out.println("hi");
	    }

	    @Override
	    public void close() throws RuntimeException {
	        driver.close();
	    }

	    public void printGreeting(final String message) {
	        try (Session session = driver.session()) {
	        	 org.neo4j.driver.Result result = session.run(
	                     "CREATE (n:AUDIENCE {name:'Ronaldo',height:2,weight:100,number:123,age:30}) RETURN n.name"
	                     );
//	        	 org.neo4j.driver.Result result = session.run(
//	                     "MATCH (rishi:PLAYER{name: 'Stan Van Gundy'}),(coach:COACH{name:'Taylor Jenkins'}) CREATE (rishi)<-[:COACHES_FOR]-(coach) RETURN rishi");
	        	 while (result.hasNext())
	             {
	                 org.neo4j.driver.Record record = result.next();
	                 // Values can be extracted from a record by index or name.
	                 System.out.println(record.get("age").asString());
	             }
	        	 System.out.println("log");//	            System.out.println(greeting);
	        }
	    }

	    public static void main(String... args) {
	    	
	        Neoj4trial greeter = new Neoj4trial();
	            greeter.printGreeting("hello, world");
	        
	    }
	}

