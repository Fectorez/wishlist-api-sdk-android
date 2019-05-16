package com.jeremie.testandroid.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Wishlist extends Model {

    public String name;
    public boolean isPublic;
    public List<Item> items;
    public PrizePool prizePool;
    public long prizePoolId;
    public User owner;
    public long ownerId;
    public List<User> participants;

    public Wishlist() {
    }

    public Wishlist(JSONObject json, boolean includeRelations) {
        try {
            this.id = (int) (json.get("id"));
            this.createdAt = (long) (json.get("createdAt"));
            this.updatedAt = (long) (json.get("updatedAt"));
            this.name = (String) (json.get("name"));
            this.isPublic = (boolean) (json.get("isPublic"));

            this.prizePoolId = (int) (json.get("prizePoolId"));
            this.ownerId = (int) (json.get("ownerId"));

            JSONObject prizePoolJson = (JSONObject) (json.get("prizePool"));
            this.prizePool = new PrizePool(prizePoolJson, false);

            JSONObject ownerJson = (JSONObject) (json.get("owner"));
            this.owner = new User(ownerJson, false);

            if ( includeRelations ) {
                JSONArray itemsJson = (JSONArray) (json.get("items"));
                int nbItems = itemsJson.length();
                this.items = new ArrayList<>(nbItems);
                for (int i = 0; i < nbItems; i++) {
                    JSONObject itemJson = (JSONObject) (itemsJson.get(i));
                    Item item = new Item(itemJson, false);
                    this.items.add(item);
                }

                JSONArray participantsJson = (JSONArray) (json.get("participants"));
                int nbParticipants = participantsJson.length();
                this.participants = new ArrayList<>(nbParticipants);
                for (int i = 0; i < nbParticipants; i++) {
                    JSONObject participantJson = (JSONObject) (participantsJson.get(i));
                    User participant = new User(participantJson, false);
                    this.participants.add(participant);
                }
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Wishlist(JSONObject json) {
        this(json, true);
    }

    public Wishlist(Wishlist other) {
        this.name = other.name;
        this.isPublic = other.isPublic;
        this.items = other.items;
        this.prizePool = other.prizePool;
        this.prizePoolId = other.prizePoolId;
        this.owner = other.owner;
        this.ownerId = other.ownerId;

        this.participants = new ArrayList<>(other.participants.size());
        for ( User participant : other.participants )
            this.participants.add(new User(participant));
    }

    @Override
    public JSONObject getModelDefinition() throws JSONException {
        return new JSONObject()
                .put("name", "Wishlist")
                .put("plural", "Wishlists")
                .put("path", "Wishlist")
                .put("idName", "id")
                .put("relations", new JSONObject()
                        .put("participants", new JSONObject()
                                .put("name", "participants")
                                .put("type", "List<User>")
                                .put("model", "User")
                        )
                );
    }
}
