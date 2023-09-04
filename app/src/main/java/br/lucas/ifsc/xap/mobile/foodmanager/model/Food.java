package br.lucas.ifsc.xap.mobile.foodmanager.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Food {
    private int id;
    private String name;
    private String description;
    private float price;
    private boolean freteGratis;
    private boolean combo;

    public Food() {
        this.setId(0);
        this.setName("");
        this.setDescription("");
        this.setPrice(0);
        this.setCombo(false);
        this.setFreteGratis(false);
    }

    public void FoodJS (JSONObject jp){
        try {
            Integer numero = (int) jp.get("id");
            this.setId(numero);
            this.setName((String) jp.get("name"));
            this.setDescription((String) jp.get("description"));
            this.setPrice((float) jp.get("price"));
            boolean frete = Boolean.getBoolean(jp.get("frete").toString());
            this.setFreteGratis(frete);
            boolean combo = Boolean.getBoolean(jp.get("combo").toString());
            this.setCombo(combo);
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    public JSONObject toJsonFood () {
        JSONObject json = new JSONObject();
        try {
            json.put("id", this.id);
            json.put("name", this.name);
            json.put("description", this.description);
            json.put("price", this.price);
            json.put("frete", this.freteGratis);
            json.put("combo", this.combo);
        } catch (JSONException e){
            e.printStackTrace();
        }
        return json;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {


        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isFreteGratis() {
        return freteGratis;
    }
    public void setFreteGratis(boolean freteGratis) {
        this.freteGratis = freteGratis;
    }
    public boolean isCombo() {
        return combo;
    }
    public void setCombo(boolean combo) {
        this.combo = combo;
    }
}
