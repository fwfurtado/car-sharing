package me.fwfurtado.search.changelog;

import static java.util.UUID.fromString;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Indexes;
import me.fwfurtado.search.domain.CarMatch;
import org.bson.Document;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeLog
public class Migration001 {

    @ChangeSet(order = "001", id = "populate-cars-collection", author = "Fernando")
    public void populateCarsCollection(MongoTemplate db) {
        String ownerName = "Fernando";

        MongoCollection<Document> collection = db.getCollection("cars");

        collection.createIndex(Indexes.geo2dsphere("location"));

        db.insert(new CarMatch(fromString("6a9d7bdc-7e84-45fc-9e3a-58f87c040574"), "CLC 200K", "MERCEDES_BENZ",
            ownerName, new Point(-28.5359, -52.1486), true), "cars");

        db.insert(new CarMatch(fromString("22feced4-93bb-4fa4-b55b-61b07cfe2644"), "330i", "BMW",
            ownerName, new Point(-23.5329, -46.6395), true), "cars");

        db.insert(new CarMatch(fromString("3a045f2a-8b75-46f5-8130-c07d07b5c4f8"), "A4", "AUDI",
            ownerName, new Point(-23.5208, -46.1854), true), "cars");

    }
}
