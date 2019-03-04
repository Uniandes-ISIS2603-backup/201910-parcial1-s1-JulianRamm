/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.dtos;

import co.edu.uniandes.csw.recipes.entities.IngredientEntity;
import java.io.Serializable;

/**
 *
 * @author je.osorio
 */
public class IngredientDTO implements Serializable {

    private String name;
    private Long calorias;
    private Long id;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the calorias
     */
    public Long getCalorias() {
        return calorias;
    }

    /**
     * @param calorias the calorias to set
     */
    public void setCalorias(Long calorias) {
        this.calorias = calorias;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    public IngredientDTO(){
        
    }
    public IngredientDTO(IngredientEntity ingredient){
        this.id = ingredient.getId();
        this.name =ingredient.getName();
        this.calorias =ingredient.getCalorias();
    }
    public IngredientEntity toEntity() {
    IngredientEntity entity = new IngredientEntity();
    entity.setId(this.id);
    entity.setName(this.name);   
    entity.setCalorias(this.calorias);
    return entity;
}
    

    
}
