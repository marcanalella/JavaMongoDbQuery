package com.jcg.java.mongodb;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDemo {

	private static Logger log = Logger.getLogger(MongoDemo.class);

	// Fetching all documents from the mongo collection.
	private static void getAllDocuments(MongoCollection<Document> col) {
		log.info("Fetching all documents from the collection");

		// Performing a read operation on the collection.
		FindIterable<Document> fi = col.find();
		MongoCursor<Document> cursor = fi.iterator();
		try {
			while(cursor.hasNext()) {
				log.info(cursor.next().toJson());
			}
		} finally {
			cursor.close();
		}
	}

	// Fetch a selective document from the mongo collection.
	private static void getSelectiveDocument(MongoCollection<Document> col) {
		log.info("Fetching a particular document from the collection");

		// Performing a read operation on the collection.
		String col_name = "name", srch_string = "Charlotte Neil";
		FindIterable<Document> fi = col.find(Filters.eq(col_name, srch_string));		
		MongoCursor<Document> cursor = fi.iterator();
		try {
			while(cursor.hasNext()) {
				log.info(cursor.next().toJson());
			}
		} finally {
			cursor.close();
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// Mongodb initialization parameters.
		int port_no = 27017;
		String host_name = "localhost", db_name = "sampledb", db_coll_name = "emp";

		// Mongodb connection string.
		String client_url = "mongodb://" + host_name + ":" + port_no + "/" + db_name;
		MongoClientURI uri = new MongoClientURI(client_url);

		// Connecting to the mongodb server using the given client uri.
		MongoClient mongo_client = new MongoClient(uri);

		// Fetching the database from the mongodb.
		MongoDatabase db = mongo_client.getDatabase(db_name);

		// Fetching the collection from the mongodb.
		MongoCollection<Document> coll = db.getCollection(db_coll_name);

		// Fetching all the documents from the mongodb.
		getAllDocuments(coll);

		log.info("\n");

		// Fetching a single document from the mongodb based on a search_string.
		getSelectiveDocument(coll);
	}
}