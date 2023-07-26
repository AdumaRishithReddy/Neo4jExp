import org.neo4j.driver.AuthTokens;
	import org.neo4j.driver.Driver;
	import org.neo4j.driver.GraphDatabase;
	import org.neo4j.driver.Query;

	import static org.neo4j.driver.Values.parameters;
public class Neo4jcon {
	

	public class HelloWorldExample implements AutoCloseable {
	    private final Driver driver;
	    
	    public HelloWorldExample() {
	    	public static String uri="http://localhost:7474/";
	    	public static String user="neo4j";
		    public static String password="rishi@neo";
	        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
	    }

	    @Override
	    public void close() throws RuntimeException {
	        driver.close();
	    }

	    public void printGreeting(final String message) {
	        try (var session = driver.session()) {
	            var greeting = session.executeWrite(tx -> {
	                var query = new Query("MATCH (n) RETURN n");
	                var result = tx.run(query);
	                return result.single().get(0).asString();
	            });
	            System.out.println(greeting);
	        }
	    }

	    public static void main(String... args) {
	        try (var greeter = new HelloWorldExample()) {
	            greeter.printGreeting("hello, world");
	        }
	    }
	}
}
