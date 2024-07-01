package br.univille.mongotests;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public final class Exercicio1 {
    private static final Logger log = LoggerFactory.getLogger(Exercicio1.class);

    private Exercicio1() {}

    public static void main(String[] args) throws Exception {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mflix");
        MongoCollection<Document> collection = database.getCollection("movies");
        Document doc = collection.find(Filters.eq("title", "The Room")).first();
        log.info("Achei: {}", doc);
        mongoClient.close();
        log.info("Ok");
    }
}
