package info.sanaulla;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;

public class BookService {

	@Autowired Client esClient;
	
	
}
